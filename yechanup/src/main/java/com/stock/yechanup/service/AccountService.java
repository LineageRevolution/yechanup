package com.stock.yechanup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.yechanup.mapper.AccountMapper;
import com.stock.yechanup.vo.Account;
import com.stock.yechanup.vo.Branch;
import com.stock.yechanup.vo.Member;

@Service
public class AccountService {
@Autowired
AccountMapper accountMapper;

	
	public Member getBranchCode(String id) {
		System.out.println("id.getBranchCode.AccountService : " + id);
		
		Member member = accountMapper.selectBranchCode(id);
		System.out.println("member.getBranchCode.AccountService : " + member);
		return member;
	}
	
	public Branch getBranch(String branchCode) {
		Branch branch = accountMapper.selectBranch(branchCode);
		return branch;
	}
	
	public void insertAccount(Account account, String branchCode) {
		System.out.println("account.insertAccount.AccountService : " + account);
		System.out.println("branchCode.insertAccount.AccountService : " + branchCode);
		String categoryCode = null;
		if(account.getAccountName().equals("001") || account.getAccountName().equals("002") || account.getAccountName().equals("003")) {
			categoryCode = "01";
		} else if(account.getAccountName().equals("004") || account.getAccountName().equals("005") || account.getAccountName().equals("006")) {
			categoryCode = "02";
		} else {
			categoryCode = "03";
		}
		int max = accountMapper.selectAccountMax();
		max = max + 1;
		String yechan = "000"; 
		if(max >= 0 && max < 9) {
			yechan = "000";
		} else if(max > 8 && max < 99) {
			yechan = "00";
		} else {
			yechan = "0";
		}
		String maxYechan = yechan + max;
		String accountNumber = branchCode + categoryCode + maxYechan;
		
		System.out.println("accountNumber.insertAccount.AccountService : " + accountNumber);
		account.setAccountNumber(accountNumber);
		System.out.println("account.insertAccount.AccountService : " + account);
		
	}
}
