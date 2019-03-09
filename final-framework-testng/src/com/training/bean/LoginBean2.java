package com.training.bean;
public class LoginBean2 {
	private String username;
	private String password;
	private String productname;
	private String Metatagtile;
	private String  model;
	private String  price;
	private String  quantity;
	private String  category;
	

	public LoginBean2() {
	}

	public LoginBean2(String username, String password,String productname,
			String Metatagtile,String model,String price,String quantity,String category) {
		super();
		this.username = username;
		this.password = password;
		this.productname=productname;
		this.Metatagtile=Metatagtile;
		this.model=model;
		this.price=price;
		this.quantity=quantity;
		this.category=category;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getProductname() {
		return productname;
		
	}
	public void setProductname(String productname) {
		this.productname=productname;
	}

	
	public String getMetatagtile() {
		return Metatagtile;
		
	}
	public void setMetatagtile(String Metatagtile) {
		this.Metatagtile=Metatagtile;
	}
	

	
	public String getModel(){
		
		return model;
	}
	
	public void setModel(String model){
		
		this.model=model;
	}
	

	
	public String getPrice(){
		return price;
		
	}
	
	
	public void setPrice(String price){
		this.price=price;
	}
	

	
	 public String getQuantity(){
		 
		 return quantity;
	 }
	
	public void setQuantity(String quantity){
		
		this.quantity=quantity;
	}
	

	
	public String getCategory(){
		return category;
		
	}
	
	public void setCategory(String category){
		
		this.category=category;
		
	}
	
	

	@Override
	public String toString() {
return "LoginBean2 [username=" + username + ", password=" + password +",productname="+productname+",Metatagtile="+ Metatagtile +",model="+model+", price="+ price +",quantity="+quantity+",category="+category+"]";
		
		
	}

}
