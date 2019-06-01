package com.nt.entity;

public class ProductDetails {
	private int pid;
	private String pname;
	private float quantity;
	private float price;
	private boolean isExpired;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public boolean getIsExpired() {
		return isExpired;
	}
	public void setIsExpired(boolean isExpired) {
		this.isExpired = isExpired;
	}
	@Override
	public String toString() {
		return "ProductDetails [pid=" + pid + ", pname=" + pname + ", quantity=" + quantity + ", price=" + price
				+ ", isExpired=" + isExpired + "]";
	}
	
	
}
