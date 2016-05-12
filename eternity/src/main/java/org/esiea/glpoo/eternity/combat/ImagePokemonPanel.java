package org.esiea.glpoo.eternity.combat;

import java.awt.event.MouseListener;
import java.util.EventListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImagePokemonPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Pokemon pokemon;
	private boolean estEnBas;
	private JLabel image;
	private ImageIcon icone;
	
	public ImagePokemonPanel(Pokemon pkmn, boolean estEnBas) {
		this.pokemon = pkmn;
		this.estEnBas = estEnBas;
		
		this.icone = new ImageIcon(this.pokemon.getCheminImage(this.estEnBas));
		
		this.image = new JLabel(icone);
		this.add(image);
		this.pokemon.setImagePanel(this);
	}
	
	public Pokemon getPokemon() {
		return this.pokemon;
	}
	
	public void setListener(EventListener l) {
		for( MouseListener ml : this.getMouseListeners() ) {
	        this.removeMouseListener(ml);
	    }
		
		this.addMouseListener((MouseListener)l);
	}
	
	public JLabel getImage() {
		return this.image;
	}
	
	public ImageIcon getIcone() {
		return this.icone;
	}
}
