package fr.eseo.e3.poo.projet.blox.modele;

import org.junit.jupiter.api.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CouleurTest {

    @Test
    void testCouleurConstructeur(){
        assertEquals(Couleur.ROUGE.getCouleurPourAffichage(), Color.RED ,"test rouge");
        assertEquals(Couleur.ORANGE.getCouleurPourAffichage(), Color.ORANGE ,"test");
        assertEquals(Couleur.BLEU.getCouleurPourAffichage(), Color.BLUE ,"test");
        assertEquals(Couleur.VERT.getCouleurPourAffichage(), Color.GREEN ,"test");
        assertEquals(Couleur.JAUNE.getCouleurPourAffichage(), Color.YELLOW ,"test");
        assertEquals(Couleur.CYAN.getCouleurPourAffichage(), Color.CYAN ,"test");
        assertEquals(Couleur.VIOLET.getCouleurPourAffichage(), Color.MAGENTA ,"test");
    }


}
