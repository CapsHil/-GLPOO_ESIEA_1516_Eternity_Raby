package org.esiea.glpoo.eternity.combat;

public class LanceurCombat {
	
	public static void main( String[] args )
    {	
		Context.extractData();
		
		JoueurReel j1 = new JoueurReel("Toto");
		JoueurReel j2 = new JoueurReel("Bastien");
		
        Combat combat = new Combat(j1, j2, 2, 2);
        
        combat.lancer();
    }
}
