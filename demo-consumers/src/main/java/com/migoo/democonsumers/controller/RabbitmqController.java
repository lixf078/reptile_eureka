package com.migoo.democonsumers.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitmqController {

    /*@RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(value = "test_queue"),
                    exchange = @Exchange(value = "test_exchange", type = "topic"),
                    key = "test.#"
            )
    })
    public void index(String message) {
        System.out.println("消费端rabbitmq：message: " + message);
    }*/

    @JmsListener(destination = "springboot.queue.test")
    public void receiveQueue(String msg) {
        System.out.println("消费端activemq：message: " + msg);
    }

}
