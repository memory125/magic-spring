package com.wing;

import com.wing.consumer.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConsumerApplicationTests {

	@Autowired
	UserService userService;

	@Test
	void contextLoads() {
		userService.bugTicket();
	}
}
