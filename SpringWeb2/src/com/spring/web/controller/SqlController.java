package com.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SqlController {
	@RequestMapping("/sqljndijsp")
	public String TestJNDIJsp() {
		return "SqlTest";
	}

}
