package com.example.tech11;

import java.util.List;

public interface UserEJB {
    List<User> findAll();
    User getUser(Long id);
    void register(User user);
    void update(Long id, User user);
    void delete(Long id);
}
