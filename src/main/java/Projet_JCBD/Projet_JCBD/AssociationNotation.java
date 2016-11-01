package Projet_JCBD.Projet_JCBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AssociationNotation
{

	private Set<Lien> Liens = new HashSet<Lien>();
	private static AssociationNotation instance;
	
	public AssociationNotation()
	{
		
	}

	
	public void creerLien(Module module, Etudiant etudiant, Notation note)
	{
		Lien lien = new Lien(module, etudiant);
		lien.setNotation(note);
		Liens.add(lien);
	}
	
	public void supprimerLien(Module module, Etudiant etudiant)
	{
		Iterator<Lien> i = Liens.iterator();
		while(i.hasNext())
		{
			if (i.next().getModule() == module && i.next().getEtudiant() == etudiant)
				i.remove();
		}
	}
	
	public void supprimerLien(Lien lien)
	{
		Iterator<Lien> i = Liens.iterator();
		while(i.hasNext())
		{
			if (lien.equals(i.next()))
				i.remove();
		}
	}
	
	public Lien getLien(Module module, Etudiant etudiant)
	{
		Iterator<Lien> i = Liens.iterator();
		while(i.hasNext())
		{
			if(i.next().getModule() == module && i.next().getEtudiant() == etudiant)
				return i.next();
		}
		return null;
		
	}
	
	public Set<Lien> getLiens(Etudiant etudiant)
	{
		Set<Lien> SLien = new HashSet<Lien>();
		Iterator<Lien> i = Liens.iterator();
		while(i.hasNext())
		{
			if(i.next().getEtudiant() == etudiant)
				SLien.add(i.next());
		}
		return SLien;
		
	}
	
	public Set<Lien> getLiens()
	{
		
		return Liens;
		
	}
	
	public Set<Lien> getLiens(Module module)
	{
		Set<Lien> SLien = new HashSet<Lien>();
		Iterator<Lien> i = Liens.iterator();
		while(i.hasNext())
		{
			if(i.next().getModule() == module)
				SLien.add(i.next());
		}
		return SLien;
	}
	
	public Set<Module> getModules(Etudiant etudiant)
	{
		Set<Module> SLien = new HashSet<Module>();
		Iterator<Lien> i = Liens.iterator();
		while(i.hasNext())
		{
			if(i.next().getEtudiant() == etudiant)
				SLien.add(i.next().getModule());
		}
		return SLien;
	}
	
	public Set<Etudiant> getEtudiants(Module module)
	{
		Set<Etudiant> SLien = new HashSet<Etudiant>();
		Iterator<Lien> i = Liens.iterator();
		while(i.hasNext())
		{
			if(i.next().getModule() == module)
				SLien.add(i.next().getEtudiant());
		}
		return SLien;
	}
	
	public static AssociationNotation getInstance()
	{
		if(instance == null)
			instance = new AssociationNotation();
		return instance;
	}
}
