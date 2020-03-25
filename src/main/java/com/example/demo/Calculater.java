package com.example.demo;

public class Calculater {
	
	public int calculate(int [] sum) {
		int x=0;
		for(int val:sum) {
			x+=val;
			System.out.print(x);
		}
		return x;
	}

}
