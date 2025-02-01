package fr.eseo.e3.poo.projet.blox.modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;



public class CoordonneesTest {
    @Test
    void testConstructeur(){
        Coordonnees coordonnees = new Coordonnees(2,6);
        assertEquals(coordonnees.getOrdonnee(), 6, "test ordonnées");
        assertEquals(coordonnees.getAbscisse(), 2, "test abscisse");
    }

    @Test
    void testToString(){
        Coordonnees coordonnees = new Coordonnees(2,6);
        assertEquals(coordonnees.toString(), "(2, 6)", "test tostring");
        coordonnees.setAbscisse(4);
        coordonnees.setOrdonnee(5);
        assertEquals(coordonnees.toString(), "(4, 5)", "test tostring");

    }

    @Test
    void testEquals(){
        Coordonnees coordonnees = new Coordonnees(2,6);
        Coordonnees coordonnees2 = new Coordonnees(2,6);
        Coordonnees coordonnees3 = new Coordonnees(5,10);
        assertEquals(coordonnees.hashCode(), 961+2*31+6, "test hashcode");
        assertEquals(coordonnees2.hashCode(), 961+2*31+6, "test hashcode");
        assertEquals(coordonnees3.hashCode(), 961+5*31+10, "test hashcode");

        assertTrue(coordonnees.equals(coordonnees2), "test equals true");
        assertFalse(coordonnees.equals(coordonnees3), "test equals false");
    }
}
