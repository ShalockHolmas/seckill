import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class Test {

    @Autowired
    RedisTemplate redisTemplate;

    @org.junit.Test
    public void test(){
        redisTemplate.getClientList();
    }
}
