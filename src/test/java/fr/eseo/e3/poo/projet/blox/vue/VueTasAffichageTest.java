package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.Tetromino;
import org.junit.jupiter.api.Test;

import javax.swing.JFrame;
import javax.swing.WindowConstants;


public class VueTasAffichageTest {

    @Test
    void testTas(){
        Puits puits = new Puits(15,20,3,3);
        VuePuits vuePuits = new VuePuits(puits);
        UsineDePiece.setMode(UsineDePiece.CYCLIC);
        Tetromino tetro = UsineDePiece.genererTetromino();
        Tetromino tetro1 = UsineDePiece.genererTetromino();

        puits.setPieceSuivante(tetro);
        puits.setPieceSuivante(tetro1);

        JFrame f = new JFrame("test tas");
        f.add(vuePuits);
        f.setSize(puits.getLargeur() * vuePuits.getTaille(), puits.getProfondeur() * vuePuits.getTaille());
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
