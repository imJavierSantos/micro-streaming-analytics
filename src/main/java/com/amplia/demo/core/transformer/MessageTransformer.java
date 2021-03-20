package com.amplia.demo.core.transformer;

import com.amplia.demo.core.DTO.MessageDTO;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public interface MessageTransformer {

    MessageDTO createInstanceFromJson(String json) throws IOException;

}
