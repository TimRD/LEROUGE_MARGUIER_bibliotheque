package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Bibliotheque;
import model.Document;
import model.Livre;
import model.Manuel;
import model.Revue;
import model.Roman;

public class fenetrage extends JFrame implements ActionListener { // Declaration des differents panel
	Bibliotheque B = new Bibliotheque();
	JPanel panel = new JPanel();
	JPanel h = new JPanel();
	JPanel s = new JPanel();
	JPanel st = new JPanel();
	JPanel sp = new JPanel();

	JButton voir = new JButton("Voir la liste"); // Declaration de tous les boutin s de la fenetre Swing
	JButton ajouter = new JButton("Ajouter un ouvrage");
	JButton supprimer = new JButton("Supprimer un ouvrage");
	JButton retour = new JButton("retour");
	JButton retour2 = new JButton("retour");
	JButton retour3 = new JButton("retour");
	JButton retour4 = new JButton("retour");
	JButton retour5 = new JButton("retour");
	JButton valider = new JButton("Valider");
	JButton delete = new JButton("Supprimer");
	JButton delete1 = new JButton("Supprimer");
	JButton suppTitre = new JButton("Supprimer Titre");
	JButton suppPrix = new JButton("Supprimer Prix");
	JButton importer = new JButton("Importer Bibliotheque");
	JButton sauvegarder = new JButton("Sauvegarder la Bibliothèque");
	JPanel r = new JPanel();

	JRadioButton jr1 = new JRadioButton("AUCUN");
	JRadioButton jr2 = new JRadioButton("GONCOURT");
	JRadioButton jr3 = new JRadioButton("MEDICIS");
	JRadioButton jr4 = new JRadioButton("ITERALLIE");

	JTextField jtf1 = new JTextField("");
	JTextField jtf2 = new JTextField("");
	JTextField jtf3 = new JTextField("");

	JLabel label1 = new JLabel("Titre");
	JLabel label2 = new JLabel("Auteur");
	JLabel label3 = new JLabel("Nombre de Pages");
	JLabel label4 = new JLabel("Prix Litteraire");

	JTextArea v = null;

	public fenetrage() {
		Document[] documents = { new Livre("L'Archipel Du Goulag", "Soljenitsyne", 250),
				new Roman("Rouge Brésil", "Rufin", 120, Roman.GONCOURT), 
				new Revue("Le point", 03, 2014),
				new Livre("La condition humaine", "Malraux", 130),
				new Roman("Le mendiant", "Wiesel", 150, Roman.MEDICIS),
				new Manuel("Manuel qualité ISO 9001", "AFNOR", -1, 3) };

		for (Document doc : documents) {
			B.addDocument(doc);
		}

		this.setTitle("Afficheur Bibliotheque"); // Titre de la fenetre
		this.setSize(400, 600); // Taille de la fenetre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fermer l'application lorsque un clic sur la croix rouge
																// est opéré
		Build();
		this.setVisible(true);
	}

	public void Build() { // panel de base, avec les fonctionnalités possibles
		voir.addActionListener(this);
		ajouter.addActionListener(this);
		supprimer.addActionListener(this);
		importer.addActionListener(this);
		sauvegarder.addActionListener(this);

		panel.add(voir);
		panel.add(ajouter);
		panel.add(supprimer);
		panel.add(importer);
		panel.add(sauvegarder);

		this.add(panel);
	}

	public void afficher() {
		h.removeAll();

		Affichage a = new Affichage();
		String message = a.afficherDocuments(B.getDocuments()); // affichage de la liste des livres de la biliotheque
		String message2 = a.afficherAuteurs(B.getDocuments());
		v = new JTextArea("Livres :" + "\n\n" + message + "\nAuteurs : " + "\n\n" + message2);
		retour.addActionListener(this);
		h.add(retour);
		h.add(v);
		h.updateUI();
		this.add(h);
	}

	public void ajouter() {
		retour2.addActionListener(this);
		valider.addActionListener(this);
		r.setLayout(null);
		label1.setBounds(0, 0, 100, 50);
		r.add(label1);
		jtf1.setBounds(100, 0, 200, 50);
		r.add(jtf1);

		label2.setBounds(0, 100, 100, 50); // Positionnement de tous les boutons 
		r.add(label2);
		jtf2.setBounds(100, 100, 200, 50);
		r.add(jtf2);

		label3.setBounds(0, 200, 100, 50);
		r.add(label3);
		jtf3.setBounds(100, 200, 200, 50);
		r.add(jtf3);

		label4.setBounds(0, 300, 100, 50);
		r.add(label4);
		jr1.setBounds(100, 300, 100, 50);
		r.add(jr1);
		jr2.setBounds(200, 300, 100, 50);
		r.add(jr2);
		jr3.setBounds(300, 300, 100, 50);
		r.add(jr3);
		jr4.setBounds(400, 300, 100, 50);
		r.add(jr4);

		valider.setBounds(0, 400, 100, 50);
		r.add(valider);

		retour2.setBounds(0, 500, 100, 50);
		r.add(retour2);

		this.add(r);

	}

	public void supprimer() {
		retour3.addActionListener(this);
		suppPrix.addActionListener(this);
		suppTitre.addActionListener(this);

		s.add(suppPrix);
		s.add(suppTitre);
		s.add(retour3);

		this.add(s);

	}

