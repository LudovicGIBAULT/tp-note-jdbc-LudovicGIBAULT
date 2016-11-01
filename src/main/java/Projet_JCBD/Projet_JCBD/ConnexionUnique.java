package Projet_JCBD.Projet_JCBD;

import java.sql.*;

public class ConnexionUnique
{
	private Connection connection;
	static private ConnexionUnique instance;
	
	static final String CONNECT_URL = "jdbc:mysql://mysql-ludovic-gibault.alwaysdata.net:3306/ludovic-gibault_mysql";
	static final String LOGIN = "128884";
	static final String PASSWORD = "WWlbtfj4";
	
	private ConnexionUnique()
	{
		try 
		{
			System.out.println("Connexion a " + CONNECT_URL);
			connection =  DriverManager.getConnection(CONNECT_URL, LOGIN, PASSWORD);
			System.out.println("Connecte\n");
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public Connection getConnection()
	{
		return connection;
	}
	
	public static ConnexionUnique getInstance()
	{
		if(instance == null)
			instance = new ConnexionUnique();
		return instance;
	}
}
