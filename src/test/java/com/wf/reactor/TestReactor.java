package com.wf.reactor;

import com.wf.reactor.server.UserServer;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author wf
 * @create 2020-09-09 23:25
 * @desc
 **/
public class TestReactor {

    /**
     * 声明Flux
     */
    @Test
    public void test1() {
        Flux.just(1, 2, 3, 4);
        Mono.just(1);

        Integer[] arr = {1, 2, 3, 4};
        Flux.fromArray(arr);

        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        Flux.fromIterable(integers);

        Flux.fromStream(integers.stream());
    }

    @Test
    public void test2() {
        Flux.just(1, 2, 3, 4).subscribe(System.out::println);

        Mono.just(1).subscribe(System.out::println);
    }

    @Test
    public void test3() throws IOException {
        UserServer server = new UserServer();
        server.createReactorServer();
        System.out.println("Helo");
        System.in.read();
    }
}
