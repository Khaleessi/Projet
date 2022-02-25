package interfacesDao;

import java.util.List;

import models.Constructeur;

public interface InterfaceConstructeurDao extends InterfaceDAO<Constructeur> {
public List<Constructeur> getAll();
}
