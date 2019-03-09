package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import com.training.bean.LoginBean;
import com.training.bean.LoginBean2;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

// Data Access Object 
public class ELearningDAO2 {
	
	Properties properties; 
	
	public ELearningDAO2() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<LoginBean2> getLogins(){
		String sql = properties.getProperty("get.logins"); 
		
		GetConnection gc  = new GetConnection(); 
		List<LoginBean2> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<LoginBean2>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				LoginBean2 temp = new LoginBean2(); 
				temp.setUserName(gc.rs1.getString(1));
				temp.setPassword(gc.rs1.getString(2));
				temp.setProductname(gc.rs1.getString(3));
				temp.setMetatagtile(gc.rs1.getString(4));
				temp.setModel(gc.rs1.getString(5));
				temp.setPrice(gc.rs1.getString(6));
				temp.setQuantity(gc.rs1.getString(7));
				temp.setCategory(gc.rs1.getString(8));
			    

				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	
	public static void main(String[] args) {
		new ELearningDAO2().getLogins().forEach(System.out :: println);
	}
	
	
}