	public void supprimerTitre() {
		retour5.addActionListener(this);
		delete.addActionListener(this);

		st.setLayout(null);
		label1.setBounds(0, 0, 200, 50); //
		st.add(label1);

		jtf1.setBounds(100, 0, 200, 50);
		st.add(jtf1);

		delete.setBounds(200, 100, 200, 50);
		st.add(delete);

		retour5.setBounds(300, 200, 200, 50);
		st.add(retour5);

		this.add(st);

	}

	public void supprimerPrix() {
		retour4.addActionListener(this);
		delete1.addActionListener(this);

		label4.setBounds(0, 0, 200, 50);
		sp.add(label4);

		jr1.setBounds(100, 100, 200, 50);
		sp.add(jr1);
		jr2.setBounds(200, 200, 200, 50);
		sp.add(jr2);
		jr3.setBounds(300, 0, 200, 50);
		sp.add(jr3);
		jr4.setBounds(400, 0, 200, 50);
		sp.add(jr4);
		delete1.setBounds(500, 0, 200, 50);
		sp.add(delete1);
		retour4.setBounds(600, 0, 200, 50);
		sp.add(retour4);
		this.add(sp);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == voir) {
			this.remove(panel);
			this.afficher();

			this.validate();
			this.repaint();
		}

		if (e.getSource() == importer) { // On definit tous les cas possible lorsque l'utilisateur clique sur un bouton avec les exceptions éventuelles
			try {
				B.lireFile();
			} catch (IOException e2) {
				System.out.println("Fichier illisible");
			} // importe la bibliotheque
		}

		if (e.getSource() == sauvegarder) {
			{
				try {
					B.ecrireFile();
				} catch (IOException e1) {
					System.out.println("Fichier illisible");
				} // sauvegarde la bibliotheque
			}
		}

		if (e.getSource() == valider) {

			String titre = "";
			String auteur = "";
			int nbPages = 0;
			int PrixLitteraire = 0;

			if (!jtf1.getText().isEmpty()) {
				titre = jtf1.getText();
			} else
				System.out.println("Vous n'avez pas saisi de titre");

			if (!jtf2.getText().isEmpty()) {
				auteur = jtf2.getText();
			} else
				System.out.println("Vous n'avez pas saisi d'auteur");

			if (!jtf3.getText().isEmpty()) {
				try {
					nbPages = Integer.parseInt(jtf3.getText());
				} catch (NumberFormatException exc) {
					System.out.println("pas un nombre");
				}

			} else
				System.out.println("Vous n'avez pas saisi le nombre de pages");

			if (jr1.isSelected() || jr2.isSelected() || jr3.isSelected() || jr4.isSelected()) {

				if (jr2.isSelected()) {
					PrixLitteraire = 1;
				}
				if (jr3.isSelected()) {
					PrixLitteraire = 2;

				}
				if (jr4.isSelected()) {
					PrixLitteraire = 3;
				}

			} else
				PrixLitteraire = -1;
			;

			if (jr1.isSelected()) {
				if (!jtf1.getText().isEmpty() && !jtf2.getText().isEmpty() && !jtf3.getText().isEmpty()
						&& PrixLitteraire == 0) {
					Livre l = new Livre(titre, auteur, nbPages);

					B.addDocument(l);
				}

			} else {
				if (!jtf1.getText().isEmpty() && !jtf2.getText().isEmpty() && !jtf3.getText().isEmpty()
						&& PrixLitteraire == 0) {
					Roman zeub = new Roman(titre, auteur, nbPages, PrixLitteraire);
					B.addDocument(zeub);
				}

			}

		}

		if (e.getSource() == ajouter) {
			this.remove(panel);
			this.ajouter();
			this.validate();
			this.repaint();
		}

		if (e.getSource() == supprimer) {
			this.remove(panel);
			this.supprimer();
			this.validate();
			this.repaint();
		}

		if (e.getSource() == retour) { // on clean le panel, on appele notr fonction build
			this.remove(h);
			this.Build();
			this.validate(); // obligatoires avec remove
			this.repaint();
		}

		if (e.getSource() == retour2) {
			this.remove(r);
			this.Build();
			this.validate();
			this.repaint();
		}
		if (e.getSource() == retour3) {
			this.remove(s);
			this.Build();
			this.validate();
			this.repaint();
		}
		if (e.getSource() == retour4) {
			this.remove(sp);
			this.supprimer();
			this.validate();
			this.repaint();
		}
		if (e.getSource() == retour5) {
			this.remove(st);
			this.supprimer();
			this.validate();
			this.repaint();
		}
		if (e.getSource() == suppPrix) {
			this.remove(s);
			this.supprimerPrix();
			this.validate();
			this.repaint();
		}
		if (e.getSource() == suppTitre) {
			this.remove(s);
			this.supprimerTitre();
			this.validate();
			this.repaint();
		}
		if (e.getSource() == delete) {
			List<Document> doco = new ArrayList<Document>();
			for (Document d : B.getDocuments()) {
				if (d.getTitre().equals(jtf1.getText())) {
					doco.add(d);
				}
			}
			for (Document d : doco) {
				B.getDocuments().remove(d);
			}
		}
		if (e.getSource() == delete1) {
			int p = 0;
			if (jr1.isSelected())
				p = -1;
			if (jr2.isSelected())
				p = 1;
			if (jr3.isSelected())
				p = 2;
			if (jr4.isSelected())
				p = 3;

			for (Document d : B.getDocuments()) { // on supprime e document par son prix litteraire
				if (d instanceof Roman) {
					if (((Roman) d).getPrixLitteraire() == p)
						B.getDocuments().remove(d);
				}

			}
		}
	}
}
