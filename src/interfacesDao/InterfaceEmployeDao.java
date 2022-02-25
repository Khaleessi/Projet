package interfacesDao;

import java.util.List;

import models.Employee;

public interface InterfaceEmployeDao extends InterfaceDAO<Employee>{
public List<Employee> getAll();

}
