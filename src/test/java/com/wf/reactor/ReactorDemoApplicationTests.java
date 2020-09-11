package com.wf.reactor;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReactorDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void test1() {
        ObserverDemo observerDemo = new ObserverDemo();
        observerDemo.addObserver((o, arg) -> {
            System.out.println("发生变化");
        });

        observerDemo.addObserver((o, arg) -> {
            System.out.println("发生变化2");
        });

        observerDemo.setChanged();
        observerDemo.notifyObservers();
    }


}
