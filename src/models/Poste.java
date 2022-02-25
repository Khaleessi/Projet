package models;

public class Poste {
	private int id;
	private String intitule;
	public Poste(String intitule) {
		this.intitule = intitule;
	}
	public Poste(int id,String intitule) {
		super();
		this.id = id;
		this.intitule = intitule;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Poste [id=" + id + ", intitule=" + intitule + "]";
	}
}
