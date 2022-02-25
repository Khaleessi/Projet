package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import implementationsDao.AeroportDaoImpl;
import implementationsDao.AffectationDaoImpl;
import implementationsDao.EmployeeDaoImpl;
import implementationsDao.ModelDaoImpl;
import implementationsDao.PiloteDaoImpl;
import implementationsDao.VolDaoImpl;
import interfacesDao.InterfaceAeroportDao;
import interfacesDao.InterfaceAffectationDao;
import interfacesDao.InterfaceEmployeDao;
import interfacesDao.InterfaceModelDao;
import interfacesDao.InterfacePiloteDao;
import interfacesDao.InterfaceVolDao;
import models.Aeroport;
import models.Affectation;
import models.Employee;
import models.Pilote;
import models.Vol;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;

public class second extends JFrame {
	private Tables tables = new Tables();
	private InterfaceEmployeDao employeeDao = new EmployeeDaoImpl();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldRecherche;
	private JScrollPane scrollPaneMain;
	private FormEmployee formEmployee = new FormEmployee();
	private String tableName = new String();
	private JTable table = new JTable();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					second frame = new second();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 */class RoundBtn implements Border 
	 {
		    private int r;
		    RoundBtn(int r) {
		        this.r = r;
		    }
		    public Insets getBorderInsets(Component c) {
		        return new Insets(this.r+1, this.r+1, this.r+2, this.r);
		    }
		    public boolean isBorderOpaque() {
		        return true;
		    }
		    public void paintBorder(Component c, Graphics g, int x, int y, 
		    int width, int height) {
		        g.drawRoundRect(x, y, width-1, height-1, r, r);
		    }
		}
	 
	public second() {
		setSize(new Dimension(1423, 941));
		setPreferredSize(new Dimension(1920, 1024));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1423, 812);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(1920, 1024));
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
///////////////////////////////////////////////// PANEL - PANEL - PANEL - PANEL ///////////////////////////////////////////////////////////////////////		
		JPanel panelHeader = new JPanel();
		panelHeader.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelHeader.setPreferredSize(new Dimension(10, 220));
		contentPane.add(panelHeader, BorderLayout.NORTH);
		panelHeader.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panelLogo = new JPanel();
		panelLogo.setPreferredSize(new Dimension(400, 200));
		panelHeader.add(panelLogo);
		panelLogo.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 10, 244, 127);
		panelLogo.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\b-oma\\Downloads\\Rectangle 29.png"));

		
///////////////////////////////////////////////// BUTTON - BUTTON - BUTTON - BUTTON ///////////////////////////////////////////////////////////////////////		
		
		JPanel panelOnglet = new JPanel();
		FlowLayout fl_panelOnglet = (FlowLayout) panelOnglet.getLayout();
		fl_panelOnglet.setVgap(100);
		fl_panelOnglet.setAlignment(FlowLayout.RIGHT);
		panelOnglet.setPreferredSize(new Dimension(950, 200));
		panelHeader.add(panelOnglet);
		
		JPanel panelSideBar = new JPanel();
		panelSideBar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelSideBar.setPreferredSize(new Dimension(300, 10));
		contentPane.add(panelSideBar, BorderLayout.WEST);
		panelSideBar.setLayout(null);
		
		JButton btnCompte = new JButton("Compte");
		btnCompte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPaneMain.setViewportView(tables.getTableCompte());
				JTable table = tables.getTableCompte();
				TestTableSortFilter filter = new TestTableSortFilter(table, textFieldRecherche);
				tableName = "Compte";
				table.addMouseListener(new MouseAdapter() {
				    public void mousePressed(MouseEvent mouseEvent) {
				        JTable table =(JTable) mouseEvent.getSource();
				        Point point = mouseEvent.getPoint();
				        int row = table.rowAtPoint(point);
				        if (table.getSelectedRow() != -1) {
				        	int id = (int) table.getValueAt(table.getSelectedRow(), 0);
				        }

				    }
				});
			}
		});
		panelOnglet.add(btnCompte);


		JButton btnPilote = new JButton("Pilote");
		btnPilote.setFont(new Font("Arial", Font.PLAIN, 20));
		btnPilote.setPreferredSize(new Dimension(150, 40));
		panelOnglet.add(btnPilote);
		btnPilote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPaneMain.setViewportView(tables.getTableEmployee());
				JTable table = tables.getTableEmployee();
				TestTableSortFilter filter = new TestTableSortFilter(table, textFieldRecherche);
				tableName = "pilote";
				table.addMouseListener(new MouseAdapter() {
				    public void mousePressed(MouseEvent mouseEvent) {
				        JTable table =(JTable) mouseEvent.getSource();
				        Point point = mouseEvent.getPoint();
				        int row = table.rowAtPoint(point);
				        if (table.getSelectedRow() != -1) {
				        	int id = (int) table.getValueAt(table.getSelectedRow(), 0);
				        }

				    }
				});
				
			}
		});

		textFieldRecherche = new JTextField();
		textFieldRecherche.setBounds(39, 35, 222, 45);
		panelSideBar.add(textFieldRecherche);
		textFieldRecherche.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textFieldRecherche.setText(null);
			}
		});
		textFieldRecherche.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldRecherche.setPreferredSize(new Dimension(150, 19));
		textFieldRecherche.setText("Rechercher");
		textFieldRecherche.setColumns(10);
		
		JButton btnAjouter = new JButton("Ajouter Compte");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormCompte form = new FormCompte(scrollPaneMain);
				scrollPaneMain.setViewportView(form);
			}
		});
		btnAjouter.setBounds(98, 157, 85, 21);
		panelSideBar.add(btnAjouter);

		JPanel panelMain = new JPanel();
		contentPane.add(panelMain, BorderLayout.CENTER);
		panelMain.setLayout(null);
		
		scrollPaneMain = new JScrollPane();
		scrollPaneMain.setBounds(0, 0, 1099, 535);
		panelMain.add(scrollPaneMain);

	}
}
