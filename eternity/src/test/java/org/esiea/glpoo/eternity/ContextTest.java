package org.esiea.glpoo.eternity;

import org.esiea.glpoo.eternity.combat.ActionPanel;
import org.esiea.glpoo.eternity.combat.Context;
import org.esiea.glpoo.eternity.combat.Joueur;
import org.esiea.glpoo.eternity.combat.JoueurReel;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ContextTest extends TestCase
{
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ContextTest( String ContextTest )
    {
        super( ContextTest );
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
    	
    }
    
    
    public  void testgetPokemonAleatoire ()
    {
    	  
    }
}
