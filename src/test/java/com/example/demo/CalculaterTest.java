package com.example.demo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class CalculaterTest {
	
	SomeDataService service =mock(SomeDataService.class);
	SomeBusinessServiceImpl impl = new SomeBusinessServiceImpl();
	
	@Before
	public void setUp() {
		
		impl.setValues(new int[] {2,8,9});
	}
	@Test
	public void testCalculate() {
		Calculater calculater = new Calculater();
		int expected = calculater.calculate(new int[] {3,5,8,6,5,2,4});
		
		int actual =33;
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void someBusinessServiceTest() {
		service.setValues(new int[] {2,8,9});
		when(service.getValues()).thenReturn(19);
		assertEquals(service.getValues(), 19);
	}

	@Test
	public void someBusinessServiceEmptyTest() {
		service.setValues(new int[] {});
		when(service.getValues()).thenReturn(0);
		assertEquals(service.getValues(), 0);
	}
}
