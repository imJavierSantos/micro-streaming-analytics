package com.amplia.demo.sender.data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomMessage implements Serializable {

    @JsonProperty("Version")
    private String version;

    @JsonProperty("Event")
    private Event event;

    public CustomMessage(){
        this.version = "7.0";
        this.event = new Event();
    }

}
