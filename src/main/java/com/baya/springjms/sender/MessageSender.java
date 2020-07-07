package com.baya.springjms.sender;

import com.baya.springjms.config.JmsConfig;
import com.baya.springjms.model.MyMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@Component
public class MessageSender {

    private final JmsTemplate jmsTemplate;

    @Scheduled(fixedRate = 2000)
    public void sendMessage() {
        log.info("I am sending a message");

        MyMessage message = MyMessage.builder().id(UUID.randomUUID()).message("Hello World!").build();

        jmsTemplate.convertAndSend(JmsConfig.MY_QUEUE, message);

        log.info("Message Sent!");
    }
}
