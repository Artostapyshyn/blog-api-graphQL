package com.artostapyshyn.blog.controller;

import com.artostapyshyn.blog.model.User;
import com.artostapyshyn.blog.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @QueryMapping
    public List<User> findAllUsers() {
        return userService.findAll();
    }

    @QueryMapping
    public User findUserById(@Argument Long id) {
        return userService.findById(id);
    }

    @QueryMapping
    public int countUsers() {
        return userService.countUsers();
    }

    @MutationMapping
    public User createUser(@Argument String name, @Argument String email) {
        return userService.save(name, email);
    }

    @MutationMapping
    public User updateUser(@Argument Long id, @Argument String name, @Argument String email) {
        return userService.updateUser(id, name, email);
    }

    @MutationMapping
    public boolean deleteUser(@Argument Long id) {
        return userService.deleteById(id);
    }

}
