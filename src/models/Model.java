package models;

import java.util.List;

import implementationsDao.AffectationDaoImpl;
import interfacesDao.InterfaceAffectationDao;

public class Model {
	private InterfaceAffectationDao affectationDao = new AffectationDaoImpl();
	
	@Override
	public String toString() {
		return this.nom;
	}
	private int id;
	private String nom;
	private int capacite;
	private Constructeur constructeur;
	
	public Model(int id,String nom,int capacite,Constructeur constructeur) {
		super();
		this.id = id;
		this.nom = nom;
		this.capacite = capacite;
		this.constructeur = constructeur;
	}
	public Model(String nom,int capacite,Constructeur constructeur) {
		super();
		this.nom = nom;
		this.capacite = capacite;
		this.constructeur = constructeur;
	}
	
	
	public List<Affectation> getListAffectation() {
		
		List<Affectation> listAffectation = affectationDao.getAll();
		for (int i=0;i<listAffectation.size();i++) {
            if(listAffectation.get(i).getAvion().getId() != this.id) {
            	listAffectation.remove(listAffectation.get(i));
            }
        }
		return listAffectation;
	}
	
	
	
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getId() {
		return id;
	}
	public int getCapacite() {
		return capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	public Constructeur getConstructeur() {
		return constructeur;
	}
	public void setConstructeur(Constructeur constructeur) {
		this.constructeur = constructeur;
	}
	
	
}
