package fr.eseo.e3.poo.projet.blox.modele;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
public class ElementTest {

    @Test
    void testConstructeur1(){
        Element element = new Element(new Coordonnees(14,15), Couleur.JAUNE);
        assertEquals(element.getCoordonnees().getAbscisse(), 14, "test abscisses");
        assertEquals(element.getCoordonnees().getOrdonnee(), 15, "test ordonnées");
        assertEquals(element.getCouleur(), Couleur.JAUNE, "test couleur");

    }

    @Test
    void testConstructeur3(){
        Element element = new Element(new Coordonnees(14,15));
        assertEquals(element.getCoordonnees().getAbscisse(), 14, "test abscisses");
        assertEquals(element.getCoordonnees().getOrdonnee(), 15, "test ordonnées");
        assertEquals(element.getCouleur(), Couleur.ROUGE, "test couleur");
    }

    @Test

    void testtoString(){
        Element element = new Element(new Coordonnees(14,15), Couleur.JAUNE);
        assertEquals(element.toString(), "(14, 15) - JAUNE", "test toString");

        Element element2 = new Element(new Coordonnees(4,5), Couleur.ROUGE);
        assertFalse(element.equals(element2),"test equals");
    }

    @Test
    void testHashCode(){
        Element element = new Element(new Coordonnees(14,15), Couleur.JAUNE);
        assertEquals(element.hashCode(), 961+31* new Coordonnees(14,15).hashCode()+Couleur.JAUNE.hashCode());
    }

    @Test
    void setElement(){
        Element element = new Element(new Coordonnees(14,15), Couleur.JAUNE);
        element.setCouleur(Couleur.ROUGE);
        element.setCoordonnees(new Coordonnees(4,5));
        assertEquals(element.getCouleur(), Couleur.ROUGE, "test toString");
        assertEquals(element.getCoordonnees(), new Coordonnees(4,5), "test toString");
    }

    @Test
    void constructeurInt(){
        Element element = new Element(12,12,Couleur.CYAN);
        assertEquals(element.getCoordonnees(),new Coordonnees(12,12), "test coordonnee");
        assertEquals(element.getCouleur(),Couleur.CYAN, "test couleur");

    }

    @Test
    void constructeurInt2(){
        Element element = new Element(12,12);
        assertEquals(element.getCoordonnees(),new Coordonnees(12,12), "test coordonnee");
        assertEquals(element.getCouleur(),Couleur.ROUGE, "test couleur");

    }


}
