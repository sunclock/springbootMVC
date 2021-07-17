package com.sunclock.book.springbootMVC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication // always defined in the class at root of project
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        // .run executes WAS inside so that there's no need to install tomcat at server
        // upside: you can deploy springboot when, where, in any environment.
    }
}
