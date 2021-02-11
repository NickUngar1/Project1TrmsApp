package dev.ungar.daos;

import java.util.List;

import dev.ungar.model.Form;

//dynamic table all CRUD required
public interface FormDAO {
	
	public Form getForm(int id);
	public Form getFormByEmpId(int id);
	public boolean addForm(Form f);
	public List<Form> getAllForms();
	public boolean updateForm(Form change);
	public boolean deleteForm(int id);
	
	public boolean supUp(int id);
	public void getSupForm(int id);
	
	public boolean ceoUp(int id);
	public Form ceoGet(int id);
	
	public boolean updateApproved(double amount, int id);



}
