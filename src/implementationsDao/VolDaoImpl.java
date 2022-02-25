package implementationsDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.AbstractDao;
import interfacesDao.InterfaceAeroportDao;
import interfacesDao.InterfaceVolDao;
import models.Vol;

public class VolDaoImpl extends AbstractDao implements InterfaceVolDao{
	InterfaceAeroportDao aeroportDao = new AeroportDaoImpl();
	@Override
	public String add(Vol obj) {
		PreparedStatement pst=null;
		String sql ="INSERT INTO vol (numero,date,heure_depart,heure_arrive,aeroport_depart,aeroport_arrive) VALUES (?,?,?,?,?,?)";
		try {
			pst=connection.prepareStatement(sql);
			pst.setString(1, obj.getNumero());
			pst.setDate(2, obj.getDate());
			pst.setTime(3, obj.getHeureDepart());
			pst.setTime(4, obj.getHeureArrive());
			pst.setInt(5, obj.getAeroportDepart().getId());
			pst.setInt(6, obj.getAeroportArrive().getId());
			pst.executeUpdate();
			String message =  "Le vol de  "+obj.getAeroportDepart().getVille()+" a destination de "+obj.getAeroportArrive().getVille() +" a été ajouté avec succes";
			return message;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public String delete(int id) {
		PreparedStatement pst=null;
		String sql ="DELETE FROM vol WHERE id=?";
		try {
			pst=connection.prepareStatement(sql);
			pst.setInt(1,id);
			pst.executeUpdate();
			String message =  "Le vol a été supprimé avec succes";
			return message;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Vol getOne(int id) {
		PreparedStatement pst=null;
		ResultSet rs;
		String sql ="select * from vol where id=?";
		try {
			pst=connection.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			if(rs.next()) {
				return new Vol(rs.getInt("id"),rs.getString("numero"),rs.getDate("date"), rs.getTime("heure_depart"),rs.getTime("heure_arrive"),aeroportDao.getOne(rs.getInt("aeroport_depart")),aeroportDao.getOne(rs.getInt("aeroport_arrive")));
			}
		} catch (Exception e) {
		}
		return null;
	}
	public List<Vol> getAll() {
		List<Vol> list = new ArrayList<Vol>();
		PreparedStatement pst=null;
		ResultSet rs;
		String sql ="select * from vol";
		
		try {
			pst=connection.prepareStatement(sql);
			rs=pst.executeQuery();
	
			while(rs.next()) {
				list.add(new Vol(rs.getInt("id"),rs.getString("numero"),rs.getDate("date"), rs.getTime("heure_depart"),rs.getTime("heure_arrive"),aeroportDao.getOne(rs.getInt("aeroport_depart")),aeroportDao.getOne(rs.getInt("aeroport_arrive"))));
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
		String sql ="select * from vol";
		
		try {
			pst=connection.prepareStatement(sql);
			rs=pst.executeQuery();
	
		} catch (Exception e) {
			// TODO: handle exception
		}

		return rs;
	}

	@Override
	public String update(Vol obj) {
		PreparedStatement pst=null;
		String sql ="update vol set  numero= ?,date=?,heure_depart=?,heure_arrive=?,aeroport_depart=?,aeroport_arrive=?) where id = ?";
		try {
			pst=connection.prepareStatement(sql);
			pst.setString(1, obj.getNumero());
			pst.setDate(2, obj.getDate());
			pst.setTime(3, obj.getHeureDepart());
			pst.setTime(4, obj.getHeureArrive());
			pst.setInt(5, obj.getAeroportDepart().getId());
			pst.setInt(6, obj.getAeroportArrive().getId());
			pst.setInt(7, obj.getId());
			pst.executeUpdate();
			String message =  "Le vol de  "+obj.getAeroportDepart().getVille()+" a destination de "+obj.getAeroportArrive().getVille() +" a été ajouté avec succes";
			return message;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	

}
