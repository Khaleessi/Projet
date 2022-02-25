package interfacesDao;

import java.sql.ResultSet;
import java.util.List;

public interface InterfaceDAO<T> {
	public String add(T obj);
	public String delete(int id);
	public T getOne(int id);
	public List<T> getAll();
	public ResultSet getResultSet();
	public String update(T obj);
}
