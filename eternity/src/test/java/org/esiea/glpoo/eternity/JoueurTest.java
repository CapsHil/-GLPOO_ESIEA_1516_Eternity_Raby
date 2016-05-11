package org.esiea.glpoo.eternity;

import org.esiea.glpoo.eternity.combat.ActionPanel;
import org.esiea.glpoo.eternity.combat.Capacite;
import org.esiea.glpoo.eternity.combat.Joueur;
import org.esiea.glpoo.eternity.combat.JoueurPanel;
import org.esiea.glpoo.eternity.combat.JoueurReel;
import org.esiea.glpoo.eternity.combat.Pokemon;
import org.esiea.glpoo.eternity.combat.StatutJoueurEnum;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class JoueurTest  extends TestCase
{
	
	private Joueur joueur;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public JoueurTest( String JoueurTest )
    {
        super( JoueurTest );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( JoueurTest.class );
    }

    
    
    protected void setUp() throws Exception {
    	super.setUp();
    	this.joueur =  new JoueurReel("Joueur");
    	Joueur joueur2 =  new JoueurReel("Joueur2");
    	
    	ActionPanel actionPanel = new ActionPanel();
		this.joueur.initCombat(joueur2, false, actionPanel, 0);

    	
    }
    
    
    /**
     * Rigourous Test :-)
     */
    
    /* Capacite is set */
    public void testJoueur()
    {

        assertNotNull("Object not created", joueur);	
    }
    
    	
	public void testgetPokemon() {
		  assertNotNull("value is null", joueur.getNbPkmn());
	}
	
	public void testgetNbPkmn() {
			assertNull("value is null", joueur.getStatut());
	}
	
	public void testgetStatut() {
		  assertNotNull("value is null", joueur.getPanel());
	}
	
}