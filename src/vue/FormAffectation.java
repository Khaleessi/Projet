package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import implementationsDao.AffectationDaoImpl;
import implementationsDao.AvionDaoImpl;
import implementationsDao.ModelDaoImpl;
import implementationsDao.PiloteDaoImpl;
import implementationsDao.VolDaoImpl;
import interfacesDao.InterfaceAffectationDao;
import interfacesDao.InterfaceAvionDao;
import interfacesDao.InterfaceModelDao;
import interfacesDao.InterfacePiloteDao;
import interfacesDao.InterfaceVolDao;
import models.Affectation;
import models.Avion;
import models.Model;
import models.Pilote;
import models.Vol;

public class FormAffectation extends JPanel {
	private Tables tables = new Tables();
	private JTable tableAffectation = tables.getTableAffectation();
	private InterfacePiloteDao piloteDao = new PiloteDaoImpl();
	private InterfaceAvionDao avionDao = new AvionDaoImpl();
	private InterfaceAffectationDao affectationDao = new AffectationDaoImpl();
	private InterfaceVolDao volDao = new VolDaoImpl();
	private InterfaceModelDao modelDao = new ModelDaoImpl();
	
	/**
	 * Create the panel.
	 */
	public FormAffectation(JScrollPane scrollePane,Affectation affectation) {
		setLayout(null);
		

		JLabel lblPilote = new JLabel("Pilote");
		lblPilote.setBounds(48, 63, 45, 13);
		add(lblPilote);
		
		JComboBox comboBoxPilote = new JComboBox();
		comboBoxPilote.setBounds(156, 59, 166, 21);
		add(comboBoxPilote);
		if(affectation!=null) {
				comboBoxPilote.addItem(affectation.getPilote());
			for(Pilote pilote : piloteDao.getAll()) {
			if(pilote!=affectation.getPilote()) {
				comboBoxPilote.addItem(pilote);
			}
			}
		
			
		}else {
			for(Pilote pilote : piloteDao.getAll()) {
					comboBoxPilote.addItem(pilote);
				}
		}
		
		JLabel lblVol = new JLabel("Vol");
		lblVol.setBounds(48, 114, 45, 13);
		add(lblVol);
		
		
		JComboBox comboBoxVol = new JComboBox();
		comboBoxVol.setBounds(156, 110, 166, 21);
		add(comboBoxVol);
		
		if(affectation!=null) {
			comboBoxVol.addItem(affectation.getVol());
			for(Vol vol : volDao.getAll()) {
		if(vol!=affectation.getVol()) {
			comboBoxVol.addItem(vol);
		}
		}
		
		
	}else {
		for(Vol vol : volDao.getAll()) {
				comboBoxVol.addItem(vol);
			}
	}
		

		JLabel lblAvion = new JLabel("Avion");
		lblAvion.setBounds(48, 173, 45, 13);
		add(lblAvion);
		
		JComboBox comboBoxAvion = new JComboBox();
		comboBoxAvion.setBounds(156, 169, 166, 21);
		add(comboBoxAvion);
		
		if(affectation!=null) {
			comboBoxAvion.addItem(affectation.getAvion());
			for(Model avion : modelDao.getAll()) {
		if(avion!=affectation.getAvion()) {
			comboBoxAvion.addItem(avion);
		}
		}
		
		}else {
		for(Model avion : modelDao.getAll()) {
				comboBoxAvion.addItem(avion);
			}
	}
		
		

		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(affectation==null) {

				Vol vol = (Vol) comboBoxVol.getSelectedItem();
				Model avion = (Model) comboBoxAvion.getSelectedItem();
				Pilote pilote = (Pilote) comboBoxPilote.getSelectedItem();
				Affectation affectation = new Affectation(vol,avion,pilote);
				if(pilote.getListAffectation().size() == 0 && avion.getListAffectation().size() == 0) {
					affectationDao.add(affectation);
					scrollePane.setViewportView(tables.getTableAffectation());
					
				}else {
					for(Affectation affectationPilote : pilote.getListAffectation()) {
						if(affectationPilote.getVol().getDate().equals(vol.getDate())) {
							JOptionPane.showMessageDialog(null,"Ce Pilote est deja affecté a cette date"," titre ",JOptionPane.WARNING_MESSAGE);
						}
						
					}
					for(Affectation affectationAvion : avion.getListAffectation()) {
						if(affectationAvion.getVol().getDate().equals(vol.getDate())) {
							JOptionPane.showMessageDialog(null,"Cet avion est deja affecté a cette date"," titre ",JOptionPane.WARNING_MESSAGE);
						}
						
					}
				}
				
			}else{
						Vol vol = (Vol) comboBoxVol.getSelectedItem();
						Model avion = (Model) comboBoxAvion.getSelectedItem();
						Pilote pilote = (Pilote) comboBoxPilote.getSelectedItem();
						affectation.setVol(vol);
						affectation.setPilote(pilote);
						affectation.setAvion(avion);
						affectationDao.update(affectation);
						scrollePane.setViewportView(tables.getTableAffectation());

					}
				}
		});
		btnEnregistrer.setBounds(237, 238, 85, 21);
		add(btnEnregistrer);

	}
}
