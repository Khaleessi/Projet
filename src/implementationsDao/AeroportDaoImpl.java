package implementationsDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.AbstractDao;
import interfacesDao.InterfaceAeroportDao;
import models.Aeroport;

public class AeroportDaoImpl extends AbstractDao implements InterfaceAeroportDao {



	@Override
	public List<Aeroport> getAll() {
		List<Aeroport> list = new ArrayList<Aeroport>();
		PreparedStatement pst=null;
		ResultSet rs;
		String sql ="select * from aeroport";
		try {
			pst=connection.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()) {
				list.add(new Aeroport(rs.getInt("id"),rs.getString("code_iata"),rs.getString("nom"),rs.getString("ville")));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public Aeroport getOne(int id) {
		PreparedStatement pst=null;
		ResultSet rs;
		String sql ="select * from aeroport where id=?";
		try {
			pst=connection.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			if(rs.next()) {
				return new Aeroport(rs.getInt("id"),rs.getString("code_iata"),rs.getString("nom"),rs.getString("ville"));
			}
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public String add(Aeroport obj) {
		PreparedStatement pst=null;
		String sql ="INSERT INTO aeroport (code_iata,nom,ville) VALUES (?, ?, ?)";
		
		try {
			pst=connection.prepareStatement(sql);
			pst.setString(1, obj.getCodeIata());
			pst.setString(2, obj.getNom());
			pst.setString(3, obj.getVille());
			pst.executeUpdate();
			String message =  "L'aeorport "+obj.getNom()+"a été ajouté avec succes";
			return message;
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public String delete(int id) {
		
		PreparedStatement pst=null;
		String sql ="DELETE FROM aeroport WHERE id=?";
		try {
			pst=connection.prepareStatement(sql);
			pst.setInt(1,id);
			pst.executeUpdate();
			
			String message =  "L'aeorport a été supprimé avec succes";
			return message;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultSet getResultSet() {
		PreparedStatement pst=null;
		ResultSet rs = null;
		String sql ="select * from aeroport";
		try {
			pst=connection.prepareStatement(sql);
			rs=pst.executeQuery();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}

	@Override
	public String update(Aeroport obj) {
		
		PreparedStatement pst=null;
		String sql ="UPDATE aeroport SET code_iata = ?,nom = ?, ville = ? where id = ?";
		
		try {
			pst=connection.prepareStatement(sql);
			pst.setString(1, obj.getCodeIata());
			pst.setString(2, obj.getNom());
			pst.setString(3, obj.getVille());
			pst.setInt(4, obj.getId());
			pst.executeUpdate();
			String message =  "L'aeorport "+obj.getNom()+" a été modifié avec succes";
			return message;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	

	


}
