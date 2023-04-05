package com.thiruacademy.vo;

import com.thiruacademy.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDepartmentVO {
	private Student student;
	private Department department;
}
