package org.esiea.glpoo.eternity.combat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JoueurReel extends Joueur  implements ActionListener, MouseListener {
	
	private Capacite tempCapacite;
	private int argent;
	private Joueur joueurPari;

	public JoueurReel(String nom, int argent) {
		super(nom);
		this.argent = argent;
	}
	
	public void jouerPokemon() {
		super.jouerPokemon();
		
		if (this.statut != StatutJoueurEnum.Termine && this.statut != StatutJoueurEnum.Perdant && this.statut != StatutJoueurEnum.Vainqueur) {
			this.actionPanel.boutonPanel.setVisible(true);
			this.actionPanel.boutonPanel.setNomsCapacites(this.pokemons[this.pkmnActif]);
			this.statut = StatutJoueurEnum.AttendCapacite;
			this.actionPanel.printlnText("Selectionnez une capacité");
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if (this.isClicking)
			return;
		
		this.isClicking = true;
		
		if (e.getSource() instanceof CapaciteBouton && this.statut == StatutJoueurEnum.AttendCapacite) {
			Capacite cap = ((CapaciteBouton)e.getSource()).getCapacite();
			
			if (cap == null)
				return;
			
			this.tempCapacite = cap;
			
			this.statut = StatutJoueurEnum.AttendPokemon;

			this.actionPanel.printlnText("Selectionnez un pokémon pour utiliser : " + cap.getNom());
		}
		
		this.isClicking = false;
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
		
		if (e.getSource() instanceof ImagePokemonPanel && this.statut == StatutJoueurEnum.AttendPokemon) {
			if (this.tempCapacite == null)
				return;
			
			Pokemon pkmnCible = ((ImagePokemonPanel)e.getSource()).getPokemon();
			
			this.pokemons[pkmnActif].lancerCapacite(pkmnCible, this.tempCapacite);
			
			this.pkmnActif++;
			
			this.jouerPokemon();
		}
	}

	public void mouseReleased(MouseEvent e) {
		this.isClicking = false;		
	}
	
	public void initListener() {
		this.actionPanel.setBoutonListener(this);
		this.joueurPanel.setListener(this);
		this.adversaire.getPanel().setListener(this);
	}
	
	public void finirTour() {
		
	}
	
	public int getArgent() {
		return argent;
	}

	public void setArgent(int argent) {
		this.argent = argent;
	}
	
	public Joueur getJoueurPari() {
		return joueurPari;
	}

	public void setJoueurPari(Joueur joueurPari) {
		this.joueurPari = joueurPari;
	}

}
