package implementationsDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.AbstractDao;
import interfacesDao.InterfacePosteDao;
import models.Poste;

public class PosteDaoImpl extends AbstractDao implements InterfacePosteDao{

	@Override
	public String add(Poste obj) {
		PreparedStatement pst=null;
		String sql ="INSERT INTO poste (intitule) VALUES (?)";
		
		try {
			pst=connection.prepareStatement(sql);
			pst.setInt(1, obj.getId());
			pst.executeUpdate();
			String message =  "Le poste "+obj.getIntitule()+"a été ajouté avec succes";
			return message;
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public String delete(int id) {
		PreparedStatement pst=null;
		String sql ="DELETE FROM poste WHERE id=?";
		try {
			pst=connection.prepareStatement(sql);
			pst.setInt(1,id);
			pst.executeUpdate();
			
			String message =  "La poste a été supprimé avec succes";
			return message;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Poste getOne(int id) {
		PreparedStatement pst=null;
		ResultSet rs;
		String sql ="select * from poste where id=?";
		try {
			pst=connection.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			if(rs.next()) {
				return new Poste(rs.getInt("id"),rs.getString("intitule"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public List<Poste> getAll() {
		List<Poste> list = new ArrayList<Poste>();
		PreparedStatement pst=null;
		ResultSet rs;
		String sql ="select * from poste";
		try {
			pst=connection.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()) {
				list.add(new Poste(rs.getInt("id"),rs.getString("intitule")));
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
		String sql ="select * from poste";
		try {
			pst=connection.prepareStatement(sql);
			rs=pst.executeQuery();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}

	@Override
	public String update(Poste obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
