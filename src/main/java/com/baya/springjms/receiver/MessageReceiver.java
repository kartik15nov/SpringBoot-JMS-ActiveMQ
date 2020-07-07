package com.baya.springjms.receiver;

import com.baya.springjms.config.JmsConfig;
import com.baya.springjms.model.MyMessage;
import lombok.extern.log4j.Log4j2;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Log4j2
@Component
public class MessageReceiver {

    @JmsListener(destination = JmsConfig.MY_QUEUE)
    public void listen(@Payload MyMessage myMessage, @Headers MessageHeaders messageHeaders, Message message) {
        log.info("Got a message : {}", myMessage);
    }

}
