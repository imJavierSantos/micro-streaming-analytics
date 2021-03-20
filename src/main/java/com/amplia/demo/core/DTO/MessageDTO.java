package com.amplia.demo.core.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MessageDTO {

    @JsonProperty("Version")
    private String version;

    @JsonProperty("Id")
    private String id;

    @JsonProperty("Velocity")
    private String velocity;

}
