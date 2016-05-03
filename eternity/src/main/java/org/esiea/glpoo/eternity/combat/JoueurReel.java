package org.esiea.glpoo.eternity.combat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JoueurReel extends Joueur  implements ActionListener, MouseListener {
	
	private Capacite tempCapacite;

	public JoueurReel(String nom) {
		super(nom);
	}
	
	public void jouerPokemon() {
		super.jouerPokemon();
		
		if (this.statut != StatutJoueurEnum.Termine) {
			this.actionPanel.boutonPanel.setNomsCapacites(this.pokemons[this.pkmnActif]);
			this.statut = StatutJoueurEnum.AttendCapacite;
			this.actionPanel.printlnText("Selectionnez une capacité");
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof CapaciteBouton && this.statut == StatutJoueurEnum.AttendCapacite) {
			Capacite cap = ((CapaciteBouton)e.getSource()).getCapacite();
			
			this.tempCapacite = cap;
			
			this.statut = StatutJoueurEnum.AttendPokemon;

			this.actionPanel.printlnText("Selectionnez un pokémon pour utiliser : " + cap.getNom());
		}
		
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() instanceof ImagePokemonPanel && this.statut == StatutJoueurEnum.AttendPokemon) {
			if (this.tempCapacite == null)
				return;
			
			Pokemon pkmnCible = ((ImagePokemonPanel)e.getSource()).getPokemon();
			
			this.pokemons[pkmnActif].lancerCapacite(pkmnCible, this.tempCapacite);
			
			this.pkmnActif++;
			
			this.jouerPokemon();
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
	
	public void initListener() {
		this.actionPanel.setBoutonListener(this);
		this.joueurPanel.setListener(this);
		this.adversaire.getPanel().setListener(this);
	}
	
	public void finirTour() {
		
	}
}
