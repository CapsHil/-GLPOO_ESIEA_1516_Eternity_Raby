package org.esiea.glpoo.eternity.combat;

public class PokemonCsv {
	private int pv;
	//private int puissance;
	private String nom;
	private String cheminImageFace;
	private String cheminImageDos;
	
	private int[] capaciteIds;
	//... tous es champs csv
	
	//... constructeur tt champsace
	public PokemonCsv(String nom, int pv, String cheminImageFace, String cheminImageDos, int capacite1Id, int capacite2Id, int capacite3Id, int capacite4Id) {
		this.nom = nom;
		this.pv = pv;
		this.cheminImageFace = cheminImageFace;
		this.cheminImageDos = cheminImageDos;
		
		this.capaciteIds = new int[4];
		this.capaciteIds[0] = capacite1Id;
		this.capaciteIds[1] = capacite2Id;
		this.capaciteIds[2] = capacite3Id;
		this.capaciteIds[3] = capacite4Id;
	}
	
	public int getCapaciteId(int num) {
		return capaciteIds[num];
	}

	public int getPv() {
		return this.pv;
	}

	public String getNom() {
		return this.nom;
	}

	public String getCheminImageFace() {
		return this.cheminImageFace;
	}

	public String getCheminImageDos() {
		return this.cheminImageDos;
	}
	
	//... getters uniquement
}
