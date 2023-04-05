package com.thiruacademy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="table_student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long studentId;
	private String firstName;
	private String lastName;
	private String email;
	private Long departmentId;
}
