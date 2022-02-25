package implementationsDao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.AbstractDao;
import interfacesDao.InterfaceAffectationDao;
import interfacesDao.InterfaceAvionDao;
import interfacesDao.InterfaceModelDao;
import interfacesDao.InterfacePiloteDao;
import interfacesDao.InterfaceVolDao;
import models.Affectation;
import models.Pilote;

public class AffectationDaoImpl extends AbstractDao implements InterfaceAffectationDao{
		
	InterfaceVolDao volDao = new VolDaoImpl();
	InterfaceAvionDao avionDao = new AvionDaoImpl();
	InterfacePiloteDao piloteDao = new PiloteDaoImpl();
	InterfaceModelDao modelDao = new ModelDaoImpl();
	@Override
	public String add(Affectation obj) {
		PreparedStatement pst=null;
		String sql ="INSERT INTO affectation (vol,pilote,avion) VALUES (?, ?, ?)";
		
		try {
			pst=connection.prepareStatement(sql);
			pst.setInt(1, obj.getVol().getId());
			pst.setInt(2, obj.getPilote().getId());
			pst.setInt(3, obj.getAvion().getId());
			pst.executeUpdate();
			String message =  "L'Affectation a été ajouté avec succes";
			return message;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public String delete(int id) {
		PreparedStatement pst=null;
		String sql ="DELETE FROM affectation WHERE id=?";
		try {
			pst=connection.prepareStatement(sql);
			pst.setInt(1,id);
			pst.executeUpdate();
			String message =  "L'affectation a été supprimé avec succes";
			return message;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Vous devez d'abord supprimer tout les avions qui appartiennent a ce constructeur.");
		}
		return null;
		
	}


	@Override
	public List<Affectation> getAll() {
		List<Affectation> list = new ArrayList<Affectation>();
		PreparedStatement pst=null;
		ResultSet rs;
		String sql ="select * from affectation";
		try {
			pst=connection.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()) {
				list.add(new Affectation(rs.getInt("id"),volDao.getOne(rs.getInt("vol")),modelDao.getOne(rs.getInt("avion")),piloteDao.getOne(rs.getInt("pilote"))));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public Affectation getOne(int id) {
		PreparedStatement pst=null;
		ResultSet rs;
		String sql ="select * from affectation where id=?";
		try {
			pst=connection.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			if(rs.next()) {
				return new Affectation(rs.getInt("id"),volDao.getOne(rs.getInt("vol")),modelDao.getOne(rs.getInt("avion")),piloteDao.getOne(rs.getInt("pilote")));
			}
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public ResultSet getResultSet() {
		PreparedStatement pst=null;
		ResultSet rs = null;
		String sql ="select * from affectation";
		try {
			pst=connection.prepareStatement(sql);
			rs=pst.executeQuery();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}

	@Override
	public String update(Affectation obj) {
		PreparedStatement pst=null;
		String sql ="UPDATE affectation SET vol = ?,pilote = ?, avion = ? where id = ?";
		
		try {
			pst=connection.prepareStatement(sql);
			pst.setInt(1, obj.getVol().getId());
			pst.setInt(2, obj.getPilote().getId());
			pst.setInt(3, obj.getAvion().getId());
			pst.setInt(4, obj.getId());
			pst.executeUpdate();
			String message =  "L'Affectation a été modifié avec succes";
			return message;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
		
		
	}



}
