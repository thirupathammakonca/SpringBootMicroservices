package com.thiruacademy.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.thiruacademy.entity.Student;
import com.thiruacademy.service.StudentService;
import com.thiruacademy.vo.StudentDepartmentVO;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/save")
	public Student saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	
	@GetMapping("/{id}")
	@CircuitBreaker(name="studentservice", fallbackMethod = "fallbackMethod")
	@ResponseStatus(HttpStatus.CREATED)
	@Retry(name="studentservice")
	@TimeLimiter(name="studentservice")
	public CompletableFuture<String> getStudentWithDepartment(@PathVariable Long id) {
		return CompletableFuture.supplyAsync(()->studentService.getStudentWithDepartment(id));
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	public CompletableFuture<String> fallbackMethod(@PathVariable Long id, RuntimeException ex) {
		return CompletableFuture.supplyAsync(()->"Service is down. Please try after some time.");
	}
}
