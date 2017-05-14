package org.office.leavemanagement.service.impl;

import javax.annotation.Resource;

import org.office.leavemanagement.dao.LoginDao;
import org.office.leavemanagement.po.Account;
import org.office.leavemanagement.service.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{
	@Resource
	private LoginDao loginDao;
	@Override
	public String login(Account account)  {
		System.out.println(account.getLoginName()+account.getPassword());
		Account acc=loginDao.login(account);
		System.out.println(acc);
		if(acc!=null){
			return "1";
		}else{
			return "0";
		}
		
	}
	
}
