package Projet_JCBD.Projet_JCBD;

import java.sql.*;

import Projet_JCBD.Projet_JCBD.ConnexionUnique;

public class testConnection
{
	// Requête
	static final String req = "SELECT NUM_ET, NOM_ET, PRENOM_ET " +
	                          "FROM ETUDIANT " +
	                          "WHERE VILLE_ET = 'AIX-EN-PROVENCE'";      
	
	public static void main(String[] args) throws SQLException 
	{
		// Objet materialisant la connexion a la base de donnees
		try (Connection conn = ConnexionUnique.getInstance().getConnection())
		{
			// Creation d'une instruction SQL
			Statement stmt = conn.createStatement();
			// Execution de la requete
			System.out.println("Execution de la requete : " + req );
			ResultSet rset = stmt.executeQuery(req);
			// Affichage du resultat
			while (rset.next())
			{	
				System.out.print(rset.getInt("NUM_ET") + " ");
				System.out.print(rset.getString("NOM_ET") + " ");
				System.out.println(rset.getString("PRENOM_ET"));
			}
			// Fermeture de l'instruction (liberation des ressources)
			stmt.close();
			System.out.println("\nOk.\n");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			System.out.println("Erreur");
		}
	}
}