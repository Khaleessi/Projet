package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import implementationsDao.EmployeeDaoImpl;
import interfacesDao.InterfaceEmployeDao;
import models.Employee;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MesInformations extends JFrame {


	
	private JPanel contentPane;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldAdresse;
	private JTextField textFieldEmail;
	private JTextField textFieldTelephone;
	private InterfaceEmployeDao employeeDao = new EmployeeDaoImpl();
	
	
	public static void main(String[] args,Employee employee) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MesInformations frame = new MesInformations(employee);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Launch the application.
	 */


	public MesInformations(Employee employee) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(10, 22, 45, 13);
		
		contentPane.add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(10, 56, 45, 13);
		
		contentPane.add(lblPrenom);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(10, 90, 45, 13);
		
		contentPane.add(lblAdresse);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 124, 45, 13);
		lblEmail.setText(employee.getEmail());
		contentPane.add(lblEmail);
		
		JLabel lblTel = new JLabel("Telephone");
		lblTel.setBounds(10, 161, 45, 13);
		lblTel.setText(String.valueOf(employee.getTelephone()));
		contentPane.add(lblTel);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(84, 19, 96, 19);
		textFieldNom.setText(employee.getNom());
		contentPane.add(textFieldNom);
		textFieldNom.setColumns(10);
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setBounds(84, 53, 96, 19);
		textFieldPrenom.setText(employee.getPrenom());
		contentPane.add(textFieldPrenom);
		textFieldPrenom.setColumns(10);
		
		textFieldAdresse = new JTextField();
		textFieldAdresse.setBounds(84, 87, 96, 19);
		textFieldAdresse.setText(employee.getAdresse());
		contentPane.add(textFieldAdresse);
		textFieldAdresse.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(84, 121, 96, 19);
		textFieldEmail.setText(employee.getEmail());
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldTelephone = new JTextField();
		textFieldTelephone.setBounds(84, 158, 96, 19);
		textFieldTelephone.setText(String.valueOf(employee.getTelephone()));
		contentPane.add(textFieldTelephone);
		textFieldTelephone.setColumns(10);
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				employee.setNom(textFieldNom.getText());
				employee.setPrenom(textFieldPrenom.getText());
				employee.setAdresse(textFieldAdresse.getText());
				employee.setEmail(textFieldEmail.getText());
				employee.setTelephone(Integer.valueOf(textFieldTelephone.getText()));
				
				employeeDao.update(employee);
			}
		});
		btnEnregistrer.setBounds(293, 232, 85, 21);
		contentPane.add(btnEnregistrer);
	}

}
