package models;

public class Employee {
	
	private int id;
	private String nom;
	private String prenom;
	private String adresse;
	private String email;
	private int telephone;
	private Poste poste;
	private Contrat contrat;

	
	public Employee(String nom, String prenom,Poste poste,Contrat contrat, String adresse, String email, int telephone) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.telephone = telephone;
		this.poste = poste;
		this.contrat = contrat;

	}
	
	public Employee(int id,String nom, String prenom,Poste poste,Contrat contrat, String adresse, String email, int telephone) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.telephone = telephone;
		this.poste = poste;
		this.contrat = contrat;

	}


	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public Poste getPoste() {
		return poste;
	}
	public void setPoste(Poste poste) {
		this.poste = poste;
	}
	public Contrat getContrat() {
		return contrat;
	}
	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Employe [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", email=" + email
				+ ", telephone=" + telephone + ", poste=" + poste + ", contrat=" + contrat + "]";
	}
	
	
}	
