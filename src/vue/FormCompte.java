package vue;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import implementationsDao.CompteDaoImpl;
import implementationsDao.ContratDaoImpl;
import implementationsDao.EmployeeDaoImpl;
import implementationsDao.MD5;
import implementationsDao.PosteDaoImpl;
import interfacesDao.InterfaceCompteDao;
import interfacesDao.InterfaceContratDao;
import interfacesDao.InterfaceEmployeDao;
import interfacesDao.InterfacePosteDao;
import models.Compte;
import models.Contrat;
import models.Employee;
import models.Poste;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.awt.event.ActionEvent;

public class FormCompte extends JPanel {
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldAdresse;
	private JTextField textFieldEmail;
	private JTextField textFieldTel;
	private JTextField textFieldLogin;
	private JTextField textFieldMDP;
	private boolean actif;
	private JButton btnActiver;
	private JButton btnDesactiver;
	private InterfaceEmployeDao employeeDao = new EmployeeDaoImpl();
	private InterfaceCompteDao compteDao = new CompteDaoImpl();
	private InterfaceContratDao contratDao = new ContratDaoImpl();
	private InterfacePosteDao posteDao = new PosteDaoImpl();
	private Tables tables = new Tables();

	/**
	 * Create the panel.
	 */
	public String generationPassWord() {
			return	textFieldNom.getText()+""+textFieldPrenom.getText();
		 
		
	}
	public String generationLogin() {
		return textFieldNom.getText()+""+textFieldPrenom.getText();
		
		
	}
	
	
	public FormCompte(JScrollPane scrollPane){
		setLayout(null);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(10, 25, 45, 13);
		add(lblNom);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(95, 22, 96, 19);
		add(textFieldNom);
		textFieldNom.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(10, 59, 45, 13);
		add(lblPrenom);
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldLogin.setText(generationLogin());
				textFieldMDP.setText(generationPassWord());
			}
		});
		textFieldPrenom.setBounds(95, 56, 96, 19);
		add(textFieldPrenom);
		textFieldPrenom.setColumns(10);
		
		JLabel lblPoste = new JLabel("Poste");
		lblPoste.setBounds(10, 99, 45, 13);
		add(lblPoste);
		
		JComboBox comboBoxPoste = new JComboBox(posteDao.getAll().toArray());
		comboBoxPoste.setBounds(95, 95, 96, 21);
		add(comboBoxPoste);
		
		JLabel lblContrat = new JLabel("Contrat");
		lblContrat.setBounds(10, 138, 45, 13);
		add(lblContrat);
		
		JComboBox comboBoxContrat = new JComboBox(contratDao.getAll().toArray());
		comboBoxContrat.setBounds(95, 134, 96, 21);
		add(comboBoxContrat);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(10, 185, 45, 13);
		add(lblAdresse);
		
		textFieldAdresse = new JTextField();
		textFieldAdresse.setBounds(95, 182, 96, 19);
		add(textFieldAdresse);
		textFieldAdresse.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 229, 45, 13);
		add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(95, 226, 96, 19);
		add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblTel = new JLabel("Telephone");
		lblTel.setBounds(272, 25, 45, 13);
		add(lblTel);
		
		textFieldTel = new JTextField();
		textFieldTel.setBounds(344, 22, 96, 19);
		add(textFieldTel);
		textFieldTel.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(272, 71, 45, 13);
		add(lblLogin);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(344, 68, 96, 19);
		add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		JLabel lblMDP = new JLabel("Mot de passe");
		lblMDP.setBounds(272, 119, 45, 13);
		add(lblMDP);
		
		textFieldMDP = new JTextField();
		textFieldMDP.setBounds(344, 116, 96, 19);
		add(textFieldMDP);
		textFieldMDP.setColumns(10);
		

		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				Poste poste = (Poste) comboBoxPoste.getSelectedItem();
				Contrat contrat = (Contrat) comboBoxContrat.getSelectedItem();
				
				Employee employee = new Employee(textFieldNom.getText(), textFieldPrenom.getText(), poste, contrat, textFieldAdresse.getText(), textFieldEmail.getText(), Integer.valueOf( textFieldTel.getText()));
				employeeDao.add(employee);
				
				MD5 md5 = new MD5();
				String hashPassWord = md5.getMd5(generationPassWord());
				Employee lastEmployee = employeeDao.getAll().get(employeeDao.getAll().size() - 1);

				Compte compte = new Compte(lastEmployee, generationLogin(),hashPassWord ,actif);
				compteDao.add(compte);
				
				scrollPane.setViewportView(tables.getTableCompte());
			}
		});
		btnNewButton.setBounds(355, 256, 85, 21);
		add(btnNewButton);
		
		btnActiver = new JButton("Activer");
		btnActiver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actif = true;
				btnDesactiver.setEnabled(false);
			}
		});
		btnActiver.setBounds(257, 203, 85, 21);
		add(btnActiver);
		
		btnDesactiver = new JButton("Desactiver");
		btnActiver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actif = false;
				btnActiver.setEnabled(false);
			}
		});
		btnDesactiver.setBounds(355, 203, 85, 21);
		add(btnDesactiver);

	}
}
