package com.stock.yechanup.mapper;

import org.apache.ibatis.annotations.Mapper;


import com.stock.yechanup.vo.Member;

@Mapper
public interface YeChanupMapper {
	//고객 한명을 조회하는 메서드
	Member userSelectOne(Member member);
	//회원가입하는 메서드
	int memberInsert(Member member);
}
