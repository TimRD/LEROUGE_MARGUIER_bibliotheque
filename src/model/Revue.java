package model;


public class Revue extends Document {
	// definition d'une revue 
	
	private int mois;  // attribut mois de la parution de la revue pour la javadoc
	private int annee; // attribut annee de la parution de la revue pour la javadoc 

	public Revue() {
		this("unknown", 0, 0);
	}

	public Revue(String titre, int mois, int annee) {
		super(titre);
		this.mois = mois;
		this.annee = annee;
	}

	public int getMois() {
		return mois;
	}

	public void setMois(int mois) {
		this.mois = mois;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public String toString() {
		return super.toString() + ", écrit en " + this.getMois() + "/" + this.getAnnee();
	}

}
