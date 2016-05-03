package org.esiea.glpoo.eternity.combat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class Combat implements MouseListener {
	private Joueur joueurHaut, joueurBas;
	
	private boolean estJoueurHautActif;
	
	private CombatView combatView;
	private ActionPanel actionPanel;
	
	public Combat (Joueur joueurHaut, Joueur joueurBas, int nbPkmnHaut, int nbPkmnBas) {
		this.joueurHaut = joueurHaut;
		this.joueurBas = joueurBas;
		
		this.actionPanel = new ActionPanel();
		
		this.actionPanel.setConsoleListener(this);
		
		nbPkmnHaut = nbPkmnHaut <= 0 ? 1 : nbPkmnHaut;
		nbPkmnBas = nbPkmnBas <= 0 ? 1 : nbPkmnBas;
		
		this.joueurHaut.initCombat(this.joueurBas, false, this.actionPanel, nbPkmnHaut);
		this.joueurBas.initCombat(this.joueurHaut, true, this.actionPanel, nbPkmnBas);

		this.joueurHaut.initListener();
		
		this.combatView = new CombatView(this.joueurHaut.getPanel(), this.joueurBas.getPanel(), actionPanel);
	}
	
	public void lancer() {
		this.actionPanel.printlnText("Bienvenu dans Pokesiea");
		
		this.estJoueurHautActif = false;
		this.joueurBas.lancerTour();
		
	}

	public void mouseClicked(MouseEvent e) {
		if (this.estJoueurHautActif && this.joueurHaut.getStatut() == StatutJoueurEnum.Termine) {
			this.joueurHaut.setStatut(StatutJoueurEnum.AttendTour);
			this.estJoueurHautActif = !this.estJoueurHautActif;
			//... check a perdu
			this.joueurBas.lancerTour();
		}
		else if (this.joueurBas.getStatut() == StatutJoueurEnum.Termine){
			this.joueurBas.setStatut(StatutJoueurEnum.AttendTour);
			this.estJoueurHautActif = !this.estJoueurHautActif;
			this.joueurHaut.lancerTour();
		}
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
