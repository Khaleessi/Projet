package models;

public class Contrat {
	private int id;
	private String nom;
	
	public Contrat(String nom) {
		super();
	
		this.nom = nom;
	}
	
	public Contrat(int id,String nom) {
		super();
		this.id = id;
		this.nom = nom;
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
	@Override
	public String toString() {
		return "Contrat [id=" + id + ", nom=" + nom + "]";
	}
}
