package com.qfedu;

import com.alibaba.fastjson.JSON;

import java.io.InputStream;
import java.net.URL;

public class App {

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://api.tianapi.com/meinv/?key=772a81a51ae5c780251b1f98ea431b84&num=30&page=2");
        // HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        // connection.setRequestMethod("post");
        // connection.addRequestProperty("apikey", "772a81a51ae5c780251b1f98ea431b84");
        try (InputStream input = url.openStream()) {
            StringBuilder jsonStr = new StringBuilder();
            byte[] buffer = new byte[512];
            int totalBytes;
            while ((totalBytes = input.read(buffer)) != -1) {
                jsonStr.append(new String(buffer, 0, totalBytes, "utf-8"));
            }
            System.out.println(jsonStr.toString());
            DataModel dataModel = JSON.parseObject(jsonStr.toString(), DataModel.class);
            for (NewsModel model : dataModel.getNewslist()) {
                System.out.println(model.getTitle());
                System.out.println(model.getPicUrl());
            }
        }
    }
}
