package dev.ungar.services;

import java.util.List;

import dev.ungar.daos.TuitionReimbursementDAO;
import dev.ungar.daos.TuitionReimbursementDAOImpl;
import dev.ungar.model.TuitionReimbursement;

public class TuitionReimbursementServiceImpl implements TuitionReimbursementService {
	
	TuitionReimbursementDAO trd = new TuitionReimbursementDAOImpl();


	@Override
	public TuitionReimbursement getTuitionReimbursement(int id) {
		return trd.getTuitionReimbursement(id);
	}

	@Override
	public boolean addTuitionReimbursement(TuitionReimbursement a) {
		return trd.addTuitionReimbursement(a);
	}

	@Override
	public List<TuitionReimbursement> getAllTuitionReimbursements() {
		return trd.getAllTuitionReimbursements();
	}

	@Override
	public boolean updateTuitionReimbursement(TuitionReimbursement change) {
		return trd.updateTuitionReimbursement(change);
	}
	
	@Override
	public boolean updatePending(double amount, int id) {
		return trd.updatePending(amount, id);
	}
	
	@Override
	public boolean updateApproved(double amount, int id) {
		return trd.updateApproved(amount, id);
	}

	@Override
	public boolean deleteTuitionReimbursement(int id) {
		return trd.deleteTuitionReimbursement(id);
	}
	


}
