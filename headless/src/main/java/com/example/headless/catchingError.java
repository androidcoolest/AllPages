package com.example.headless;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class catchingError {
	
	@Test
	public static void myTest (){
		// TODO Auto-generated method stub
		try{
			System.out.println(1/0);
		}catch(Exception e) {
			System.out.println("Inside Exception block");
			assertTrue(true);
		}
	}

}
