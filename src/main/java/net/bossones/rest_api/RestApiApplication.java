package net.bossones.rest_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class RestApiApplication {

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(RestApiApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "9090"));
        app.run(args);

    }

}
