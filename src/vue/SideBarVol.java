package vue;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import implementationsDao.VolDaoImpl;
import interfacesDao.InterfaceVolDao;
import models.Vol;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SideBarVol extends JPanel {
	private InterfaceVolDao volDao = new VolDaoImpl();
	/**
	 * Create the panel.
	 */
	public SideBarVol(JScrollPane scrollPane,Vol vol) {
		setLayout(null);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormVol form = new FormVol(scrollPane,vol);
				scrollPane.setViewportView(form);
			}
		});
		btnModifier.setBounds(48, 131, 85, 21);
		add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(vol.getListAffectation().size()!=0) {
					JOptionPane.showMessageDialog(null,"Ce Vol est affecté vous ne pouvez pas le supprimer"," titre ",JOptionPane.WARNING_MESSAGE);

				}else {
					volDao.delete(vol.getId());
				}
				
			}
		});
		btnSupprimer.setBounds(48, 178, 85, 21);
		add(btnSupprimer);

	}

}
