package com.qq;

import config.MyMvcConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(MyMvcConfig.class)
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
