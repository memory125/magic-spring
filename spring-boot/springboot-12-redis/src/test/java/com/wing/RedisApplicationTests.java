package com.wing;

import com.wing.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;


@SpringBootTest
class RedisApplicationTests {

	@Autowired
	@Qualifier("redisTemplate")
	RedisTemplate redisTemplate;

	@Test
	void contextLoads() {
		User user = new User("Jack", 20);
		redisTemplate.opsForValue().set("user", user);
		System.out.println(redisTemplate.opsForValue().get("user"));
	}

}
