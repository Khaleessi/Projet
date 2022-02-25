package implementationsDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.AbstractDao;
import interfacesDao.InterfaceCompteDao;
import interfacesDao.InterfaceEmployeDao;
import models.Compte;

public class CompteDaoImpl extends AbstractDao implements InterfaceCompteDao{
	
	InterfaceEmployeDao employeeDao = new EmployeeDaoImpl();
	
	@Override
	public String add(Compte obj) {
		PreparedStatement pst=null;
		String sql ="INSERT INTO compte (employee,login,mdp,actif) VALUES (?, ?, ?,?)";

		try {
			pst=connection.prepareStatement(sql);
			pst.setInt(1, obj.getEmployee().getId());
			pst.setString(2, obj.getLogin());
			pst.setString(3, obj.getMdp());
			pst.setBoolean(4, obj.isActif());
			pst.executeUpdate();
			String message =  "Le compte de "+obj.getEmployee().getNom()+" "+obj.getEmployee().getPrenom()+"a été ajouté avec succes";
			return message;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public String delete(int id) {
		PreparedStatement pst=null;
		String sql ="DELETE FROM compte WHERE id=?";
		try {
			pst=connection.prepareStatement(sql);
			pst.setInt(1,id);
			pst.executeUpdate();
			String message =  "Le compte a été supprimé avec succes";
			return message;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public Compte getOne(int id) {
		PreparedStatement pst=null;
		ResultSet rs;
		String sql ="select * from compte where id=?";
		try {
			pst=connection.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			if(rs.next()) {
				return new Compte(rs.getInt("id"),employeeDao.getOne(rs.getInt("employee")),rs.getString("login"),rs.getString("mdp"),rs.getBoolean("actif"));
			}
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public List<Compte> getAll() {
		List<Compte> list = new ArrayList<Compte>();
		PreparedStatement pst=null;
		ResultSet rs;
		String sql ="select * from compte";
		try {
			pst=connection.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()) {
				list.add(new Compte(rs.getInt("id"),employeeDao.getOne(rs.getInt("employee")),rs.getString("login"),rs.getString("mdp"),rs.getBoolean("actif")));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public ResultSet getResultSet() {
		PreparedStatement pst=null;
		ResultSet rs = null;
		String sql ="select * from compte";
		try {
			pst=connection.prepareStatement(sql);
			rs=pst.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}

	@Override
	public String update(Compte obj) {
		PreparedStatement pst=null;
		String sql ="update compte set employee = ?,login = ?,mdp = ?,actif = ?) where id=?";

		try {
			pst=connection.prepareStatement(sql);
			pst.setInt(1, obj.getEmployee().getId());
			pst.setString(2, obj.getLogin());
			pst.setString(3, obj.getMdp());
			pst.setBoolean(4, obj.isActif());
			pst.setInt(5, obj.getId());
			pst.executeUpdate();
			String message =  "Le compte de "+obj.getEmployee().getNom()+" "+obj.getEmployee().getPrenom()+"a été modifié avec succes";
			return message;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
