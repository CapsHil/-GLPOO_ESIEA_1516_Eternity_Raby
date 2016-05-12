package org.esiea.glpoo.eternity.combat;

import java.awt.Color;

import javax.swing.JButton;

public class CapaciteBouton extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4873024777233659430L;
	public Capacite capacite;

	public Capacite getCapacite() {
		return this.capacite;
	}

	public void setCapacite(Capacite capacite) {
		this.capacite = capacite;
		
		if (capacite != null) {
			this.setText(capacite.getNom());
			
			if (capacite.hasAttaque())
				this.setForeground(Color.RED);
			else
				this.setForeground(Color.BLUE);
		}
		else
			this.setText("");
	}

}


