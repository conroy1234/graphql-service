package com.example.demo;

import java.util.List;

public class Generix<T extends Comparable<T>> {
	
	public T calculate(T t1, T t2) {
		if(t1.compareTo(t2)<0)
			return t1;
		
		return t2;		
	}
	
	public T calculate2(T t1, T t2) {
		if(t1.compareTo(calculate(t1, t2))<0)
			return t1;
		
		return t2;		
	}
	
	public static void sum(List<? extends Number> list) {
		double num =0.0;
		
		for(Number n:list) {
			num = (num)+(n.doubleValue());
		
		}
		System.out.println("number is ="+num);
	}
	
}
