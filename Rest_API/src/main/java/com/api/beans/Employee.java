package com.api.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Employee {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String company;
	private Double salary;

}
