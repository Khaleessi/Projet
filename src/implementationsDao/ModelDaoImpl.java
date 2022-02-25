package implementationsDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.AbstractDao;
import interfacesDao.InterfaceConstructeurDao;
import interfacesDao.InterfaceModelDao;
import models.Model;

public class ModelDaoImpl extends AbstractDao implements InterfaceModelDao {
	private InterfaceConstructeurDao contructeurDao = new ConstructeurDaoImpl();
	@Override
	public String add(Model obj) {
		PreparedStatement pst=null;
		String sql ="INSERT INTO model (nom,capacite,constructeur) VALUES (?,?,?)";
		
		try {
			pst=connection.prepareStatement(sql);
			pst.setString(1, obj.getNom());
			pst.setInt(2, obj.getCapacite());
			pst.setInt(3, obj.getConstructeur().getId());
			pst.executeUpdate();
			String message =  "Le model "+obj.getNom()+"a été ajouté avec succes";
			return message;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
		
	}

	@Override
	public String delete(int id) {
		PreparedStatement pst=null;
		String sql ="DELETE FROM model WHERE id=?";
		try {
			pst=connection.prepareStatement(sql);
			pst.setInt(1,id);
			pst.executeUpdate();
			
			String message =  "Le model a été supprimé avec succes";
			return message;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return null;
		
	}

	@Override
	public Model getOne(int id) {
		PreparedStatement pst=null;
		ResultSet rs;
		String sql ="select * from model where id=?";
		try {
			pst=connection.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			if(rs.next()) {
				return new Model(rs.getInt("id"),rs.getString("nom"),rs.getInt("capacite"),contructeurDao.getOne(rs.getInt("constructeur")));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public List<Model> getAll() {
		List<Model> list = new ArrayList<Model>();
		PreparedStatement pst=null;
		ResultSet rs;
		String sql ="select * from model";
		try {
			pst=connection.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()) {
				list.add(new Model(rs.getInt("id"),rs.getString("nom"),rs.getInt("capacite"),contructeurDao.getOne(rs.getInt("constructeur"))));
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
		String sql ="select * from model";
		try {
			pst=connection.prepareStatement(sql);
			rs=pst.executeQuery();

		} catch (Exception e) {
			System.out.println(e);
		}
		return rs;
	}

	@Override
	public String update(Model obj) {
		PreparedStatement pst=null;
		String sql ="update model set nom = ? where id = ?";
		
		try {
			pst=connection.prepareStatement(sql);
			pst.setString(1, obj.getNom());
			pst.setInt(2, obj.getId());
			pst.executeUpdate();
			String message =  "La categorie "+obj.getNom()+"a été modifié avec succes";
			return message;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
