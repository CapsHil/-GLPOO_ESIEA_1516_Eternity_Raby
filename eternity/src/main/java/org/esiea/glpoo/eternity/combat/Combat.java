package org.esiea.glpoo.eternity.combat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class Combat implements MouseListener {
	private Joueur joueurHaut, joueurBas, joueurActif, vainqueur;
	private JoueurReel joueurUtilisateur;
	
	private boolean estJoueurHautActif;
	
	private TypeCombatEnum typeCombat;
	
	private CombatView combatView;
	private ActionPanel actionPanel;
	
	private boolean isClicking;
	
	private boolean termine;
	
	public Combat (Joueur joueurHaut, Joueur joueurBas, JoueurReel joueurUtilisateur, int nbPkmnHaut, int nbPkmnBas, TypeCombatEnum typeCombat) {
		this.joueurHaut = joueurHaut;
		this.joueurBas = joueurBas;
		this.joueurUtilisateur = joueurUtilisateur;
		this.typeCombat = typeCombat;
		
		this.termine = false;
		
		this.actionPanel = new ActionPanel();
		
		this.actionPanel.addConsoleListener(this);
		
		nbPkmnHaut = nbPkmnHaut <= 0 ? 1 : nbPkmnHaut;
		nbPkmnBas = nbPkmnBas <= 0 ? 1 : nbPkmnBas;
		
		this.joueurHaut.initCombat(this.joueurBas, false, this.actionPanel, nbPkmnHaut);
		this.joueurBas.initCombat(this.joueurHaut, true, this.actionPanel, nbPkmnBas);

		this.joueurHaut.initListener();
		
		this.combatView = new CombatView(this.joueurHaut.getPanel(), this.joueurBas.getPanel(), actionPanel);
		
		this.isClicking = false;
	}
	
	public void lancer() {
		this.actionPanel.printlnText("Bienvenu dans Pokesiea");
		
		this.estJoueurHautActif = false;
		this.joueurActif = this.joueurBas;
		this.joueurBas.lancerTour();
	}
		
	public void finir(Joueur vainqueur, Joueur Perdant) {
		this.vainqueur = vainqueur;
		
		this.termine = true;
	}

	public void mouseClicked(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		if (this.isClicking)
			return;
		
		this.isClicking = true;
		
		if (this.joueurActif.statut == StatutJoueurEnum.Termine) {
			this.joueurActif.setStatut(StatutJoueurEnum.AttendTour);
			
			if (this.estJoueurHautActif)
				this.joueurActif = this.joueurBas;
			else
				this.joueurActif = this.joueurHaut;
			
			this.estJoueurHautActif = !this.estJoueurHautActif;
			
			this.joueurActif.lancerTour();
		}
		else if (this.joueurActif.statut == StatutJoueurEnum.Vainqueur || this.joueurActif.statut == StatutJoueurEnum.Perdant) {
			if (this.joueurActif.statut == StatutJoueurEnum.Perdant)
				this.estJoueurHautActif = !this.estJoueurHautActif;
			
			if (this.estJoueurHautActif)
				this.finir(joueurHaut, joueurBas);
			else
				this.finir(joueurBas, joueurHaut);
		}		
	}

	public void mouseReleased(MouseEvent e) {
		this.isClicking = false;
	}
	
	public Joueur getVainqueur() {
		return vainqueur;
	}

	public boolean isTermine() {
		return termine;
	}
}
