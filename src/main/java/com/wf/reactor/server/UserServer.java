package com.wf.reactor.server;

import com.wf.reactor.handler.UserHandler;
import com.wf.reactor.service.UserService;
import com.wf.reactor.service.UserServiceImpl;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.netty.http.server.HttpServer;

import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;

/**
 * @author wf
 * @create 2020-09-11 21:57
 * @desc
 **/
public class UserServer {

    public RouterFunction<ServerResponse> routerFunction() {
        UserService userService = new UserServiceImpl();
        UserHandler handler = new UserHandler(userService);

        return RouterFunctions.route(
            GET("/user/{id}").and(accept(APPLICATION_JSON)), handler :: getUserById)
                .andRoute(GET("/users").and(accept(APPLICATION_JSON)), handler :: getAllUsers);
    }

    public void createReactorServer() throws IOException {
        RouterFunction<ServerResponse> routerFunction = routerFunction();
        HttpHandler httpHandler = toHttpHandler(routerFunction);
        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);
        HttpServer.create().handle(adapter).bindNow();

    }

}
