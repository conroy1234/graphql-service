package com.example.demo;

public class SomeBusinessServiceImpl implements SomeDataService {
	int[] val;
	int y;
	public void setValues(int[] val ){
		this.val=val;
		
	}
	@Override
	public int getValues() {
		for(int x:val) {
			y=+x;
		}
		return y;
	}
	
	
	
}
