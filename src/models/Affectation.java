package models;

import java.util.List;

import implementationsDao.AffectationDaoImpl;
import interfacesDao.InterfaceAffectationDao;

public class Affectation {
	InterfaceAffectationDao affectationDao = new AffectationDaoImpl();
	@Override
	public String toString() {
		return "Affectation [id=" + id + ", vol=" + vol + ", avion=" + avion + ", pilote=" + pilote + "]";
	}

	private int id;
	private Vol vol;
	private Model avion;
	private Pilote pilote;
	public Affectation(Vol vol, Model avion, Pilote pilote) {
		super();
		this.vol = vol;
		this.avion = avion;
		this.pilote = pilote;
	}
	public Affectation(int id,Vol vol, Model avion, Pilote pilote) {
		super();
		this.id = id;
		this.vol = vol;
		this.avion = avion;
		this.pilote = pilote;
	}

	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {

		this.vol = vol;
		
	}

	public Model getAvion() {
		return avion;
	}

	public void setAvion(Model avion) {
		this.avion = avion;
	}

	public Pilote getPilote() {
		return pilote;
	}

	public void setPilote(Pilote pilote) {
		this.pilote = pilote;
	}

	public int getId() {
		return id;
	}

}
