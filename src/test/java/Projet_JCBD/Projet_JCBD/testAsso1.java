package Projet_JCBD.Projet_JCBD;

import java.sql.*;
import java.util.ArrayList;

import Projet_JCBD.Projet_JCBD.ConnexionUnique;
import Projet_JCBD.Projet_JCBD.Module;
import Projet_JCBD.Projet_JCBD.Prof;

public class testAsso1
{
	// Requête
	static final String req = "SELECT * " +
						"FROM PROF, MODULE " + "WHERE MAT_SPEC = CODE";
	
	   
		
	public static void main(String[] args) throws SQLException 
	{
		ArrayList<Prof> prof = new ArrayList<Prof>();
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
				prof.add(new Prof());
				prof.get(i).setNumProf(rset.getInt("NUM_PROF"));
				prof.get(i).setNomProf(rset.getString("NOM_PROF"));
				prof.get(i).setPrenomProf(rset.getString("PRENOM_PROF"));
				prof.get(i).setAdrProf(rset.getString("ADR_PROF"));
				prof.get(i).setVilleProf(rset.getString("VILLE_PROF"));
				prof.get(i).setCpProf(rset.getString("CP_PROF"));
				
				//Module sp�cialit�
				Module mod = new Module();
				mod.setCode(rset.getString("MAT_SPEC"));
				mod.setLibelle(rset.getString("LIBELLE"));
				mod.sethCoursPrev(rset.getInt("H_COURS_PREV"));
				mod.sethCoursRea(rset.getInt("H_COURS_REA"));
				mod.sethTpPrev(rset.getInt("H_TP_PREV"));
				mod.sethTpRea(rset.getInt("H_TP_REA"));
				mod.setDiscipline(rset.getString("DISCIPLINE"));
				mod.setCoefTest(rset.getInt("COEFF_TEST"));
				mod.setCoefCC(rset.getInt("COEFF_CC"));
				
				//Module p�re du module sp�cialit�
				Module mod2 = new Module();
				mod2.setCode(rset.getString("CODEPERE"));
				mod2.setLibelle(rset.getString("LIBELLE"));
				mod2.sethCoursPrev(rset.getInt("H_COURS_PREV"));
				mod2.sethCoursRea(rset.getInt("H_COURS_REA"));
				mod2.sethTpPrev(rset.getInt("H_TP_PREV"));
				mod2.sethTpRea(rset.getInt("H_TP_REA"));
				mod2.setDiscipline(rset.getString("DISCIPLINE"));
				mod2.setCoefTest(rset.getInt("COEFF_TEST"));
				mod2.setCoefCC(rset.getInt("COEFF_CC"));
				mod.setPere(mod2); 
				
				//Prof Responsable du module sp�cialit�
				Prof pr = new Prof();
				pr.setNumProf(rset.getInt("RESP"));
				pr.setNomProf(rset.getString("NOM_PROF"));
				pr.setPrenomProf(rset.getString("PRENOM_PROF"));
				pr.setAdrProf(rset.getString("ADR_PROF"));
				pr.setVilleProf(rset.getString("VILLE_PROF"));
				pr.setCpProf(rset.getString("CP_PROF"));
				mod.setResponsable(pr); 
				
				
				prof.get(i).setSpecialite(mod);
				System.out.println(prof.get(i).toString());
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