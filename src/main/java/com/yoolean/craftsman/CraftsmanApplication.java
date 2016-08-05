package com.yoolean.craftsman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CraftsmanApplication
{
    public static void main( String[] args ) {
        SpringApplication application = new SpringApplication(CraftsmanApplication.class);
        application.run(args);
    }
}
