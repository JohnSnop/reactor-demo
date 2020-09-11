package com.wf.reactor.controller;

import com.wf.reactor.pojo.User;
import com.wf.reactor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author wf
 * @create 2020-09-10 22:34
 * @desc
 **/
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public Mono<User> getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @GetMapping("/users")
    public Flux<User> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/saveuser")
    public Mono<Void> saveUser(@RequestBody User user) {
        return userService.saveUser(Mono.just(user));
    }
}
