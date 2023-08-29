package com.icicibk.empms.dto;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
	
	
	private String empId;
	private String empFirstName;
	private String empLastName;
	private String empAddress;
	private float empSalary;
	private String contactNumber;
	
	

}
