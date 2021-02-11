package dev.ungar.services;

import java.util.List;

import dev.ungar.model.Form;

public interface FormService {
	
	public Form getForm(int id);
	public Form getFormByEmpId(int id);
	public boolean addForm(Form a);
	public List<Form> getAllForms();
	public boolean updateForm(Form change);
	public boolean deleteForm(int id);
	
	public boolean supUp(int id);
	
	public boolean ceoUp(int id);
	public Form ceoGet(int id);
	
	public boolean updateApproved(double amount, int id);


}
