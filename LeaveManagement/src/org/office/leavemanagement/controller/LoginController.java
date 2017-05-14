package org.office.leavemanagement.controller;


import org.office.leavemanagement.util.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController extends BaseController{

	@RequestMapping("/")
	public String loginView(Model model){
//		model.addAttribute("base",getBasePath());
//		model.addAttribute("isSuccess","");
		return "login";
	}
}
