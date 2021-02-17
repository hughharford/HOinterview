package cucumber;

import com.posco.codesignal.rotateimage.RotateImage;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class RotateImageTest {

	private String arrayNameA;
	private String arrayNameB;

	private int[][] arrayForTestA;
	private int[][] arrayTargetA;
	private int[][] rotatedArrayA;
	
	private int[][] arrayForTestB;
	private int[][] arrayTargetB;
	private int[][] rotatedArrayB;
	
	private RotateImage rotor = new RotateImage();

	@Given("an n-by-n sorted array")
	public void given1(DataTable inputArrayNames) throws Throwable {
		List<String> list = inputArrayNames.asList(String.class);
		
		arrayNameA = list.get(0);
		arrayForTestA = getArrayForInput(arrayNameA);
		arrayNameB = list.get(1);
		arrayForTestB = getArrayForInput(arrayNameB);
/*		
  		USE THIS FOR OUTPUTTING THE ARRAY IF NEEDED
  		System.out.println("INPUT ARRAY ______ b ");
		rotor.output(arrayForTestB);
		System.out.println("\n");
*/
	}

	@When("the array is rotated")
	public void when() throws Throwable {
		rotatedArrayA = rotor.rotateArray(arrayForTestA);
		rotatedArrayB = rotor.rotateArray(arrayForTestB);
	}

	@Test
	@Then("the target should be returned")
	public void then(DataTable outputArrayNames) throws Throwable {
		List<String> list = outputArrayNames.asList(String.class);
		
		arrayNameA = list.get(0);
		arrayTargetA = getArrayForCheck(arrayNameA);
		
		arrayNameB = list.get(1);
		arrayTargetB = getArrayForCheck(arrayNameB);
		
		assertTrue("ARRAYS 'a' DO NOT MATCH", Arrays.equals(arrayTargetA, rotatedArrayA));
		assertTrue("ARRAYS 'b' DO NOT MATCH", Arrays.equals(arrayTargetB, rotatedArrayB));
		
	}
	
	private int[][] getArrayForInput(String in) {
		int[][] basic = {{1,2},{3,4}};
		int[][] a = {{1,2,3}, 
					 {4,5,6}, 
					 {7,8,9}};
		
		int[][] b = {{ 2, 4, 6, 8}, 
					 {10,12,14,16}, 
					 {18,20,22,24},
					 {26,28,30,32}};
		
		switch (in) {
	    case "a": return a;
	    case "b": return b;
	    default: return basic;
	    	// break; NOTE breaks taken out as returns end processing
	    }
	}
	
	private int[][] getArrayForCheck(String in) {
		int[][] basic = {{0,0},{0,0}};
		int[][] A = {{7,4,1}, 
				     {8,5,2}, 
				     {9,6,3}};
		
		int[][] B = {{26,18,10, 2}, 
				 	 {28,20,12, 4}, 
				 	 {30,22,14, 6},
				 	 {32,24,16, 8}};
		
		switch (in) {
	    case "A": return A;
	    case "B": return B;
	    default: return basic;
    		// break; NOTE breaks taken out as returns end processing
	    }
	}

}
