package com.example.demo;

public class Menu {

	private int price;
	private int colories;
	private String name;
	private Type type;
	
	
	
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Menu(int price, int colories, String name, Type type) {
		super();
		this.price = price;
		this.colories = colories;
		this.name = name;
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getColories() {
		return colories;
	}

	public void setColories(int colories) {
		this.colories = colories;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "Menu [price=" + price + ", colories=" + colories + ", name=" + name + ", type=" + type + "]";
	}


	enum Type{
		MEAT,VEGATABLE,FRUIT
	}
}
