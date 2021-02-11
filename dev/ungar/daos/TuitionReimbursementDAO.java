package dev.ungar.daos;

import java.util.List;

import dev.ungar.model.TuitionReimbursement;

//dynamic table all CRUD required
public interface TuitionReimbursementDAO {
	
	public TuitionReimbursement getTuitionReimbursement(int id);
	public boolean addTuitionReimbursement(TuitionReimbursement tr);
	public List<TuitionReimbursement> getAllTuitionReimbursements();
	public boolean updateTuitionReimbursement(TuitionReimbursement change);
	
	public boolean updateApproved(double amount, int id);
	public boolean updatePending(double amount, int id);
	
	public boolean deleteTuitionReimbursement(int id);



}
