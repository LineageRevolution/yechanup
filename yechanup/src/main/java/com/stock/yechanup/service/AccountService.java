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

//id를 입력하여 branchCode를 리턴하는 메서드 선언
	public Member getBranchCode(String id) {
		System.out.println("id.getBranchCode.AccountService : " + id);
		
		Member member = accountMapper.selectBranchCode(id);
		System.out.println("member.getBranchCode.AccountService : " + member);
		return member;
	}
//branchCode를 입력하여 계좌개설지점 및 계좌담당자를 리턴하는 메서드 선언	
	public Branch getBranch(String branchCode) {
		Branch branch = accountMapper.selectBranch(branchCode);
		return branch;
	}
	
//지점코드 + 종목코드 + 일련번호 = 계좌번호 처리과정 후 계좌를 생성하는 메서드 선언
	public Account insertAccount(Account account, String branchCode) {
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
		if(max >= 0 && max < 10) {
			yechan = "000";
		} else if(max > 9 && max < 100) {
			yechan = "00";
		} else {
			yechan = "0";
		}
		String maxYechan = yechan + max;
		String accountNumber = branchCode + categoryCode + maxYechan;
		
		System.out.println("accountNumber.insertAccount.AccountService : " + accountNumber);
		account.setAccountNumber(accountNumber);
		System.out.println("account.insertAccount.AccountService : " + account);
		accountMapper.insertAccount(account);
		return account;
	}
}
