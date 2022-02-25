package vue;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import implementationsDao.AffectationDaoImpl;
import interfacesDao.InterfaceAffectationDao;
import models.Affectation;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SideBarAffectation extends JPanel {
	private InterfaceAffectationDao affectationDao = new AffectationDaoImpl();
	private Tables tables = new Tables();
	/**
	 * Create the panel.
	 */
	public SideBarAffectation(JScrollPane scrollPane,Affectation affectation) {
		setLayout(null);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormAffectation form = new FormAffectation(scrollPane,affectation);
				scrollPane.setViewportView(form);
			}
		});
		btnModifier.setBounds(48, 131, 85, 21);
		add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				affectationDao.delete(affectation.getId());
				scrollPane.setViewportView(tables.getTableAffectation());
			}
		});
		btnSupprimer.setBounds(48, 178, 85, 21);
		add(btnSupprimer);

	}

}
