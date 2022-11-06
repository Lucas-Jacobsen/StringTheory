package com.gcu.model;

//intitializes variables in the order model
public class OrderModel {

	Long id = 0L;
	String orderNum = "";
	String productName = "";
	float price = 0.00f;
	int quantity = 0;

	// creates the order with the attributes provided
	public OrderModel(long id, String orderNum, String productName, float price, int quantity) {
		super();
		this.id = id;
		this.orderNum = orderNum;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}

//getters and setters for the order model
	public void setId(long id) {
		this.id = id;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
