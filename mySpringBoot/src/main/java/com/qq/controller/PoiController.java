package com.qq.controller;

import com.qq.dto.AirIndex;
import com.qq.util.WordGenerator;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PoiController {

    @PostMapping("/word")
    public  String generatedWord(Model model,
                                 HttpServletRequest request,
                                 HttpServletResponse resp){
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String tel = request.getParameter("tel");
        String addr = request.getParameter("addr");
        String content = request.getParameter("content");
        Map<String,String> map = new HashMap<>();
        map.put("name",name);
        map.put("sex",sex);
        map.put("tel",tel);
        map.put("addr",addr);
        map.put("content",content);
        model.addAttribute("information",map);

        File file = null;
        InputStream fin = null;
        ServletOutputStream out = null;
        try {
            // 调用工具类WordGenerator的createDoc方法生成Word文档
            file = WordGenerator.createDoc(map, "resume");
            fin = new FileInputStream(file);

            resp.setCharacterEncoding("utf-8");
            resp.setContentType("application/msword");
            // 设置浏览器以下载的方式处理该文件默认名为resume.doc
            resp.addHeader("Content-Disposition", "attachment;filename=resume.doc");

            out = resp.getOutputStream();
            byte[] buffer = new byte[512];  // 缓冲区
            int bytesToRead = -1;
            // 通过循环将读入的Word文件的内容输出到浏览器中
            while((bytesToRead = fin.read(buffer)) != -1) {
                out.write(buffer, 0, bytesToRead);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fin != null) {fin.close();}
                if(out != null) {out.close();}
                if(file != null) {file.delete();}// 删除临时文件
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "resumeView";
    }

    @GetMapping("/pdf")
    public  String generatePdf(Model model){

        String temp = "This is a Pdf 请假ad";
        model.addAttribute("textContent",temp);
        return "leavePdfView";
    }

    @GetMapping("/excel")
    public String generateExcel(Model model) {
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
        model.addAttribute("cities", cities);
        return "excelView";
    }
    // BeanNameViewResolver
}
