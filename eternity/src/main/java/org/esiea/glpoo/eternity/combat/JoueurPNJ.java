package org.esiea.glpoo.eternity.combat;

public class JoueurPNJ extends Joueur {

	public JoueurPNJ(String nom) {
		super(nom);
	}
	
	public void jouerPokemon() {
		super.jouerPokemon();
		
		if (this.statut != StatutJoueurEnum.Termine) {
			//choisir une capacite alea, pkmn adversaire alea et lancer cap
		}
	}
	
}
