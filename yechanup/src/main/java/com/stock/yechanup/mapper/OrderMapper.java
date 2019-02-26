package com.stock.yechanup.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stock.yechanup.vo.Account;
import com.stock.yechanup.vo.Order;

@Mapper
public interface OrderMapper {
//아이디별 계좌를 조회하는 메서드 선언	
	List<Account> selectAccount(String id);
//주문을 입력하는 메서드 선언	
	void orderInsert(Order order);
}
