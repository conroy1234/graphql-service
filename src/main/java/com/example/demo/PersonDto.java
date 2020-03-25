package com.example.demo;

import java.util.Arrays;
import java.util.List;

public class PersonDto {
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + "]";
	}

	public PersonDto(int age) {
		super();
		this.age = age;
	}
	

}
