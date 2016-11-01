package Projet_JCBD.Projet_JCBD;

import java.sql.*;
import java.util.ArrayList;

import Projet_JCBD.Projet_JCBD.ConnexionUnique;
import Projet_JCBD.Projet_JCBD.Etudiant;

public class testEntite
{
	// Requête
	static final String req = "SELECT NUM_ET, ANNEE, GROUPE, NOM_ET, PRENOM_ET, PRENOM_ET, VILLE_ET, CP_ET " +
	                          "FROM ETUDIANT ";      
	
	public static void main(String[] args) throws SQLException 
	{
		ArrayList<Etudiant> etu = new ArrayList<Etudiant>();
		int i = 0;
		// Objet materialisant la connexion a la base de donnees
		try (Connection conn = ConnexionUnique.getInstance().getConnection())
		{
			// Creation d'une instruction SQL
			Statement stmt = conn.createStatement();
			// Execution de la requete
			System.out.println("Execution de la requete : " + req );
			ResultSet rset = stmt.executeQuery(req);
			// Affichage du resultat
			i = 0;
			while (rset.next())
			{	
				etu.add(new Etudiant());
				etu.get(i).setNumEt(rset.getInt("NUM_ET"));
				etu.get(i).setAnnee(rset.getInt("ANNEE"));
				etu.get(i).setGroupe(rset.getInt("GROUPE"));
				etu.get(i).setNomEt(rset.getString("NOM_ET"));
				etu.get(i).setPrenomEt(rset.getString("PRENOM_ET"));
				etu.get(i).setVilleEt(rset.getString("VILLE_ET"));
				etu.get(i).setCpEt(rset.getString("CP_ET"));
				System.out.println(etu.get(i).toString());
				i++;
			}
			
			// Fermeture de l'instruction (liberation des ressources)
			stmt.close();
		} catch (SQLException exc)
		{
			exc.printStackTrace();
			System.out.println("Erreur");
		}
	}
}