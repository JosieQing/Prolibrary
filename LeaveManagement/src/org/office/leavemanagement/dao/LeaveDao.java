package org.office.leavemanagement.dao;

import java.util.List;

import org.office.leavemanagement.po.LeavePO;

public interface LeaveDao {
	
	public int addLeaveManagement(LeavePO leavePO);
	
	public List<LeavePO> listMessage(LeavePO leavePO);
	
	public LeavePO checkLeave(int lid);
	
	public int deleteLeave(int lid);
	
	public int updateLeave(LeavePO leavePO);
	
	public int updateState(LeavePO leavePO);
	
	public List<LeavePO> listMgrApproval();
	
	public int mgrUpdateState(LeavePO leavePO);
	
	public List<LeavePO> listDepApproval();
	
	public List<LeavePO> mgrlistMessage(LeavePO leavePO);
	
	public int updateMgrState(LeavePO leavePO);
}
