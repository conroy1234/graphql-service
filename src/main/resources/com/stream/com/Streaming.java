package com.stream.com;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streaming {

	static List<Integer> person = Arrays.asList(20,10,45,60,5,18,9);
	
	public static void main(String[] args) {
		List<Inteder> result = person.stream().filter(p -> p< 10).collect(Collectors.toList());
		person.forEach(System.out::println);

	}

}
