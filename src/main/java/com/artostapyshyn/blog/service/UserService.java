package com.artostapyshyn.blog.service;

import com.artostapyshyn.blog.model.User;

import java.util.List;

public interface UserService {
    User save(String name, String email);
    List<User> findAll();
    int countUsers();
    User findById(Long id);
    User updateUser(Long id, String name, String email);
    boolean deleteById(Long id);
}
