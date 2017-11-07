import com.qfedu.ann.config.AppConfig;
import com.qfedu.ann.domain.User;
import com.qfedu.ann.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class AppTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
        System.out.println(userMapper);
        User user = userMapper.findByUsername("asd");
        System.out.println(user.getEmail());
    }
}
