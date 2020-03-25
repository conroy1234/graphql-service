package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

import com.example.demo.Menu.Type;

public class MenuTest implements dtos {

	String name="A";
	List<String> stri = new ArrayList<String>();
	
	Menu men = new Menu();
	@Test
	public void test() {
		List<String> groupDishes= dishes.stream()
				.filter(p ->p.getName().equals("Cabbage"))
				.map(Menu::getName)
				.collect(Collectors.toList());
		men.setName(groupDishes.get(0));
		assertEquals(groupDishes.size(),1);
		assertEquals(men.getName(),"Cabbage");
	}

	
	List<Menu> dishes = Arrays.asList(new Menu(1, 2, "Chicken", Menu.Type.MEAT),
			new Menu(5, 5, "Beef", Menu.Type.MEAT),new Menu(1, 2, "Pork", Menu.Type.MEAT),
			new Menu(1, 2, "Cabbage", Menu.Type.VEGATABLE),new Menu(6, 16, "mango", Menu.Type.FRUIT));
	
	
	@Test
	public void streamTest() {
		stri.add(name);
	List<String> l=	stri.stream().filter(n->n.equalsIgnoreCase("A") && n.startsWith("A")).collect(Collectors.toList());
	assertEquals(l.get(0),"A");
	assertEquals(l.size(),1);
	}
	
	
	
	@Test
	public void mapping() {
		List<Person> person= Arrays.asList(new Person(13),new Person(20));
		List<PersonDto> personDto=person.stream().map( m->{
			PersonDto dto = new PersonDto(m.getAge());
			return dto;
		}).collect(Collectors.toList());
		PersonDto val = personDto.get(0);
		assertEquals(val.getAge(),13);
		assertThat(personDto.get(0)).hasNoNullFieldsOrProperties();
		
		List<PersonDto>pers = Arrays.asList(new PersonDto(20),new PersonDto(10),new PersonDto(5),new PersonDto(8),new PersonDto(7));
		
//		double avg=pers.stream()
//	    .mapToDouble(PersonDto::getAverage)
//	    .average()
//	    .orElse(0);
//		
		
	}
	
	@Test
	public void average() {
		Integer number[] = {12,10,7,85,96,9,2,10,35};
		
		int avgs = Arrays.stream(number).filter(p->p >50).findAny().get();
		
		System.out.println(avgs);
	}
}





