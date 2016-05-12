package org.esiea.glpoo.eternity.combat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Combat implements MouseListener {
	private Joueur joueurHaut, joueurBas, joueurActif;
	private JoueurReel utilisateur;
	
	private boolean estJoueurHautActif;
	
	private TypeCombatEnum typeCombat;
	
	private CombatView combatView;
	private ActionPanel actionPanel;
	
	private boolean isClicking;
	
	private int miseEnJeux;
	
	private boolean termine;
	
	private boolean finit;

	public Combat (Joueur joueurHaut, Joueur joueurBas, JoueurReel utilisateur, int nbPkmnHaut, int nbPkmnBas, TypeCombatEnum typeCombat) {
		this.joueurHaut = joueurHaut;
		this.joueurBas = joueurBas;
		this.utilisateur = utilisateur;
		this.typeCombat = typeCombat;
		
		this.termine = false;
		this.finit = false;
		
		this.actionPanel = new ActionPanel();
		
		this.actionPanel.addConsoleListener(this);
		
		nbPkmnHaut = nbPkmnHaut <= 0 ? 1 : nbPkmnHaut;
		nbPkmnBas = nbPkmnBas <= 0 ? 1 : nbPkmnBas;
		
		this.joueurHaut.initCombat(this.joueurBas, false, this.actionPanel, nbPkmnHaut);
		this.joueurBas.initCombat(this.joueurHaut, true, this.actionPanel, nbPkmnBas);

		this.joueurHaut.initListener();
		
		this.combatView = new CombatView(this.joueurHaut.getPanel(), this.joueurBas.getPanel(), actionPanel);
		
		this.isClicking = false;
		
		if (typeCombat == TypeCombatEnum.ReelVsPNJ) {
			this.miseEnJeux = (int)(Math.random() * 500);
		}
		else if (typeCombat == TypeCombatEnum.PariSur2PNJ) {
			this.combatView.setEnabled(false);
			PariJoueurView pariView = new PariJoueurView(this.utilisateur, this.joueurHaut, this.joueurBas);
			
			while(!(pariView.isPret())) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			this.miseEnJeux = pariView.getPari();
			pariView.dispose();
			
			this.combatView.setEnabled(true);
		}
		else
			this.miseEnJeux = 0;
	}
	
	public void lancer() {
		this.actionPanel.printlnText("Bienvenu dans Pokesiea");
		
		this.estJoueurHautActif = false;
		this.joueurActif = this.joueurBas;
		this.joueurBas.lancerTour();
	}
		
	public void finir(Joueur vainqueur, Joueur Perdant) {
		if (typeCombat == TypeCombatEnum.ReelVsPNJ) {
			if (vainqueur == this.utilisateur) {
				this.utilisateur.setArgent(this.utilisateur.getArgent() + this.miseEnJeux);
				this.actionPanel.printlnText("");
				this.actionPanel.printlnText("Vous avez gagné le combat, vous remportez " + this.miseEnJeux + "$");
			}
			else {
				this.actionPanel.printlnText("");
				this.actionPanel.printlnText("Vous avez perdu le combat, vous ne remportez rien.");
			}
		}
		else if (typeCombat == TypeCombatEnum.PariSur2PNJ) {
			if (vainqueur == this.utilisateur.getJoueurPari()) {
				this.utilisateur.setArgent(this.utilisateur.getArgent() + this.miseEnJeux);
				this.actionPanel.printlnText("");
				this.actionPanel.printlnText("Vous avez gagné le pari, vous remportez " + this.miseEnJeux + "$");
			}
			else {
				this.utilisateur.setArgent(this.utilisateur.getArgent() - this.miseEnJeux);
				this.actionPanel.printlnText("");
				this.actionPanel.printlnText("Vous avez perdu le pari, vous perdez " + this.miseEnJeux + "$");
			}
		}
		
		this.actionPanel.printlnText("Appuyez sur la console pour revenir à la map ...");
		this.finit = true;
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
		
		if (this.finit)
			this.termine = true;
		
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
	
	public void disposeView() {
		this.combatView.dispose();
	}
	
	public boolean isTermine() {
		return termine;
	}
}
