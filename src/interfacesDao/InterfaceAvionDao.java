package interfacesDao;

import java.util.List;

import models.Avion;

public interface InterfaceAvionDao extends InterfaceDAO<Avion> {
	public List<Avion> getAll();
}
