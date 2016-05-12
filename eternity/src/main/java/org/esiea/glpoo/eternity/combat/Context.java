package org.esiea.glpoo.eternity.combat;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Scanner;

public class Context {

	private static Hashtable<Integer, PokemonCsv> pokemons; // <id, objet>
	private static Hashtable<Integer, Capacite> capacites;
	static Hashtable<Integer, TirageEuromillion> tirages;
	
	public static void extractCapacityData(String chemin) throws FileNotFoundException {
		
		capacites = new Hashtable<Integer, Capacite>();

        Scanner scanner = new Scanner(new File(chemin));
        Scanner dataScanner = null;
        int index = 0;
        int id = 0, degat = 0, soin = 0;
        String nom = null;
         
        while (scanner.hasNextLine()) {
            dataScanner = new Scanner(scanner.nextLine());
            dataScanner.useDelimiter(",");
 
            while (dataScanner.hasNext()) {
                String data = dataScanner.next();
                if (index == 0)
                    id = Integer.parseInt(data);
                else if (index == 1)
                	nom = data;
                else if (index == 2)
                	degat = Integer.parseInt(data);
                else if (index == 3)
                	soin = Integer.parseInt(data);
                else
                    System.out.println("invalid data::" + data);
                index++;
            }
            Capacite cap = new Capacite(nom,degat,soin);
            index = 0;
            capacites.put(id,cap);
        }
        scanner.close();
        /*for(int i=1;i<=37;i++)
        	System.out.println(capacites.get(i).getNom());*/
	}
	
	public static void extractPokemonData(String chemin) throws FileNotFoundException {
		
		pokemons = new Hashtable<Integer, PokemonCsv>();

		Scanner scanner = new Scanner(new File(chemin));
        Scanner dataScanner = null;
        int index = 0;
        int id = 0, pv = 0, cap1 = 0, cap2 = 0, cap3 = 0, cap4 = 0;
        String nom = null, cheminImageFace = null, cheminImageDos = null;
         
        while (scanner.hasNextLine()) {
            dataScanner = new Scanner(scanner.nextLine());
            dataScanner.useDelimiter(",");
 
            while (dataScanner.hasNext()) {
                String data = dataScanner.next();
                if (index == 0)
                    id = Integer.parseInt(data);
                else if (index == 1)
                	nom = data;
                else if (index == 2)
                	pv = Integer.parseInt(data);
                else if (index == 3)
                	cheminImageFace = data;
                else if (index == 4)
                	cheminImageDos = data;
                else if (index == 5)
                	cap1 = Integer.parseInt(data);
                else if (index == 6)
                	cap2 = Integer.parseInt(data);
                else if (index == 7)
                	cap3 = Integer.parseInt(data);
                else if (index == 8)
                	cap4 = Integer.parseInt(data);
                else
                    System.out.println("invalid data::" + data);
                index++;
            }
            PokemonCsv pokemon = new PokemonCsv(nom, pv, cheminImageFace, cheminImageDos, cap1, cap2, cap3, cap4);
            index = 0;
            pokemons.put(id,pokemon);
        }
        scanner.close();
        /*for(int i=1;i<=20;i++)
        	System.out.println(pokemons.get(i).getCapaciteId(3));*/
	}
	
	
	public static void extractTirageData (String chemin) throws FileNotFoundException {
		tirages = new Hashtable<Integer, TirageEuromillion>();

		Scanner scanner = new Scanner(new File(chemin));
        Scanner dataScanner = null;
        int index = 0;
        int id = 1, boule1 = 0, boule2 = 0, boule3 = 0, boule4 = 0, boule5 = 0, etoile1 = 0, etoile2 = 0;
         
        while (scanner.hasNextLine()) {
            dataScanner = new Scanner(scanner.nextLine());
            dataScanner.useDelimiter(";");
            while (dataScanner.hasNext()) {
                String data = dataScanner.next();
                if (index == 4)
                	boule1 = Integer.parseInt(data);
                else if (index == 5)
                	boule2 = Integer.parseInt(data);
                else if (index == 6)
                	boule3 = Integer.parseInt(data);
                else if (index == 7)
                	boule4 = Integer.parseInt(data);
                else if (index == 8)
                	boule5 = Integer.parseInt(data);
                else if (index == 9)
                	etoile1 = Integer.parseInt(data);
                else if (index == 10)
                	etoile2 = Integer.parseInt(data);
                /*else
                    System.out.println("invalid data::" + data);*/
                index++;
            }
            TirageEuromillion tirage = new TirageEuromillion(boule1, boule2, boule3, boule4, boule5, etoile1, etoile2);
            index = 0;
            tirages.put(id,tirage);
            id++;
        }
        scanner.close();
        /*for(int i=1;i<=20;i++)
        	System.out.println(tirages.get(i).getBoule1());*/
		
	}
	
	public static void extractData () {
		try {
			extractCapacityData("./src/data/csv/competences.csv");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			extractPokemonData("./src/data/csv/pokemon.csv");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			extractTirageData("./src/data/csv/euromillions.csv");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Pokemon getPokemonAleatoire() {
		while (true) {
			int rand = (int) (Math.random() * tirages.size()); //... en fonction d'un tirage
			int id = (tirages.get(rand).getBoule1() + tirages.get(rand).getBoule2() + tirages.get(rand).getBoule3() + tirages.get(rand).getBoule4() + tirages.get(rand).getBoule5()) % pokemons.size();
			if (pokemons.get(id) != null)
				return new Pokemon(pokemons.get(id));
		}
	}
	
	public static Capacite getCapacite(int id) {
		return capacites.get(id);
	}
}