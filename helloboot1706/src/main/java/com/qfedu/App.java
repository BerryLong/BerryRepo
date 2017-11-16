package com.qfedu;

import com.qfedu.view.AirIndexExcelView;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@RestController
public class App {

    @Bean
    public AirIndexExcelView excelView() {
        return new AirIndexExcelView();
    }

    @GetMapping(value = "/", produces = "text/plain; charset=utf-8")
    public String home() {
        return "hello, world! 你好世界!";
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
