package vue;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import implementationsDao.PiloteDaoImpl;
import interfacesDao.InterfacePiloteDao;
import models.Employee;
import models.Pilote;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SideBarPilote extends JPanel {
	private InterfacePiloteDao piloteDao = new PiloteDaoImpl();
	private Tables tables = new Tables();
	/**
	 * Create the panel.
	 */
	public SideBarPilote(JScrollPane scrollPane,Employee pilote) {
		setLayout(null);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormPilote form = new FormPilote(pilote,scrollPane);
				scrollPane.setViewportView(form);
			}
		});
		btnModifier.setBounds(48, 131, 85, 21);
		add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				if(pilote.getListAffectation().size()!=0) {
//					JOptionPane.showMessageDialog(null,"Ce Pilote est affecté vous ne pouvez pas le supprimer"," titre ",JOptionPane.WARNING_MESSAGE);
//				}else {
//					
//				}
				piloteDao.delete(pilote.getId());
					scrollPane.setViewportView(tables.getTablePilote());
				
			}
		});
		btnSupprimer.setBounds(48, 178, 85, 21);
		add(btnSupprimer);

	}

}
