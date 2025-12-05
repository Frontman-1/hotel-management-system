package com.example.StudentManagementSystem.service;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudentManagementSystem.model.Student;
import com.example.StudentManagementSystem.repository.StudentsDal;
import org.slf4j.Logger;

@Service
public class StudentsService {

	
	private final StudentsDal studentDal;
	
	Logger logger = LoggerFactory.getLogger(StudentsService.class);
	
	@Autowired
	public StudentsService(StudentsDal studentsDal) {
		this.studentDal = studentsDal;
	}
	

	public int increementService(int num) {
		return num+1;
	}
	
	public List<Student> getStudents(){
		logger.info("getStudent() service!");
		return studentDal.findAll();
	}

	public Student addStudent(Student student) {
		return studentDal.save(student);
	}

	public boolean deleteStudent(int sid) {
		if(studentDal.existsById(sid)) {
			studentDal.deleteById(sid);
			return true;
		}
		return false;
	}
}
