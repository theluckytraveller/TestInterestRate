General description about the package
_________________________________________________________________________________________________________________
The package was created on Java by using TestNG (testng.org) and com.google.guava_1.6.0.jar libraries.
Test data exists in comma-separated csv files for each automated test.
The solutions are as simple and easy as they can be according to requirement about "short script". But in any reason they aren't finished and ready to use as a lot of methods should be yet implemented.
So the tests itself are just black drafts and should be clarified by tested system and its requirements.
   
Task 1 (PIN input)
You can find the source code for this task in TestCardPIN.java, Card.java and Common.java. The data file is in the "TestCardPIN.csv"
The solution based upon common data input file for all test cases but separated method for each piece of logic 

Task 2
1. Manual: What balance value(s) would you use to test % charging?

Solution
___________________________________________________________________________________________________________________
Balance values for positive test cases: 1, 100, 101, 1000, 1001, 1000500.75
Balance values for negative test cases: -100, 0
Depending on system requirements and type of tested system itself it can be also: 1e1, “<b>100</b>”, “!£$^dfd”, etc
___________________________________________________________________________________________________________________   

2. Automated (Interest rate)

Solution
___________________________________________________________________________________________________________________
You can find the solution in the file "TestRate.java" (source code) and "TestRate.csv" (data input and expected result)
Expected result for each test case in this task isn't calculated inside the code by design to make automated tests more reliable 