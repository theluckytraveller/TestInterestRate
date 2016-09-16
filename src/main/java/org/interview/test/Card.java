package org.interview.test;

public class Card {

	public Card() {
		
	}
	
	public int enterPIN(String pin) {
		  int result = 1;
		  System.out.println("Enter PIN: " + pin);
		  //...
		  result = Common.RESULT_OK; //temporary
		  return result;
	  }

	public int activatePINInput() {
	  System.out.println("Activate PIN input");
	  int result = 1;
	  /*long timeout = Long.parseLong(Common.getProperty(Common.PIN_TIMEOUT));
	  Thread thread = new Thread(new Runnable() {
		  public void run() {
			  System.out.println("Start activation...");
			//Here should be a call/query to the tested system
			 
		  }
	  }
			  );
	  long startTime = System.currentTimeMillis();
	  thread.start();
	  while ((System.currentTimeMillis() - startTime) < timeout) {
		  //Here should be check if the system is ready for PIN input
		  //...
		  result = 0;
	  }
	  //... */
	  result = Common.RESULT_OK; //temporary
	  return result;
	}
	
	public int getCardStatus() {
		System.out.println("Get card status");
		return Common.RESULT_OK;
	}
	
	public int getAccountStatus() {
		System.out.println("Get account status");
		return Common.RESULT_OK;
	}
}
