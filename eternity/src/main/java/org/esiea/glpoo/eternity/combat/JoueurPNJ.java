package org.esiea.glpoo.eternity.combat;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JoueurPNJ extends Joueur implements MouseListener {

	public JoueurPNJ(String nom) {
		super(nom);
	}
	
	public void jouerPokemon() {
		super.jouerPokemon();
		
		if (this.statut != StatutJoueurEnum.Termine && this.statut != StatutJoueurEnum.Perdant && this.statut != StatutJoueurEnum.Vainqueur) {
			this.actionPanel.boutonPanel.setVisible(false);
			this.statut = StatutJoueurEnum.AttendUtilisateur;
			this.actionPanel.printlnText("Appuyez pour continuer ...");
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		if (this.isClicking)
			return;
		
		this.isClicking = true;
		
		if (this.statut == StatutJoueurEnum.AttendUtilisateur) {
			this.statut = StatutJoueurEnum.Actif;
			Capacite cap = this.pokemons[pkmnActif].getCapaciteAleatoire();
				
			Pokemon pkmnCible;
	
			if (cap.hasAttaque())
				pkmnCible = this.adversaire.getPokemonVivantAleatoire();
			else
				pkmnCible = this.getPokemonVivantAleatoire();
				
			this.pokemons[pkmnActif].lancerCapacite(pkmnCible, cap);
			
			this.pkmnActif++;
	
			this.jouerPokemon();
		}		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		this.isClicking = false;
	}
	
	public void initListener() {
		this.actionPanel.addConsoleListener(this);
	}	
}