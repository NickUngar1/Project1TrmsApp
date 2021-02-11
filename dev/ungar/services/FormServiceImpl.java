package dev.ungar.services;

import java.util.List;

import dev.ungar.daos.FormDAO;
import dev.ungar.daos.FormDAOImpl;
import dev.ungar.model.Form;

public class FormServiceImpl implements FormService {
	
	FormDAO fd = new FormDAOImpl();

	@Override
	public Form getForm(int id) {
		return fd.getForm(id);
	}
	
	public Form getFormByEmpId(int id) {
		return fd.getFormByEmpId(id);
	}


	@Override
	public boolean addForm(Form a) {
		return fd.addForm(a);
	}

	@Override
	public List<Form> getAllForms() {
		return fd.getAllForms();
	}

	@Override
	public boolean updateForm(Form change) {
		return fd.updateForm(change);
	}

	@Override
	public boolean deleteForm(int id) {
		return fd.deleteForm(id);
	}
	
	public boolean supUp(int id) {
		fd.supUp(id);
		return true;
	}
	
	public boolean ceoUp(int id) {
		fd.ceoUp(id);
		return true;
	}
	public Form ceoGet(int id) {
		return fd.ceoGet(id);
	}
	
	public boolean updateApproved(double amount, int id) {
		fd.updateApproved(amount, id);
		return true;
	}


	
	

}
