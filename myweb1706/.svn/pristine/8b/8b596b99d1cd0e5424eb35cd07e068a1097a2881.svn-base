package com.qfedu.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@WebServlet(urlPatterns = "/hello", loadOnStartup =  1, asyncSupported = true)
public class HelloServlet extends HttpServlet {
    private static List<String> sentencesList = new CopyOnWriteArrayList<>(Arrays.asList(
            "世上并没有绝望的处境，只有对处境绝望的人",
            "人生的道路在态度的岔口一分为二，从此通向成功或失败",
            "不思进取也是对生命的不负责任",
            "生命的精彩之处在于有太多的不确定性",
            "只有非常的努力，才能看起来毫不费力"
    ));

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        AsyncContext asyncContext = req.startAsync();
        // asyncContext.setTimeout(10000);
        asyncContext.start(() -> {
            delay((long) (Math.random() * 5001 + 3000));
            try (PrintWriter pw = resp.getWriter()) {
                int index = (int) (Math.random() * (sentencesList.size() - 1));
                String sentence = sentencesList.remove(index);
                pw.print(sentence);
                sentencesList.add(sentence);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        });
    }

    private void delay(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
