package com.spring.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
public class UserBean {
	@NotNull
	private Integer id;
	@Range(min=1,max=100)
	private Integer age;
	@NotEmpty
	private String name;
	
	private String gender;
	private String frameworks;
	private String number;
	private String country;
}
