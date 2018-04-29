package model;

public class Manuel extends Livre {

	private int niveau;
	// definition du manuel 

	public Manuel(String titre, String auteur, int nbPages, int niveau) {
		super(titre, auteur, nbPages);
		this.niveau = niveau;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public String toString() {
		return super.toString() + " Niveau :" + this.getNiveau();
	}

}
