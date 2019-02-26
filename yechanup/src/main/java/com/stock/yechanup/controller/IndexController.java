package com.stock.yechanup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class IndexController {
	//get방식으로 index 이동 요청시 index메서드 실행 
		@GetMapping("index")
		public String index() {
		//index.html 화면 출력
			    return "index";
		}
}
