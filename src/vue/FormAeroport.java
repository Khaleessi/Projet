package vue;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

import implementationsDao.AeroportDaoImpl;
import interfacesDao.InterfaceAeroportDao;
import models.Aeroport;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormAeroport extends JPanel {
	private JTextField textFieldCodeIata;
	private JTextField textFieldNom;
	private JTextField textFieldVille;
	private Tables tables = new Tables();
	private InterfaceAeroportDao aeroportDao = new AeroportDaoImpl();

	/**
	 * Create the panel.
	 * @wbp.parser.constructor
	 */
	public FormAeroport(Aeroport aeroport, JScrollPane scrollPane) {
		setLayout(null);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(34, 56, 45, 13);
		add(lblNom);
		
		JLabel lblCodeIata = new JLabel("Code Iata");
		lblCodeIata.setBounds(34, 30, 45, 13);
		add(lblCodeIata);
		
		JLabel lblVille = new JLabel("Ville");
		lblVille.setBounds(34, 79, 45, 13);
		add(lblVille);
		
		textFieldCodeIata = new JTextField();
		textFieldCodeIata.setBounds(111, 27, 96, 19);
		add(textFieldCodeIata);
		textFieldCodeIata.setColumns(10);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(111, 53, 96, 19);
		add(textFieldNom);
		textFieldNom.setColumns(10);
		
		textFieldVille = new JTextField();
		textFieldVille.setBounds(111, 76, 96, 19);
		add(textFieldVille);
		textFieldVille.setColumns(10);
		
		if(aeroport!=null) {
			textFieldCodeIata.setText(aeroport.getCodeIata());
			textFieldNom.setText(aeroport.getNom());
			textFieldVille.setText(aeroport.getVille());
			
		}
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(aeroport==null) {
					Aeroport aeroport = new Aeroport(textFieldCodeIata.getText(), textFieldNom.getText(), textFieldVille.getText());
					aeroportDao.add(aeroport);
					scrollPane.setViewportView(tables.getTableAeroport());
				}else {
					aeroport.setCodeIata(textFieldCodeIata.getText());
					aeroport.setNom(textFieldNom.getText());
					aeroport.setVille(textFieldVille.getText());
					aeroportDao.update(aeroport);
					scrollPane.setViewportView(tables.getTableAeroport());
				}
				
			}
		});
		btnEnregistrer.setBounds(146, 185, 85, 21);
		add(btnEnregistrer);

	}
}
