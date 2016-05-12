package org.esiea.glpoo.eternity.combat;

import java.awt.Color;

import javax.swing.JProgressBar;

public class JaugeVieProgressBar extends JProgressBar {

	private static final long serialVersionUID = 1L;

	public JaugeVieProgressBar(int min, int max) {
		super(min, max);
		
		this.setStringPainted(true);
		this.setForeground(Color.decode("#35B941"));
	}
	
	public void setValue(int n)	{
		
		super.setValue(n);
		super.setString(n + " PV / " + this.getMaximum());
		
		if (n < this.getMaximum()*0.2) {
			this.setForeground(Color.RED);
		}
		else if (n < this.getMaximum()*0.4) {
			this.setForeground(Color.ORANGE);
		}
		else {
			this.setForeground(Color.decode("#35B941"));
		}
	}

}
