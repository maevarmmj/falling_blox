package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;
import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ITetrominoTest {

    @Test
    void testConstructeur(){
        Tetromino itetromino = new ITetromino(new Coordonnees(5,4), Couleur.CYAN);
        assertEquals(itetromino.toString(),"ITetromino :\n\t(5, 4) - CYAN\n\t(5, 3) - CYAN\n\t(5, 2) - CYAN\n\t(5, 5) - CYAN\n","Test toString");
    }

    @Test
    void testSetPosition(){
        Tetromino itetromino = new ITetromino(new Coordonnees(5,4),Couleur.CYAN);
        itetromino.setPosition(0,0);
        assertEquals(itetromino.toString(),"ITetromino :\n\t(0, 0) - CYAN\n\t(0, -1) - CYAN\n\t(0, -2) - CYAN\n\t(0, 1) - CYAN\n","Test toString");
    }

    @Test
    void testGetElement(){
        Tetromino itetromino = new ITetromino(new Coordonnees(5,4),Couleur.CYAN);
        assertEquals(itetromino.getElements()[1].getCoordonnees().getAbscisse(),5,"Test getElements");
        assertEquals(itetromino.getElements()[1].getCoordonnees().getOrdonnee(),3,"Test getElements");
    }
/*
    @Test
    void testDeplacementTetro() {
        Tetromino itetromino = new ITetromino(new Coordonnees(5,4),Couleur.CYAN);
        itetromino.deplacerDe(0,1);
        assertEquals(itetromino.getElements()[0].getCoordonnees().getAbscisse(),5, "test deplacement x");
        assertEquals(itetromino.getElements()[0].getCoordonnees().getOrdonnee(),5, "test deplacement y");
    }*/

    @Test
    void testRotation() throws BloxException {
        Tetromino itetromino = new ITetromino(new Coordonnees(0,0),Couleur.CYAN);
        itetromino.tourner(true);

        assertEquals(itetromino.getElements()[1].getCoordonnees().getAbscisse(),1, "1) test deplacement x case 0");
        assertEquals(itetromino.getElements()[1].getCoordonnees().getOrdonnee(),0, "1) test deplacement y case 0");

        assertEquals(itetromino.getElements()[2].getCoordonnees().getAbscisse(),2, "2) test deplacement x case 0");
        assertEquals(itetromino.getElements()[2].getCoordonnees().getOrdonnee(),0, "2) test deplacement y case 0");

        assertEquals(itetromino.getElements()[3].getCoordonnees().getAbscisse(),-1, "3) test deplacement x case 0");
        assertEquals(itetromino.getElements()[3].getCoordonnees().getOrdonnee(),0, "3) test deplacement y case 0");

        itetromino.tourner(true);
        assertEquals(itetromino.getElements()[1].getCoordonnees().getAbscisse(),0, "1) test deplacement x case 1");
        assertEquals(itetromino.getElements()[1].getCoordonnees().getOrdonnee(),1, "1) test deplacement y case 1");

        assertEquals(itetromino.getElements()[2].getCoordonnees().getAbscisse(),0, "2) test deplacement x case 1");
        assertEquals(itetromino.getElements()[2].getCoordonnees().getOrdonnee(),2, "2) test deplacement y case 1");

        assertEquals(itetromino.getElements()[3].getCoordonnees().getAbscisse(),0, "3) test deplacement x case 1");
        assertEquals(itetromino.getElements()[3].getCoordonnees().getOrdonnee(),-1, "3) test deplacement y case 1");

        itetromino.tourner(true);
        assertEquals(itetromino.getElements()[1].getCoordonnees().getAbscisse(),-1, "1) test deplacement x case 2");
        assertEquals(itetromino.getElements()[1].getCoordonnees().getOrdonnee(),0, "1) test deplacement y case 2");

        assertEquals(itetromino.getElements()[2].getCoordonnees().getAbscisse(),-2, "2) test deplacement x case 2");
        assertEquals(itetromino.getElements()[2].getCoordonnees().getOrdonnee(),0, "2) test deplacement y case 2");

        assertEquals(itetromino.getElements()[3].getCoordonnees().getAbscisse(),1, "3) test deplacement x case 2");
        assertEquals(itetromino.getElements()[3].getCoordonnees().getOrdonnee(),0, "3) test deplacement y case 2");

        itetromino.tourner(true);
        assertEquals(itetromino.getElements()[1].getCoordonnees().getAbscisse(),0, "1) test deplacement x case 3");
        assertEquals(itetromino.getElements()[1].getCoordonnees().getOrdonnee(),-1, "1) test deplacement y case 3");

        assertEquals(itetromino.getElements()[2].getCoordonnees().getAbscisse(),0, "2) test deplacement x case 3");
        assertEquals(itetromino.getElements()[2].getCoordonnees().getOrdonnee(),-2, "2) test deplacement y case 3");

        assertEquals(itetromino.getElements()[3].getCoordonnees().getAbscisse(),0, "3) test deplacement x case 3");
        assertEquals(itetromino.getElements()[3].getCoordonnees().getOrdonnee(),1, "3) test deplacement y case 3");
    }

    @Test
    void testOTetrotourner() throws BloxException {
        Tetromino otetro = new OTetromino(new Coordonnees(5,7),Couleur.CYAN);

        assertEquals(otetro.getElements()[1].getCoordonnees().getAbscisse(),5, "1) test deplacement x");
        assertEquals(otetro.getElements()[1].getCoordonnees().getOrdonnee(),6, "1) test deplacement x");

        otetro.tourner(true);
        assertEquals(otetro.getElements()[0].getCoordonnees().getAbscisse(),5, "1) test deplacement x");
        assertEquals(otetro.getElements()[0].getCoordonnees().getOrdonnee(),7, "1) test deplacement x");

        assertEquals(otetro.getElements()[1].getCoordonnees().getAbscisse(),5, "1) test deplacement x");
        assertEquals(otetro.getElements()[1].getCoordonnees().getOrdonnee(),6, "1) test deplacement x");

        otetro.tourner(false);

        assertEquals(otetro.getElements()[1].getCoordonnees().getAbscisse(),5, "1) test deplacement x");
        assertEquals(otetro.getElements()[1].getCoordonnees().getOrdonnee(),6, "1) test deplacement x");

    }

}
