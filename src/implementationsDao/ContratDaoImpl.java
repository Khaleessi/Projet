package implementationsDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.AbstractDao;
import interfacesDao.InterfaceContratDao;
import models.Contrat;
public class ContratDaoImpl extends AbstractDao implements InterfaceContratDao{

	@Override
	public String add(Contrat obj) {
		PreparedStatement pst=null;
		String sql ="INSERT INTO contrat (nom) VALUES (?)";
		
		try {
			pst=connection.prepareStatement(sql);
			pst.setInt(1, obj.getId());
			pst.executeUpdate();
			String message =  "Le contrat "+obj.getNom()+"a été ajouté avec succes";
			return message;
		} catch (Exception e) {
			
		}
		return null;
		
	}

	@Override
	public String delete(int id) {
		PreparedStatement pst=null;
		String sql ="DELETE FROM contrat WHERE id=?";
		try {
			pst=connection.prepareStatement(sql);
			pst.setInt(1,id);
			pst.executeUpdate();
			
			String message =  "La contrat a été supprimé avec succes";
			return message;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public Contrat getOne(int id) {
		PreparedStatement pst=null;
		ResultSet rs;
		String sql ="select * from contrat where id=?";
		try {
			pst=connection.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			if(rs.next()) {
				return new Contrat(rs.getInt("id"),rs.getString("nom"));
			}
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public List<Contrat> getAll() {
		
		List<Contrat> list = new ArrayList<Contrat>();
		PreparedStatement pst=null;
		ResultSet rs;
		String sql ="select * from contrat";
		try {
			pst=connection.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()) {
				list.add(new Contrat(rs.getInt("id"),rs.getString("nom")));
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
		String sql ="select * from contrat";
		try {
			pst=connection.prepareStatement(sql);
			rs=pst.executeQuery();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}

	@Override
	public String update(Contrat obj) {
		PreparedStatement pst=null;
		String sql ="update contrat set nom = ?  where id=?";
		
		try {
			pst=connection.prepareStatement(sql);
			pst.setString(1,obj.getNom());
			pst.setInt(2, obj.getId());
			pst.executeUpdate();
			String message =  "Le contrat "+obj.getNom()+"a été ajouté avec succes";
			return message;
		} catch (Exception e) {
			
		}
		return null;
	}

}
