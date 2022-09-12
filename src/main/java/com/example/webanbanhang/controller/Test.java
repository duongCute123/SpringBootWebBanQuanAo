package com.example.webanbanhang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test {
	@RequestMapping("/getHome")
	public String getHome() {
		return "home";
	}
}
