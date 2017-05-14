package org.office.leavemanagement.controller;

import javax.annotation.Resource;

import org.office.leavemanagement.po.Account;
import org.office.leavemanagement.service.LoginService;
import org.office.leavemanagement.util.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class IndexController extends BaseController{
	@Resource
	private LoginService loginService;
	
	//Controller中的po类：要与页面传上来的<input> name属性相一致.区分大小写
	//Mapper.xml中的SQL语句的属性，要与parameterType的po类中的属性相一致.(可缺省)
	@RequestMapping("/login.action")
	@ResponseBody
		public String loginAction(Model model,Account account){
			if("1".equals(loginService.login(account))){
				model.addAttribute("base",getBasePath());
				return "1";
			}else{
				model.addAttribute("base",getBasePath());
				model.addAttribute("isSuccess","");
				return "0";
			}
			
		}
	
	@RequestMapping("/main")
	public String mainView(){
		return "main";
	}
	
	@RequestMapping("/nav")
	public String navView(){
		return "nav";
	}
	
	@RequestMapping("/emplist")
	public String emplistView(){
		return "emplist";
	}
	
	@RequestMapping("/addleave")
	public String addleaveView(){
		return "addleave";
	}
}
