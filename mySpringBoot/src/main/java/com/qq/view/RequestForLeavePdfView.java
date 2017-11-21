package com.qq.view;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.Map;

public class RequestForLeavePdfView extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> map,
                                    Document document,
                                    PdfWriter pdfWriter,
                                    HttpServletRequest req,
                                    HttpServletResponse resp) throws Exception {
        String filename = URLEncoder.encode("学生请假条.pdf", "utf-8");
        resp.setHeader("Content-Disposition", "inline; filename=" + filename);
        String content = (String) map.get("textContent");
        Paragraph paragraph = new Paragraph();
        paragraph.add(content);
        document.add(paragraph);
        document.addAuthor("lby");
    }
}
