package org.esiea.glpoo.eternity.combat;

public class LanceurCombat {
	
	public static void main( String[] args )
    {	
		Context.extractData();
		
		JoueurPNJ j1 = new JoueurPNJ("Toto");
		JoueurPNJ j2 = new JoueurPNJ("Bastien");
		
        Combat combat = new Combat(j1, j2, 4, 4);
        
        combat.lancer();
    }
}
