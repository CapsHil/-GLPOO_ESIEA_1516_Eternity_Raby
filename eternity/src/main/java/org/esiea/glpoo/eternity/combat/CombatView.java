package org.esiea.glpoo.eternity.combat;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class CombatView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 320307291367758001L;
	private JoueurPanel joueurPanelHaut;
	private JoueurPanel joueurPanelBas;
	private ActionPanel actionPanel;
	
	public CombatView (JoueurPanel joueurPanelHaut, JoueurPanel joueurPanelBas, ActionPanel actionPanel) {
		super("Pokésiea");
		this.joueurPanelHaut = joueurPanelHaut;
		this.joueurPanelBas = joueurPanelBas;
		this.actionPanel = actionPanel;
		
		this.initGui();
	}
	
	public void initGui() {
		Container cont = this.getContentPane();
		cont.add(this.joueurPanelHaut, BorderLayout.NORTH);
		cont.add(this.joueurPanelBas, BorderLayout.CENTER);
		cont.add(this.actionPanel, BorderLayout.SOUTH);
		this.setContentPane(cont);
		
		this.setBounds(200,200,1200,600);
		
		this.setVisible(true);
	}
}
