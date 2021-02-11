package dev.ungar.services;

import java.util.List;

import dev.ungar.daos.ApprovalDAO;
import dev.ungar.daos.ApprovalDAOImpl;
import dev.ungar.model.Approval;

public class ApprovalServiceImpl implements ApprovalService {
	
	ApprovalDAO ad = new ApprovalDAOImpl();

	@Override
	public Approval getApproval(int id) {
		return ad.getApproval(id);
	}

	@Override
	public boolean addApproval(Approval a) {
		return ad.addApproval(a);
	}

	@Override
	public List<Approval> getAllApprovals() {
		return ad.getAllApprovals();
	}

	@Override
	public boolean updateApproval(Approval change) {
		return ad.updateApproval(change);
	}

	@Override
	public boolean deleteApproval(int id) {
		return ad.deleteApproval(id);
	}
	
	public boolean supApproval(Approval a) {
		a.setSupAppStatus(1);
		ad.updateApproval(a);
		return true;
	}
	
	public boolean deptApproval(Approval a) {
		a.setDeptAppStatus(1);
		ad.updateApproval(a);
		return true;
		
	}
	
	public boolean benApproval(Approval a) {
		a.setBenAppStatus(1);
		ad.updateApproval(a);
		return true;
	}

}
