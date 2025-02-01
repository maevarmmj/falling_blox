package fr.eseo.e3.poo.projet.blox;

import fr.eseo.e3.poo.projet.blox.controleur.Gravite;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.Tetromino;
import fr.eseo.e3.poo.projet.blox.vue.EcranPause;
import fr.eseo.e3.poo.projet.blox.vue.PanneauInformation;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;
import org.junit.jupiter.api.Test;

import javax.swing.JFrame;
import javax.swing.WindowConstants;


import java.awt.BorderLayout;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FallingBloxVersion1 {

    private static Puits puits;
    private static VuePuits vuePuits;
    private static Gravite gravite;
    private static PanneauInformation panneau;
    static Tetromino tetro1;
    static Tetromino tetro2;

    public FallingBloxVersion1() {
    }

    @Test
    public void startGame() {
        puits = new Puits(15, 25);
        vuePuits = new VuePuits(puits);
        gravite = new Gravite(vuePuits);

        panneau = new PanneauInformation(puits);

        UsineDePiece.setMode(UsineDePiece.ALEATOIRE_COMPLET);
        tetro1 = UsineDePiece.genererTetromino();
        tetro2 = UsineDePiece.genererTetromino();
        puits.setPieceSuivante(tetro1);
        puits.setPieceSuivante(tetro2);

        //CREATION DE LA FENETRE
        JFrame f = new JFrame("Falling Blox");
        vuePuits.setjFrame(f);

        f.setLayout(new BorderLayout());
        f.add(vuePuits, BorderLayout.CENTER);
        f.add(panneau, BorderLayout.EAST);

        f.setSize((int) (puits.getLargeur() * puits.getProfondeur() / 4.54 + puits.getLargeur() * vuePuits.getTaille()),
                (puits.getProfondeur() * puits.getLargeur() / 10 + puits.getProfondeur() * (vuePuits.getTaille())));
        f.setResizable(false); //peut pas modifier la taille
        f.setVisible(true);
        f.setLocationRelativeTo(null); //fenetre au centre de l'écran
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //fermer la fenetre permet d'arreter le jeu

        f.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    EcranPause ecranPause = new EcranPause();
                    ecranPause.setFrame2(f);
                    ecranPause.setGravite(gravite);
                    ecranPause.pressSpaceBar();
                    gravite.timerPause();
                    f.setEnabled(false);
                }
            }
        });
    }

    /*public static void main(String args[]) {
        FallingBloxVersion1.startGame();
    }*/
}