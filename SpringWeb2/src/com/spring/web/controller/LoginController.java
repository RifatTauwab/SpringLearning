package com.spring.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.web.dao.Notice;
import com.spring.web.dao.User;
import com.spring.web.service.NoticesService;
import com.spring.web.service.UsersService;

@Controller
public class LoginController {

	private UsersService usersService;

	@Autowired
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	@RequestMapping("/login")
	public String showHome() {
		return "login";
	}

	@RequestMapping("/logout")
	public String logOut() {
		return "logout";
	}
	
	@RequestMapping("/AccountForm")
	public String accountform(Model model) {
		model.addAttribute("user", new User());
		return "AccountForm";
	}

	@RequestMapping(value = "/CreateAccount", method = RequestMethod.POST)
	public String createAccount(@Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "AccountForm";
		}
		if (usersService.exists(user.getUsername())) {
			result.rejectValue("username", "DuplicateKey.user.username");
			return "AccountForm";
		}
		
		usersService.create(user);
		/*try {
			usersService.create(user);
		} catch (DuplicateKeyException e) {
			result.rejectValue("username", "DuplicateKey.user.username", "this username already exist");
			return "AccountForm";
		}*/
		return "AccountCreated";
	}
}
