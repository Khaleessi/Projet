package implementationsDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.AbstractDao;
import interfacesDao.InterfaceConstructeurDao;
import models.Constructeur;

public class ConstructeurDaoImpl extends AbstractDao implements InterfaceConstructeurDao{

	@Override
	public String add(Constructeur obj) {
		PreparedStatement pst=null;
		String sql ="INSERT INTO constructeur (nom) VALUES (?)";
		
		try {
			pst=connection.prepareStatement(sql);
			pst.setInt(1, obj.getId());
			pst.executeUpdate();
			String message =  "Le constructeur "+obj.getNom()+"a été ajouté avec succes";
			return message;
		} catch (Exception e) {
			
		}
		return null;
		
		
	}

	@Override
	public String delete(int id) {
		PreparedStatement pst=null;
		String sql ="DELETE FROM constructeur WHERE id=?";
		try {
			pst=connection.prepareStatement(sql);
			pst.setInt(1,id);
			pst.executeUpdate();
			String message =  "Le constructeur a été supprimé avec succes";
			return message;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Vous devez d'abord supprimer tout les avions qui appartiennent a ce constructeur.");
		}
		return null;
		
		
	}

	@Override
	public Constructeur getOne(int id) {
		PreparedStatement pst=null;
		ResultSet rs;
		String sql ="select * from constructeur where id=?";
		try {
			pst=connection.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			if(rs.next()) {
				return new Constructeur(rs.getInt("id"),rs.getString("nom"));
			}
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public List<Constructeur> getAll() {
		List<Constructeur> list = new ArrayList<Constructeur>();
		PreparedStatement pst=null;
		ResultSet rs;
		String sql ="select * from constructeur";
		try {
			pst=connection.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()) {
				list.add(new Constructeur(rs.getInt("id"),rs.getString("nom")));
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
		String sql ="select * from constructeur";
		try {
			pst=connection.prepareStatement(sql);
			rs=pst.executeQuery();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}

	@Override
	public String update(Constructeur obj) {
		PreparedStatement pst=null;
		String sql ="update constructeur set nom = ? where id=?";
		
		try {
			pst=connection.prepareStatement(sql);
			pst.setString(1, obj.getNom());
			pst.setInt(2, obj.getId());
			pst.executeUpdate();
			String message =  "Le constructeur "+obj.getNom()+"a été ajouté avec succes";
			return message;
		} catch (Exception e) {
			
		}
		return null;
	}

}
