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
	
//get방식으로 accountSetup으로 이동 요청시 accountSetup메서드 실행, session영역에 세팅된 id값을 받아와 AccountService객체 내 getBranchCode메서드 호출시 입력.
//리턴된 branchCode값을 받아 AccountService객체 내 getBranch메서드 호출시 입력. 포워드방식으로 accountSetup.html화면 출력
	@GetMapping("accountSetup")
	public String accountSetup(HttpSession session, Model model) {
		String id = (String)session.getAttribute("id");
		System.out.println("id.accountSetup.AccountController : " + id);
		
		Member member = accountService.getBranchCode(id);
		String branchCode = member.getBranchCode();
		
		Branch branch = accountService.getBranch(branchCode);
		model.addAttribute("member", member);
		model.addAttribute("branch", branch);
		return "accountSetup";
	}
//post방식으로 accountSetup으로 이동 요청시 accountSetup메서드 실행, 화면에 입력된 값을 Account객체 내에 세팅, 화면에서 보낸 branchCode받기.
//account와 branchCode를 입력하여 AccountService객체 내 insertAccount메서드 호출
	@PostMapping("accountSetup")
	public String accountSetup(Account account, String branchCode, Model model) {
		System.out.println("account.accountSetup.AccountController : " + account);
		System.out.println("branchCode.accountSetup.AccountController : " + branchCode);
		Account resultAccount = accountService.insertAccount(account, branchCode);
		System.out.println("resultAccount.accountSetup.AccountController : " + resultAccount);
		model.addAttribute("resultAccount", resultAccount);
		return "accountSetupDone";
	}
	
		
	
	
}
