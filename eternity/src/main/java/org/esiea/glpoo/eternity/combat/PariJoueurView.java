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
	
	private Joueur joueurHaut, joueurBas;
	
	private JLabel montant;
	private JLabel joueur;
	
	private JLabel argent;
	private JLabel argentJoueur;
	
	private JTextField montantPari;
	private JRadioButton haut;
	private JRadioButton bas;
	private ButtonGroup joueurPari;
	
	private JButton okButton;
	
	private boolean pret;
	
	private int pari;

	public PariJoueurView (JoueurReel utilisateur, Joueur joueurHaut, Joueur joueurBas) {
		super("Pariez sur un joueur !");
		this.pret = false;
		this.utilisateur = utilisateur;
		this.joueurHaut = joueurHaut;
		this.joueurBas = joueurBas;
		
		this.initGui();
	}

	public boolean isPret() {
		return pret;
	}

	public void initGui() {
		Container cont = this.getContentPane();
		cont.add(this.getPanel(), BorderLayout.CENTER);
		this.setContentPane(cont);
		
		this.setBounds(1000,700,400,250);
		
		this.setVisible(true);
	}
	
	public JPanel getPanel() {
		JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
		
		montant = new JLabel("Montant");
		joueur = new JLabel("Joueur");
		
		argent = new JLabel("Argent");
		argentJoueur = new JLabel(this.utilisateur.getArgent() + " $");
		
		montantPari = new JTextField();	
		haut = new JRadioButton("Haut");
	    bas = new JRadioButton("Bas");
		haut.setSelected(true);
	    joueurPari = new ButtonGroup();
		
		okButton = new JButton("OK");
		okButton.addActionListener(this);
		
		panel.add(argent);
		panel.add(argentJoueur);
		
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
		ArrayList<String> erreurs = new ArrayList<String>();
		
		try {
			this.pari = Integer.parseInt(montantPari.getText());
			
			if (this.pari <= 0)
				erreurs.add("Le montant doit être supérieur à zéro");
			
			if (this.pari > this.utilisateur.getArgent())
				erreurs.add("Le montant doit inférieur ou égal à votre argent");
		}
		catch (NumberFormatException e1) {
			erreurs.add("Le montant doit être un nombre");
		}
		
		if (erreurs.size() == 0) {
			if (this.haut.isSelected())
				this.utilisateur.setJoueurPari(this.joueurHaut);
			else
				this.utilisateur.setJoueurPari(this.joueurBas);
			
			this.pret = true;
		}
		else {
			String erreurMsg = "";
			
			for (String ch : erreurs) {
				erreurMsg += ch + "\n";
			}
			
			JOptionPane.showMessageDialog(null, erreurMsg, "Erreur ...", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public int getPari() {
		return pari;
	}
}
