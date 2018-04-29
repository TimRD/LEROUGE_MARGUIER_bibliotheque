package controller;

import model.Bibliotheque;
import model.Document;
import model.Livre;
import model.Manuel;
import model.Revue;
import model.Roman;
import view.Affichage;
import view.fenetrage;

import java.util.Collection;

public class TestDocuments {

	/**
	 * Programme de test.
	 */
	public static void main(String[] args) {

		Bibliotheque B = new Bibliotheque(); // Creation d'un nouvel objet bibliotheque

		Affichage a = new Affichage();

		B.getDocuments().sort(Document.compDoc); // Tri des docments de la bibliotheque

		for (Document d : B.getDocuments()) { 
			System.out.println(d);
		}

		fenetrage f = new fenetrage();  //Affichage Swing

	}

}
