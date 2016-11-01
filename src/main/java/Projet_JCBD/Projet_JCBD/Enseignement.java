package Projet_JCBD.Projet_JCBD;

import java.util.Set;

public class Enseignement
{
	private Module module;
	private Etudiant etudiant;
	private Prof prof;
	
	
	@Override
	public String toString() {
		return "Enseignement [module=" + module + ", etudiant=" + etudiant + ", prof=" + prof + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((etudiant == null) ? 0 : etudiant.hashCode());
		result = prime * result + ((module == null) ? 0 : module.hashCode());
		result = prime * result + ((prof == null) ? 0 : prof.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enseignement other = (Enseignement) obj;
		if (etudiant == null) {
			if (other.etudiant != null)
				return false;
		} else if (!etudiant.equals(other.etudiant))
			return false;
		if (module == null) {
			if (other.module != null)
				return false;
		} else if (!module.equals(other.module))
			return false;
		if (prof == null) {
			if (other.prof != null)
				return false;
		} else if (!prof.equals(other.prof))
			return false;
		return true;
	}
	public Module getModule()
	{
		return module;
	}
	public void setModule(Module module)
	{
		this.module = module;
	}
	public Etudiant getEtudiant()
	{
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant)
	{
		this.etudiant = etudiant;
	}
	public Prof getProf()
	{
		return prof;
	}
	public void setProf(Prof prof)
	{
		this.prof = prof;
	}
	
	

}
