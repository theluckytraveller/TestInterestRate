package org.interview.test;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.Iterator;

import javax.naming.spi.DirStateFactory.Result;

import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestCardPIN {

	public static int bitMask1 = 00000001;
	public static int bitMask2 = 00000010;
	public static int bitMask3 = 00000100;
	
  @DataProvider
  //read test data and expected result from comma-separated csv file: <pin1>,<pin2>,<pin3>,<bit flag>
  public Iterator<Object []> csvDataProvider() throws IOException {
		return Common.csvDataProvider(this.getClass().getSimpleName());
  }	  
	

  @BeforeTest
  public void beforeTest() {
	  //precondition: start tested system and/or provide basic sanity check (== the system is running and is in a normal state)
	  System.out.println("Precondition: start tested system and/or provide basic sanity check");
  }
  
  @Test(dataProvider = "csvDataProvider")
  public void testPINCycle(Object objPin1, Object objPin2, Object objPin3, Object objExpectedState) {
	    int expectedState = Integer.valueOf((String) objExpectedState);
	    String pin1 = objPin1.toString();
	    String pin2 = objPin2.toString();
	    String pin3 = objPin3.toString();
	   	switch(expectedState) {
	   		case(0): testValidPINFirstAttemp(pin1, expectedState); break;
	   		case(1): testValidPINSecondAttemp(pin1, pin2, expectedState); break;
	   		case(3): testValidPINThirdAttemp(pin1, pin2, pin3, expectedState); break;
	   		default: testInvalidPIN(pin1, pin2, pin3, expectedState);
	   	}
  }
  
  public void testValidPINFirstAttemp(String pin, int expectedState) {
	  Card card = new Card();
	  System.out.println("Positive case: testValidPINFirstAttemp");
	  //step 0: activate PIN input
	  int result =  card.activatePINInput();
	  int expectedResult = expectedState & bitMask1;
	  //check that system is ready to PIN input
	  Assert.assertEquals(result, Common.RESULT_OK, "Is active for PIN input");
	  //step 1: enter PIN1
	  result = card.enterPIN(pin);
	  //check result with the expected one
	  Assert.assertEquals(result, expectedResult, "First PIN check");
	  //check that the card isn't eaten and the account is available
	  Assert.assertEquals(card.getCardStatus(), Common.RESULT_OK, "Check that the card isn't eaten");
	  Assert.assertEquals(card.getAccountStatus(), Common.RESULT_OK, "Check the account is available");
  }
  
  public void testValidPINSecondAttemp(String pin1, String pin2, int expectedState) {
	  System.out.println("Positive case: testValidPINSecondAttemp");
	  //step 0: activate PIN input
	  Card card = new Card();
	  int result =  card.activatePINInput();
	  int expectedResult = expectedState & bitMask1;
	  //check that system is ready to PIN input
	  Assert.assertEquals(result, Common.RESULT_OK, "Is active for PIN input");
	  //step 1: enter PIN1
	  result = card.enterPIN(pin1);
	  //check result with the expected one
	  Assert.assertEquals(result, expectedResult, "First PIN check");
	  //check that the card isn't eaten but the account isn't available still
	  Assert.assertEquals(card.getCardStatus(), Common.RESULT_OK, "Check that the card isn't eaten");
	  Assert.assertNotEquals(card.getAccountStatus(), Common.RESULT_OK, "Check the account is not available");
	  //step 2: enter PIN2
	  result = card.enterPIN(pin2);
	  expectedResult = expectedState & bitMask2;
	  //check result with the expected one
	  Assert.assertEquals(result, expectedResult, "Second PIN check");
	  //check that the card isn't eaten and the account is available
	  Assert.assertEquals(card.getCardStatus(), Common.RESULT_OK, "Check that the card isn't eaten");
	  Assert.assertEquals(card.getAccountStatus(), Common.RESULT_OK, "Check the account is available");
  }
  
  public void testValidPINThirdAttemp(String pin1, String pin2, String pin3, int expectedState) {
	  System.out.println("Positive case: testValidPINThirdAttemp");
	  //step 0: activate PIN input
	  //check that system is ready to PIN input
	  //step 1: enter PIN1
	  //check result with the expected one
	  //check that the card isn't eaten but the account isn't available still
	  //step 2: enter PIN2
	  //check result with the expected one
	  //check that the card isn't eaten but the account isn't available still
	  //step 3: enter PIN3
	  //check result with the expected one
	  //check that the card isn't eaten and the account is available
  }
  
  
  
  //negative case
  public void testInvalidPIN(String pin1, String pin2, String pin3, int expectedState) {
	  System.out.println("Negative case: testInvalidPIN");
	  //step 0: activate PIN input
	  //check that system is ready to PIN input
	  //step 1: enter PIN1
	  //check result with the expected one
	  //check that the card isn't eaten but the account isn't available still
	  //step 2: enter PIN2
	  //check result with the expected one
	  //check that the card isn't eaten but the account isn't available still
	  //step 3: enter PIN3
	  //check result with the expected one
	  //check that the card is eaten and the account isn't available
  }

  @AfterTest
  public void afterTest() {
	  //postcondition: return the tested system to a normal state (as it was before the test starting)
	  System.out.println("Postcondition: return the tested system to a normal state");
  }

}
