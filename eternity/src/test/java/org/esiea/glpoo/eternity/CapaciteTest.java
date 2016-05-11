package org.esiea.glpoo.eternity;


import org.esiea.glpoo.eternity.combat.Capacite;
import org.esiea.glpoo.eternity.combat.Pokemon;
import org.esiea.glpoo.eternity.combat.PokemonCsv;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CapaciteTest    extends TestCase
{
	
	private Capacite capacite;
	private int soin = 10;
	private int degat = 1;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CapaciteTest( String Capacite )
    {
        super( Capacite );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( CapaciteTest.class );
    }

    
    
    protected void setUp() throws Exception {
    	super.setUp();
    	capacite = new Capacite("Pikachu",this.degat,this.soin);
    }
    
    
    /**
     * Rigourous Test :-)
     */
    
    /* Capacite is set */
    public void testCapacite()
    {
        assertNotNull("Object not created", capacite);	
    }
    
    /* degat is set */
    public void testhasAttaque()
    {
        assertNotNull("value is null", capacite.hasAttaque());
    }
    
     public void testhasAttaqueAndSup()
    {
    	boolean attaque = capacite.hasAttaque();
   		assertEquals(attaque, true);
    }
     
    /* Soin is set */
    public void testhasSoin()
    {
        assertNotNull("value is null", capacite.hasSoin());
        
    }
    
    public void testhasSoinAndSup()
    {
    	boolean soin = capacite.hasSoin();
  		assertEquals(soin, true);
    }
        
    /* valeur is set and correct */
    public void testgetValeurAppliquee()
    {
        assertEquals("Value is correct",this.soin, capacite.getValeurAppliquee(this.soin));	
    }
        
    
     /* soin > 0  */
    /*
    public void testSoigner()
    {
    	
    	PokemonCsv emmeteurCSV = new PokemonCsv("Bulbizarre",45,"./src/data/img/pokemon/bulbizarre.png","./src/data/img/pokemon/bulbizarre-dos.png",1,2,0,02);
    	PokemonCsv receveurCSV = new PokemonCsv("Salamèche",39,"./src/data/img/pokemon/salameche.png","./src/data/img/pokemon/salameche-dos.png",3,2,0,03);
    	Pokemon emmeteur = new Pokemon(emmeteurCSV);
    	Pokemon receveur = new Pokemon(receveurCSV);
    	
   		capacite.soigner(emmeteur,receveur );
    	
    }*/
       
    
    
}
