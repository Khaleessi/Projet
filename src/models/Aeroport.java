package models;

public class Aeroport{
	
	private int id;
	private String codeIata;
	private String nom;
	private String ville;
	
	public String getCodeIata() {
		return codeIata;
	}

	public void setCodeIata(String codeIata) {
		this.codeIata = codeIata;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Aeroport(String codeIata, String nom, String ville) {
		this.codeIata = codeIata;
		this.nom = nom;
		this.ville = ville;
	}
	public Aeroport(int id,String codeIata, String nom, String ville) {
		this.id = id;
		this.codeIata = codeIata;
		this.nom = nom;
		this.ville = ville;
	}

	@Override
	public String toString() {
		return this.nom;
	}


}
