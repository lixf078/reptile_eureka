package com.migoo.demoproducers.controller;

import com.migoo.demoproducers.domain.User;
import com.migoo.demoproducers.service.UserService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class IndexController {

    /*@Autowired
    private RabbitTemplate rabbitTemplate;*/

    @Autowired
    private UserService userService;

    @Autowired
    private JmsTemplate jmsTemplate;

    /*@GetMapping("/sendMessageByRabbitMq")
    public String sendMessage() {
        rabbitTemplate.convertAndSend("test_exchange", "test.123", "this is a message");
        return "success";
    }*/

    @GetMapping("/sendMessageByActiveMq")
    public String sendMessageByActiveMq() {
        ActiveMQQueue activeMQQueue = new ActiveMQQueue("springboot.queue.test");
        jmsTemplate.convertAndSend("springboot.queue.test", "this is a message");
        return "success";
    }

    @GetMapping("/getUserInfo")
    public String getUserInfo(String userId) {
        long userIdLong = Long.parseLong(userId);
        User userById = this.userService.findUserById(userIdLong);
        return userById.getName();
    }

}
