package models;

public class Constructeur {
	private int id;
	private String nom;
	
	public Constructeur(String nom) {
		super();
		this.nom = nom;
	}
	public Constructeur(int id ,String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	public int getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@Override
	public String toString() {
		return this.nom;
	}
}
