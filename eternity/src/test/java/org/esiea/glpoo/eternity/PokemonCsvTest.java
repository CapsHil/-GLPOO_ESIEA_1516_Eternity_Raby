package org.esiea.glpoo.eternity;

import org.esiea.glpoo.eternity.combat.Capacite;
import org.esiea.glpoo.eternity.combat.Pokemon;
import org.esiea.glpoo.eternity.combat.PokemonCsv;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class PokemonCsvTest    extends TestCase
{
	
	PokemonCsv pokemonCsv;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PokemonCsvTest( String pokemonCsv )
    {
        super( pokemonCsv );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( PokemonCsvTest.class );
    }
   
    protected void setUp() throws Exception {
    	super.setUp();
    	this.pokemonCsv = new PokemonCsv("Bulbizarre",45,"./src/data/img/pokemon/bulbizarre.png","./src/data/img/pokemon/bulbizarre-dos.png",1,2,0,2);
    }
    
    /**
     * Rigourous Test :-)
     */
    public void testPokemonCsv()
    {
        assertNotNull("Object created", this.pokemonCsv);
    }
    
    
    public void testgetCapaciteId() {
    	assertEquals("value incorrect",1,this.pokemonCsv.getCapaciteId(0));
	}

	public void testgetPv() {
		assertEquals("value incorrect",45,this.pokemonCsv.getPv());
	}

	public void testgetNom() {
		assertEquals("value incorrect","Bulbizarre",this.pokemonCsv.getNom());
	}

	public void testgetCheminImageFace() {
		assertEquals("value incorrect","./src/data/img/pokemon/bulbizarre.png",this.pokemonCsv.getCheminImageFace());
	}

	public void testgetCheminImageDos() {
		assertEquals("value incorrect","./src/data/img/pokemon/bulbizarre-dos.png",this.pokemonCsv.getCheminImageDos());
	}
    
}
