package com.stock.yechanup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.yechanup.mapper.YeChanupMapper;
import com.stock.yechanup.vo.Member;

@Service
public class YeChanupService {
	@Autowired
	YeChanupMapper yeChanupMapper;
	
	//고객 한명을 조회하고 리턴하는 메서드
	public Member getUser(Member member) {
	//받은 member값을 콘솔창을 통해 확인.	
		System.out.println(member + "<-member.getUser.YeChanupService");
	//YeChanupMapper객체 내 userSelectOne메서드 호출시 member입력, 리턴된 값을 getMember에 복사	
		Member getMember = yeChanupMapper.userSelectOne(member);
	//콘솔창을 통해 getMember의 값을 확인	
		System.out.println(getMember + "<-getMember.getUser.YeChanupService");
	//getMember 리턴	
		return getMember;
		
	}
}
