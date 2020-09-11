package com.wf.reactor.server;

import com.wf.reactor.pojo.User;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

/**
 * @author wf
 * @create 2020-09-11 22:14
 * @desc
 **/
public class Client {
    public static void main(String[] args) {
        WebClient webClient = WebClient.create("http://127.0.0.1:5794");
        String id = "1";
        User block = webClient.get().uri("/user/{id}", id).accept(MediaType.APPLICATION_JSON)
                .retrieve().bodyToMono(User.class).block();
        System.out.println(block.getName());

        Flux<User> userFlux = webClient.get().uri("/users").accept(MediaType.APPLICATION_JSON)
                .retrieve().bodyToFlux(User.class);
        userFlux.map(stu -> stu.getName())
                .buffer().doOnNext(System.out::println).blockFirst();
    }
}
