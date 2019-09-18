package com.ihealthPharmacy.stock.service;

import com.ihealthPharmacy.stock.model.Table;

public class ExcelService {
	
	
	public static String findDataSize(String givenString,String startIndex,String endIndex) {	
		
		 int firstIndex=givenString.indexOf(startIndex);
		 int secondIndex=givenString.indexOf(endIndex);
		 String data =givenString.substring(firstIndex+1,secondIndex);		 
		 
		 return data;
	}
	
	
	public static String findColumnName(String inputLine) {
		System.out.println("check"+inputLine);
		
		
		 //String givenString="CREATE TABLE `user_roles` ( `USER_ROLES_ID` int(11) NOT NULL AUTO_INCREMENT,"; 		 
		 
		 String splitArray[]=inputLine.trim().split(" "); 
		 
		 
		 for(String each:splitArray){
			 
			 if(inputLine.startsWith(" ")){
				 System.out.println(each+"\n");
			 }
		 }
		 
		 return splitArray[0].replace('`',' ').trim();       
	  //`USER_ROLES_ID` int(11) NOT NULL AUTO_INCREMENT,
			 
	}
	
	
	public static Table processLine(String line){
		 //`USER_ID` int(11) DEFAULT NULL,
		
		Table table = new Table();
		String lineTokens[] = line.split("\\s");
		
		for(String token:lineTokens){
			if(token.startsWith("`")){
				table.setColumn(token.replace("`", "").trim());
				System.out.println("Token : "+table.getColumn());
			}
			if(token.contains("(")){
				table.setSize(Integer.parseInt(findDataSize(token,"(",")")));
				System.out.println("Size : "+table.getSize());
			}
			
			
			
		}
		
		return table;
	}

}
