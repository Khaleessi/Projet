package vue;

import javax.swing.JPanel;


import javax.swing.JScrollPane;

import implementationsDao.AvionDaoImpl;
import implementationsDao.ModelDaoImpl;
import interfacesDao.InterfaceAvionDao;
import interfacesDao.InterfaceModelDao;
import models.Avion;
import models.Model;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SideBarAvion extends JPanel {
	private InterfaceModelDao modelDao = new ModelDaoImpl();
	private Tables tables = new Tables();
	/**
	 * Create the panel.
	 */
	public SideBarAvion(JScrollPane scrollPane,Model model) {
		setLayout(null);
		
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(model.getListAffectation().size()!=0) {
					JOptionPane.showMessageDialog(null,"Cet avion est affecté impossible de supprimer"," titre ",JOptionPane.WARNING_MESSAGE);

				}else {
					modelDao.delete(model.getId());
					scrollPane.setViewportView(tables.getTableAvion());
				}
				
			}
		});
		btnSupprimer.setBounds(48, 178, 85, 21);
		add(btnSupprimer);


	}

}
