package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bibliotheque implements Cloneable {

	// Liste des documents de la bibliotheque
	private List<Document> documents;

	/**
	 * Constructeur d'une bibliotheque dont la liste de documents est vide.
	 */
	public Bibliotheque() {

		this.documents = new ArrayList<Document>();
	}

	/**
	 * Renvoie la liste des documents de la bibliotheque.
	 */

	public List<Document> getDocuments() {
		return documents;
	}

	/**
	 * Renvoie le i ème document de la liste des documents, s’il existe, ou null
	 * sinon.
	 */
	public Document getDocument(int i) {
		int compteur = 1;
		for (Document d : this.documents) {
			if (compteur == i) {
				return d;
			}
			compteur++;
		}
		return null;
	}

	/**
	 * Si doc est non null et n'appartient pas déjà à la liste des documents, alors
	 * ajoute doc à cette liste et renvoie true ; sinon renvoie faux.
	 */
	public boolean addDocument(Document doc) {
		for (Document d : this.documents) {
			if (doc == d || doc == null)
				return false;
		}
		documents.add(doc);
		return true;
	}

	/**
	 * Si doc est dans la liste des documents, alors l'y supprime et renvoie true;
	 * sinon renvoie false.
	 */
	public boolean removeDocument(Document doc) {
		for (Document d : this.documents) {
			if (doc == d) {
				documents.remove(doc);
				return true;
			}
		}

		return false;

	}

	public boolean estUnEntier(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Bibliotheque de " + documents.size() + " documents";
	}

	// Fonctions utiles a l'import d'une bibliotheque, l premiere pour ecrire
	// l'autre pour lire

	public void lireFile() throws IOException {
		BufferedReader read = new BufferedReader(new FileReader("test.csv"));
		List<String> elements = new ArrayList<String>();
		String line = null;
		Scanner scan = null;
		Document d = null;
		int i = 0;

		while ((line = read.readLine()) != null) {

			scan = new Scanner(line);
			scan.useDelimiter(";");

			while (scan.hasNext()) {

				elements.add(scan.next());

				if (elements.get(i) == "") {
					elements.remove(i);// break

				}

				i++;

			}

			i = 0;
			if (elements.size() == 3) {
				if (!estUnEntier(elements.get(1))) {
					d = new Livre(elements.get(0), elements.get(1), Integer.parseInt(elements.get(2)));

				} else {
					d = new Revue(elements.get(0), Integer.parseInt(elements.get(1)),
							Integer.parseInt(elements.get(2)));
				}
			} else if (elements.size() == 4) {
				if (!estUnEntier(elements.get(3))) {
					if (elements.get(3) == "GONCOURT")
						d = new Roman(elements.get(0), elements.get(1), Integer.parseInt(elements.get(2)), 0);
					else if (elements.get(3) == "GONCOURT")
						d = new Roman(elements.get(0), elements.get(1), Integer.parseInt(elements.get(2)), 1);
					else
						d = new Roman(elements.get(0), elements.get(1), Integer.parseInt(elements.get(2)), 2);

				} else
					d = new Manuel(elements.get(0), elements.get(1), Integer.parseInt(elements.get(2)),
							Integer.parseInt(elements.get(3)));
			}

			this.addDocument(d);

			elements.clear();

		}
		read.close();

	}

	public Bibliotheque clone() throws CloneNotSupportedException {

		return (Bibliotheque) super.clone();
	}

	public void ecrireFile() throws FileNotFoundException {
		OutputStreamWriter out = null;
		out = new OutputStreamWriter(new FileOutputStream("Bibliotheque.csv"));
		PrintWriter pw = new PrintWriter(out);

		for (Document d : this.documents) {
			if (d instanceof Livre) {
				Livre l = (Livre) d;
				pw.write(l.getTitre() + ";" + l.getauteur() + ";" + l.getnbPages() + ";");
				pw.flush();
				if (d instanceof Manuel) {
					Manuel m = (Manuel) l;
					pw.write(m.getNiveau() + ";" + "\n");
					pw.flush();
				} else if (d instanceof Roman) {
					Roman r = (Roman) l;
					if (r.getPrixLitteraire() == 0) {
						pw.write("GONCOURT;" + "\n");
						pw.flush();
					} else if (r.getPrixLitteraire() == 1) {
						pw.write("MEDICIS;" + "\n");
						pw.flush();
					} else if (r.getPrixLitteraire() == 2) {
						pw.write("INTERALLIE;" + "\n");
						pw.flush();
					}

				} else {
					pw.write("\n");
					pw.flush();
				}
			} else if (d instanceof Revue) {
				Revue r = (Revue) d;
				pw.write(r.getTitre() + ";" + r.getAnnee() + ";" + r.getMois() + ";" + "\n");
				pw.flush();
			}

		}

		pw.close();
	}

}
