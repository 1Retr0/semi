package cn.edu.zucc.service.impl;

import cn.edu.zucc.domain.dao.UserRepository;
import cn.edu.zucc.domain.entity.User;
import cn.edu.zucc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void create(User user) { userRepository.save(user); } //注册用户

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Cacheable(value = "user", key = "#id")
    public User getUser(long id) {
        return userRepository.findById(id).get();
    }

    @Override
    @Cacheable(value = "user", key = "#name")
    public User getUser(String name) {
        return userRepository.findUser(name);
    }

    @Override
    public User getUser(String name, String password) {
        return userRepository.findByNameAndPassword(name, password);
    }

    @Override
    public List<User> getDeveloper(String superior) {
        return userRepository.findBySuperior(superior);
    }

}
