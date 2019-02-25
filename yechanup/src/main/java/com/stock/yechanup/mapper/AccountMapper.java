package com.stock.yechanup.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.stock.yechanup.vo.Account;
import com.stock.yechanup.vo.Branch;
import com.stock.yechanup.vo.Member;

@Mapper
public interface AccountMapper {
//branchCode를 조회하는 메서드 선언	
	Member selectBranchCode(String id);

//계좌개설지점 및 계좌담당자를 조회하는 메서드 선언
	Branch selectBranch(String branchCode);

//일련번호 최고값을 조회하는 메서드 선언
	
	int selectAccountMax();
//계좌를 생성하는 메서드 선언	
	void insertAccount(Account account);
}
