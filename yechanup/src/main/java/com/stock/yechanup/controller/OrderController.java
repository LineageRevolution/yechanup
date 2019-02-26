package com.stock.yechanup.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stock.yechanup.service.OrderService;
import com.stock.yechanup.vo.Account;
import com.stock.yechanup.vo.Order;

@Controller
public class OrderController {
	@Autowired
	OrderService orderService;
	
//get방식으로 orderAccount이동요청시 orderAccount메서드 실행, session영역에 세팅된 id값을 받아 OrderService객체 내 getAccount메서드 호출시 입력,
//리턴되어 온 listAccount에 복사된 값을 model영역에 세팅, forward 방식으로 orderAccount.html화면 출력	
	@GetMapping("orderAccount")
	public String orderAccount(HttpSession session, Model model) {
		String id = (String)session.getAttribute("id");
		System.out.println("id.orderInsert.OrderController : " + id);
		List<Account> listAccount = orderService.getAccount(id);
		System.out.println("listAccount.orderInsert.OrderController : " + listAccount);
		model.addAttribute("listAccount", listAccount);
		return "orderAccount";
	}
//post방식으로 orderAccount이동요청시 orderAccount메서드 실행, 화면에 입력된 accountNumber에 복사된 값을 받아 OrderService객체 내 getCategoryCode메서드
//호출시 입력, 리턴되어온 substrAccountNumber에 복사된 값과 accountNumber에 복사된 값을 model영역에 세팅, forward방식으로 orderCount.html화면 출력	
	@PostMapping("orderAccount")
	public String orderAccount(@RequestParam("accountNumber") String accountNumber, Model model) {
		System.out.println("accountNumber.orderInsert.OrderController : " + accountNumber);
		String substrAccountNumber = orderService.getCategoryCode(accountNumber);
		model.addAttribute("substrAccountNumber", substrAccountNumber);
		model.addAttribute("accountNumber", accountNumber);
		return "orderCount";
	}
//post방식으로 orderCount이동요청시 orderCount메서드 실행, 화면에 입력된 값들을 Order객체 내부에 세팅, session영역에 세팅된 id값을 Order객체에 세팅하고 
//OrderService객체내 addOrder메서드 호출, redirect방식으로 orderListByDay로 이동 요청.	
	@PostMapping("orderCount")
	public String orderCount(Order order, HttpSession session) {
		System.out.println("categoryCode.orderCount.OrderController : " + order.getCategoryCode());
		System.out.println("orderAmount.orderCount.OrderController : " + order.getOrderAmount());
		System.out.println("accountNumber.orderCount.OrderController : " + order.getAccountNumber());
		order.setMemberId((String)session.getAttribute("id"));
		orderService.addOrder(order);
		return "redirect:/orderListByDay";
	}
//get방식으로 orderListByDay이동요청시 orderListByDay메서드 실행, forward방식으로 orderListByDay.html화면 출력.	
	@GetMapping("orderListByDay")
	public String orderListByDay() {
		return "orderListByDay";
	}
}

