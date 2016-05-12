package org.esiea.glpoo.eternity.combat;

public class LanceurCombat {
	
	public static void main( String[] args )
    {	
		Context.extractData();
		
		TypeCombatEnum typeCombat = TypeCombatEnum.Libre;
		
		JoueurReel joueurUtilisateur = new JoueurReel("Bastien");
		
		Joueur joueurHaut, joueurBas;
		int nbPkmnHaut, nbPkmnBas;
		
		if (typeCombat == TypeCombatEnum.Libre) {
			ParametresCombatView param = new ParametresCombatView();
			
			while(!(param.isPret())) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			joueurHaut = param.getJoueurHaut();
			joueurBas = param.getJoueurBas();
			nbPkmnHaut = param.getNbPkmnH();
			nbPkmnBas = param.getNbPkmnB();
			
	        param.dispose();
		}
		else if (typeCombat == TypeCombatEnum.PariSur2PNJ) {
			joueurHaut = new JoueurPNJ("toto"); // A modifier en fonction d'un param ?
			joueurBas = new JoueurPNJ("bidule");
			nbPkmnHaut = 2; // A modifier en fonction d'un param ?
			nbPkmnBas = 2;
			
			// fenetre demandant les tunes a parier
		}
		else { // TypeCombatEnum.ReelVsPNJ
			
			joueurHaut = new JoueurPNJ("toto"); // A modifier en fonction d'un param ? ou recup depuis la map
			joueurBas = joueurUtilisateur;
			nbPkmnHaut = 2; // A modifier en fonction d'un param ?
			nbPkmnBas = 2;
			
			// montant aleatoire des tunes a gagner
		}
		
        Combat combat = new Combat(joueurHaut, joueurBas, joueurUtilisateur, nbPkmnHaut, nbPkmnBas, typeCombat);
        
        combat.lancer();
    }
}
