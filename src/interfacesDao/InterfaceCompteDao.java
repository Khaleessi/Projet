package interfacesDao;

import java.util.List;

import models.Compte;

public interface InterfaceCompteDao extends InterfaceDAO<Compte>{
	public List<Compte> getAll();
}
