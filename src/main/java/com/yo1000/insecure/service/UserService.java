package com.yo1000.insecure.service;

import com.yo1000.insecure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Map<String, Object>> find() {
        return getUserRepository().select();
    }

    public Map<String, Object> signin(String username, String password) {
        return getUserRepository().select(username, password);
    }

    public Map<String, Object> modify(String username, String password, String fullname) {
        return getUserRepository().update(username, password, fullname);
    }

    protected UserRepository getUserRepository() {
        return userRepository;
    }
}
