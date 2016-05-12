package org.esiea.glpoo.eternity.combat;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.EventListener;

import javax.swing.JPanel;

public class BoutonPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	CapaciteBouton capacite[];
	
	public BoutonPanel() {
		GridLayout gl = new GridLayout(2, 2);
		gl.setHgap(10);
		gl.setVgap(10);
		
		this.setLayout(gl);
		this.setPreferredSize(getPreferredSize());
		
		this.capacite = new CapaciteBouton[4];
		
		for (int i = 0; i < 4; i++) {
			capacite[i] = new CapaciteBouton();
			this.add(this.capacite[i]);
		}
	}
	
	@Override
	public Dimension getPreferredSize() { // Preferred size of the component
		return new Dimension(300, 100);
	}
	
	public void setNomsCapacites(Pokemon p) {
		for (int i = 0; i < 4; i++) {
			this.capacite[i].setCapacite(p.getCapacite(i));
		}
	}
	
	public void setListener(EventListener l) {
		for (int i = 0; i < 4; i++) {
			capacite[i].addActionListener((ActionListener)l);
		}
	}
	
}
