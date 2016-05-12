package org.esiea.glpoo.eternity.combat;

public class Capacite {
	private String nom;
	private int degat;
	private int soin;
	
	public Capacite(String nom, int degat, int soin) {
		this.nom = nom;
		this.degat = degat;
		this.soin = soin;
	}

	public void attaquer (Pokemon emmeteur, Pokemon receveur) {
		if (this.degat > 0) {
			
			int degatApplique = this.getValeurAppliquee(this.degat);
			
			if (degatApplique > 0) {
				emmeteur.mvntAttaquer();
				receveur.mvntSubirDebats();
				int pvReceveur = receveur.getPv();
				receveur.setPv(receveur.getPv() - degatApplique);
				receveur.getActionPanel().printlnText(receveur.getNom() + " perd " + (pvReceveur - receveur.getPv()) + " PV");
				receveur.updateEstVivant();
			}
			else {
				receveur.getActionPanel().printlnText(this.nom + " est un échec");
			}
		}
	}
	
	public void soigner (Pokemon emmeteur, Pokemon receveur) {
		if (this.soin > 0) {
			
			int soinApplique = this.getValeurAppliquee(this.soin);
			
			if (soinApplique > 0) {
				emmeteur.mvntSoigner();
				receveur.mvntSubirSoins();
				int pvReceveur = receveur.getPv();
				receveur.setPv(receveur.getPv() + soinApplique);
				receveur.getActionPanel().printlnText(receveur.getNom() + " récupere " + (receveur.getPv() - pvReceveur) + " PV");
			}
			else {
				receveur.getActionPanel().printlnText(this.nom + " est un échec");
			}
		}
	}
	
	public boolean hasAttaque () {
		return this.degat > 0;
	}
	
	public boolean hasSoin () {
		return this.soin > 0;
	}
	
	public int getValeurAppliquee (int valeur) {
		int rand = (int)(Math.random() * Context.tirages.size());
		int valeurReel = (Context.tirages.get(rand).getEtoile1() * Context.tirages.get(rand).getEtoile1()) % valeur;
		return valeurReel;
	}
	
	public String getNom() {
		return this.nom;
	}
}
