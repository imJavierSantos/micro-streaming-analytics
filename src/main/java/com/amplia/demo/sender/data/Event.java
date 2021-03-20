package com.amplia.demo.sender.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Random;

public class Event {

    @JsonProperty("Id")
    private String id;

    @JsonProperty("Velocity")
    private String velocity;

    public Event(){
        this.id = "123";
        this.velocity = String.valueOf(new Random().nextInt(50));
    }

}
