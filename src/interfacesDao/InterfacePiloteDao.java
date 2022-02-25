package interfacesDao;

import java.util.List;

import models.Pilote;

public interface InterfacePiloteDao extends InterfaceDAO<Pilote>{
public List<Pilote> getAll();
}
