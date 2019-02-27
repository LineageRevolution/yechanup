package com.stock.yechanup.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stock.yechanup.service.MemberService;
import com.stock.yechanup.vo.Member;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	
	//get방식으로 login 이동 요청시 login메서드 실행
	@GetMapping("login")
	public String login() {
	//login.html화면 출력	
		return "login";
	}
	//post방식으로 login 이동 요청시 login메서드 실행 
	@PostMapping("login")
	public String login(@RequestParam("memberId") String memberId, @RequestParam("memberPw") String memberPw, HttpSession session) {
	//login화면에서 입력된 id와 pw를 받음, session영역을 이용하기위해 HttpSession session을 매개변수로 받음.	
	//콘솔창을 통해 memberId와  memberPw 값을 확인	
		System.out.println(memberId + "<-memberId.login.YeChanupController");
		System.out.println(memberPw + "<-memberPw.login.YeChanupController");
	//Member객체 내에 memberId값과 memberPw 값을 세팅	
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
	//YeChanupService객체 내 getUser메서드 호출시 member입력, 리턴된 값을 getMember에 복사	
		Member getMember = memberService.getUser(member);
		String memberName = getMember.getMemberName();
	//콘솔창을 통해 getMember에 복사된 값을 확인.	
		System.out.println(getMember + "<-getMember.login.MemberController");
	//화면에 입력된 값이 DB에 세팅된 값과 동일하면 로그인 성공.	
		if(memberId.equals(getMember.getMemberId()) && memberPw.equals(getMember.getMemberPw())) {			
	//로그인 성공이면 session영역에 세팅		
			session.setAttribute("id", memberId);
			session.setAttribute("pw", memberPw);
			session.setAttribute("name", memberName);
	//index로 이동 요청		
			return "redirect:/index";
		} else {
	//화면에 입력된 값과 DB에 세팅된 값이 일치하지 않으면 login으로 이동 요청		
			return "redirect:/index";
		}
	}
	//get방식으로 memberInsert 이동 요청시 memberInsert메서드 실행 
	@GetMapping("memberInsert")
	public String memberInsert() {
	//memberInsert메서드 실행되는지 콘솔창에 출력
		System.out.println("memberInsert메서드 실행");
	//memberInsert.html 화면 출력
		return "memberInsert";
	}
	//post방식으로 memberInsert 이동 요청시 memberAdd메서드 실행 
	@PostMapping("memberInsert")
	public String memberAdd(Member member) {
	//화면에서 입력한 데이터들을 member객체 내에 setting한다
	//콘솔창에 memberAdd메서드가 실행되는지 확인한다
		System.out.println("memberAdd메서드 실행여부" +member);
	//member객체 내에 memberName get메서드 호출
		member.getMemberName();
		//yeChanupService클래스 내에 addmember메서드 호출
		memberService.addmember(member);
	//index로 이동요청
		return "redirect:/index";
		
	}
	//get방식으로 logout 이동 요청시 logout메서드 실행 
	@GetMapping("logout")
	public String logout(HttpSession session) {
	//session영역을 이용하기위해 HttpSession session을 매개변수로 받는다	
	//logout메서드가 실행되는지 콘솔창에 확인한다
		System.out.println("logout-->" +session);
	//session값 초기화
		session.invalidate();
	//index로 이동요청
		return "redirect:/index";
		
	}
	
}