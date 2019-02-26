package com.stock.yechanup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.yechanup.mapper.OrderMapper;
import com.stock.yechanup.vo.Account;
import com.stock.yechanup.vo.Order;

@Service
public class OrderService {
@Autowired
	OrderMapper orderMapper;
	
	public List<Account> getAccount(String id){
		List<Account> listAccount = orderMapper.selectAccount(id);
		System.out.println("listAccount.getAccount.OrderService : " + listAccount);
		return listAccount;
	}
	
	public String getCategoryCode(String accountNumber) {
		String substrAccountNumber = accountNumber.substring(3, 5);
		System.out.println("substrAccountNumber.getCategoryCode.OrderService : " + substrAccountNumber);
		return substrAccountNumber;
	}
	
	public void addOrder(Order order) {
		int orderMoney = 0;
		if(order.getCategoryCode().equals("01")) {
			orderMoney = 10000;
		} else if(order.getCategoryCode().equals("02")) {
			orderMoney = 20000;
		} else {
			orderMoney = 30000;
		}
		System.out.println("orderMoney.addOrder.OrderService : " + orderMoney);
		order.setOrderMoney(orderMoney);
		orderMapper.orderInsert(order);
	}
	public List<Order> getOrder() {
		List<Order> listOrder = orderMapper.selectOrder();
		System.out.println("listOrder.getOrder.OrderService"+ listOrder);
		return listOrder;
	
	}
	public Account getAccountDeposit(String accountNumber) {
		Account account = orderMapper.selectAccountDeposit(accountNumber);
		return account;
	}
		
	
}
