package cn.edu.zucc.service;


import cn.edu.zucc.domain.entity.User;

import java.util.List;

public interface UserService {
    void create(User user);
    void update(User user);
    void deleteById(long id);
    List<User> getAllUsers();
    User getUser(long id);
    User getUser(String name);
    User getUser(String name, String password);
}
