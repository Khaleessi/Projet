package interfacesDao;

import java.util.List;

import models.Aeroport;

public interface InterfaceAeroportDao extends InterfaceDAO<Aeroport> {
	
	public List<Aeroport> getAll();
	

}
