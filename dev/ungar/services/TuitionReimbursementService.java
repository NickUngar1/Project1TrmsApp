package dev.ungar.services;

import java.util.List;

import dev.ungar.model.TuitionReimbursement;

public interface TuitionReimbursementService {
	
	public TuitionReimbursement getTuitionReimbursement(int id);
	public boolean addTuitionReimbursement(TuitionReimbursement a);
	public List<TuitionReimbursement> getAllTuitionReimbursements();
	public boolean updateTuitionReimbursement(TuitionReimbursement change);
	public boolean deleteTuitionReimbursement(int id);
	
	public boolean updateApproved(double amount, int id);
	public boolean updatePending(double amount, int id);

}
