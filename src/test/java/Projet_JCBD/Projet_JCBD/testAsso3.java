package Projet_JCBD.Projet_JCBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import Projet_JCBD.Projet_JCBD.ConnexionUnique;
import Projet_JCBD.Projet_JCBD.Enseignement;
import Projet_JCBD.Projet_JCBD.Etudiant;
import Projet_JCBD.Projet_JCBD.Module;
import Projet_JCBD.Projet_JCBD.Prof;

public class testAsso3
{
	
	static final String req = "SELECT * " +
			"FROM ETUDIANT, MODULE, PROF ";
	
	// Requête
	static final String req2 = "SELECT * " +
						"FROM ENSEIGNT ";
	   
		
	public static void main(String[] args) throws SQLException 
	{
		ArrayList<Etudiant> etu = new ArrayList<Etudiant>();
		ArrayList<Module> mod = new ArrayList<Module>();
		ArrayList<Prof> prof = new ArrayList<Prof>();
		
		ArrayList<Enseignement> ens = new ArrayList<Enseignement>();
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
				
				mod.add(new Module());
				mod.get(i).setCode(rset.getString("CODE"));
				mod.get(i).setLibelle(rset.getString("LIBELLE"));
				mod.get(i).sethCoursPrev(rset.getInt("H_COURS_PREV"));
				mod.get(i).sethCoursRea(rset.getInt("H_COURS_REA"));
				mod.get(i).sethTpPrev(rset.getInt("H_TP_PREV"));
				mod.get(i).sethTpRea(rset.getInt("H_TP_REA"));
				mod.get(i).setDiscipline(rset.getString("DISCIPLINE"));
				mod.get(i).setCoefTest(rset.getInt("COEFF_TEST"));
				mod.get(i).setCoefCC(rset.getInt("COEFF_CC"));
				
				prof.add(new Prof());
				prof.get(i).setNumProf(rset.getInt("NUM_PROF"));
				prof.get(i).setNomProf(rset.getString("NOM_PROF"));
				prof.get(i).setPrenomProf(rset.getString("PRENOM_PROF"));
				prof.get(i).setAdrProf(rset.getString("ADR_PROF"));
				prof.get(i).setVilleProf(rset.getString("VILLE_PROF"));
				prof.get(i).setCpProf(rset.getString("CP_PROF"));

				i++;
			}
			// Fermeture de l'instruction (liberation des ressources)
			stmt.close();
			Statement stmt2 = conn.createStatement();
			System.out.println("Execution de la requete : " + req2 );
			ResultSet rset2 = stmt2.executeQuery(req2);
			i = 0;
			while (rset2.next())
			{	
				ens.add(new Enseignement());
				for(int j = 0; j < mod.size(); j++ )
				{
					if(mod.get(j).getCode().equals(rset2.getString("CODE")))
					{
						ens.get(i).setModule(mod.get(j));
					}
				}
					
				
				for(int j = 0; j < etu.size(); j++ )
				{
					if(etu.get(j).getNumEt() == rset2.getInt("NUM_ET"))
					{
						ens.get(i).setEtudiant(etu.get(j));
					}
				}
				
				for(int j = 0; j < prof.size(); j++ )
				{
					if(prof.get(j).getNumProf() == rset2.getInt("NUM_PROF"))
					{
						ens.get(i).setProf(prof.get(j));
					}
				}
				

				
				i++;
			}
			stmt2.close();
			
			for(int j = 0; j < ens.size(); j++)
			{
				if(ens.get(j).getEtudiant().getGroupe() == 1)
					System.out.println(ens.get(j));
			}
			
		} catch (SQLException exc)
		{
			exc.printStackTrace();
			System.out.println("Erreur");
		}	
	}
}