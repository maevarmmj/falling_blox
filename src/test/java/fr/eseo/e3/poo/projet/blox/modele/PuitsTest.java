package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.ITetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.OTetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.Tetromino;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuitsTest {

    @Test
    void testConstructeur1() {
        Puits puits1 = new Puits();
        assertEquals(puits1.getLargeur(), 5, "Test Largeur");
        assertEquals(puits1.getProfondeur(), 15, "Test Profondeur");
    }
    @Test
    void testConstructeurError() throws IllegalArgumentException{
        Puits puits2 = new Puits(5,15);
        assertEquals(puits2.getLargeur(),5,"Test exception Largeur");
        assertEquals(puits2.getProfondeur(),15,"Test exception Profondeur");
    }

    @Test
    void testConstructeur2(){
        Puits puits2 = new Puits(6,17);
        assertEquals(puits2.getLargeur(),6,"Test Largeur");
        assertEquals(puits2.getProfondeur(),17,"Test Profondeur");
        /*puits2.setLargeur(4);
        puits2.setProfondeur(20);
        assertEquals(puits2.getLargeur(),4,"Test exception Largeur");
        assertEquals(puits2.getProfondeur(),20,"Test exception Profondeur");*/
    }

    @Test
    void testPuits(){
        Tetromino itetromino = new ITetromino(new Coordonnees(5,6),Couleur.CYAN);
        Tetromino otetromino = new OTetromino(new Coordonnees(4,3),Couleur.BLEU);
        Tetromino itetromino1 = new ITetromino(new Coordonnees(7,2),Couleur.ROUGE);

        Puits puits = new Puits(6,17);
        puits.setPieceSuivante(itetromino);
        assertEquals(puits.toString(),"Puits : Dimension 6 x 17\n" +
                "Piece Actuelle : <aucune>\n" +
                "Piece Suivante : ITetromino :\n" +
                "\t(5, 6) - CYAN\n" +
                "\t(5, 5) - CYAN\n" +
                "\t(5, 4) - CYAN\n" +
                "\t(5, 7) - CYAN\n","Test itetromino");

        puits.setPieceSuivante(otetromino);
        assertEquals(puits.toString(),"Puits : Dimension 6 x 17\n" +
                "Piece Actuelle : ITetromino :\n" +
                "\t(3, -4) - CYAN\n" +
                "\t(3, -5) - CYAN\n" +
                "\t(3, -6) - CYAN\n" +
                "\t(3, -3) - CYAN\n" +
                "Piece Suivante : OTetromino :\n" +
                "\t(4, 3) - BLEU\n" +
                "\t(4, 2) - BLEU\n" +
                "\t(5, 3) - BLEU\n" +
                "\t(5, 2) - BLEU\n","Test otetromino");

        puits.setPieceSuivante(itetromino1);
        assertEquals(puits.toString(),"Puits : Dimension 6 x 17\n" +
                "Piece Actuelle : OTetromino :\n" +
                "\t(3, -4) - BLEU\n" +
                "\t(3, -5) - BLEU\n" +
                "\t(4, -4) - BLEU\n" +
                "\t(4, -5) - BLEU\n" +
                "Piece Suivante : ITetromino :\n" +
                "\t(7, 2) - ROUGE\n" +
                "\t(7, 1) - ROUGE\n" +
                "\t(7, 0) - ROUGE\n" +
                "\t(7, 3) - ROUGE\n");
    }
}
