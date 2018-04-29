package view;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import model.Document;
import model.Livre;
import model.Manuel;
import model.Roman;

/**
 * Utilitaires d'affichage
 */

public class Affichage {
	public Affichage() {

	}

	public String afficherDocuments(Collection<Document> docs) {
		String message = "";
		for (Document d : docs)
			if (d instanceof Livre && d instanceof Manuel == false) {
				{
					message += d.toString();
					message += "\n";
				}

			}
		return message;
	}

	public String afficherAuteurs(Collection<Document> docs) { 
		String message2 = "";
		List<Livre> livres = new ArrayList<Livre>();
		for (Document d : docs) {
			if (d instanceof Livre && d instanceof Manuel == false) {
				livres.add((Livre) d);
			}
		}
		livres.sort(Livre.compLivre);
		for (Livre l : livres) {
			message2 += l.getauteur();
			message2 += "\n";
		}

		return message2;
	}

	public void SuppressionTitre(Collection<Document> docs, String Titre) {
		List<Document> documents = new ArrayList<Document>();
		for (Document d : docs) {

			if (Titre == d.getTitre()) {
				documents.add(d);

			}
		}
		for (Document d1 : documents) {
			docs.remove(d1);
		}
	}

	public void SuppressionPrix(Collection<Document> docs, String Prix) {
		List<Roman> documents = new ArrayList<Roman>();
		int p = 0;
		if (Prix == "GONCOURT")
			p = 1;
		if (Prix == "MEDICIS")
			p = 2;

		for (Document d : docs) {
			if (d instanceof Roman) {
				Roman r = (Roman) d;
				if (p == r.getPrixLitteraire())
					documents.add(r);
			}

		}
		for (Roman r : documents) {
			docs.remove(r);
		}
	}
}
