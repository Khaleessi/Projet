package metier;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.github.javafaker.Faker;
import com.mysql.cj.protocol.Resultset;

import implementationsDao.AeroportDaoImpl;
import implementationsDao.AffectationDaoImpl;
import implementationsDao.CompteDaoImpl;
import implementationsDao.ContratDaoImpl;
import implementationsDao.EmployeeDaoImpl;
import implementationsDao.MD5;
import implementationsDao.PiloteDaoImpl;
import implementationsDao.PosteDaoImpl;
import implementationsDao.VolDaoImpl;
import interfacesDao.InterfaceAeroportDao;
import interfacesDao.InterfaceAffectationDao;
import interfacesDao.InterfaceCompteDao;
import interfacesDao.InterfaceContratDao;
import interfacesDao.InterfaceEmployeDao;
import interfacesDao.InterfacePiloteDao;
import interfacesDao.InterfacePosteDao;
import interfacesDao.InterfaceVolDao;
import models.Aeroport;
import models.Affectation;
import models.Compte;
import models.Employee;
import models.Vol;
import vue.*;

public class App {

	public static void main(String[] args) throws SQLException {
		InterfaceAeroportDao aeroportDao = new AeroportDaoImpl();
		InterfaceEmployeDao employeeDao = new EmployeeDaoImpl();
		InterfaceAffectationDao affectationDao = new AffectationDaoImpl();
		InterfaceVolDao volDao = new VolDaoImpl();
		InterfacePosteDao posteDao = new PosteDaoImpl();
		InterfaceContratDao contratDao = new ContratDaoImpl();
		InterfacePiloteDao piloteDao = new PiloteDaoImpl();
		InterfaceCompteDao compteDao = new CompteDaoImpl();
		Faker faker = new Faker();
		Resultset rs = (Resultset) piloteDao.getResultSet();
		MD5 md5 = new MD5();
		
		String password = md5.getMd5("El KachichiSabah");
//		System.out.println(password.toString());
//		String password2 = compteDao.getOne(4).getMdp();
//		if (password2.equals(password)){
//			System.out.println("vous etes connecté");
//		}else {
//			System.out.println("incorrect");
//		}
		
		String login ="El KachichiSabah";
		
		for(Compte compte : compteDao.getAll()) {
			if(compte.getLogin().equals(login) && compte.getMdp().equals(MD5.getMd5("El KachichiSabah"))){
			System.out.println("vous etes connecté");
		}else {
			System.out.println("login ou mdp incorrect");
		}
		}
		
		
		
		
//		
//		////////////////         EMPLOYEE  /////////////////////////
//		
//		
//		for (int i = 0; i<20 ; i++) {
//			Random r = new Random();
//
//			int i1 = r.nextInt(8); // returns random number between 0 and 7
//			int i2 = r.nextInt(8);
//			int i3 = r.nextInt(8);
//			int i4 = r.nextInt(742); // returns random number between 0 and 741
//			int i5 = r.nextInt(10000); // returns random number between 0 and 9999
//
//			String phoneNumber = "0"+String.valueOf(i1);
//			phoneNumber +=String.valueOf(i3);
//			phoneNumber +=String.valueOf(i4);
//			phoneNumber +=String.valueOf(i5);
//			
//			String firstName = faker.name().firstName(); // Emory
//			String lastName = faker.name().lastName(); // Barton
//			String email = lastName+firstName+"@gmail.com";
//			String streetAddress = faker.address().streetAddress();
//			
//			int randomNum = ThreadLocalRandom.current().nextInt(1, 4 + 1);
//			int randomNum2 = ThreadLocalRandom.current().nextInt(1, 2 + 1);
//			Employee employee = new Employee(lastName, firstName, posteDao.getOne(randomNum), contratDao.getOne(randomNum2), streetAddress, email, Integer.parseInt(phoneNumber));
//			
//			employeeDao.add(employee);
//		}
		
		
		
		
}
	
}
