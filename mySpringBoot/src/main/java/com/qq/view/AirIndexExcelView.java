package com.qq.view;

import com.qq.dto.AirIndex;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

public class AirIndexExcelView extends AbstractXlsView {

    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook,
                                      HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String filename = URLEncoder.encode("空气指数报表.xls", "utf-8");
        resp.setHeader("Content-Disposition", "attach; filename=" + filename);
        List<List<AirIndex>> cities = (List<List<AirIndex>>) map.get("cities");
        String[] cityNames = { "北京", "上海", "广州" };
        for (int i = 0; i < cities.size(); ++i) {
            List<AirIndex> city = cities.get(i);
            Sheet sheet = workbook.createSheet(cityNames[i]);
            for(int j = 0;j<city.size();i++){
                AirIndex day = city.get(i);
                Row row = sheet.createRow(j);
                row.createCell(0).setCellValue(day.getDay());
                row.createCell(1).setCellValue(day.getPm25());
                row.createCell(2).setCellValue(day.getPm10());
                row.createCell(3).setCellValue(day.getSo2());
                row.createCell(4).setCellValue(day.getNo2());
                row.createCell(5).setCellValue(day.getCo());
                row.createCell(6).setCellValue(day.getLevel());
                row.createCell(7).setCellValue(day.getAqi());
            }
        }
    }
}
