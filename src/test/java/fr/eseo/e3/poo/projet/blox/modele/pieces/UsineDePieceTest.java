package fr.eseo.e3.poo.projet.blox.modele.pieces;


import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.ITetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.OTetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.Tetromino;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class UsineDePieceTest {
    @Test
    void testGenererTetro2() {
        UsineDePiece.setMode(2);
        assertEquals(UsineDePiece.genererTetromino().toString(), "OTetromino :\n" +
                "\t(2, 3) - ROUGE\n" +
                "\t(2, 2) - ROUGE\n" +
                "\t(3, 3) - ROUGE\n" +
                "\t(3, 2) - ROUGE\n", "Test générer tetromino + toString");
    }

    @Test
    void testRatioAleatoirePiece() {
        double compteurItetromino = 0, compteurOtetromino = 0;

        Coordonnees coord = new Coordonnees(2, 3);
        Tetromino itetromino = new ITetromino(coord, Couleur.ORANGE);
        Tetromino otetromino = new OTetromino(coord, Couleur.ROUGE);

        Tetromino tetromino; //variable à comparer

        for (int i = 0; i < 10000; i++) {
            tetromino = UsineDePiece.genererTetromino();

            if (tetromino.getElements()[0].equals(otetromino.getElements()[0])) {
                compteurOtetromino++;
            } else if (tetromino.getElements()[0].equals(itetromino.getElements()[0])) {
                compteurItetromino++;
            }
        }
        System.out.println("Ratio OTETROMINO = " + (compteurOtetromino / (compteurOtetromino + compteurItetromino)) +
                "\nRatio ITETROMINO = " + (compteurItetromino / (compteurOtetromino + compteurItetromino)));
    }

    @Test
    void testRatioAleatoireComplet() {
        //Initialisation de tout
        Coordonnees coord = new Coordonnees(2, 3);
        Couleur[] couleurTab = Couleur.values();
        Couleur[] couleurTabTetro = new Couleur[7];

        for (int i = 0 ; i < 6 ; i++){
            couleurTabTetro[i] = couleurTab[i];
        }

        Tetromino[] otetrominos = new Tetromino[7];
        Tetromino[] itetrominos = new Tetromino[7];

        //Compteurs pour les tetros :
        int[] compteurOTetro = new int[7];
        int[] compteurITetro = new int[7];

        //Creation des tableaux avec chaque tetro
        for (int i = 0; i < 6; i++) {
            otetrominos[i] = new OTetromino(coord, couleurTabTetro[i]);
            itetrominos[i] = new ITetromino(coord, couleurTabTetro[i]);
            System.out.println(otetrominos[i].getElements()[0].getCouleur());
            System.out.println(itetrominos[i].getElements()[0].getCouleur());

        }
        Tetromino tetromino; //variable à comparer

        int length = 10000;

        for (int i = 0; i < length; i++) {
            UsineDePiece.setMode(1); //aléatoire complet
            tetromino = UsineDePiece.genererTetromino();

            for (int j = 0; j < 6; j++) {

                if (tetromino.getElements()[3].equals(otetrominos[j].getElements()[3])) {
                    compteurOTetro[j]++;
                } else if (tetromino.getElements()[3].equals(itetrominos[j].getElements()[3])) {
                    compteurITetro[j]++;
                }
            }
        }

        //Ratio de chaque apparition
        System.out.print("Compteur OTetro : [");
        int somme = 0;
        boolean verif = false;
        for (int i = 0; i < 6; i++) {
            float resultat1 = (float) compteurOTetro[i] / length;
            somme += compteurOTetro[i];
            if ((float) compteurOTetro[i] / length > 0.06 && (float) compteurOTetro[i] / length < 0.08) {
                verif = true;
            }
            assertTrue(verif, "test verif");
            System.out.print(resultat1 + ", ");

        }
        System.out.println("]");

        System.out.print("Compteur ITetro : [");
        for (int i = 0; i < 6; i++) {
            float resultat2 = (float) compteurITetro[i] / length;
            somme += compteurITetro[i];

            System.out.print(resultat2 + ", ");

        }
        System.out.println("]");

        //Test si la somme de tous les ratios = 1
        assertEquals(1, somme / length, "test somme compteurs");
    }
}