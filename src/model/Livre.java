package model;

import java.util.Comparator;

public class Livre extends Document implements Comparable<Livre> {

	private String auteur;
	private int nbPages;

	public Livre() {
		this("unknown", "unknown", 0);
	}

	public Livre(String titre, String auteur, int nbPages) {
		super(titre);
		this.auteur = auteur;
		this.nbPages = nbPages;
	}

	public String getauteur() {
		return auteur;
	}

	public void setauteur(String auteur) {
		this.auteur = auteur;
	}

	public int getnbPages() {
		return nbPages;
	}

	public void setnbPages(int nbPages) {
		this.nbPages = nbPages;
	}

	public String toString() {
		return super.toString() + " de " + this.getauteur() + ", Nb de Pages du livre:" + this.getnbPages();
	}

	public int compareTo(Livre l) { 
		int i = 0;
		while (this.getauteur().charAt(i) == l.getauteur().charAt(i)&& i < l.getauteur().length() && i< this.getauteur().length())
			i++;
		return this.getauteur().charAt(i) - l.getauteur().charAt(i);
	}

	public static Comparator<Livre> compLivre = new Comparator<Livre>() {

		public int compare(Livre l1, Livre l2) {
			return l1.compareTo(l2);
		}
	};

}
