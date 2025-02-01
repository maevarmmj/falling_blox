package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;


import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.Tetromino;
import org.junit.jupiter.api.Test;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class VuePuitsAffichageTest {

    @Test
    private void testConstructeurPuits() {
        UsineDePiece.setMode(1); //mode aleatoire tot
        Tetromino tetro = UsineDePiece.genererTetromino(); //generer tetro
        Puits puits = new Puits(); //initiaisation puits 5x15
        VuePuits vuepuits = new VuePuits(puits);
        VueTas vueTas = new VueTas(vuepuits);
        puits.setPieceSuivante(tetro);


        JFrame f = new JFrame("Puits");
        f.setVisible(true);
        f.setSize(puits.getLargeur() * vuepuits.getTaille(), puits.getProfondeur() * vuepuits.getTaille());
        f.setLocationRelativeTo(null); //fenetre au centre de l'écran
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //appli s'arrête qd l'utilisateur ferme la fenêtre

        f.add(vuepuits);

    }

    @Test
    private void testConstructeurPuitsTaille() {
        UsineDePiece.setMode(1);
        Puits puits = new Puits(15, 25);
        Tetromino tetro = UsineDePiece.genererTetromino();
        int taille = 19;
        VuePuits vuepuits = new VuePuits(puits, taille);
        puits.setPieceSuivante(tetro);


        JFrame f = new JFrame("Puits et taille");
        f.setSize(puits.getLargeur() * vuepuits.getTaille(), puits.getProfondeur() * vuepuits.getTaille());
        f.setVisible(true);
        f.setLocationRelativeTo(null); //fenetre au centre de l'écran
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //appli s'arrête qd l'utilisateur ferme la fenêtre
        f.add(vuepuits);
    }

    public VuePuitsAffichageTest() {
        testPanneau();
    }

    public void testPanneau() {
        testConstructeurPuitsTaille();
        testConstructeurPuits();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VuePuitsAffichageTest();
            }
        });
    }
}

