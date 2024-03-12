package com.artostapyshyn.blog.service.impl;

import com.artostapyshyn.blog.model.User;
import com.artostapyshyn.blog.repository.UserRepository;
import com.artostapyshyn.blog.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User save(String name, String email) {
        return userRepository.save(User.builder()
                .name(name)
                .email(email)
                .build());
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public int countUsers() {
        return userRepository.countAllUsers();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public User updateUser(Long id, String name, String email) {
        User user = userRepository.findById(id).orElseThrow(RuntimeException::new);
        user.setName(name);
        user.setEmail(email);
        return userRepository.save(user);
    }

    @Override
    public boolean deleteById(Long id) {
        userRepository.deleteById(id);
        return true;
    }
}
