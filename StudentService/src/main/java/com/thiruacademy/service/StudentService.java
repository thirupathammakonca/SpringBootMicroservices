package com.thiruacademy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.thiruacademy.entity.Student;
import com.thiruacademy.repository.StudentRepository;
import com.thiruacademy.vo.Department;
import com.thiruacademy.vo.StudentDepartmentVO;

@Service
public class StudentService {
	
	private String baseUrl = "http://DEPARTMENTSERVICE:8090/department/";
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private MailService mailService;
	
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public String getStudentWithDepartment(Long id) {
		Student student = studentRepository.findById(id).get();
		Department department = restTemplate.getForObject(baseUrl+student.getDepartmentId(), Department.class);
		/*
		 * StudentDepartmentVO vo = new StudentDepartmentVO();
		 * vo.setDepartment(department); vo.setStudent(student);
		 */
		StringBuffer buffer = new StringBuffer();
		buffer.append("Please find below ");
		buffer.append("\n");
		buffer.append(student.getStudentId()+"  "+student.getFirstName()+ "  "+student.getLastName()+"  "+student.getEmail()+"  "+student.getDepartmentId());
		buffer.append("\n");
		buffer.append(department.getDepartmentName()+"  "+department.getDepartmentCode()+"  "+department.getDepartmentAddress());
		mailService.sendMail("kthiru.50@gmail.com", "StudentWithDepartmentInfo", buffer.toString());
		return "Student with department details send to email";
	}
}
