package dev.ungar.daos;

import java.util.List;

import dev.ungar.model.Grading;

//static table only needs to be referenced
public interface GradingDAO {
	
	public Grading getGrading(int id);
	public boolean addGrading(Grading a);
	public List<Grading> getAllGrading();
	public boolean updateGrading(Grading change);
	public boolean deleteGrading(int id);


}
