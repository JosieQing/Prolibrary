package org.office.leavemanagement.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.office.leavemanagement.dao.LeaveDao;
import org.office.leavemanagement.po.LeavePO;
import org.office.leavemanagement.service.LeaveService;
import org.springframework.stereotype.Service;
@Service
public class LeaveServiceImpl implements LeaveService{
	@Resource
	private LeaveDao leaveDao;
	@Override
	public int addLeaveManagement(LeavePO leavePO) {
		int i=leaveDao.addLeaveManagement(leavePO);	
		return i;
	}
	
	@Override
	public List<LeavePO> listMessage(LeavePO leavePO) {
		java.text.SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		List<LeavePO> list=leaveDao.listMessage(leavePO);
		for(int i=0;i<list.size();i++){
			LeavePO leave=(LeavePO)list.get(i);
			leave.setEnd_times(sdf.format(leave.getEnd_time()));
			leave.setStart_times(sdf.format(leave.getStart_time()));
		//	leave.setWrite_times(sdf.format(leave.getWrite_time()));
		}
		return list;
	}

	@Override
	public LeavePO checkLeave(int lid) {
		LeavePO leavePO=leaveDao.checkLeave(lid);
		java.text.SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		leavePO.setEnd_times(sdf.format(leavePO.getEnd_time()));
		leavePO.setStart_times(sdf.format(leavePO.getStart_time()));
		leavePO.setWrite_times(sdf.format(leavePO.getWrite_time()));
		return leavePO;
	}

	@Override
	public int deleteLeave(int lid) {
		int i=leaveDao.deleteLeave(lid);
		return i;
	}

	@Override
	public int updateLeave(LeavePO leavePO) {
		
		int i=leaveDao.updateLeave(leavePO);

		return i;
	}

	@Override
	public int updateState(LeavePO leavePO) {
		int i=leaveDao.updateState(leavePO);
		return i;
	}

	@Override
	public List<LeavePO> listMgrApproval() {
		List<LeavePO> listApproval=leaveDao.listMgrApproval();
		java.text.SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		for(int i=0;i<listApproval.size();i++){
			LeavePO leavePO=(LeavePO)listApproval.get(i);
		leavePO.setEnd_times(sdf.format(leavePO.getEnd_time()));
		leavePO.setStart_times(sdf.format(leavePO.getStart_time()));
		leavePO.setWrite_times(sdf.format(leavePO.getWrite_time()));
		}
		return listApproval;
	}

	@Override
	public int mgrUpdateState(LeavePO leavePO) {
		int i=leaveDao.mgrUpdateState(leavePO);
		return i;
	}

	@Override
	public List<LeavePO> listDepApproval() {
		List<LeavePO> listApproval=leaveDao.listDepApproval();
		java.text.SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		for(int i=0;i<listApproval.size();i++){
			LeavePO leavePO=(LeavePO)listApproval.get(i);
		leavePO.setEnd_times(sdf.format(leavePO.getEnd_time()));
		leavePO.setStart_times(sdf.format(leavePO.getStart_time()));
		leavePO.setWrite_times(sdf.format(leavePO.getWrite_time()));
		}
		return listApproval;
	}

	@Override  
	public List<LeavePO> mgrlistMessage(LeavePO leavePO) {
		java.text.SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		List<LeavePO> list=leaveDao.mgrlistMessage(leavePO);
		for(int i=0;i<list.size();i++){
			LeavePO leave=(LeavePO)list.get(i);
			leave.setEnd_times(sdf.format(leave.getEnd_time()));
			leave.setStart_times(sdf.format(leave.getStart_time()));
		//	leave.setWrite_times(sdf.format(leave.getWrite_time()));
		}
		return list;
		
	}

	@Override
	public int updateMgrState(LeavePO leavePO) {
		int i=leaveDao.updateMgrState(leavePO);
		return i;
	}
	
}
