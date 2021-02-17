package cucumber;

import static org.junit.Assert.assertEquals;

import java.util.List;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class DoChopDataTableTest {

	@Given("an integer array")
	public void an_integer_array(DataTable simpleDataIn) throws Throwable {

		//Write the code to handle Data Table
		List<List<String>> data = simpleDataIn.asLists();

		System.out.println("First Row + 1st Column: " + data.get(0).get(0));
		System.out.println("First Row + 2nd Column: " + data.get(0).get(1));

		//This is to get the first data of the set (First Row + First Column)
		// driver.findElement(By.id("log")).sendKeys(data.get(0).get(0)); 
	}

	@When("the array is checked for the target")
	public void the_array_is_checked_for_the_target(DataTable moreData) throws Throwable {
	}

	@Then("the index should be returned")
	public void then_the_index_should_be_returned(DataTable evenMoreData) throws Throwable {
		assertEquals(1, 1);
	
	}

}
