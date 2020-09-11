package com.wf.reactor.service;

import com.wf.reactor.pojo.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wf
 * @create 2020-09-10 22:36
 * @desc
 **/
@Service
public class UserServiceImpl implements UserService {

    private static final Map<Integer, User> userMap = new HashMap<>();
    static {
        userMap.put(1, new User("lucy", "2", 20));
        userMap.put(2, new User("jack", "1", 29));
        userMap.put(3, new User("nack", "2", 33));
    }
    @Override
    public Mono<User> getUserById(Integer id) {
        return Mono.justOrEmpty(userMap.get(id));
    }

    @Override
    public Flux<User> getAllUser() {
        return Flux.fromIterable(userMap.values());
    }

    @Override
    public Mono<Void> saveUser(Mono<User> user) {
        return user.doOnNext(u -> {
            int id = userMap.size() + 1;
            userMap.put(id, u);
        }).thenEmpty(Mono.empty());
    }
}
