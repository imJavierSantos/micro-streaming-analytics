package com.amplia.demo.config;

import com.amplia.demo.core.repository.EventRepository;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.SpringDataMongoDB;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import java.io.IOException;

@Configuration
@ComponentScan("com.amplia.demo.core")
@EnableRabbit
public class AppConfig {

    @Bean
    public Queue myQueue() {
        return new Queue("myQueue", false);
    }


}
