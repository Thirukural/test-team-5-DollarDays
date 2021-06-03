package com.dd.framework.factory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadFromJson {
	
	private static Logger logger = LogManager.getLogger(ReadFromJson.class.getName());


	
	/*
	 * 
	 * Method declaration to read from json files and return as Map. File name is passed as argument.
	 * 
	 */
	
	public static Map<String,String> getJSONMap(String filename){
		 
		  Map<String, String> returnMap = null;
		 		  
		  try {
			   //create ObjectMapper instance - Class from com.fasterxml.jackson.core dependency in pom.xml
				ObjectMapper objectMapper = new ObjectMapper();
				
				//convert json List of strings to object
				returnMap = objectMapper.readValue(new File(System.getProperty("user.dir")+"/src/test/resources/"+filename+".json"), Map.class);	
				
		  		} catch (JsonGenerationException e) {
					logger.error("ERROR!!! Cannot generate Json "+e.getMessage());
					e.printStackTrace();
		  		} catch (JsonMappingException e) {
		  			logger.error("ERROR!!! Json mapping is inaccurate "+e.getMessage());
		  			e.printStackTrace();
		  		} catch (IOException e) {
		  			logger.error("ERROR!!! Cannot read the Json file "+e.getMessage());
		  			e.printStackTrace();
		  		}
			return returnMap;
	  }
	/*public static Map<String,Object> getJSONMapObject(String filename){
		 
		  Map<String, Object> returnMap = null;
		 		  
		  try {
			   //create ObjectMapper instance - Class from com.fasterxml.jackson.core dependency in pom.xml
				ObjectMapper objectMapper = new ObjectMapper();
				
				//convert json List of strings to object
				returnMap = objectMapper.readValue(new File(System.getProperty("user.dir")+"/src/test/resources/"+filename+".json"), Map.class);	
				
		  		} catch (JsonGenerationException e) {
					logger.error("ERROR!!! Cannot generate Json "+e.getMessage());
					e.printStackTrace();
		  		} catch (JsonMappingException e) {
		  			logger.error("ERROR!!! Json mapping is inaccurate "+e.getMessage());
		  			e.printStackTrace();
		  		} catch (IOException e) {
		  			logger.error("ERROR!!! Cannot read the Json file "+e.getMessage());
		  			e.printStackTrace();
		  		}
			return returnMap;
	  }
	  */
}
