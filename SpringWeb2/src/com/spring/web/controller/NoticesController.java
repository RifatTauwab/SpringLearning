package com.spring.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.web.dao.Notice;
import com.spring.web.service.NoticesService;

@Controller
public class NoticesController {

	private NoticesService noticesService;
	
	@RequestMapping("/")
	public String showHome() {
		return "home";
	}
	
	@RequestMapping("/Session")
	public String TestSession(HttpSession session) {
		//System.out.println("from controller");
		session.setAttribute("name", "Tauwab");
		return "home";
	}
	
	@RequestMapping("/ModelAndView")
	public ModelAndView TestModelAndView() {
		ModelAndView mv = new ModelAndView("home");
		Map<String,Object> model = mv.getModel();
		model.put("name","Rifat");
		return mv;
	}
	
	@RequestMapping("/Model")
	public String TestModel(Model model) {
		model.addAttribute("name","Model Tauwab");
		return "home";
	}
	
	@Autowired
	public void setNoticesService(NoticesService noticesService) {
		this.noticesService = noticesService;
	}
	@RequestMapping("/ServiceDao")
	public String ServiceDao(Model model) {
		List<Notice> notices = noticesService.getNotices();
		model.addAttribute("notices",notices);
		return "ServiceDao";
	}
	
	@RequestMapping("/get")
	public String TestGet(Model model,@RequestParam("id") String Id) {
		System.out.println("ID is " + Id);
		return "home";
	}
	
	@RequestMapping("/NoticeForm")
	public String NoticeForm(Model model) {
		model.addAttribute(new Notice());
		return "CreateNotice";
	}
	@RequestMapping("/CreateNotice")
	public String CreateNoticeGET(Model model,Notice notice) {
		System.out.println(notice);
		return "Messages";
	}
	@RequestMapping(value="/CreateNotice",method=RequestMethod.POST)
	public String CreateNoticePOST(Model model, @Valid Notice notice, BindingResult result) {
		if(result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors(); 
			for(ObjectError e:errors) {
				System.out.println(e.getDefaultMessage());
			}
			return "CreateNotice";
		}
		
		System.out.println(notice);
		noticesService.create(notice);
		return "Messages";
	}
	@RequestMapping("/Messages")
	public String showMessages(Model model) {
		model.addAttribute("message","notice created");
		return "Messages";
	}
	
	
	@RequestMapping("/exception")
	public String testException() {
		noticesService.testException();
		return "Message";
	}
	
	/*
	 * following method DatabaseException 
	 * handles all exceptions related to 
	 * DataAccessException class or its subclasses. 
	 * if it find any DataAccessException , then it automatically 
	 * return to Error.jsp
	 
	@ExceptionHandler(DataAccessException.class)
	public String DatabaseException(DataAccessException ex) {
		return "Error";
	}
	*/
}
