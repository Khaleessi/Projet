package models;

import java.util.List;

import implementationsDao.AffectationDaoImpl;
import interfacesDao.InterfaceAffectationDao;

public class Avion {
	

	private int id;
	private Model model;
	private Aeroport aeroportBase;
	private InterfaceAffectationDao affectationDao = new AffectationDaoImpl();
	
	
	public List<Affectation> getListAffectation() {
		
		List<Affectation> listAffectation = affectationDao.getAll();
		for (int i=0;i<listAffectation.size();i++) {
            if(listAffectation.get(i).getAvion().getId() != this.id) {
            	listAffectation.remove(listAffectation.get(i));
            }
        }
		return listAffectation;
	}
	
	
	public Model getModel() {
		return model;
	}

	public void setModel(Model categorie) {
		this.model = categorie;
	}



	public Aeroport getAeroportBase() {
		return aeroportBase;
	}

	public void setAeroportBase(Aeroport aeroportBase) {
		this.aeroportBase = aeroportBase;
	}

	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return this.getModel().getNom();
	}
	public Avion(Model model,Aeroport aeroportBase) {
		super();
		this.model = model;
		this.aeroportBase = aeroportBase;
	}

	public Avion(int id,Model model,Aeroport aeroportBase) {
		super();
		this.id = id;
		this.model = model;
		this.aeroportBase = aeroportBase;
	}
}
