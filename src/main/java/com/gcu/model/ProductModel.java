package com.gcu.model;

//Initializes product model variables
public class ProductModel {

	int productID = 0;
	String productName = "";
	String productDescription = " ";
	float productPrice = 0.00f;

	//creates the product model
	public ProductModel(int productID, String productName, String productDescription, float productPrice) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
	}

	//getters and setters for the product model
	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescripiton() {
		return productDescription;
	}

	public void setProductDescripiton(String productDescripiton) {
		this.productDescription	 = productDescripiton;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	
	
}
