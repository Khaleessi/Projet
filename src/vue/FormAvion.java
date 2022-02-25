package vue;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import implementationsDao.AeroportDaoImpl;
import implementationsDao.ConstructeurDaoImpl;
import implementationsDao.ModelDaoImpl;
import interfacesDao.InterfaceAeroportDao;
import interfacesDao.InterfaceConstructeurDao;
import interfacesDao.InterfaceModelDao;
import models.Constructeur;
import models.Model;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormAvion extends JPanel {
	
	private InterfaceModelDao modelDao = new ModelDaoImpl();
	private InterfaceAeroportDao aeroportDao = new AeroportDaoImpl();
	private InterfaceConstructeurDao constructeurDao = new ConstructeurDaoImpl();
	private JTextField textFieldCapacite;
	private JTextField textFieldModel;
	private Tables tables = new Tables();
	/**
	 * Create the panel.
	 */
	public FormAvion(JScrollPane scrollPane) {
		setLayout(null);
		
		JComboBox comboBoxConstructeur = new JComboBox(constructeurDao.getAll().toArray());
		comboBoxConstructeur.setBounds(176, 151, 96, 21);
		add(comboBoxConstructeur);
		
		JLabel lblConstructeur = new JLabel("Constructeur");
		lblConstructeur.setBounds(60, 155, 88, 13);
		add(lblConstructeur);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Constructeur contructeur = (Constructeur) comboBoxConstructeur.getSelectedItem();
				Model avion = new Model(textFieldModel.getText(),Integer.valueOf(textFieldCapacite.getText()) , contructeur);
				modelDao.add(avion);
				scrollPane.setViewportView(tables.getTableAvion());
			}
		});
		btnNewButton_1.setBounds(164, 245, 85, 21);
		add(btnNewButton_1);
		
		JLabel lblCapacite = new JLabel("Capacite");
		lblCapacite.setBounds(60, 125, 45, 13);
		add(lblCapacite);
		
		textFieldCapacite = new JTextField();
		textFieldCapacite.setBounds(176, 122, 96, 19);
		add(textFieldCapacite);
		textFieldCapacite.setColumns(10);
		
		textFieldModel = new JTextField();
		textFieldModel.setBounds(176, 93, 96, 19);
		add(textFieldModel);
		textFieldModel.setColumns(10);
		
		JLabel lblModel = new JLabel("Model");
		lblModel.setBounds(60, 96, 45, 13);
		add(lblModel);

	}
}
