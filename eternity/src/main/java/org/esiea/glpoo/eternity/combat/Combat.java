package org.esiea.glpoo.eternity.combat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class Combat implements MouseListener {
	private Joueur joueurHaut, joueurBas, joueurActif;
	
	private boolean estJoueurHautActif;
	
	private CombatView combatView;
	private ActionPanel actionPanel;
	
	private boolean isClicking;
	
	public Combat (Joueur joueurHaut, Joueur joueurBas, int nbPkmnHaut, int nbPkmnBas) {
		this.joueurHaut = joueurHaut;
		this.joueurBas = joueurBas;
		
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
}
