package com.amplia.demo.core;

import com.amplia.demo.core.DTO.MessageDTO;
import com.amplia.demo.core.repository.EventRepository;
import com.amplia.demo.core.repository.model.Event;
import com.amplia.demo.core.transformer.MessageTransformer;
import com.amplia.demo.core.transformer.MessageTransformerImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static java.lang.Integer.parseInt;

@Component
@RequiredArgsConstructor
public class MessageConsumer {

    private final MessageTransformer messageTransformer;

    private final EventRepository eventRepository;

    @RabbitListener(queues = "myQueue")
    public void listen(Message message) throws Exception {

        if(messageIsNotEmpty(message)){
            processMessage(message);
        }

        System.out.println("Message read from myQueue : " + message);
    }


    private static boolean messageIsNotEmpty(Message message) {
        boolean isEmpty = false;
        byte[] body = message.getBody();
        if(Objects.nonNull(body) && body.length > 0) {
            isEmpty = true;
        }
        return isEmpty;
    }

    private void processMessage(Message message) throws Exception {

        MessageDTO messageDTO = messageTransformer.createInstanceFromJson(new String(message.getBody()));

        Event event = new Event();

        event.setId(messageDTO.getId());
        event.setVelocity(parseInt(messageDTO.getVelocity()));

        //eventRepository.saveAll(event);

        System.out.println("Message read from myQueue : " + messageDTO);

    }


}
