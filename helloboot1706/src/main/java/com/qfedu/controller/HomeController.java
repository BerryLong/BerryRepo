package com.qfedu.controller;

import com.qfedu.dto.AirIndex;
import com.qfedu.util.DataUtil;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @GetMapping("/data")
    public Integer[] getData() {
        Integer[] data = new Integer[7];
        for (int i = 0; i < data.length; ++i) {
            data[i] = (int) (Math.random() * 401 + 100);
        }
        return data;
    }

    @GetMapping("/air")
    public List<List<AirIndex>> getAirIndex() {
        return DataUtil.randomAirIndexData();
    }

    @MessageMapping("/foo")
    @SendTo("/info/air")
    public List<List<AirIndex>> sendAirIndexMessage() {
        return DataUtil.randomAirIndexData();
    }

}
