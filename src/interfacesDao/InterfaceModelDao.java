package interfacesDao;

import java.util.List;

import models.Model;

public interface InterfaceModelDao extends InterfaceDAO<Model>{
	public List<Model> getAll();
}
