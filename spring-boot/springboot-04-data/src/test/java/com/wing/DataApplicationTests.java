package com.wing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class DataApplicationTests {

	@Autowired
	DataSource dataSource;

	@Test
	void contextLoads() throws SQLException {
		/*
		class com.zaxxer.hikari.HikariDataSource
		 */
		System.out.println(dataSource.getClass());

		// 获得连接
		/*
		  异常:
		 	The last packet sent successfully to the server was 0 milliseconds ago. The driver has not received any packets from the server.
		 */
		Connection connection = dataSource.getConnection();

		System.out.println(connection);

		// 关闭
		connection.close();
	}

}
