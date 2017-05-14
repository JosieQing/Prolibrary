package com.neuedu.examonline.system.menu;

import java.util.ArrayList;
import java.util.List;

public class MenuList {

	public List getMenuList(){
		List menuList = new ArrayList();
		Menu m1 = new Menu();
		m1.setName("菜单名称");
		m1.setLink("area_list.jsp");
		menuList.add(m1);
		return menuList;
	}
}
