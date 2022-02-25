package interfacesDao;

import java.util.List;

import models.Vol;

public interface InterfaceVolDao extends InterfaceDAO<Vol> {
	
	public List<Vol> getAll();
	
}
