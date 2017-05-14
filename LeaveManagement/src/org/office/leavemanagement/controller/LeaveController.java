package org.office.leavemanagement.controller;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.office.leavemanagement.po.LeavePO;
import org.office.leavemanagement.service.LeaveService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
public class LeaveController {
    @InitBinder   
    public void initBinder(WebDataBinder binder) {   
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");   
        dateFormat.setLenient(true);   
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   
    }  
	@Resource
	private LeaveService leaveService;
	
	@RequestMapping("add.action")
	public String addAction(Model model,LeavePO leavePO){
		try {
			String lname=new String(leavePO.getLname().getBytes("iso8859-1"),"utf-8");
			leavePO.setLname(lname);
			String leave_reason=new String(leavePO.getLeave_reason().getBytes("iso8859-1"),"utf-8");
			leavePO.setLeave_reason(leave_reason);
			String state=new String(leavePO.getState().getBytes("iso8859-1"),"utf-8");
			leavePO.setState(state);
			String job=new String(leavePO.getJob().getBytes("iso8859-1"),"utf-8");
			leavePO.setJob(job);
			String leave_type=new String(leavePO.getLeave_type().getBytes("iso8859-1"),"utf-8");
			leavePO.setLeave_type(leave_type);
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}
		int i=leaveService.addLeaveManagement(leavePO);
		if(i==1){
			return "emplist";
		}else{
			return "";
		}
		
	}
	
	@RequestMapping("ajaxEmplist.action")
	@ResponseBody
	public String listMessage(LeavePO leavePO){
		List<LeavePO> list=leaveService.listMessage(leavePO);
		Gson gson=new Gson();
		String json="";
		if(list!=null){
			json=gson.toJson(list);
			System.out.println(json);
			return json;
		}
		return "";
	}
	
