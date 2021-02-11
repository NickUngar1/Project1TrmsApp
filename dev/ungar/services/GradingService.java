package dev.ungar.services;

import java.util.List;

import dev.ungar.model.Grading;

public interface GradingService {
	
	public Grading getGrading(int id);
	public boolean addGrading(Grading a);
	public List<Grading> getAllGrading();
	public boolean updateGrading(Grading change);
	public boolean deleteGrading(int id);

}
