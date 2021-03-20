package com.amplia.demo.sender;

import com.amplia.demo.sender.data.CustomMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;


@Service
public class MessageSender {


    public MessageSender(RabbitTemplate rabbitTemplate) throws JsonProcessingException {
        String orderJson = new ObjectMapper().writeValueAsString(new CustomMessage());

        Message message = MessageBuilder
                .withBody(orderJson.getBytes())
                .setContentType(MessageProperties.CONTENT_TYPE_JSON)
                .build();

        rabbitTemplate.convertAndSend("myQueue", message);
    }

}
