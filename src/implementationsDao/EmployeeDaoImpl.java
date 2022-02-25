package implementationsDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.AbstractDao;
import interfacesDao.InterfaceContratDao;
import interfacesDao.InterfaceEmployeDao;
import interfacesDao.InterfacePosteDao;
import models.Employee;

public class EmployeeDaoImpl extends AbstractDao implements InterfaceEmployeDao{
	InterfacePosteDao posteDao = new PosteDaoImpl();
	InterfaceContratDao contratDao = new ContratDaoImpl();
	@Override
	public String add(Employee obj) {
		PreparedStatement pst=null;
		String sql ="INSERT INTO `employee`(`nom`, `prenom`, `poste`, `contrat`, `adresse`, `email`, `telephone`) VALUES (?,?,?,?,?,?,?)";
		String sql2 ="INSERT INTO `pilote`(`fiche_employee`) VALUES (?)";
		try {
			pst=connection.prepareStatement(sql);
			pst.setString(1, obj.getNom());
			pst.setString(2, obj.getPrenom());
			pst.setInt(3, obj.getPoste().getId());
			pst.setInt(4, obj.getContrat().getId());
			pst.setString(5, obj.getAdresse());
			pst.setString(6, obj.getEmail());
			pst.setInt(7, obj.getTelephone());
			pst.executeUpdate();
			if(obj.getPoste().getId()==3) {
				pst=connection.prepareStatement(sql2);
				pst.setInt(1, getAll().get(getAll().size() - 1).getId());
				pst.executeUpdate();
			}
			String message =  "L'employé(e) "+obj.getNom()+" "+obj.getPrenom()+"a été ajouté avec succes";
			return message;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
		
	}

	@Override
	public String delete(int id) {
		PreparedStatement pst=null;
		String sql ="DELETE FROM employee WHERE id=?";
		try {
			pst=connection.prepareStatement(sql);
			pst.setInt(1,id);
			pst.executeUpdate();
			String message =  "L'employé(e) a été supprimé avec succes";
			return message;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return null;
		
	}

	@Override
	public Employee getOne(int id) {
		PreparedStatement pst=null;
		ResultSet rs;
		String sql ="select * from employee where id=?";
		try {
			pst=connection.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			if(rs.next()) {
				return new Employee(rs.getInt("id"),rs.getString("nom"),rs.getString("prenom"),posteDao.getOne(rs.getInt("poste")),contratDao.getOne(rs.getInt("contrat")),rs.getString("adresse"),rs.getString("email"),rs.getInt("telephone"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> list = new ArrayList<Employee>();
		PreparedStatement pst=null;
		ResultSet rs;
		String sql ="select * from employee";
		try {
			pst=connection.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()) {
				list.add(new Employee(rs.getInt("id"),rs.getString("nom"),rs.getString("prenom"),posteDao.getOne(rs.getInt("poste")),contratDao.getOne(rs.getInt("contrat")),rs.getString("adresse"),rs.getString("email"),rs.getInt("telephone")));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	public ResultSet getResultSet() {
		PreparedStatement pst=null;
		ResultSet rs = null;
		String sql ="select * from employee";
		try {
			pst=connection.prepareStatement(sql);
			rs=pst.executeQuery();
		
		} catch (Exception e) {
			System.out.println(e);
		}
		return rs;
	}

	@Override
	public String update(Employee obj) {
		PreparedStatement pst=null;
		String sql ="update `employee` set  `nom`=?, `prenom`=?, `poste`=?, `contrat`=?, `adresse`=?, `email`=?, `telephone`=? where  id = ?";
		try {
			pst=connection.prepareStatement(sql);
			pst.setString(1, obj.getNom());
			pst.setString(2, obj.getPrenom());
			pst.setInt(3, obj.getPoste().getId());
			pst.setInt(4, obj.getContrat().getId());
			pst.setString(5, obj.getAdresse());
			pst.setString(6, obj.getEmail());
			pst.setInt(7, obj.getTelephone());
			pst.setInt(8, obj.getId());
			pst.executeUpdate();
			String message =  "L'employé(e) "+obj.getNom()+" "+obj.getPrenom()+"a été ajouté avec succes";
			return message;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
}
