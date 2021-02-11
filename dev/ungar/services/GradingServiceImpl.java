package dev.ungar.services;

import java.util.List;

import dev.ungar.daos.GradingDAO;
import dev.ungar.daos.GradingDAOImpl;
import dev.ungar.model.Grading;

public class GradingServiceImpl implements GradingService {
	
	GradingDAO gd = new GradingDAOImpl();

	@Override
	public Grading getGrading(int id) {
		return gd.getGrading(id);
	}

	@Override
	public boolean addGrading(Grading a) {
		return gd.addGrading(a);
	}

	@Override
	public List<Grading> getAllGrading() {
		return gd.getAllGrading();
	}

	@Override
	public boolean updateGrading(Grading change) {
		return gd.updateGrading(change);
	}

	@Override
	public boolean deleteGrading(int id) {
		return gd.deleteGrading(id);
	}
	

}
