package implementationsDao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.AbstractDao;
import interfacesDao.InterfaceEmployeDao;
import interfacesDao.InterfacePiloteDao;
import models.Pilote;

public class PiloteDaoImpl extends AbstractDao implements InterfacePiloteDao{
	private InterfaceEmployeDao employeeDao = new EmployeeDaoImpl();
	
	@Override
	public String add(Pilote obj) {
		PreparedStatement pst=null;
		String sql ="INSERT INTO `pilote`(`fiche_employee`) VALUES (?)";
		
		try {
			pst=connection.prepareStatement(sql);
			pst.setInt(1, obj.getFicheEmployee().getId());
			pst.executeUpdate();
			String message =  "Le Pilote "+obj.getFicheEmployee().getNom()+" "+obj.getFicheEmployee().getPrenom()+"a été ajouté avec succes";
			return message;
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public String delete(int id) {
		PreparedStatement pst=null;
		String sql ="DELETE FROM pilote WHERE id=?";
		try {
			pst=connection.prepareStatement(sql);
			pst.setInt(1,id);
			pst.executeUpdate();
			String message =  "L'employé(e) a été supprimé avec succes";
			return message;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public Pilote getOne(int id) {
		PreparedStatement pst=null;
		ResultSet rs;
		String sql ="select * from pilote where id=?";
		try {
			pst=connection.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			if(rs.next()) {
				return new Pilote(rs.getInt("id"),employeeDao.getOne(rs.getInt("fiche_employee")));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public List<Pilote> getAll() {
		List<Pilote> list = new ArrayList<Pilote>();
		PreparedStatement pst=null;
		ResultSet rs;
		String sql ="select * from pilote";
		try {
			pst=connection.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()) {
				list.add(new Pilote(rs.getInt("id"),employeeDao.getOne( rs.getInt("fiche_employee"))));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	@Override
	public ResultSet getResultSet() {
		PreparedStatement pst=null;
		ResultSet rs = null;
		String sql ="select * from pilote";
		try {
			pst=connection.prepareStatement(sql);
			rs=pst.executeQuery();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}

	@Override
	public String update(Pilote obj) {
		return null;
	}
	


	
}
