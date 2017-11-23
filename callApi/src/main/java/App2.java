import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class App2 {
    public static void main(String[] args) throws  Exception {
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet getReq = new HttpGet("http://api.avatardata.cn/Joke/QueryJokeByTime?key=0446a80169034e7fa28e9c58953c9c1a&page=2&rows=10&sort=asc&time=1418745237");
        HttpResponse resp =httpClient.execute(getReq);
        String jsonStr = EntityUtils.toString(resp.getEntity(),"utf-8");
        System.out.println(jsonStr);
        //jackson
        ObjectMapper mapper = new ObjectMapper();
        NewsData newsData = mapper.readValue(jsonStr,NewsData.class);
        for(News news:newsData.getResult()){
            System.out.println(news.getContent());
            System.out.println("---------------------------");
        }
    }
}
