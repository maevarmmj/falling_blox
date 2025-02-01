package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.Tetromino;
import fr.eseo.e3.poo.projet.blox.vue.PanneauInformation;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;
import org.junit.jupiter.api.Test;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;


public class GraviteTest {

@Test
        void testGravite(){
        Puits puits = new Puits(15, 25, 5, 3);
        VuePuits vuePuits = new VuePuits(puits);
        Gravite gravite = new Gravite(vuePuits);

        PanneauInformation panneau = new PanneauInformation(puits);
        UsineDePiece.setMode(UsineDePiece.ALEATOIRE_PIECE);
        Tetromino tetro = UsineDePiece.genererTetromino();
        Tetromino tetro1 = UsineDePiece.genererTetromino();

        puits.setPieceSuivante(tetro);
        puits.setPieceSuivante(tetro1);

        JFrame f = new JFrame("test tas");
        f.setLayout(new BorderLayout());
        f.add(vuePuits, BorderLayout.CENTER);
        f.add(panneau, BorderLayout.EAST);
        f.setSize((int) (puits.getLargeur() * (vuePuits.getTaille() + 5.5)), (int) (puits.getProfondeur() * (vuePuits.getTaille() + 1.5)));
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
