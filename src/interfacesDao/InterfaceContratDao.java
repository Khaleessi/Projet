package interfacesDao;

import java.util.List;

import models.Contrat;

public interface InterfaceContratDao extends InterfaceDAO<Contrat>{
	public List<Contrat> getAll();
}
