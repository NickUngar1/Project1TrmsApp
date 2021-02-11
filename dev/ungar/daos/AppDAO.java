package dev.ungar.daos;

import dev.ungar.model.Form;

public interface AppDAO {
	
	public Form getFormsAsSup(int id);
	public boolean supUp(int id);
	
	public Form getFormsAsDept(int id);
	public Form getFormsAsCeo(int id);

}
