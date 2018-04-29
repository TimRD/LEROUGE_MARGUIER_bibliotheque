package model;

import java.util.Comparator;

public abstract class Document {

	private int numEnreg;
	private String titre;
	private static int count = 0;

	public Document(String titre) {
		this.titre = titre;
		setNumEnreg(++count);
	}

	public int getNumEnreg() {
		return numEnreg;
	}

	public void setNumEnreg(int numEnreg) {
		this.numEnreg = numEnreg;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String toString() {
		return "Matricule : " + this.getNumEnreg() + ", Titre : " + this.getTitre();
	}

	public int compareTo(Document l) { // Pour comparer deux documents, on compare caractère par caractère
		int i = 0;
		while (this.getTitre().charAt(i) == l.getTitre().charAt(i) )
			i++;
		return this.getTitre().charAt(i) - l.getTitre().charAt(i);
	}

	public static Comparator<Document> compDoc = new Comparator<Document>() {
		public int compare(Document l1, Document l2) {
			return l1.compareTo(l2);
		}
	};
}
