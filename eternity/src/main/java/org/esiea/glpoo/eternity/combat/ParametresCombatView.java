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

public class ParametresCombatView extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7619139499343220035L;
	private Joueur joueurHaut, joueurBas;
	private int nbPkmnH, nbPkmnB;
	
	private JLabel nom;
	private JLabel type;
	private JLabel nbPkmn;
	
	private JLabel jh;
	private JTextField nomJH;
	private JRadioButton reelJH;
	private JRadioButton pnjJH;
	private ButtonGroup typeJH;
	private JTextField nbPkmnJH;
	
	private JLabel jb;
	private JTextField nomJB;
	private JRadioButton reelJB;
	private JRadioButton pnjJB;
	private ButtonGroup typeJB;
	private JTextField nbPkmnJB;
	
	private JButton okButton;
	
	private boolean pret;
	
	public ParametresCombatView () {
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
		
		this.setBounds(200,200,400,250);
		
		this.setVisible(true);
	}
	
	public JPanel getPanel() {
		JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
		
		nom = new JLabel("Nom");
		type = new JLabel("Type");
		nbPkmn = new JLabel("Nb pokemons");
		
		jh = new JLabel("Joueur haut");
		nomJH = new JTextField();	
		reelJH = new JRadioButton("Joueur");
	    pnjJH = new JRadioButton("Ordi");
		pnjJH.setSelected(true);
	    typeJH = new ButtonGroup();
	    typeJH.add(reelJH);
	    typeJH.add(pnjJH);	
		nbPkmnJH = new JTextField();
		
		jb = new JLabel("Joueur bas");
		nomJB = new JTextField();	
		reelJB = new JRadioButton("Joueur");
		reelJB.setSelected(true);
	    pnjJB = new JRadioButton("Ordi");
	    typeJB = new ButtonGroup();
	    typeJB.add(reelJB);
	    typeJB.add(pnjJB);	
		nbPkmnJB = new JTextField();
		
		okButton = new JButton("OK");
		okButton.addActionListener(this);
		
		panel.add(new JLabel());
		panel.add(jh);
		panel.add(jb);
		
		panel.add(nom);
		panel.add(nomJH);
		panel.add(nomJB);
		
		panel.add(type);
		panel.add(reelJH);
		panel.add(reelJB);
		
		panel.add(new JLabel());
		panel.add(pnjJH);
		panel.add(pnjJB);
		
		panel.add(nbPkmn);
		panel.add(nbPkmnJH);
		panel.add(nbPkmnJB);
		
		panel.add(new JLabel());
		panel.add(okButton);
		
		return panel;
	}

	public void actionPerformed(ActionEvent e) {
		ArrayList<String> erreurs = new ArrayList<String>();
		
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
		}
		
	}
}