	@RequestMapping("emplist.action")
	public String listMessage(Model model,LeavePO leavePO){
	
		try {
			String lname = new String(leavePO.getLname().getBytes("iso8859-1"),"utf-8");
			leavePO.setLname(lname);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		List<LeavePO> list=leaveService.listMessage(leavePO);
		if(list!=null){
			model.addAttribute("list",list );
			return "emplist";
		}else{
				return "";
		}

	}
	
	@RequestMapping("checkleave")
	public String checkleaveView(Model model,int lid){
		LeavePO leavePO=leaveService.checkLeave(lid);
		if(leavePO!=null){
			model.addAttribute("leavePO",leavePO);
			return "checkleave";
		}
		return "emplist";
	}
	
	@RequestMapping("delete.action")
	public String deleteAction(int lid){
		int i=leaveService.deleteLeave(lid);
		if(i==1){
			return "emplist";
		}
		return "";
	}
	
	@RequestMapping("updateleave")
	public String updateleaveView(Model model,int lid){
		LeavePO leavePO=leaveService.checkLeave(lid);
		if(leavePO!=null){
			model.addAttribute("leavePO",leavePO);
			return "updateleave";
		}
		return "";
	}
	
	@RequestMapping("update.action")
	public String updateleaveView(LeavePO leavePO){
		try {
			String lname=new String(leavePO.getLname().getBytes("iso8859-1"),"utf-8");
			leavePO.setLname(lname);
			String leave_reason=new String(leavePO.getLeave_reason().getBytes("iso8859-1"),"utf-8");
			leavePO.setLeave_reason(leave_reason);
			String state=new String(leavePO.getState().getBytes("iso8859-1"),"utf-8");
			leavePO.setState(state);
			String job=new String(leavePO.getJob().getBytes("iso8859-1"),"utf-8");
			leavePO.setJob(job);
			String leave_type=new String(leavePO.getLeave_type().getBytes("iso8859-1"),"utf-8");
			leavePO.setLeave_type(leave_type);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int i=leaveService.updateLeave(leavePO);
		if(i==1){
			return "emplist";
		}
		return " ";
	}
	
	@RequestMapping("updateStateAction")
	public String updateState(LeavePO leavePO){
		int i=leaveService.updateState(leavePO);
		if(i==1){
			return "emplist";
		}
		return "";
	}
	
	@RequestMapping("mgrapproval")
	public String listMgrApproval(Model model){
		List<LeavePO> listApproval=leaveService.listMgrApproval();
		model.addAttribute("listApproval", listApproval);
		return "mgrapproval";
	}
	
	@RequestMapping("mgrupdateState")
	public String mgrUpdateState(LeavePO leavePO){
		int i=leaveService.mgrUpdateState(leavePO);
		if(i==1){
			return "mgrapproval";
		}
		return "";
	}
	
	@RequestMapping("depapproval")
	public String listDepApproval(Model model){
		List<LeavePO> listApproval=leaveService.listDepApproval();
		model.addAttribute("listApproval", listApproval);
		return "depapproval";
	}
	
	@RequestMapping("mgrlist")
	public String mgrlistView(){
		return "mgrlist";
	}
	
	@RequestMapping("mgrlist.action")
	public String mgrlistMessage(Model model,LeavePO leavePO){
		List<LeavePO> list=leaveService.mgrlistMessage(leavePO);
		if(list!=null){
			model.addAttribute("list",list );
			return "mgrlist";
		}else{
				return "";
		}
		
	}
	
	@RequestMapping("ajaxMgrlist.action")
	@ResponseBody
	public String mgrlistMessage(LeavePO leavePO){
		List<LeavePO> list=leaveService.mgrlistMessage(leavePO);
		Gson gson=new Gson();
		String json="";
		if(list!=null){
			json=gson.toJson(list);
			System.out.println(json);
			return json;
		}
		return "";
	}
	
	@RequestMapping("addmgrleave")
	public String addmgrleaveView(){
		return "addmgrleave";
	}
	
	@RequestMapping("addmgr.action")
	public String addMgrAction(Model model,LeavePO leavePO){
		try {
			String lname=new String(leavePO.getLname().getBytes("iso8859-1"),"utf-8");
			leavePO.setLname(lname);
			String leave_reason=new String(leavePO.getLeave_reason().getBytes("iso8859-1"),"utf-8");
			leavePO.setLeave_reason(leave_reason);
			String state=new String(leavePO.getState().getBytes("iso8859-1"),"utf-8");
			leavePO.setState(state);
			String job=new String(leavePO.getJob().getBytes("iso8859-1"),"utf-8");
			leavePO.setJob(job);
			String leave_type=new String(leavePO.getLeave_type().getBytes("iso8859-1"),"utf-8");
			leavePO.setLeave_type(leave_type);
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}
		int i=leaveService.addLeaveManagement(leavePO);
		if(i==1){
			return "mgrlist";
		}else{
			return "";
		}
		
	}
	
	@RequestMapping("updateMgrleave")
	public String updateMgrleaveView(Model model,int lid){
		LeavePO leavePO=leaveService.checkLeave(lid);
		if(leavePO!=null){
			model.addAttribute("leavePO",leavePO);
			return "updateMgrleave";
		}
		return "";
	}
	
	@RequestMapping("updateMgr.action")
	public String updateMgrleaveView(LeavePO leavePO){
		try {
			String lname=new String(leavePO.getLname().getBytes("iso8859-1"),"utf-8");
			leavePO.setLname(lname);
			String leave_reason=new String(leavePO.getLeave_reason().getBytes("iso8859-1"),"utf-8");
			leavePO.setLeave_reason(leave_reason);
			String state=new String(leavePO.getState().getBytes("iso8859-1"),"utf-8");
			leavePO.setState(state);
			String job=new String(leavePO.getJob().getBytes("iso8859-1"),"utf-8");
			leavePO.setJob(job);
			String leave_type=new String(leavePO.getLeave_type().getBytes("iso8859-1"),"utf-8");
			leavePO.setLeave_type(leave_type);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int i=leaveService.updateLeave(leavePO);
		if(i==1){
			return "mgrlist";
		}
		return " ";
	}
	
	@RequestMapping("updateMgrStateAction")
	public String updateMgrState(LeavePO leavePO){
		int i=leaveService.updateMgrState(leavePO);
		if(i==1){
			return "mgrlist";
		}
		return "";
	}
	
}
