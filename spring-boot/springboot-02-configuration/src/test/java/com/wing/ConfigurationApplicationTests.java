package com.wing;

import com.wing.pojo.Staff;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConfigurationApplicationTests {

	@Autowired
	private Staff staff;

	@Test
	void contextLoads() {
		/*
		Staff(name=Jack,
		age=35,
		hobbies=[coding, music, reading, electronics, swimming, badminton, hiking, riding],
		credentials={IDCard=25544545, BookCard=8956622, StudentCard=622323, StaffID=9852626, DirverLisence=BX1545125},
		isMarried=false)
		 */
		System.out.println(staff);
	}

}
