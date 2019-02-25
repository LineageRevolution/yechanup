package com.stock.yechanup.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.stock.yechanup.service.AccountService;
import com.stock.yechanup.vo.Account;
import com.stock.yechanup.vo.Branch;
import com.stock.yechanup.vo.Member;
@Controller
public class AccountController {
@Autowired
AccountService accountService;
	
	@GetMapping("accountSetup")
	public String accountSetup(HttpSession session, Model model) {
		String id = (String)session.getAttribute("id");
		System.out.println("id.accountSetup.AccountController : " + id);
		
		Member member = accountService.getBranchCode(id);
		String branchCode = member.getBranchCode();
		
		Branch branch = accountService.getBranch(branchCode);
		model.addAttribute(member);
		model.addAttribute(branch);
		return "accountSetup";
	}
	@PostMapping("accountSetup")
	public String accountSetup(Account account, String branchCode) {
		System.out.println("account.accountSetup.AccountController : " + account);
		System.out.println("branchCode.accountSetup.AccountController : " + branchCode);
		accountService.insertAccount(account, branchCode);
		return "redirect:/accountSetupDone";
	}
	@GetMapping("accountSetupDone")
	public String accountSetupDone() {
		return "accountSetupDone";
		
	}
	
}
