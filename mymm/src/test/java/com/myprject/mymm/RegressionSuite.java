package com.myprject.mymm;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegressionSuite {
  @Test
  public void testToPass() {
	  System.out.println("This is a test to Fail");
	  String str="Pass";
	  Assert.assertEquals(str, "Pass");
  }
  @Test
  public void testToFail() {
	  System.out.println("This is a test to pass");
	  String str="Pass";
	  Assert.assertEquals(str, "Fail");
  }  
}
