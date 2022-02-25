package vue;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

import implementationsDao.AeroportDaoImpl;
import implementationsDao.VolDaoImpl;
import interfacesDao.InterfaceAeroportDao;
import interfacesDao.InterfaceVolDao;
import models.Aeroport;
import models.Vol;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class FormVol extends JPanel {
	private JTextField textFieldNumero;
	private JTextField textFieldDate;
	private JTextField textFieldHD;
	private JTextField textFieldHA;
	private Tables tables = new Tables();
	private InterfaceVolDao volDao = new VolDaoImpl();
	private InterfaceAeroportDao aeroportDao = new AeroportDaoImpl();

	/**
	 * Create the panel.
	 * @wbp.parser.constructor
	 */
	public FormVol(JScrollPane scrollPane,Vol vol) {
		setLayout(null);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(34, 56, 45, 13);
		add(lblDate);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(34, 30, 45, 13);
		add(lblNumero);
		
		JLabel lblheureDepart = new JLabel("Heure de D\u00E9part");
		lblheureDepart.setBounds(34, 79, 45, 13);
		add(lblheureDepart);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setBounds(111, 27, 96, 19);
		add(textFieldNumero);
		textFieldNumero.setColumns(10);
		
		textFieldDate = new JTextField();
		textFieldDate.setBounds(111, 53, 96, 19);
		add(textFieldDate);
		textFieldDate.setColumns(10);
		
		textFieldHD = new JTextField();
		textFieldHD.setBounds(111, 76, 96, 19);
		add(textFieldHD);
		textFieldHD.setColumns(10);
		
		
		
		textFieldHA = new JTextField();
		textFieldHA.setColumns(10);
		textFieldHA.setBounds(111, 102, 96, 19);
		add(textFieldHA);
		
		JLabel lblHeureDeArriv = new JLabel("Heure de Arriv\u00E9");
		lblHeureDeArriv.setBounds(34, 105, 45, 13);
		add(lblHeureDeArriv);
		
		JComboBox comboBoxAeroportD = new JComboBox(aeroportDao.getAll().toArray());
		comboBoxAeroportD.setBounds(111, 131, 96, 21);
		add(comboBoxAeroportD);
		
		JComboBox comboBoxAeroportA = new JComboBox(aeroportDao.getAll().toArray());
		comboBoxAeroportA.setBounds(111, 162, 96, 21);
		add(comboBoxAeroportA);
		
		JLabel lblNewLabel = new JLabel("Aeroport de D\u00E9part");
		lblNewLabel.setBounds(34, 135, 45, 13);
		add(lblNewLabel);
		
		JLabel lblAeroportDarriv = new JLabel("Aeroport d'Arriv\u00E9");
		lblAeroportDarriv.setBounds(34, 166, 45, 13);
		add(lblAeroportDarriv);
		
		
		if(vol!=null) {
			textFieldNumero.setText(vol.getNumero());
			textFieldDate.setText(vol.getDate().toString());
			textFieldHD.setText(vol.getHeureDepart().toString());
			textFieldHA.setText(vol.getHeureArrive().toString());
			comboBoxAeroportD.getSelectedItem();
			comboBoxAeroportA.getSelectedItem();
		}
		
		
		
		
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date = Date.valueOf(textFieldDate.getText());
				SimpleDateFormat sdf = new SimpleDateFormat(textFieldHD.getText());
				long ms = 0;
				try {
					ms = sdf.parse(textFieldHD.getText()).getTime();
				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				Time t = new Time(ms);

				SimpleDateFormat sdf2= new SimpleDateFormat(textFieldHA.getText());
				long ms2 = 0;
				try {
					ms2 = sdf2.parse(textFieldHA.getText()).getTime();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Time t2 = new Time(ms2);
				Aeroport aeroportD = (Aeroport) comboBoxAeroportD.getSelectedItem();
				Aeroport aeroportA = (Aeroport)comboBoxAeroportA.getSelectedItem();
				Vol vol = new Vol(textFieldNumero.getText(), date,t,t2,aeroportD, aeroportA);
				volDao.add(vol);
				scrollPane.setViewportView(tables.getTableVol());
			}
		});
		btnEnregistrer.setBounds(150, 226, 85, 21);
		add(btnEnregistrer);
		
		
		

	}
	
	
	
	
//	public FormVol(JScrollPane scrollPane,Vol vol) {
//		setLayout(null);
//		
//		JLabel lblDate = new JLabel("Date");
//		lblDate.setBounds(34, 56, 45, 13);
//		add(lblDate);
//		
//		JLabel lblNumero = new JLabel("Numero");
//		lblNumero.setBounds(34, 30, 45, 13);
//		add(lblNumero);
//		
//		JLabel lblheureDepart = new JLabel("Heure de D\u00E9part");
//		lblheureDepart.setBounds(34, 79, 45, 13);
//		add(lblheureDepart);
//		
//		textFieldNumero = new JTextField();
//		textFieldNumero.setBounds(111, 27, 96, 19);
//		add(textFieldNumero);
//		textFieldNumero.setColumns(10);
//		
//		textFieldDate = new JTextField();
//		textFieldDate.setBounds(111, 53, 96, 19);
//		add(textFieldDate);
//		textFieldDate.setColumns(10);
//		
//		textFieldHD = new JTextField();
//		textFieldHD.setBounds(111, 76, 96, 19);
//		add(textFieldHD);
//		textFieldHD.setColumns(10);
//		
//		
//		
//		textFieldHA = new JTextField();
//		textFieldHA.setColumns(10);
//		textFieldHA.setBounds(111, 102, 96, 19);
//		add(textFieldHA);
//		
//		JLabel lblHeureDeArriv = new JLabel("Heure de Arriv\u00E9");
//		lblHeureDeArriv.setBounds(34, 105, 45, 13);
//		add(lblHeureDeArriv);
//		
//		JComboBox comboBox = new JComboBox();
//		comboBox.setBounds(111, 131, 96, 21);
//		add(comboBox);
//		
//		JComboBox comboBox_1 = new JComboBox();
//		comboBox_1.setBounds(111, 162, 96, 21);
//		add(comboBox_1);
//		
//		JLabel lblNewLabel = new JLabel("Aeroport de D\u00E9part");
//		lblNewLabel.setBounds(34, 135, 45, 13);
//		add(lblNewLabel);
//		
//		JLabel lblAeroportDarriv = new JLabel("Aeroport d'Arriv\u00E9");
//		lblAeroportDarriv.setBounds(34, 166, 45, 13);
//		add(lblAeroportDarriv);
//		
//		JButton btnEnregistrer = new JButton("Enregistrer");
//		btnEnregistrer.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				scrollPane.setViewportView(tables.getTableVol());
//				
//			}
//		});
//		btnEnregistrer.setBounds(150, 226, 85, 21);
//		add(btnEnregistrer);
//		
//		
//		if(vol!=null) {
//			
//		}
//
//	}
}

