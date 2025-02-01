package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;


import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OTetrominoTest {

    @Test
    void testConstructeur(){
        OTetromino otetromino = new OTetromino(new Coordonnees(5,4), Couleur.CYAN);
        assertEquals(otetromino.toString(),"OTetromino :\n\t(5, 4) - CYAN\n\t(5, 3) - CYAN\n\t(6, 4) - CYAN\n\t(6, 3) - CYAN\n","Test toString");
    }

    @Test
    void testGetElement(){
        OTetromino otetromino = new OTetromino(new Coordonnees(5,4),Couleur.CYAN);
        assertEquals(otetromino.getElements()[1].getCoordonnees().getAbscisse(),5,"Test getElements");
    }

    @Test
    void testSetPosition(){
        Tetromino otetromino = new OTetromino(new Coordonnees(5,4),Couleur.CYAN);
        otetromino.setPosition(0,0);
        assertEquals(otetromino.toString(),"OTetromino :\n\t(0, 0) - CYAN\n\t(0, -1) - CYAN\n\t(1, 0) - CYAN\n\t(1, -1) - CYAN\n","Test toString");
    }

    @Test
    void testPuits(){
        Puits puits = new Puits();
        Puits puits2 = new Puits();

        Tetromino tetromino = new OTetromino(new Coordonnees(2,3),Couleur.CYAN);
        puits.setPieceSuivante(tetromino);
        assertEquals(tetromino.getPuits(), null, "test puits");
        tetromino.setPuits(puits2);
        assertEquals(tetromino.getPuits(), puits2, "test puits");

    }
}
