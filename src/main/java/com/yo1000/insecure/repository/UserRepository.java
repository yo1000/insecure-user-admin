package com.yo1000.insecure.repository;

import java.util.List;
import java.util.Map;

public interface UserRepository {
    List<Map<String, Object>> select();
    Map<String, Object> select(String username, String password);
    Map<String, Object> update(String username, String password, String fullname);
}
