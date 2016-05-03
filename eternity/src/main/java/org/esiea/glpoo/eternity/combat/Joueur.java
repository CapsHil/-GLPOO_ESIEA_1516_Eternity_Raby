package org.esiea.glpoo.eternity.combat;

public abstract class Joueur {
	protected String nom;
	protected Pokemon[] pokemons;
	protected boolean estEnBas;
	protected StatutJoueurEnum statut;
	
	protected JoueurPanel joueurPanel;
	protected ActionPanel actionPanel;
	
	protected int pkmnActif;
	protected Joueur adversaire;
	protected int nbPkmn;
	protected boolean aPerdu;
	
	public Joueur(String nom) {
		this.nom = nom;
	}
	
	public void initCombat(Joueur adversaire, boolean estEnBas, ActionPanel actionPanel, int nbPkmn) {
		this.adversaire = adversaire;
		this.estEnBas = estEnBas;
		this.nbPkmn = nbPkmn;
		this.aPerdu = false;

		this.pokemons = new Pokemon[this.nbPkmn];
		
		for (int i = 0; i < this.nbPkmn; i++)
			this.pokemons[i] = Context.getPokemonAleatoire();
		
		this.joueurPanel = new JoueurPanel(this, estEnBas);
		this.actionPanel = actionPanel;
		
		
		for (int i = 0; i < this.nbPkmn; i++)
			this.pokemons[i].setActionPanel(this.actionPanel);
	}
	
	public void lancerTour() {
		this.initListener();
		this.pkmnActif = 0;
		this.statut = StatutJoueurEnum.Actif;
		
		this.jouerPokemon();
	}
	
	public void jouerPokemon() {		
		if (this.pkmnActif == this.nbPkmn) {
			this.statut = StatutJoueurEnum.Termine;
			this.actionPanel.printlnText("Appuyez sur la console pour finir le tour");
			return;
		}
		
		while (!this.pokemons[this.pkmnActif].getEstVivant()) {
			this.pkmnActif++;
			
			if (this.pkmnActif == this.nbPkmn) {
				this.statut = StatutJoueurEnum.Termine;
				this.actionPanel.printlnText("Appuyez sur la console pour finir le tour");
				return;
			}
		}
	}
	
	public JoueurPanel getPanel() {
		return this.joueurPanel;
	}
	
	public Pokemon getPokemon(int i) {
		return this.pokemons[i];
	}
	
	public int getNbPkmn() {
		return this.nbPkmn;
	}
	
	public StatutJoueurEnum getStatut() {
		return this.statut;
	}
	
	public void setStatut(StatutJoueurEnum statut) {
		this.statut = statut;
	}
	
	public void initListener() {
		
	}
}
