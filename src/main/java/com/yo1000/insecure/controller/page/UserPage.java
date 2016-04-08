package com.yo1000.insecure.controller.page;

import com.yo1000.insecure.InsecureUserAdminApplication;
import com.yo1000.insecure.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class UserPage {
    @Autowired
    private UserService userService;
    @Autowired
    private InsecureUserAdminApplication.SignedSession signedSession;

    @RequestMapping("")
    public String getIndex() {
        return "redirect:signin";
    }

    @RequestMapping(value = "signin", method = RequestMethod.GET)
    public String getSignin() {
        return "signin";
    }

    @RequestMapping(value = "signin", method = RequestMethod.POST)
    public String postSignin(@RequestParam String username, @RequestParam String password) {
        Map<String, Object> user = getUserService().signin(username, password);
        if (user == null) {
            return "signin";
        }

        getSignedSession().setUser(user);
        return "redirect:user-list";
    }

    @RequestMapping(value = "user-list", method = RequestMethod.GET)
    public String getUserList(Model model) {
        if (getSignedSession().getUser() == null) {
            return "redirect:signin";
        }

        model.addAttribute("users", getUserService().find());
        return "user-list";
    }

    @RequestMapping(value = "user-edit", method = RequestMethod.GET)
    public String getUserEdit(Model model) {
        if (getSignedSession().getUser() == null) {
            return "redirect:signin";
        }

        model.addAttribute("user", getSignedSession().getUser());
        return "user-edit";
    }

    @RequestMapping(value = "user-edit", method = RequestMethod.POST)
    public String postUserEdit(@RequestParam String fullname, Model model) {
        if (getSignedSession().getUser() == null) {
            return "redirect:signin";
        }

        Map<String, Object> user = getSignedSession().getUser();
        getUserService().modify((String) user.get("username"), (String) user.get("password"), fullname);

        return "redirect:user-list";
    }

    protected UserService getUserService() {
        return userService;
    }

    protected InsecureUserAdminApplication.SignedSession getSignedSession() {
        return signedSession;
    }
}
