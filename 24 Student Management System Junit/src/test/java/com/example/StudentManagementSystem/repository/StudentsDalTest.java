package com.example.StudentManagementSystem.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.example.StudentManagementSystem.model.Student;

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StudentsDalTest {

	private static final MySQLContainer MY_SQL_CONTAINER = new MySQLContainer("mysql:latest")
				.withDatabaseName("student-test-db")
				.withUsername("testUser")
				.withPassword("password");
	
	static {
		MY_SQL_CONTAINER.start();
	}
	
	@DynamicPropertySource
	static void registerDatabaseProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.datasource.url", MY_SQL_CONTAINER::getJdbcUrl);
		registry.add("spring.datasource.username", MY_SQL_CONTAINER::getUsername);
		registry.add("spring.datasource.password", MY_SQL_CONTAINER::getPassword);
	}
	
	@Autowired
	StudentsDal studentsDal;
	
	@Test
	@Order(1)
	public void shouldSaveStudent() {
		Student student = new Student(1, 
				"Rakesh", 
				19, 
				"JUnit", 
				"Aryabhatta Hostels", 
				"rakesh@gmail.com", 
				"09874562134");
		
		Student resultStudent = studentsDal.save(student);
		assertThat(resultStudent)
			.usingRecursiveComparison()
			.ignoringFields("sid")
			.isEqualTo(student);
	}
}
