package models;

public class Compte {
	
	private int id;
	private Employee employee;
	private String login;
	private String mdp;
	private boolean actif;
	public Compte(Employee employee, String login, String mdp,boolean actif) {
		super();
		this.employee = employee;
		this.login = login;
		this.mdp = mdp;
		this.actif = actif;
	}
	public Compte(int id,Employee employee, String login, String mdp,boolean actif) {
		super();
		this.id = id;
		this.employee = employee;
		this.login = login;
		this.mdp = mdp;
		this.actif = actif;
	}
	public Employee getEmployee() {
		return employee;
	}
	public boolean isActif() {
		return actif;
	}
	public void setActif(boolean actif) {
		this.actif = actif;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public int getId() {
		return id;
	}
	
}
