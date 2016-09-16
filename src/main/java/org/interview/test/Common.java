package org.interview.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class Common {
	public static final String FILE_PROPERTY = "data.testrate";
	public static final String CSV_DELIMETER = "data.csvdelimeter";
	public static final String PIN_TIMEOUT = "data.pin.timeout";
	public static final String TOLERANCE_INTERESTRATE = "data.tolerance.interestrate";
	public static final int RESULT_OK = 0;
	private static Properties properties = new Properties();
	
	public Common() throws IOException {
				setProperties();
			}
	
	public static void setProperties() throws IOException {
		if (properties.isEmpty())	{
			FileInputStream propertyFile = new FileInputStream(getPathData() + "project.properties");
		    properties.load(propertyFile);
		    System.out.println("properties = " + properties.toString());
		}
	}

		
	public static String getProperty (String propertyName) {
		return properties.getProperty(propertyName);
	}
	
	public static String getPathData() {
		return Common.class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("bin", "src/main/resources") + "/";
	}
	
	// get test data from the csv file
	public static Iterator<Object []> csvDataProvider(String fileName) throws IOException {
		List<Object []> testData = new ArrayList<>();
        String[] data= null;
        String line;
        setProperties();
        String csvDelimeter = getProperty(CSV_DELIMETER);
        BufferedReader bReader = new BufferedReader(new FileReader(Common.getPathData() + fileName + ".csv")); //this.getClass().getSimpleName());
        while ((line = bReader.readLine()) != null) {
            data = line.split(csvDelimeter);
            testData.add(data);
        }
        return testData.iterator();
  }
	
}
