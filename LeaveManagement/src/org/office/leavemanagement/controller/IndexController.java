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
	
	//Controller�е�po�ࣺҪ��ҳ�洫������<input> name������һ��.���ִ�Сд
	//Mapper.xml�е�SQL�������ԣ�Ҫ��parameterType��po���е�������һ��.(��ȱʡ)
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
