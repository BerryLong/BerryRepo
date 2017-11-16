package com.qq.controller;

import com.qq.view.AirIndexExcelView;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String toHome(){
        return  "Hello,springBoot";
    }

    @GetMapping("/data")
    public Integer[] getData(){
        Integer[] temp = new Integer[7];
        for(int i = 0; i< temp.length;i++){
            Integer random = (int)(Math.random()*400+100);
            temp[i] = random;
        }
        return  temp;
    }
}
