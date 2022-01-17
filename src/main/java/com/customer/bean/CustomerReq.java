package com.customer.bean;

public class CustomerReq {
	private int customerAdharId;
	private String customerFirstName;
	private String customerLAstName;
	private String customerPhonNumber;
	public int getCustomerAdharId() {
		return customerAdharId;
	}
	public void setCustomerAdharId(int customerAdharId) {
		this.customerAdharId = customerAdharId;
	}
	public String getCustomerFirstName() {
		return customerFirstName;
	}
	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}
	public String getCustomerLAstName() {
		return customerLAstName;
	}
	public void setCustomerLAstName(String customerLAstName) {
		this.customerLAstName = customerLAstName;
	}
	public String getCustomerPhonNumber() {
		return customerPhonNumber;
	}
	public void setCustomerPhonNumber(String customerPhonNumber) {
		this.customerPhonNumber = customerPhonNumber;
	}
	@Override
	public String toString() {
		return "CustomerReq [customerAdharId=" + customerAdharId + ", customerFirstName=" + customerFirstName
				+ ", customerLAstName=" + customerLAstName + ", customerPhonNumber=" + customerPhonNumber + "]";
	}
	
}
