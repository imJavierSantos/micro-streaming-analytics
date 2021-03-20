package com.amplia.demo.core.transformer;

import com.amplia.demo.core.DTO.MessageDTO;
import com.amplia.demo.sender.data.CustomMessage;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MessageTransformerImpl implements MessageTransformer {

    @Override
    public MessageDTO createInstanceFromJson(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        MessageDTO messageDTO = new MessageDTO();
        JsonNode jsonNode = mapper.readTree(json);
        messageDTO.setVersion(jsonNode.get("Version").asText());
        JsonNode child = jsonNode.get("Event");
        messageDTO.setId(child.get("Id").asText());
        messageDTO.setVelocity(child.get("Velocity").asText());
        return messageDTO;
    }

}
