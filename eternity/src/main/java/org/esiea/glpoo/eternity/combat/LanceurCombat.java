package org.esiea.glpoo.eternity.combat;

public class LanceurCombat {
	
	public static void main( String[] args )
    {	
		Context.extractData();
		
		ParametresCombatView param = new ParametresCombatView();
		
		while(!(param.isPret())) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
        Combat combat = new Combat(param.getJoueurHaut(), param.getJoueurBas(), param.getNbPkmnH(), param.getNbPkmnB());
        
        param.dispose();
        
        combat.lancer();
    }
}
