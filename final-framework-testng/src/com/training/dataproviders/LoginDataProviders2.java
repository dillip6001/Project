package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.bean.LoginBean2;
import com.training.dao.ELearningDAO;
import com.training.dao.ELearningDAO2;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ApachePOIExcelRead2;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders2 {

	@DataProvider(name = "db-inputs1")
	public Object [][] getDBData() {

		List<LoginBean2> list = new ELearningDAO2().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean2 temp : list){
			Object[]  obj = new Object[8]; 
			obj[0] = temp.getUserName();
			obj[1] = temp.getPassword();
			obj[2]=temp.getProductname();
			obj[3]=temp.getMetatagtile();
			obj[4]=temp.getModel();
			obj[5]=temp.getPrice();
			obj[6]=temp.getQuantity();
			obj[7]=temp.getCategory();
			 
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:\\Users\\DILLIPBEHERA\\Desktop\\TestData.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}
	
	
	@DataProvider(name = "excel-inputs1")
	public Object[][] getExcelData1(){
		String fileName ="C:\\Users\\DILLIPBEHERA\\Desktop\\TestData.xlsx"; 
		return new ApachePOIExcelRead2().getExcelContent(fileName); 
	}	
	
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	}
}
