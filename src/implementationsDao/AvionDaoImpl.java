package implementationsDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.AbstractDao;
import interfacesDao.InterfaceAeroportDao;
import interfacesDao.InterfaceAvionDao;
import interfacesDao.InterfaceConstructeurDao;
import interfacesDao.InterfaceModelDao;
import models.Avion;

public class AvionDaoImpl extends AbstractDao implements InterfaceAvionDao{
	
	InterfaceModelDao modelDao = new ModelDaoImpl();
	InterfaceConstructeurDao constructeurDao = new ConstructeurDaoImpl();
	InterfaceAeroportDao aeroportDao = new AeroportDaoImpl();
	@Override
	public String add(Avion obj) {
		PreparedStatement pst=null;
		String sql ="INSERT INTO avion (model,base) VALUES (?,?)";
		try {
			pst=connection.prepareStatement(sql);
			pst.setInt(1, obj.getModel().getId());
			pst.setInt(2, obj.getAeroportBase().getId());
			pst.executeUpdate();
			String message =  "L'Avion "+obj.getModel()+" a été ajouté avec succes";
			return message;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
		
	}

	@Override
	public String delete(int id) {
		PreparedStatement pst=null;
		String sql ="DELETE FROM avion WHERE id=?";
		try {
			pst=connection.prepareStatement(sql);
			pst.setInt(1,id);
			pst.executeUpdate();
			String message =  "L'avion a été supprimé avec succes";
			return message;
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public Avion getOne(int id) {
		PreparedStatement pst=null;
		ResultSet rs;
		String sql ="select * from avion where id=?";
		try {
			pst=connection.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			if(rs.next()) {
				return new Avion(rs.getInt("id"),modelDao.getOne(rs.getInt("model")),aeroportDao.getOne(rs.getInt("base")));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public List<Avion> getAll() {
		List<Avion> list = new ArrayList<Avion>();
		PreparedStatement pst=null;
		ResultSet rs;
		String sql ="select * from avion";
		try {
			pst=connection.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()) {
				list.add(new Avion(rs.getInt("id"),modelDao.getOne(rs.getInt("model")),aeroportDao.getOne(rs.getInt("base"))));
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
		String sql ="select * from avion";
		try {
			pst=connection.prepareStatement(sql);
			rs=pst.executeQuery();
		
		} catch (Exception e) {
			System.out.println(e);
		}
		return rs;
	}

	@Override
	public String update(Avion obj) {
		PreparedStatement pst=null;
		String sql ="update avion set model=?,base=?) where id = ?";
		try {
			pst=connection.prepareStatement(sql);
			pst.setInt(1, obj.getModel().getId());
			pst.setInt(2, obj.getAeroportBase().getId());
			pst.setInt(3, obj.getId());
			pst.executeUpdate();
			String message =  "L'Avion "+obj.getModel()+" a été ajouté avec succes";
			return message;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
