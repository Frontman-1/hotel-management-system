package com.cn.hotel.integration;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testcontainers.containers.MySQLContainer;

import com.cn.hotel.jwt.JwtAuthenticationHelper;
import com.cn.hotel.model.Hotel;
import com.cn.hotel.service.HotelService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.With;

import static java.util.Arrays.asList;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.aspectj.lang.annotation.Before;

@SpringBootTest
@AutoConfigureMockMvc
public class HotelControllerIntegrationTest {

	private static final MySQLContainer MY_SQL_CONTAINER = new MySQLContainer<>("mysql:latest")
			.withDatabaseName("hotel-test-db")
			.withUsername("testUser")
			.withPassword("password");

	@BeforeAll
	static void beforeAll(){
		MY_SQL_CONTAINER.start();
	}

	@AfterAll
	static void AfterAll(){
		MY_SQL_CONTAINER.stop();
	}

	@DynamicPropertySource
	static void registerDatabaseProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.datasource.url", MY_SQL_CONTAINER::getJdbcUrl);
		registry.add("spring.datasource.username", MY_SQL_CONTAINER::getUsername);
		registry.add("spring.datasource.password", MY_SQL_CONTAINER::getPassword);
	}

	@Autowired
	private MockMvc mockMvc;

	static String asJsonString(final Object obj) {
       try {
           return new ObjectMapper().writeValueAsString(obj);
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
	}

	@Test
	@WithMockUser(roles = "ADMIN")
	public void shouldTestGetAllHotels() throws Exception {
		Hotel hotel = new Hotel();
		hotel.setId(1L);
		hotel.setName("Raddison Hotel");
		hotel.setRating((long)4.6);
		hotel.setCity("Bangalore");

		mockMvc.perform(MockMvcRequestBuilders
				.post("/hotel/create")
				.contentType("application/json")
				.content(asJsonString(hotel))
				);

	}
}
