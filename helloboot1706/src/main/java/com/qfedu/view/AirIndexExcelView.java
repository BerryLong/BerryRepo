package com.qfedu.view;

import com.qfedu.dto.AirIndex;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

public class AirIndexExcelView extends AbstractXlsView {

    @Override
    protected void buildExcelDocument(
            Map<String, Object> map, Workbook workbook,
            HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String filename = URLEncoder.encode("空气指数报表.xls", "utf-8");
        resp.setHeader("Content-Disposition", "attachment; filename=" + filename);
        List<List<AirIndex>> cities = (List<List<AirIndex>>) map.get("cities");
        String[] cityNames = { "北京", "上海", "广州" };
        for (int i = 0; i < cities.size(); ++i) {
            List<AirIndex> city = cities.get(i);
            Sheet sheet = workbook.createSheet(cityNames[i]);

        }
    }
}
