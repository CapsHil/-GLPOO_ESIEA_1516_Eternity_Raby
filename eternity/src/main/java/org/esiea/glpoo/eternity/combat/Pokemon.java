package org.esiea.glpoo.eternity.combat;

import java.awt.Color;
import java.awt.ComponentOrientation;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Pokemon {
	
	private String nom;
	private int pv;
	private Capacite[] capacites;
	//private int puissance; // va permettre de définir les cotes pour les paris et de faire des combats équitables
	private String cheminImageFace;
	private String cheminImageDos;
	private boolean estVivant;
	private int pvMax;
	
	private ImagePokemonPanel imagePanel;
	private JProgressBar jauge;
	private ActionPanel actionPanel;
	
	public Pokemon(PokemonCsv data) {
		this.nom = data.getNom();
		this.pv = data.getPv();
		this.pvMax = data.getPv();
		this.cheminImageFace = data.getCheminImageFace();
		this.cheminImageDos = data.getCheminImageDos();
		
		capacites = new Capacite[4];
		
		for (int i = 0; i < 4; i++) {
			this.capacites[i] = Context.getCapacite(data.getCapaciteId(i));
		}
		
		this.estVivant = true;
	}
	
	//-- GUI
	
	public void mvntAttaquer() {
		
	}

	public void mvntSoigner() {
	
	}
	
	public void mvntSubirDebats() {
		
	}
	
	public void mvntSubirSoins() {
		
	}
	
	public void updateAffichagePv() {
		this.jauge.setValue(this.pv);
	}
	
	public void mourir() {
		this.actionPanel.printlnText(this.nom + " est mort");
		this.imagePanel.setListener(null);
		this.imagePanel.getImage().setVisible(false);
		this.estVivant = false;
	}
	
	//-- Methodes
	
	public void lancerCapacite (Pokemon receveur, Capacite cap) { //... exception capacite not found
		this.actionPanel.printlnText(this.nom + " lance "+ cap.getNom() + " sur " + receveur.getNom());
		
		if (cap.hasAttaque()) {
			if (this == receveur)
				this.actionPanel.printlnText("Un pokémon ne ne peut pas s'attaquer lui même : échec");
			else
				cap.attaquer(this, receveur);
		}
		else if (cap.hasSoin()) {
			cap.soigner(this, receveur);
		}
		
	}
	
	//-- Accesseurs
	
	public int getPv() {
		return pv;
	}

	public void setPv(int pv) {
		if (pv <= 0) {
			this.pv = 0;
		}
		else if (pv >= this.pvMax) {
			this.pv = this.pvMax;
		}
		else {
			this.pv = pv;
		}
		
		this.updateAffichagePv();
	}
	
	public void updateEstVivant () {
		if (this.pv <= 0) {
			this.mourir();
		}
	}
	
	public String getCheminImage (boolean estEnBas) {
		if (estEnBas)
			return this.cheminImageDos;
		else
			return this.cheminImageFace;
	}
	

	public void setImagePanel(ImagePokemonPanel p) {
		this.imagePanel = p;
	}

	public void setJauge(JProgressBar jauge) {
		this.jauge = jauge;
	}
	
	public Capacite getCapacite(int key) {
		return this.capacites[key];
	}
	
	public ActionPanel getActionPanel() {
		return this.actionPanel;
	}
	
	public void setActionPanel(ActionPanel p) {
		this.actionPanel = p;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public boolean getEstVivant() {
		return this.estVivant;
	}
	
	public Capacite getCapaciteAleatoire() {
		while (true) {
			int rand = (int) (Math.random() * Context.tirages.size()); //... en fonction d'un tirage
			//... voir si un ratio plus important d'attaque ou si ce ratio réduit en fonction de la vie des pokemens du joueur
			int id = (Context.tirages.get(rand).getEtoile1() * Context.tirages.get(rand).getEtoile1()) % capacites.length;
			if (this.capacites[id] != null)
				return this.capacites[id];
		}
	}
}
