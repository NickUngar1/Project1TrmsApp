package dev.ungar.services;

import java.util.List;

import dev.ungar.model.Approval;

public interface ApprovalService {
	
	public Approval getApproval(int id);
	public boolean addApproval(Approval a);
	public List<Approval> getAllApprovals();
	public boolean updateApproval(Approval change);
	public boolean deleteApproval(int id);
	
	public boolean supApproval(Approval a);
	public boolean deptApproval(Approval a);
	public boolean benApproval(Approval a);

}
