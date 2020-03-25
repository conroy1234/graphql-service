package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CalculateTest {
	
	@Test
	public void reflect() {
		Class<Calculater> cal = null;
		try {
			 cal = (Class<Calculater>) Class.forName("com.example.demo.Calculatore");
			 //cal.calcul(new double [] {20,10,45,78});
			 System.out.println(cal.getPackage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	Generix<Integer> gen = new Generix<Integer>();
	double result = Calculatore.calcul(new double [] {20,10,45,78});
	@Test
	public void calTest() {
		assertNotNull(result);
	}
	@SuppressWarnings("deprecation")
	@Test
	public void calculateTest() {
		double num = 100.0;
		
		System.out.println(gen.calculate(20, 10)+" || "+gen.calculate(30, 15));
		Generix.sum(Arrays.asList(2,8,9,6,7,4,5));
		assertNotNull(Calculatore.sum(Arrays.asList(10.4,10.4,10.6,10.7,10.2,10.5,20.1,20.9)));
		
		List<Serializable> myadd= new ArrayList<Serializable>();
		myadd.add("conroy");
		myadd.add("delroy");
		myadd.add("stephen");
		myadd.add("carol");
		myadd.add("thomas");
		myadd.add(5);
		
		Calculatore.sum2(myadd);
	}
	
	
	
	@Test
	public void sort() {
		List<String> list = new ArrayList<String>();
		list.add("b");
		list.add("a");
		list.add("c");
		list.add("e");
		list.add("d");
		list.add("g");
		list.add("f");
		
		
		
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String first, String second) {
			
				return first.compareTo(second);
			}
		});
		for(String s:list) {
			System.out.println(s);
		}
	}
}
