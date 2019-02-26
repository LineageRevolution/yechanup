package com.stock.yechanup.vo;

public class Order {
	private String orderDate;
	private String orderNumber;
	private String accountNumber;
	private String memberId;
	private String categoryCode;
	private int orderAmount;
	private int orderMoney;
	
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public int getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}
	public int getOrderMoney() {
		return orderMoney;
	}
	public void setOrderMoney(int orderMoney) {
		this.orderMoney = orderMoney;
	}
	@Override
	public String toString() {
		return "Order [orderDate=" + orderDate + ", orderNumber=" + orderNumber + ", accountNumber=" + accountNumber
				+ ", memberId=" + memberId + ", categoryCode=" + categoryCode + ", orderAmount=" + orderAmount
				+ ", orderMoney=" + orderMoney + "]";
	}
	
	
}
