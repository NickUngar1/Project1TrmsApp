package dev.ungar.daos;

import java.util.List;

import dev.ungar.model.Approval;

//dynamic table all CRUD required
public interface ApprovalDAO {
	
	public Approval getApproval(int id);
	public boolean addApproval(Approval a);
	public List<Approval> getAllApprovals();
	public boolean updateApproval(Approval change);
	public boolean deleteApproval(int id);


}
