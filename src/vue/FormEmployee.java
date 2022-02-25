package vue;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import implementationsDao.ContratDaoImpl;
import implementationsDao.EmployeeDaoImpl;
import interfacesDao.InterfaceContratDao;
import interfacesDao.InterfaceEmployeDao;
import models.Employee;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.awt.Dimension;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;

public class FormEmployee extends JPanel {
	private InterfaceEmployeDao employeeDao = new EmployeeDaoImpl();
	private InterfaceContratDao contratDao = new ContratDaoImpl();
	private Tables tables = new Tables();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldPoste;
	private JTextField textFieldContrat;
	private JTextField textFieldAdresse;
	private JTextField textFieldEmail;
	private JTextField textFieldTel;
	private JButton btnModifier;
	private JPanel panel;
	
	public FormEmployee() {
		
	}
	/**
	 * Create the panel.
	 */
	public JPanel getFormEmployee(Employee employee,JScrollPane scrollPane) {
		setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(38, 28, 337, 245);
		add(panel);
		panel.setLayout(null);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(38, 41, 96, 19);
		panel.add(textFieldNom);
		textFieldNom.setColumns(10);
		
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setBounds(0, 41, 96, 19);
		panel.add(textFieldPrenom);
		textFieldPrenom.setColumns(10);
		
		
		JComboBox comboBoxContrat = new JComboBox(contratDao.getAll().toArray());
		comboBoxContrat.setPreferredSize(new Dimension(150, 35));
		comboBoxContrat.setBounds(0, 84, 96, 19);
		panel.add(comboBoxContrat);
		
		textFieldContrat = new JTextField();
		textFieldContrat.setBounds(0, 133, 96, 19);
		panel.add(textFieldContrat);
		textFieldContrat.setColumns(10);
		
		textFieldAdresse = new JTextField();
		textFieldAdresse.setBounds(0, 186, 96, 19);
		panel.add(textFieldAdresse);
		textFieldAdresse.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(215, 0, 96, 19);
		panel.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldTel = new JTextField();
		textFieldTel.setBounds(215, 41, 96, 19);
		panel.add(textFieldTel);
		textFieldTel.setColumns(10);
		
		btnModifier = new JButton("Appliquer changement");
		btnModifier.setBounds(202, 224, 135, 21);
		panel.add(btnModifier);
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				employee.setNom(textFieldNom.getText());
//				employee.setPrenom(textFieldPrenom.getText());
//				employee.setAdresse(textFieldAdresse.getText());
//				employee.setEmail(textFieldEmail.getText());
//				employee.setTelephone(Integer.valueOf(textFieldTel.getText()));
//				
//				employeeDao.update(employee);
				
				scrollPane.setViewportView(tables.getTableEmployee());
				
			}
		});
		return panel;
		
		
		

	}

}
