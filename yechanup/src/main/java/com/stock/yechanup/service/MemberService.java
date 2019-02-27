package com.stock.yechanup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.yechanup.mapper.MemberMapper;
import com.stock.yechanup.vo.Member;

@Service
public class MemberService {
	@Autowired
	MemberMapper memberMapper;
	
	//고객 한명을 조회하고 리턴하는 메서드
	public Member getUser(Member member) {
	//받은 member값을 콘솔창을 통해 확인.	
		System.out.println(member + "<-member.getUser.MemberService");
	//YeChanupMapper객체 내 userSelectOne메서드 호출시 member입력, 리턴된 값을 getMember에 복사	
		Member getMember = memberMapper.userSelectOne(member);
	//콘솔창을 통해 getMember의 값을 확인	
		System.out.println(getMember + "<-getMember.getUser.MemberService");
	//getMember 리턴	
		return getMember;
		
	}
	//회원가입하는 메서드
	public int addmember(Member member) {
	//받은 member값을 콘솔창을 통해 확인
		System.out.println(member + "<-member.addmember.MemberService");
	//yeChanupMapper클래스안에 memberInsert메서드를 호출후 실행한 값 리턴	
		return memberMapper.memberInsert(member);
	}
}
