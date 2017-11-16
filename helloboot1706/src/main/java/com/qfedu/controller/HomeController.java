package com.qfedu.controller;

import com.qfedu.dto.AirIndex;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {

    @GetMapping("/air")
    public List<List<AirIndex>> getAirIndex() {
        List<List<AirIndex>> cities = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {
            List<AirIndex> days = new ArrayList<>();
            for (int j = 1; j <= 31; ++j) {
                int aqi = (int) (Math.random() * 190 + 10);
                int pm25 = (int) (Math.random() * 490 + 10);
                int pm10 = (int) (Math.random() * 190 + 10);
                double co = Math.random() * 10;
                int no2 = (int) (Math.random() * 40 + 10);
                int so2 =  (int) (Math.random() * 40 + 10);
                String level = "严重污染";
                if (pm25 < 50) {
                    level = "优";
                } else if (pm25 < 100) {
                    level = "良";
                } else if (pm25 < 150) {
                    level = "轻度污染";
                } else if (pm25 < 200) {
                    level = "中度污染";
                } else if (pm25 < 300) {
                    level = "重度污染";
                }
                AirIndex airIndex = new AirIndex(j, aqi, pm25, pm10, co, no2, so2, level);
                days.add(airIndex);
            }
            cities.add(days);
        }
        return cities;
    }

    @GetMapping("/data")
    public Integer[] getData() {
        Integer[] data = new Integer[7];
        for (int i = 0; i < data.length; ++i) {
            data[i] = (int) (Math.random() * 401 + 100);
        }
        return data;
    }
}
