package interfacesDao;

import java.util.List;

import models.Affectation;

public interface InterfaceAffectationDao extends InterfaceDAO<Affectation> {
	
	public List<Affectation> getAll();
	
}