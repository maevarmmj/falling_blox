package fr.eseo.e3.poo.projet.blox.modele;

import org.junit.jupiter.api.Test;

import java.util.Random;


public class TasTest {
    @Test
    void testPuits(){
        Puits puits = new Puits();
        Tas tas = new Tas(puits,2,3,new Random(3));
    }

    @Test
    void testPuits2(){
        Puits puits = new Puits();
        Tas tas = new Tas(puits,2);
    }


}
