package com.amplia.demo.core.repository.model;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "event")
@Data
public class Event implements Serializable {

    private static final long serialVersionUID = -5759325980569359718L;

    private String id;

    private int Velocity;


}
