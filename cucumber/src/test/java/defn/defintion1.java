package defn;

import cucumber.api.java.en.Given;

import org.testng.annotations.*;

@Test
public class defintion1 {
    @Given("^Ethere are 1 coffees left in the machine")
	public void doSomething()
	{
    	System.out.print("Prints");
	}
}
