package org.esiea.glpoo.eternity.combat;

import java.util.Hashtable;

public class Context {

	private static Hashtable<Integer, PokemonCsv> pokemons; // <id, objet>
	private static Hashtable<Integer, Capacite> capacites;
	private static Hashtable<Integer, TirageEuromillion> tirages;
	
	public static void extractCapacityData(String chemin) {
		capacites = new Hashtable<Integer, Capacite>();
		
		Capacite cap1 = new Capacite("Charge", 10, 0);
		Capacite cap2 = new Capacite("Coup de foudre", 15, 0);
		Capacite cap3 = new Capacite("Soin", 0, 10);
		Capacite cap4 = new Capacite("Bombe atomique", 999, 0);
		
		capacites.put(0, cap1);
		capacites.put(1, cap2);
		capacites.put(2, cap3);
		capacites.put(3, cap4);
	}
	
	public static void extractPokemonData(String chemin) {
		pokemons = new Hashtable<Integer, PokemonCsv>();
		
		int key = 0;
		
		PokemonCsv pkmn = new PokemonCsv("pikachu", 80, "/home/nicobas/Downloads/pickachu_face.png", "/home/nicobas/Downloads/pickachu_dos.png", 0, 1, 2, 3);
		pokemons.put(key, pkmn);
	}
	
	public static void extractTirageData (String chemin) {
		
	}
	
	public static void extractData () {
		extractCapacityData("capacite_data.csv");
		extractPokemonData("pokemon_data.csv");
		extractTirageData("tirage_data.csv");
	}
	
	public static Pokemon getPokemonAleatoire() {
		int id = (int) (Math.random() * pokemons.size()); //... en fonction d'un tirage
		return new Pokemon(pokemons.get(id));
	}
	
	public static Capacite getCapacite(int id) {
		return capacites.get(id);
	}
}
