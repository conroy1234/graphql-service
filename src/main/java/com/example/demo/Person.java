package com.example.demo;

public class Person {

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

	public Person(int age) {
		super();
		this.age = age;
	}
	
	
}
