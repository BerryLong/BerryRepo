import com.alibaba.fastjson.JSON;

import java.io.InputStream;
import java.net.URL;

public class App {
    public static void main(String[] args) throws  Exception {
        URL url = new URL("http://api.avatardata.cn/Joke/QueryJokeByTime?key=0446a80169034e7fa28e9c58953c9c1a&page=2&rows=10&sort=asc&time=1418775237");
        try (InputStream input = url.openStream()) {
            StringBuilder jsonStr = new StringBuilder();
            byte[] buffer = new byte[512];
            int totalBytes;
            while ((totalBytes = input.read(buffer)) != -1) {
                jsonStr.append(new String(buffer, 0, totalBytes, "utf-8"));
            }
            //fastjson
            NewsData newsData = JSON.parseObject(jsonStr.toString(), NewsData.class);
            for (News model : newsData.getResult()) {
                System.out.println("----------------");
                System.out.println(model.getContent());
            }
        }
    }
}
