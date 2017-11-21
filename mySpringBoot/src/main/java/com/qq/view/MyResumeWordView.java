package com.qq.view;

import com.qq.util.WordGenerator;
import org.springframework.web.servlet.view.AbstractTemplateView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

public class MyResumeWordView extends AbstractTemplateView {

    @Override
    protected void renderMergedTemplateModel(Map<String, Object> map,
                                             HttpServletRequest req,
                                             HttpServletResponse resp) throws Exception {
        String filename = URLEncoder.encode("个人简历.doc", "utf-8");
        resp.setHeader("Content-Disposition", "attachment; filename=" + filename);
        Map<String,String> information = (Map<String, String>) map.get("information");
        File file = null;
        InputStream fin = null;
        ServletOutputStream out = null;
        try {
            // 调用工具类WordGenerator的createDoc方法生成Word文档
            file = WordGenerator.createDoc(information, "resume");
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
    }
}
