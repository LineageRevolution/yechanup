package com.stock.yechanup.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.stock.yechanup.vo.Branch;
import com.stock.yechanup.vo.Member;

@Mapper
public interface AccountMapper {
	Member selectBranchCode(String id);
	
	Branch selectBranch(String branchCode);
	
	int selectAccountMax();
}
