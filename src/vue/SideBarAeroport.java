package vue;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import models.Aeroport;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SideBarAeroport extends JPanel {

	/**
	 * Create the panel.
	 */
	public SideBarAeroport(JScrollPane scrollPane,Aeroport aeroport) {
		setLayout(null);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormAeroport form = new FormAeroport(aeroport,scrollPane);
				scrollPane.setViewportView(form);
			}
		});
		btnModifier.setBounds(48, 131, 85, 21);
		add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSupprimer.setBounds(48, 178, 85, 21);
		add(btnSupprimer);

	}

}
