package org.esiea.glpoo.eternity;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class PokemonTest  extends TestCase
{
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PokemonTest( String PokemonTest )
    {
        super( PokemonTest );
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
