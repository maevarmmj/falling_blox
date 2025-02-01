package fr.eseo.e3.poo.projet.blox.vue;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Puits;


import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.ITetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.OTetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.Tetromino;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VuePuitsTest {

    @Test
    void testVuePuits(){
        Puits puits = new Puits(10,20);
        VuePuits vuePuits = new VuePuits(puits);
        assertEquals(vuePuits.getTaille(),10,"test taille");
        assertEquals(vuePuits.getPuits().getLargeur(),10,"test dim puits largeur");
        assertEquals(vuePuits.getPuits().getProfondeur(),20,"test dim puits profondeur");
    }

    @Test
    void testVuePuitsPieces(){
        Puits puits = new Puits(10,20);
        VuePuits vuePuits = new VuePuits(puits);
        Tetromino itetro1 = new ITetromino(new Coordonnees(5,3),Couleur.VERT);
        Tetromino otetro2 = new OTetromino(new Coordonnees(3,6), Couleur.ROUGE);
        Tetromino otetro3 = new OTetromino(new Coordonnees(7,5),Couleur.CYAN);
        Tetromino itetro4 = new ITetromino(new Coordonnees(4,2),Couleur.ORANGE);
        vuePuits.getPuits().setPieceSuivante(itetro1);
        assertEquals(vuePuits.getPuits().toString(),"Puits : Dimension 10 x 20\n" +
                "Piece Actuelle : <aucune>\n" +
                "Piece Suivante :ITetromino :\n" +
                "    (5, 3) - VERT\n" +
                "    (5, 4) - VERT\n" +
                "    (5, 5) - VERT\n" +
                "    (5, 2) - VERT","test setPiece 1");

        vuePuits.getPuits().setPieceSuivante(otetro2);
        assertEquals(vuePuits.getPuits().toString(),"Puits : Dimension 10 x 20\n" +
                "Piece Actuelle :ITetromino :\n" +
                "    (5, -4) - VERT\n" +
                "    (5, -3) - VERT\n" +
                "    (5, -2) - VERT\n" +
                "    (5, -5) - VERT\n" +
                "Piece Suivante :OTetromino :\n" +
                "    (3, 6) - ROUGE\n" +
                "    (4, 6) - ROUGE\n" +
                "    (3, 7) - ROUGE\n" +
                "    (4, 7) - ROUGE","test setPiece 2");

        vuePuits.getPuits().setPieceSuivante(otetro3);
        assertEquals(vuePuits.getPuits().toString(),"Puits : Dimension 10 x 20\n" +
                "Piece Actuelle :OTetromino :\n" +
                "    (5, -4) - ROUGE\n" +
                "    (6, -4) - ROUGE\n" +
                "    (5, -3) - ROUGE\n" +
                "    (6, -3) - ROUGE\n" +
                "Piece Suivante :OTetromino :\n" +
                "    (7, 5) - CYAN\n" +
                "    (8, 5) - CYAN\n" +
                "    (7, 6) - CYAN\n" +
                "    (8, 6) - CYAN","test setPiece 3");

        vuePuits.getPuits().setPieceSuivante(itetro4);
        assertEquals(vuePuits.getPuits().toString(),"Puits : Dimension 10 x 20\n" +
                "Piece Actuelle :OTetromino :\n" +
                "    (5, -4) - CYAN\n" +
                "    (6, -4) - CYAN\n" +
                "    (5, -3) - CYAN\n" +
                "    (6, -3) - CYAN\n" +
                "Piece Suivante :ITetromino :\n" +
                "    (4, 2) - ORANGE\n" +
                "    (4, 3) - ORANGE\n" +
                "    (4, 4) - ORANGE\n" +
                "    (4, 1) - ORANGE","test setPiece 4");
    }

    @Test
    void testVuePuits2(){
        Puits puits = new Puits(10,19);
        VuePuits vuePuits = new VuePuits(puits,15);
        assertEquals(vuePuits.getTaille(),15,"test taille");
        vuePuits.setPuits(new Puits(14,18));
        vuePuits.setTaille(12);
        assertEquals(vuePuits.getTaille(),12,"test taille 2");
        assertEquals(vuePuits.getPuits().getLargeur(),14,"test dim puits largeur");
        assertEquals(vuePuits.getPuits().getProfondeur(),18,"test dim puits profondeur");
    }

    @Test
    void testTeinte(){
        Puits puits = new Puits();
        VuePuits vuepuits = new VuePuits(puits,20);
        Tetromino t = new OTetromino(new Coordonnees(4,5), Couleur.CYAN);
        VuePiece vuePiece = new VuePiece(t,20);


    }



}
