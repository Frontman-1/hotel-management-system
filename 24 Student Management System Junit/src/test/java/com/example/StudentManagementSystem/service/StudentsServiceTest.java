package com.example.StudentManagementSystem.service;

import static org.mockito.ArgumentMatchers.intThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.StudentManagementSystem.model.Student;
import com.example.StudentManagementSystem.repository.StudentsDal;

@SpringBootTest
public class StudentsServiceTest {
	
	@Mock
	StudentsDal studentsDal;
	
	StudentsService studentsService;
	
	@BeforeEach
	public void setup() {
		studentsService = new StudentsService(studentsDal);
	}
	
	@Test
	@DisplayName("should increase the value of param by 1")
	public void shouldTestIncreementService() {
		int num = 0;
		int result = studentsService.increementService(num);
		Assertions.assertEquals(result, num+1);
	}
	
	@Test
	@DisplayName("should not increase the value of param by 1")
	public void shouldFailTestIncreementService() {
		int num = 0;
		int result = studentsService.increementService(num);
		Assertions.assertNotEquals(result, num);
	}
	
	@Test
	@DisplayName("should return list of all the students")
	public void shouldTestGetStudents() {
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
		Mockito.when(studentsDal.findAll())
		.thenReturn(expectedList);
		
		List<Student> resultList = studentsService.getStudents();
		Assertions.assertEquals(expectedList.size(), resultList.size());
	}
	
	@Test
	public void shouldTestDeleteStudent() {
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
		expectedList.add(
				new Student(2, 
						"Dinesh", 
						20, 
						"C++", 
						"Aryabhatta Hostels", 
						"rakesh@gmail.com", 
						"09874562134")
				);
		
		int sid = 1;
		Mockito.doNothing().when(studentsDal).deleteById(sid);
		Mockito.when(studentsDal.existsById(sid)).thenReturn(true);
		
		Boolean resultBoolean = studentsService.deleteStudent(sid);
		Assertions.assertEquals(resultBoolean, true);
	}
	
	@Test
	public void shouldNotTestDeleteStudent() {
		List<Student> expectedList = new ArrayList<>();
		expectedList.add(
				new Student(1, 
						"Rakesh", 
						19, 
						"JUnit", 
						"Aryabhatta Hostels", 
						"rakesh@gmail.com", 
						"09874562134")
				);
		expectedList.add(
				new Student(2, 
						"Dinesh", 
						20, 
						"C++", 
						"Aryabhatta Hostels", 
						"rakesh@gmail.com", 
						"09874562134")
				);
		
		int sid = 1;
		Mockito.doNothing().when(studentsDal).deleteById(sid);
		Mockito.when(studentsDal.existsById(sid)).thenReturn(false);
		
		Boolean resultBoolean = studentsService.deleteStudent(sid);
		Assertions.assertEquals(resultBoolean, false);
	}
}
