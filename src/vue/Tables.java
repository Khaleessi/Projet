package vue;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import implementationsDao.AeroportDaoImpl;
import implementationsDao.AffectationDaoImpl;
import implementationsDao.AvionDaoImpl;
import implementationsDao.ModelDaoImpl;
import implementationsDao.CompteDaoImpl;
import implementationsDao.ConstructeurDaoImpl;
import implementationsDao.ContratDaoImpl;
import implementationsDao.EmployeeDaoImpl;
import implementationsDao.PiloteDaoImpl;
import implementationsDao.PosteDaoImpl;
import implementationsDao.VolDaoImpl;
import interfacesDao.InterfaceAeroportDao;
import interfacesDao.InterfaceAffectationDao;
import interfacesDao.InterfaceAvionDao;
import interfacesDao.InterfaceModelDao;
import interfacesDao.InterfaceCompteDao;
import interfacesDao.InterfaceConstructeurDao;
import interfacesDao.InterfaceContratDao;
import interfacesDao.InterfaceEmployeDao;
import interfacesDao.InterfacePiloteDao;
import interfacesDao.InterfacePosteDao;
import interfacesDao.InterfaceVolDao;
import net.proteanit.sql.DbUtils;

public class Tables extends JTable{
	public Tables() {
	}
	private InterfaceEmployeDao employeeDao = new EmployeeDaoImpl();
	private InterfaceCompteDao compteDao = new CompteDaoImpl();
	private InterfacePosteDao posteDao = new PosteDaoImpl();
	private InterfaceContratDao contratDao = new ContratDaoImpl();
	private InterfaceAeroportDao aeroportDao = new AeroportDaoImpl();
	private InterfaceVolDao volDao = new VolDaoImpl();
	private InterfaceModelDao modelDao = new ModelDaoImpl();
	private InterfaceModelDao categorieDao = new ModelDaoImpl();
	private InterfaceConstructeurDao constructeurDao = new  ConstructeurDaoImpl();
	private InterfacePiloteDao piloteDao = new PiloteDaoImpl();
	private InterfaceAffectationDao affectationDao = new AffectationDaoImpl();
	private JTable tableEmployee = new JTable();
	private JTable tableAvion = new JTable();
	private JTable tableVol = new JTable();
	private JTable tablePilote = new JTable();
	private JTable tableAffectation = new JTable();
	private JTable tableAeroport = new JTable();
	private JTable tableCompte = new JTable();
	private JScrollPane scrollPane;
	private String tableName;
	
	public String getTableName() {
		return tableName;
	}

	@Override
    public boolean isCellEditable(int row, int column) {
       //all cells false
       return false;
    }
	
	public JTable getTableVol() {
		updateTable(volDao.getResultSet(),tableVol);
		ResultSet rs = volDao.getResultSet();
		int i = 0;
		DefaultTableModel model = (DefaultTableModel) tableVol.getModel();
		try {
			tableName = rs.getMetaData().getTableName(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			
			while (rs.next()) {
				model.setValueAt(aeroportDao.getOne(rs.getInt("aeroport_depart")).getNom(), i, 5);
				model.setValueAt(aeroportDao.getOne(rs.getInt("aeroport_arrive")).getNom(), i,6);
				tableVol.setModel(model);
				i++;
			}
		} catch (Exception e2) {
			System.out.println(e2);
		}
		
		return tableVol;
	}
	
	public JTable getTableEmployee(){
		updateTable(employeeDao.getResultSet(),tableEmployee);
		ResultSet rs = employeeDao.getResultSet();
		int i = 0;
		DefaultTableModel model = (DefaultTableModel) tableEmployee.getModel();
		try {
			tableName = rs.getMetaData().getTableName(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				model.setValueAt(posteDao.getOne(rs.getInt("poste")).getIntitule(), i, 3);
				model.setValueAt(contratDao.getOne(rs.getInt("contrat")).getNom(), i,4);
				tableEmployee.setModel(model);
				i++;
			}
		} catch (Exception e2) {
			System.out.println(e2);
		}
		
		
		
		
		
		return tableEmployee;
	}
	
	
	public JTable getTableCompte(){
		updateTable(compteDao.getResultSet(),tableCompte);
		ResultSet rs = compteDao.getResultSet();
		int i = 0;
		DefaultTableModel model = (DefaultTableModel) tableCompte.getModel();
		try {
			tableName = rs.getMetaData().getTableName(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				String fullName  = employeeDao.getOne(rs.getInt("employee")).getNom()+" "+employeeDao.getOne(rs.getInt("employee")).getPrenom();
				model.setValueAt(fullName, i, 1);
				tableCompte.setModel(model);
				i++;
			}
		} catch (Exception e2) {
			System.out.println(e2);
		}
		
		
		
		
		
		return tableCompte;
	}
	
	
	
	
	
	public JTable getTableAvion() {
		
		updateTable(modelDao.getResultSet(),tableAvion);
		ResultSet rs = modelDao.getResultSet();
		tableName = "avion";
		int i = 0;
		DefaultTableModel model = (DefaultTableModel) tableAvion.getModel();
		try {
			while (rs.next()) {
				model.setValueAt(constructeurDao.getOne(rs.getInt("constructeur")), i, 3);
				tableAvion.setModel(model);
				i++;
			}
		} catch (Exception e2) {
			System.out.println(e2);
		}
		
		return tableAvion;
	}
	
public JTable getTableAffectation() {
		
		updateTable(affectationDao.getResultSet(),tableAffectation);
		ResultSet rs = affectationDao.getResultSet();
		try {
			tableName = rs.getMetaData().getTableName(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i = 0;
		DefaultTableModel model = (DefaultTableModel) tableAffectation.getModel();
		try {
			while (rs.next()) {
				String vol = volDao.getOne(rs.getInt("vol")).getNumero()+" du "+volDao.getOne(rs.getInt("vol")).getDate();
				String fullName = piloteDao.getOne(rs.getInt("pilote")).getFicheEmployee().getNom()+" "+piloteDao.getOne(rs.getInt("pilote")).getFicheEmployee().getPrenom();
				model.setValueAt(vol, i, 1);
				model.setValueAt(modelDao.getOne(rs.getInt("avion")).getNom(), i,2);
				model.setValueAt(fullName, i,3);
				tableAffectation.setModel(model);
				i++;
			}
		} catch (Exception e2) {
			System.out.println(e2);
		}
		
		return tableAffectation;
	}

public JTable getTablePilote() {
	
	updateTable(piloteDao.getResultSet(),tablePilote);
	ResultSet rs = piloteDao.getResultSet();
	try {
		tableName = rs.getMetaData().getTableName(1);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	int i = 0;
	DefaultTableModel model = (DefaultTableModel) tablePilote.getModel();
	try {
		while (rs.next()) {
			String fullName = employeeDao.getOne(rs.getInt("fiche_employee")).getNom()+" "+employeeDao.getOne(rs.getInt("fiche_employee")).getPrenom();
			model.setValueAt(fullName, i,1);
			tablePilote.setModel(model);
			i++;
		}
	} catch (Exception e2) {
		System.out.println(e2);
	}
	
	return tablePilote;
}

public JTable getTableAeroport() {
	
	updateTable(aeroportDao.getResultSet(),tableAeroport);
	ResultSet rs = aeroportDao.getResultSet();
	try {
		tableName = rs.getMetaData().getTableName(1);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return tableAeroport;
}
	
		
	
	public void updateTable(ResultSet rs,JTable table) {
		table.setModel(DbUtils.resultSetToTableModel(rs));
	}

	
	
}
