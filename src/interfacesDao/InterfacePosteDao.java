package interfacesDao;

import java.util.List;

import models.Poste;

public interface InterfacePosteDao extends InterfaceDAO<Poste>{
public List<Poste> getAll();
}	
