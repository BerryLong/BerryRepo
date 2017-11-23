
import org.springframework.web.client.RestTemplate;

public class App3 {

    public static void main(String[] args) throws Exception {
        // Spring - RestTemplate
        RestTemplate template = new RestTemplate();
        NewsData newsData =
                template.getForObject("http://api.avatardata.cn/Joke/QueryJokeByTime?key=0446a80169034e7fa28e9c58953c9c1a&page=2&rows=10&sort=asc&time=1418745237",
                        NewsData.class);

        for(News news:newsData.getResult()){
            System.out.println(news.getContent());
        }
    }
}
