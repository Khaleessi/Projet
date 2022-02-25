package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import implementationsDao.PiloteDaoImpl;
import interfacesDao.InterfacePiloteDao;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class test extends JFrame {

	private JPanel contentPane;
	private InterfacePiloteDao piloteDao = new PiloteDaoImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
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
	public test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JComboBox comboBox_1 = new JComboBox(piloteDao.getAll().toArray());
		comboBox_1.setBounds(172, 109, 29, 21);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox = new JComboBox(piloteDao.getAll().toArray());
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(5);
				comboBox_1.add(null, comboBox.getSelectedIndex());
				
			}
		});
		comboBox.setBounds(172, 66, 29, 21);
		contentPane.add(comboBox);
		
		
	}

}
