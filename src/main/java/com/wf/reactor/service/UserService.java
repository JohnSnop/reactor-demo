package com.wf.reactor.service;

import com.wf.reactor.pojo.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author wf
 * @create 2020-09-10 22:30
 * @desc
 **/
public interface UserService {

    Mono<User> getUserById(Integer id);

    Flux<User> getAllUser();

    Mono<Void> saveUser(Mono<User> user);
}
