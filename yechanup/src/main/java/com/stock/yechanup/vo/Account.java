package com.stock.yechanup.vo;

public class Account {
	private String accountNumber;
	private String memberId;
	private String accountName;
	private int accountDeposit;
	private String accountSetup;
	private String accountManager;
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
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public int getAccountDeposit() {
		return accountDeposit;
	}
	public void setAccountDeposit(int accountDeposit) {
		this.accountDeposit = accountDeposit;
	}
	public String getAccountSetup() {
		return accountSetup;
	}
	public void setAccountSetup(String accountSetup) {
		this.accountSetup = accountSetup;
	}
	public String getAccountManager() {
		return accountManager;
	}
	public void setAccountManager(String accountManager) {
		this.accountManager = accountManager;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", memberId=" + memberId + ", accountName=" + accountName
				+ ", accountDeposit=" + accountDeposit + ", accountSetup=" + accountSetup + ", accountManager="
				+ accountManager + "]";
	}
	
	
}
