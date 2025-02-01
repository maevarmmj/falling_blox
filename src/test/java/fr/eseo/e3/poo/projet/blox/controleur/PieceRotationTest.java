package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.Tetromino;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;
import org.junit.jupiter.api.Test;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class PieceRotationTest {

    @Test
    private void testDeplacement() {
        UsineDePiece.setMode(1);
        Puits puits = new Puits(13,24);
        Tetromino tetro = UsineDePiece.genererTetromino();
        Tetromino tetro1 = UsineDePiece.genererTetromino();

        VuePuits vuepuits = new VuePuits(puits);
        puits.setPieceSuivante(tetro);
        puits.setPieceSuivante(tetro1);
        tetro.setPosition(10,10);


        JFrame f = new JFrame("Puits");
        f.setVisible(true);
        f.setSize(puits.getLargeur() * vuepuits.getTaille(), puits.getProfondeur() * vuepuits.getTaille());
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.add(vuepuits);

    }

    public PieceRotationTest() {
        testPanneau();
    }
    public void testPanneau () {
        testDeplacement();
    }

    public static void main (String [] args) {
        SwingUtilities.invokeLater(new Runnable () {
            @Override
            public void run() {
                new PieceRotationTest();
            }
        });
    }
}
