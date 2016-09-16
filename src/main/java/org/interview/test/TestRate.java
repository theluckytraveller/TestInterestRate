package org.interview.test;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterTest;


public class TestRate {
	
	@DataProvider
	//get test data and expected result from the csv file (with the same name as the class name)
	public Iterator<Object []> csvDataProvider() throws IOException {
		return Common.csvDataProvider(this.getClass().getSimpleName());
  
	}
	
	@BeforeTest
	  public void beforeTest() throws IOException {
		//Here should be preconditions to the test
		//Depends on requirements and tested system itself the annotation of this method can be different (@BeforeGroup, @BeforeSuite)
		Common.setProperties();
	  }
	
	@Test(dataProvider = "csvDataProvider")
	  public void testRate(Object objInputValue, Object objExpectedResult) {
		  //convert Object to int
		  double inputValue = Double.valueOf((String) objInputValue);
		  double expectedResult = Double.valueOf((String) objExpectedResult);
		  //get actual result from the tested system
		  double actualResult = getAccountRate(inputValue);
		  //compare the result with the expected one
		  Assert.assertEquals(actualResult , expectedResult, Double.valueOf(Common.getProperty(Common.TOLERANCE_INTERESTRATE)), "Compare actual result " + actualResult + " with the expected result " + expectedResult);
	  }
	

	@AfterTest
	  public void afterTest() {
		//Here should be postconditions to the test: return the system to the normal state (if necessary)
		//Depends on requirements and tested system itself the annotation of this method can be different (@AfterGroup, @AfterSuite)
	  }
	
	private double getAccountRate(double inputValue) {
		System.out.println("Get rate value for " + inputValue);
		// Here should be a call or a query to tested system
		double actualResult = inputValue * 0.03; //temporary
		return actualResult;
	}


}
