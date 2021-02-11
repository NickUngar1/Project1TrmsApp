package dev.ungar.services;

import dev.ungar.daos.AppDAO;
import dev.ungar.daos.AppDAOImpl;
import dev.ungar.model.Form;

public class AppServiceImpl implements AppService {
	
	AppDAO ad = new AppDAOImpl();

	@Override
	public Form getFormsAsSup(int id) {
		return ad.getFormsAsSup(id);
	}
	
	@Override
	public boolean supUp(int id) {
		return ad.supUp(id);
	}

	@Override
	public Form getFormsAsDept(int id) {
		return ad.getFormsAsDept(id);
	}

	@Override
	public Form getFormsAsCeo(int id) {
		return ad.getFormsAsCeo(id);
	}

}
