package models;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import implementationsDao.AffectationDaoImpl;
import interfacesDao.InterfaceAffectationDao;

public class Vol {
	private int id;
	private String numero;
	private Date date;
	private Time heureDepart;
	private Aeroport aeroportDepart;
	private Aeroport aeroportArrive;
	private List<Affectation> listAffectation = new ArrayList<Affectation>();
	private InterfaceAffectationDao affectationDao = new AffectationDaoImpl();
	
	public List<Affectation> getListAffectation() {
		
		List<Affectation> listAffectation = affectationDao.getAll();
		for (int i=0;i<listAffectation.size();i++) {
            if(listAffectation.get(i).getVol().getId() != this.id) {
            	listAffectation.remove(listAffectation.get(i));
            }
        }
		return listAffectation;
	}
	
	public Vol(String numero, Date date, Time heureDepart, Time heureArrive, Aeroport aeroportDepart,
			Aeroport aeroportArrive) {
		this.numero = numero;
		this.date = date;
		this.heureDepart = heureDepart;
		this.heureArrive = heureArrive;
		this.aeroportDepart = aeroportDepart;
		this.aeroportArrive = aeroportArrive;
	}
	public Vol(int id,String numero, Date date, Time heureDepart, Time heureArrive, Aeroport aeroportDepart,
			Aeroport aeroportArrive) {
		this.id = id;
		this.numero = numero;
		this.date = date;
		this.heureDepart = heureDepart;
		this.heureArrive = heureArrive;
		this.aeroportDepart = aeroportDepart;
		this.aeroportArrive = aeroportArrive;
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	private Time heureArrive;
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getHeureDepart() {
		return heureDepart;
	}
	public void setHeureDepart(Time heureDepart) {
		this.heureDepart = heureDepart;
	}
	public Time getHeureArrive() {
		return heureArrive;
	}
	public void setHeureArrive(Time heureArrive) {
		this.heureArrive = heureArrive;
	}
	public Aeroport getAeroportDepart() {
		return aeroportDepart;
	}
	public void setAeroportDepart(Aeroport aeroportDepart) {
		this.aeroportDepart = aeroportDepart;
	}
	public Aeroport getAeroportArrive() {
		return aeroportArrive;
	}
	public void setAeroportArrive(Aeroport aeroportArrive) {
		this.aeroportArrive = aeroportArrive;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return this.numero+" du "+this.date;
	}
	
	
	
	
}
