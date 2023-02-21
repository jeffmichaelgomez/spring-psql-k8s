package com.mis.studentdata.controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mis.studentdata.entities.Students;
import com.mis.studentdata.outbound.OutboundChannel;
import com.mis.studentdata.service.StudentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;


@Component
@CrossOrigin (origins = "*")
@RestController
public class StudentController {

	@Autowired
	OutboundChannel gateway;
	
	private final StudentService studentService;
	
	public StudentController(StudentService studentService, OutboundChannel gateway) {
		this.gateway = gateway;
		this.studentService = studentService;
	}

	//get all student data
	@GetMapping("/students")
	public List<Students> getStudents() {
		gateway.sendMsgToPubSub("Student list using GET Method:\n "+ studentService.getStudents().toString());
		return studentService.getStudents();
	}
	
	//add a new student
	@PostMapping("/students")
	public List<Students> addStudent(@RequestBody Students student) {
		gateway.sendMsgToPubSub("Student has been added using POST Method:\n"+ studentService.addStudent(student).toString());
	    return studentService.addStudent(student);
	}
	
	//update a student data
	@PutMapping("/students/{id}")
	public List<Students> updateStudent(@PathVariable Long id, @RequestBody Students student) {
		gateway.sendMsgToPubSub("Updated a student using PUT Method:\n" + studentService.updateStudent(id, student).toString());
		return studentService.updateStudent(id, student);
	}
	
	//delete a student data
	@DeleteMapping("/students/{id}")
	public List<Students> deleteStudent(@PathVariable Long id) {
		gateway.sendMsgToPubSub("Delete student data using DELETE Method:\n"+ studentService.deleteStudent(id).toString());
	    return studentService.deleteStudent(id);
	}
	
	//Update partially student data
	@PatchMapping("/students/{id}")
	public List<Students> patchStudent(@PathVariable Long id, @RequestBody Students student) {
		gateway.sendMsgToPubSub("Update a student using PATCH Method:\n"+ studentService.patchStudent(id, student).toString());
	    return studentService.patchStudent(id, student);
	}
	
	//Get specific student
	@GetMapping("/students/{id}")
	public Students getStudent(@PathVariable Long id) {
		gateway.sendMsgToPubSub("Student data using GET Method:\n"+ studentService.getStudent(id).toString());
	    return studentService.getStudent(id);
	}

}

