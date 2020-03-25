package com.example.demo;

import java.util.List;

public class Calculatore {

	public static double sum(List<? extends Number> list) {
		double number  =0.0;
		
		for(Number n:list) {
			number = number + n.doubleValue();
		}
		System.out.println(number);
		return number;
	}
	
	public static void sum2(List<? super Number> list) {
		
		for(Object o:list)
			System.out.println(o);
		
	}
	
	
	public static double calcul(double num[]) {
		double number =0.0;
		for(Double d:num) {
			number = number +d.doubleValue();
			System.out.println("the sum is "+number);
		}
		return number;
		
	}
}
