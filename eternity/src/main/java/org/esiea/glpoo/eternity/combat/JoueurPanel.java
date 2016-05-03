package org.esiea.glpoo.eternity.combat;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.util.EventListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class JoueurPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Joueur joueur;
	private boolean estEnBas;
	
	private JPanel pokemonsPanel;
	private JPanel statsPanel;
	private ImagePokemonPanel[] imagePanels;
	private JaugeVieProgressBar[] jauges;
	
	public JoueurPanel(Joueur joueur, boolean estEnBas) {
		this.joueur = joueur;
		this.estEnBas = estEnBas;
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		this.setPreferredSize(getPreferredSize());
		
		this.initPokemonPanel();
		this.initStatPanel();
		
		if (this.estEnBas) {
			this.add(pokemonsPanel);
			this.add(statsPanel);
		}
		else {
			this.add(statsPanel);
			this.add(pokemonsPanel);
		}
	}
	
	public void initPokemonPanel() {
		this.pokemonsPanel = new JPanel(new GridLayout(1, this.joueur.getNbPkmn()));
		
		this.imagePanels = new ImagePokemonPanel[this.joueur.getNbPkmn()];
		
		for (int i = 0; i < this.joueur.getNbPkmn(); i++) {
			this.imagePanels[i] = new ImagePokemonPanel(this.joueur.pokemons[i], this.estEnBas);
			this.pokemonsPanel.add(imagePanels[i]);
		}
	}
	
	public void initStatPanel() {
		GridLayout gl = new GridLayout(this.joueur.getNbPkmn(), 1);
		this.statsPanel = new JPanel(gl);
		gl.setVgap(20);
		
		this.jauges = new JaugeVieProgressBar[this.joueur.getNbPkmn()];
		
		for (int i = 0; i < this.joueur.getNbPkmn(); i++) {
			jauges[i] = new JaugeVieProgressBar(0, this.joueur.getPokemon(i).getPv());
			this.initJaugeView(jauges[i]);
			this.statsPanel.add(jauges[i]);
			this.joueur.getPokemon(i).setJauge(jauges[i]);
		}
	}
	
	@Override
	public Dimension getPreferredSize() { // Preferred size of the component
		return new Dimension(800, 250);
	}
	
	public void initJaugeView(JProgressBar progressBar) {
		progressBar.setValue(progressBar.getMaximum());
	}
	
	public void setListener(EventListener l) {
		for (int i = 0; i < this.joueur.getNbPkmn(); i++)
			this.imagePanels[i].setListener(l);
	}
}
