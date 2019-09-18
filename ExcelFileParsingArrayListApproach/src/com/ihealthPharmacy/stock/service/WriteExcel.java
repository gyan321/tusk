package com.ihealthPharmacy.stock.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.ihealthPharmacy.stock.model.Table;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class WriteExcel {

	
	public static void createExcel(List<Table> tables){
		try{
			String fileName="D:/query.xls";
			WritableWorkbook workbook=Workbook.createWorkbook(new File (fileName));
			WritableSheet sheet=workbook.createSheet("sheet1", 0);
			
			//adding a label
			Label label1=new Label(0,0,"TableName");
			Label label2=new Label(1,0,"ColumnName");
			Label label3=new Label(2,0,"Type");
			Label label4=new Label(3,0,"Size");
			Label label5=new Label(4,0,"Default");
			Label label6=new Label(5,0,"Constraint");
			Label label7=new Label(6,0,"primaryKey");
			Label label8=new Label(7,0,"foreignKey");
			Label label9=new Label(8,0,"ForeignkeyTable"); 
			Label label10=new Label(9,0,"Relationship");
	 


		 
			
			sheet.addCell(label1);
			sheet.addCell(label2);
			sheet.addCell(label3);	 
			sheet.addCell(label4);
			sheet.addCell(label5);
			sheet.addCell(label6);
			sheet.addCell(label7);
			sheet.addCell(label8);
			sheet.addCell(label9);
			sheet.addCell(label10);
			
		//	System.out.println("Size Table : "+tables.size());
				
			Number number= null;
			for(Table table:tables){
				System.out.println("Size Table : "+table.getSize());
					
				number = new Number(0,1,table.getSize());
				
				sheet.addCell(number);				
			}
			  
			  
			  workbook.write();
			  workbook.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
/*	public static void main(String[] args)throws IOException,WriteException {

		createExce);
		
	}*/
}
