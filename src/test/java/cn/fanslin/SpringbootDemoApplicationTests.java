package cn.fanslin;

import cn.fanslin.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class SpringbootDemoApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private RedisTemplate redisTemp;

	@Autowired
	private RedisTemplate<String, User> redisTemplate;

	@Test
	public void test() throws Exception {
		// 保存字符串
//		stringRedisTemplate.opsForValue().set("aaa", "111");
//		Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));

		// 保存对象
		User user = new User("超人", 30);
		redisTemplate.opsForValue().set(user.getUsername(), user);

		user = new User("蝙蝠侠", 35);
		redisTemplate.opsForValue().set(user.getUsername(), user);

		user = new User("蜘蛛侠", 20);
		redisTemplate.opsForValue().set(user.getUsername(), user);

		Assert.assertEquals(30, redisTemplate.opsForValue().get("超人").getAge().longValue());
		Assert.assertEquals(35, redisTemplate.opsForValue().get("蝙蝠侠").getAge().longValue());
		Assert.assertEquals(20, redisTemplate.opsForValue().get("蜘蛛侠").getAge().longValue());

		System.out.println(redisTemplate.opsForValue().get("超人").toString());
		System.out.println(redisTemplate.opsForValue().get("蝙蝠侠").toString());
		System.out.println(redisTemplate.opsForValue().get("蜘蛛侠").toString());

	}

}
