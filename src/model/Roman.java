package model;

public class Roman extends Livre {

	// definition d'un roman qui est une extension d'un livre
	private int prixLitteraire;
	public static final int GONCOURT = 1;
	public static final int MEDICIS = 2;

	public Roman(String titre, String auteur, int nbPages, int prixLitteraire) {
		super(titre, auteur, nbPages);
		this.prixLitteraire = prixLitteraire;
	}

	public Roman() {
		this("unknown", "unknown", 0, 0);
	}

	public int getPrixLitteraire() {
		return prixLitteraire;
	}

	public void setPrixLitteraire(int prixLitteraire) {
		this.prixLitteraire = prixLitteraire;
	}

	public String toString() {
		return super.toString() + ", Prix Litteraire : " + this.getPrixLitteraire();
	}
}
