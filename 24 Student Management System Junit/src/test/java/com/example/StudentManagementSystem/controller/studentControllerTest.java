package com.example.StudentManagementSystem.controller;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.StudentManagementSystem.model.Student;
import com.example.StudentManagementSystem.service.StudentsService;


@WebMvcTest(controllers = studentsController.class)
public class studentControllerTest {
	
	@MockBean
	private StudentsService studentsService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void shouldTestGetStudentsApi() throws Exception {	
		List<Student> expectedList = new ArrayList();
		expectedList.add(
				new Student(1, 
						"Rakesh", 
						19, 
						"JUnit", 
						"Aryabhatta Hostels", 
						"rakesh@gmail.com", 
						"09874562134")
				);
		
		Mockito.when(studentsService.getStudents()).thenReturn(expectedList);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/students/getStudents"))
			.andExpect(MockMvcResultMatchers.status().isOk());
		
	}

}
