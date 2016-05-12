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
	
	protected boolean isClicking;
	
	public Joueur(String nom) {
		this.nom = nom;
		this.isClicking = false;
		//this.pokemons
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
		this.actionPanel.printlnText("Le joueur " + this.nom + " commence son tour");
		this.pkmnActif = 0;
		this.statut = StatutJoueurEnum.Actif;
		
		this.jouerPokemon();
	}
	
	public void jouerPokemon() {
		while (true) {
			if (this.estMort()) {
				this.statut = StatutJoueurEnum.Perdant;
				this.adversaire.statut = StatutJoueurEnum.Vainqueur;
				this.actionPanel.printlnText("Le joueur " + this.adversaire.getNom() + " a gagné !");
				this.actionPanel.printlnText("Appuyez sur la console pour finir le tour");
				return;
			}
			else if (this.adversaire.estMort()) {
				this.adversaire.statut = StatutJoueurEnum.Perdant;
				this.statut = StatutJoueurEnum.Vainqueur;
				this.actionPanel.printlnText("Le joueur " + this.getNom() + " a gagné !");
				this.actionPanel.printlnText("Appuyez sur la console pour finir le tour");
				return;
			}
			else if (this.pkmnActif == this.nbPkmn) {
				this.statut = StatutJoueurEnum.Termine;
				this.actionPanel.printlnText("Appuyez sur la console pour finir le tour");
				return;
			}
			else if (!this.pokemons[this.pkmnActif].getEstVivant())
				this.pkmnActif++;
			else
				break;
		}
		
		this.actionPanel.printlnText("C'est à " + this.pokemons[this.pkmnActif].getNom() + " de jouer");
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
	
	public String getNom() {
		return this.nom;
	}
	
	public StatutJoueurEnum getStatut() {
		return this.statut;
	}
	
	public void setStatut(StatutJoueurEnum statut) {
		this.statut = statut;
	}
	
	public void initListener() {
		
	}
	
	public boolean estMort() {
		for (Pokemon p : this.pokemons) {
			if (p.getEstVivant())
				return false;			
		}
		return true;
	}
	
	public Pokemon getPokemonVivantAleatoire() {
		while (true) {
			int rand = (int) (Math.random() * Context.tirages.size()); //... en fonction d'un tirage
			int id = (Context.tirages.get(rand).getBoule1() + Context.tirages.get(rand).getBoule2() + Context.tirages.get(rand).getBoule3() + Context.tirages.get(rand).getBoule4() + Context.tirages.get(rand).getBoule5()) % pokemons.length;
			if (this.pokemons[id].getEstVivant())
				return this.pokemons[id];
		}
	}
}
