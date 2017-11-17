package com.qq;

import com.qq.view.AirIndexExcelView;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

    @Bean
    public AirIndexExcelView excelView() {
        return new AirIndexExcelView();
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
