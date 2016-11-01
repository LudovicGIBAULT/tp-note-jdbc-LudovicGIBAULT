package Projet_JCBD.Projet_JCBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import Projet_JCBD.Projet_JCBD.AssociationNotation;
import Projet_JCBD.Projet_JCBD.ConnexionUnique;
import Projet_JCBD.Projet_JCBD.Etudiant;
import Projet_JCBD.Projet_JCBD.Module;
import Projet_JCBD.Projet_JCBD.Notation;

public class testAsso2
{
	
	static final String req = "SELECT * " +
			"FROM ETUDIANT, MODULE ";
	
	// Requête
	static final String req2 = "SELECT ETUDIANT.NUM_ET, CODE, PRENOM_ET, NOM_ET, MOY_CC, MOY_TEST " +
						"FROM ETUDIANT, NOTATION " + "WHERE ETUDIANT.NUM_ET = NOTATION.NUM_ET AND CODE = 'ACSI' ";
	   
		
	public static void main(String[] args) throws SQLException 
	{
		ArrayList<Etudiant> etu = new ArrayList<Etudiant>();
		ArrayList<Module> mod = new ArrayList<Module>();
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
				i++;
			}
			// Fermeture de l'instruction (liberation des ressources)
			stmt.close();
			Statement stmt2 = conn.createStatement();
			System.out.println("Execution de la requete : " + req2 );
			ResultSet rset2 = stmt2.executeQuery(req2);
			AssociationNotation AN = new AssociationNotation();
			while (rset2.next())
			{	
				
				Module m = new Module();
				for(int j = 0; j < mod.size(); j++)
				{
					if(mod.get(j).getCode().equals(rset2.getString("CODE")))
					{
						m = mod.get(j);
					}
				}
				
				Etudiant e = new Etudiant();
				e.setNumEt(rset2.getInt("NUM_ET"));
				e.setNomEt(rset2.getString("NOM_ET"));
				e.setPrenomEt(rset2.getString("PRENOM_ET"));
				
				
				Notation n = new Notation();
				n.setCode(m.getCode());
				n.setNum_Et(e.getNumEt());
				n.setMoyCC(rset2.getFloat("MOY_CC"));
				n.setMoyTest(rset2.getFloat("MOY_TEST"));
				
				System.out.println(n);
				
				AN.creerLien(m, e, n);
			}
			stmt2.close();
			
				System.out.println(AN.getLiens());
			
			
		} catch (SQLException exc)
		{
			exc.printStackTrace();
			System.out.println("Erreur");
		}	
	}
}