package com.ihealthPharmacy.stock.parsingExcel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ihealthPharmacy.stock.model.Table;
import com.ihealthPharmacy.stock.service.ExcelService;
import com.ihealthPharmacy.stock.service.WriteExcel;

public class ParsingSchemaToExcel {

	
	   static Table tableObj; 
	   static ExcelService excelServiceObj; 


	   //@SuppressWarnings("unused")
	   public static void main(String[] args)throws Exception {
		
		tableObj=new Table();
		
		 System.out.println("check");
		 
		 String firstLineDelimiter="[`][A-Z]+_[A-Z]+_[A-Z]+[`][\\s]int[(][0-9]{2}[)][\\s]NOT[\\s]NULL[\\s]AUTO_INCREMENT[,]";
		 /*Pattern tableNamePattern = Pattern.compile("[`][a-zA-Z]+_[a-zA-Z]+[`]"); 		 
		 Pattern columnNamePattern = Pattern.compile("[`][A-Z]+_[A-Z]+_[A-Z]+[`]"); 
		 Pattern sizePatternFor2Digit=Pattern.compile("[a-zA-Z]+[(][0-9]{2}[)]");
		 */ 
      
		 //String secondPattern = "[`][a-zA-Z]+[,]";
		String secondPattern ="[`]([A-Z]+_[A-Z]+)+[`][\\s]+[a-zA-Z]+[(][0-9]+[)][\\s]+[A-Z]+[\\s]+[A-Z]+[,]";
		Pattern firstLinepattern=Pattern.compile(firstLineDelimiter,Pattern.CASE_INSENSITIVE); 
		Pattern secondLinepattern=Pattern.compile(secondPattern,Pattern.CASE_INSENSITIVE); 
		
		//FileReader fileObject=new FileReader("C:\\Users\\ADMIN\\Documents\\healthPharmacyRelated\\HealthPharmacyProjectStockRelated\\AllSchemaTxtFiles\\userRoles.sql");
		FileReader fileObject=new FileReader("C:\\Users\\ADMIN\\Desktop\\user_roles.sql");
		//FileReader fileObject=new FileReader("C:\\Users\\ADMIN\\Downloads\\doc_pharma.sql");
		BufferedReader bufferReaderObj=new BufferedReader(fileObject);
		
		String line= bufferReaderObj.readLine();
		
		System.out.println("1 -> Line : "+line);
		List<Table>tableListObj=new ArrayList<Table>();
		
		byte totalNumberOfLines= 0;
		
		 
		while(line!=null){ 
		//System.out.println("LINE : "+line);
		//if(line.startsWith("CREATE TABLE")){
				
			Matcher firstLineMatcher = firstLinepattern.matcher(line);    
			
			if(firstLineMatcher.find()){
				
				String firstLineMatcherInString=firstLineMatcher.group(); 
				
				System.out.println("first line found");
				System.out.println(firstLineMatcherInString);
				tableObj.setDefaults("AUTO_INCREMENT");
				tableObj.setType("INT");
				tableObj.setConstraint("NOT NULL");	
				
				if(firstLineMatcherInString.contains("AUTO_INCREMENT")){
				String dataSize= ExcelService.findDataSize(firstLineMatcherInString,"(",")");
				
				tableObj.setSize(Integer.parseInt(dataSize));
				 System.out.println("size is:"+dataSize);
				}
				
				
				String columnName=ExcelService.findColumnName(line);
				tableObj.setColumn(columnName);
				
				System.out.println("column name:"+tableObj.getColumn());
				
				tableObj.setForeignKey("NULL");
				tableObj.setForeignKeyTable("NULL");
				tableObj.setRelationShip("NULL");
				
				
			}//end 1st 
			
			totalNumberOfLines++;			
			
			line=bufferReaderObj.readLine();	
			
			//System.out.println("Line : "+line);
			if(line!=null){
		
			Matcher lineMatcher = secondLinepattern.matcher(line);

			if(lineMatcher.find()){ 
				
				String lineMatcherInString=lineMatcher.group(); 
				
				//System.out.println(lineMatcherInString);
				tableObj = ExcelService.processLine(lineMatcherInString);
				tableObj.setDefaults("NULL");
				tableListObj.add(tableObj);   
				
			}
			
		 }
			// st 2nd pattern
			
			
		}
		bufferReaderObj.close();
		System.out.println("total line :"+totalNumberOfLines);
		
		System.out.println("List Size : "+tableListObj.size());
		WriteExcel.createExcel(tableListObj);
	//} 
}

}
