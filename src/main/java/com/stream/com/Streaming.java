package com.stream.com;



import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.example.demo.Person;

public class Streaming {

	static List<Person> person = Arrays.asList(new Person(23),new Person(10),new Person(5),new Person(15),
			new Person(40),new Person(70),new Person(100)
			);
	
	public static void main(String[] args) {
//		//List<Person> result = person.stream().filter(p -> p.getAge()< 70).limit(5).collect(Collectors.toList());
//		//result.forEach(System.out::println);
//		IntStream.range(0, 10).forEach(System.out::println);
//		IntStream.range(0, person.size()).forEach(index->{
//			Person pers = person.get(index);
//			System.out.println(pers);
//		});;
		
		IntStream.iterate(1, operand -> operand+1)
		.filter(number ->number % 2==0).limit(20).forEach(System.out::println);
		
		List<Integer> numbers = Arrays.asList(1,3,5,7,8,100,23,64);
		
		Integer min = numbers.stream().max(Comparator.naturalOrder()).get();
		System.out.println(" min is "+min);
	}

}
