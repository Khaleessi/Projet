package vue;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import implementationsDao.ContratDaoImpl;
import implementationsDao.EmployeeDaoImpl;
import implementationsDao.PosteDaoImpl;
import interfacesDao.InterfaceContratDao;
import interfacesDao.InterfaceEmployeDao;
import interfacesDao.InterfacePosteDao;
import lombok.Data;
import lombok.NoArgsConstructor;
import models.Contrat;
import models.Employee;
import models.Pilote;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
@Data
@NoArgsConstructor
public class FormPilote extends JPanel {
	private InterfaceContratDao contratDao = new ContratDaoImpl();
	private InterfaceEmployeDao employeeDao = new EmployeeDaoImpl();
	private InterfacePosteDao posteDao = new PosteDaoImpl();
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldAdresse;
	private JTextField textFieldEmail;
	private JTextField textFieldTelephone;
	private Tables tables = new Tables();
	private JTable tablePilote = tables.getTablePilote();
	
	/**
	 * Create the panel.
	 */
	public FormPilote(Employee pilote,JScrollPane scrollPane) {
		
		setLayout(null);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(10, 36, 45, 13);
		add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(10, 59, 45, 13);
		add(lblPrenom);
		
		JLabel lblContrat = new JLabel("Contrat");
		lblContrat.setBounds(10, 81, 45, 13);
		add(lblContrat);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(10, 104, 45, 13);
		add(lblAdresse);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 127, 45, 13);
		add(lblEmail);
		
		JLabel lblTelephone = new JLabel("Telephone");
		lblTelephone.setBounds(10, 150, 45, 13);
		add(lblTelephone);

	 
		JComboBox comboBoxContrat = new JComboBox(contratDao.getAll().toArray());
		comboBoxContrat.setPreferredSize(new Dimension(150, 35));
		comboBoxContrat.setBounds(85, 79, 109, 17);
		add(comboBoxContrat);
		
		textFieldNom = new JTextField();
		textFieldNom.setPreferredSize(new Dimension(150, 35));
		textFieldNom.setBounds(85, 33, 179, 17);
		add(textFieldNom);
		textFieldNom.setColumns(10);
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setPreferredSize(new Dimension(150, 35));
		textFieldPrenom.setColumns(10);
		textFieldPrenom.setBounds(85, 56, 179, 17);
		add(textFieldPrenom);
		
		textFieldAdresse = new JTextField();
		textFieldAdresse.setPreferredSize(new Dimension(150, 35));
		textFieldAdresse.setColumns(10);
		textFieldAdresse.setBounds(85, 101, 179, 17);
		add(textFieldAdresse);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setPreferredSize(new Dimension(150, 35));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(85, 124, 179, 17);
		add(textFieldEmail);
		
		textFieldTelephone = new JTextField();
		textFieldTelephone.setPreferredSize(new Dimension(150, 35));
		textFieldTelephone.setColumns(10);
		textFieldTelephone.setBounds(85, 147, 179, 17);
		add(textFieldTelephone);
		
		
		if(pilote != null) {
		textFieldNom.setText(pilote.getNom());
		textFieldPrenom.setText(pilote.getPrenom());
		comboBoxContrat.setSelectedItem(pilote.getContrat());
		textFieldAdresse.setText(pilote.getAdresse());
		textFieldEmail.setText(pilote.getEmail());
		textFieldTelephone.setText(String.valueOf(pilote.getTelephone()));
	}
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contrat contrat = (Contrat) comboBoxContrat.getSelectedItem();
				if(pilote!=null) {
					
				pilote.setNom(textFieldNom.getText());
				pilote.setPrenom(textFieldPrenom.getText());
				pilote.setPoste(posteDao.getOne(3));
				pilote.setContrat(contrat);
				pilote.setAdresse(textFieldAdresse.getText());
				pilote.setEmail(textFieldEmail.getText());
				pilote.setTelephone(Integer.valueOf(textFieldTelephone.getText()));
				employeeDao.update(pilote);
				scrollPane.setViewportView(tables.getTablePilote());
				}else {
					Employee employee = new Employee(textFieldNom.getText(), textFieldPrenom.getText(), posteDao.getOne(3), contrat, textFieldAdresse.getText(), textFieldEmail.getText(), Integer.valueOf(textFieldTelephone.getText()));
					employeeDao.add(employee);
					scrollPane.setViewportView(tables.getTablePilote());
				}
				
				
				
				
			}
		});
		btnValider.setBounds(96, 246, 85, 21);
		add(btnValider);
		


	}
/**
 * @wbp.parser.constructor
 */
public FormPilote(JScrollPane scrollPane) {
		
		setLayout(null);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(10, 36, 45, 13);
		add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(10, 59, 45, 13);
		add(lblPrenom);
		
		JLabel lblContrat = new JLabel("Contrat");
		lblContrat.setBounds(10, 81, 45, 13);
		add(lblContrat);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(10, 104, 45, 13);
		add(lblAdresse);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 127, 45, 13);
		add(lblEmail);
		
		JLabel lblTelephone = new JLabel("Telephone");
		lblTelephone.setBounds(10, 150, 45, 13);
		add(lblTelephone);
		
		
	
	 
		JComboBox comboBoxContrat = new JComboBox(contratDao.getAll().toArray());
		comboBoxContrat.setPreferredSize(new Dimension(150, 35));
		comboBoxContrat.setBounds(85, 79, 109, 17);
		add(comboBoxContrat);
		
		textFieldNom = new JTextField();
		textFieldNom.setPreferredSize(new Dimension(150, 35));
		textFieldNom.setBounds(85, 33, 179, 17);
		add(textFieldNom);
		textFieldNom.setColumns(10);
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setPreferredSize(new Dimension(150, 35));
		textFieldPrenom.setColumns(10);
		textFieldPrenom.setBounds(85, 56, 179, 17);
		add(textFieldPrenom);
		
		textFieldAdresse = new JTextField();
		textFieldAdresse.setPreferredSize(new Dimension(150, 35));
		textFieldAdresse.setColumns(10);
		textFieldAdresse.setBounds(85, 101, 179, 17);
		add(textFieldAdresse);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setPreferredSize(new Dimension(150, 35));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(85, 124, 179, 17);
		add(textFieldEmail);
		
		textFieldTelephone = new JTextField();
		textFieldTelephone.setPreferredSize(new Dimension(150, 35));
		textFieldTelephone.setColumns(10);
		textFieldTelephone.setBounds(85, 147, 179, 17);
		add(textFieldTelephone);
		
		
		
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contrat contrat = (Contrat) comboBoxContrat.getSelectedItem();
				Employee pilote = new Employee(textFieldNom.getText(), textFieldPrenom.getText(), posteDao.getOne(3),contrat, textFieldAdresse.getText(), textFieldEmail.getText(), Integer.valueOf( textFieldTelephone.getText()));
				employeeDao.add(pilote);
				scrollPane.setViewportView(tables.getTablePilote());
				scrollPane.setViewportView(tablePilote);
				
			}
		});
		btnValider.setBounds(96, 246, 85, 21);
		add(btnValider);

	
}}
