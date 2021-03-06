package com.qfedu.controller;

import com.qfedu.util.DataUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PoiController {

    @GetMapping("/airExcel")
    public String generateExcel(Model model) {
        model.addAttribute("cities", DataUtil.randomAirIndexData());
        return "airExcelView";
    }
}
