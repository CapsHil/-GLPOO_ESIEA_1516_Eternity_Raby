package org.esiea.glpoo.eternity.combat;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PariJoueurView extends JFrame implements ActionListener {
	private JoueurReel utilisateur;
	
	private JLabel montant = new JLabel("Montant");
	private JLabel joueur = new JLabel("Joueur");
	
	private JTextField montantPari;
	private JRadioButton haut;
	private JRadioButton bas;
	private ButtonGroup joueurPari;
	
	private JButton okButton;
	
	private boolean pret;
	
	public PariJoueurView () {
		super("Paramètres de combat");
		this.pret = false;
		
		this.initGui();
	}
	
	public Joueur getJoueurHaut() {
		return joueurHaut;
	}

	public Joueur getJoueurBas() {
		return joueurBas;
	}

	public int getNbPkmnH() {
		return nbPkmnH;
	}

	public int getNbPkmnB() {
		return nbPkmnB;
	}

	public boolean isPret() {
		return pret;
	}

	public void initGui() {
		Container cont = this.getContentPane();
		cont.add(this.getPanel(), BorderLayout.CENTER);
		this.setContentPane(cont);
		
		this.setBounds(300,1200,400,250);
		
		this.setVisible(true);
	}
	
	public JPanel getPanel() {
		JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
		
		montant = new JLabel("Montant");
		joueur = new JLabel("Joueur");
		
		montantPari = new JTextField();	
		haut = new JRadioButton("Haut");
	    bas = new JRadioButton("Bas");
		haut.setSelected(true);
	    joueurPari = new ButtonGroup();
		
		okButton = new JButton("OK");
		okButton.addActionListener(this);
		
		panel.add(montant);
		panel.add(montantPari);
		
		panel.add(joueur);
		panel.add(haut);
		
		panel.add(new JLabel());
		panel.add(bas);
		
		panel.add(new JLabel());
		panel.add(okButton);
		
		return panel;
	}

	public void actionPerformed(ActionEvent e) {
		/*ArrayList<String> erreurs = new ArrayList<String>();
		
		if (this.nomJB.getText().length() == 0)
			erreurs.add("Le joueur bas doit avoir un nom");
		
		if (this.nomJH.getText().length() == 0)
			erreurs.add("Le joueur haut doit avoir un nom");

		try {
			this.nbPkmnB = Integer.parseInt(nbPkmnJB.getText());
		}
		catch (NumberFormatException e1) {
			erreurs.add("Le joueur haut doit avoir un nombre de pokémons valide");
		}

		try {
			this.nbPkmnH = Integer.parseInt(nbPkmnJH.getText());
		}
		catch (NumberFormatException e1) {
			erreurs.add("Le joueur bas doit avoir un nombre de pokémons valide");
		}
		
		if (erreurs.size() == 0) {
			if (this.reelJH.isSelected())
				this.joueurHaut = new JoueurReel(this.nomJH.getText(), 0);
			else
				this.joueurHaut = new JoueurPNJ(this.nomJH.getText());
			
			if (this.reelJB.isSelected())
				this.joueurBas = new JoueurReel(this.nomJB.getText(), 0);
			else
				this.joueurBas = new JoueurPNJ(this.nomJB.getText());
			
			this.pret = true;
		}
		else {
			String erreurMsg = "";
			
			for (String ch : erreurs) {
				erreurMsg += ch + "\n";
			}
			
			JOptionPane.showMessageDialog(null, erreurMsg, "Erreur ...", JOptionPane.ERROR_MESSAGE);
		}*/
		
	}
}
