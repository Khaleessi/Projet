package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import implementationsDao.CompteDaoImpl;
import implementationsDao.MD5;
import interfacesDao.InterfaceCompteDao;
import models.Aeroport;
import models.Compte;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;
import java.awt.event.ActionEvent;

public class Authentification extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private MD5 md5 = new MD5();
   	private InterfaceCompteDao compteDao = new CompteDaoImpl();
   	private static Authentification frame = new Authentification();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Authentification() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(94, 65, 45, 13);
		contentPane.add(lblLogin);
		
		JLabel lblMDP = new JLabel("Mot de passe");
		lblMDP.setBounds(94, 111, 45, 13);
		contentPane.add(lblMDP);
		
		textField = new JTextField();
		textField.setBounds(181, 62, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(181, 108, 96, 19);
		contentPane.add(passwordField);
		
		JButton btnConnection = new JButton("Connection");
		btnConnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				List<Compte> listCompte = compteDao.getAll();
				Compte compteUser = null;

				for(Compte compte : listCompte) {
					if(compte.getLogin().equals(textField.getText()) && MD5.getMd5(passwordField.getText()).equals(compte.getMdp())){
						compteUser = compte;
				}
				}	
				
				if(compteUser != null) {

					switch (compteUser.getEmployee().getPoste().getId()) {
					case 1: {
						first fenetreTechnicien = new first();
						frame.dispose();
						fenetreTechnicien.main(null);
						break;
					}
					case 2: {
						third fenetreChargé = new third();
						frame.dispose();
						fenetreChargé.main(null);
						break;
					}
					case 3: {
						MesInformations mesInformation = new MesInformations(compteUser.getEmployee());
						frame.dispose();
						mesInformation.main(null,compteUser.getEmployee());
						break;
					}
					case 4: {
						second fenetreAdmin = new second();
						frame.dispose();
						fenetreAdmin.main(null);
						break;
					}
					default:
						throw new IllegalArgumentException("Unexpected value: " + compteUser.getEmployee().getPoste().getId());
					}
				}else {
					System.out.println("login ou mot de passe incorrect");
				}
				
				
			}
		});
		btnConnection.setBounds(173, 166, 85, 21);
		contentPane.add(btnConnection);
	}
}
