package Projet_JCBD.Projet_JCBD;

import java.io.Serializable;

public class Notation implements Serializable
{
	private int num_Et;
	private String code;
	private float MoyCC;
	private float MoyTest;
	
	

	public Notation()
	{
		
	}
	
	@Override
	public String toString() {
		return "Notation [num_Et=" + num_Et + ", code=" + code + ", MoyCC=" + MoyCC + ", MoyTest=" + MoyTest + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(MoyCC);
		result = prime * result + Float.floatToIntBits(MoyTest);
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + num_Et;
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
		Notation other = (Notation) obj;
		if (Float.floatToIntBits(MoyCC) != Float.floatToIntBits(other.MoyCC))
			return false;
		if (Float.floatToIntBits(MoyTest) != Float.floatToIntBits(other.MoyTest))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (num_Et != other.num_Et)
			return false;
		return true;
	}

	public int getNum_Et() {return num_Et;}

	public void setNum_Et(int num_Et) {this.num_Et = num_Et;}

	public String getCode() {return code;}

	public void setCode(String code) {this.code = code;}

	public float getMoyCC() {return MoyCC;}

	public void setMoyCC(float moyCC) {MoyCC = moyCC;}

	public float getMoyTest() {return MoyTest;}

	public void setMoyTest(float moyTest) {MoyTest = moyTest;}
	
	
}
