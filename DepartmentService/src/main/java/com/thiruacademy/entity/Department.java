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
@Table(name="tbl_department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long departmentId;
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;
}
