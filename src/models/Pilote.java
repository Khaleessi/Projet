package models;

import java.util.List;

import implementationsDao.AffectationDaoImpl;
import interfacesDao.InterfaceAffectationDao;

public class Pilote {
	
	
	private int id;
	private Employee ficheEmployee;
	private InterfaceAffectationDao affectationDao = new AffectationDaoImpl();
	
	public Pilote(Employee ficheEmployee) {
		this.ficheEmployee = ficheEmployee;
	}


	public Pilote(int id, Employee ficheEmployee) {
		this.id = id;
		this.ficheEmployee = ficheEmployee;
	}

	
	public List<Affectation> getListAffectation() {
		
		List<Affectation> listAffectation = affectationDao.getAll();
		for (int i=0;i<listAffectation.size();i++) {
            if(listAffectation.get(i).getPilote().getId() != this.id) {
            	listAffectation.remove(listAffectation.get(i));
            }
        }
		return listAffectation;
	}
	
	public Employee getFicheEmployee() {
		return ficheEmployee;
	}


	public void setFicheEmployee(Employee ficheEmployee) {
		this.ficheEmployee = ficheEmployee;
	}


	public int getId() {
		return id;
	}


	@Override
	public String toString() {
		return this.getFicheEmployee().getNom()+" "+this.getFicheEmployee().getPrenom();
	}
	

}	
