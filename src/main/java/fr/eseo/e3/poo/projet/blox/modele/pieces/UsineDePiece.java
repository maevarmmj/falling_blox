package fr.eseo.e3.poo.projet.blox.modele.pieces;


import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.pieces.pentominos.FPentomino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.pentominos.XPentomino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.pentominos.WPentomino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.pentominos.TPentomino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.pentominos.IPentomino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.pentominos.LPentomino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.pentominos.NPentomino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.pentominos.PPentomino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.pentominos.UPentomino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.pentominos.VPentomino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.pentominos.YPentomino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.pentominos.ZPentomino;

import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.JTetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.LTetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.OTetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.ITetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.TTetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.ZTetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.STetromino;

import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.Tetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.pentominos.Pentomino;


import java.util.Random;

public class UsineDePiece {

    public static final int ALEATOIRE_PIECE = 0, ALEATOIRE_COMPLET = 1, CYCLIC = 2;
    private static int modeDefault = ALEATOIRE_PIECE;
    private static final Couleur[] COULEURTETRO = Couleur.values();


    private static Random ran = new Random();
    private static int randCouleur = ran.nextInt(7);
    private static int rand = ran.nextInt(7);
    private static int tetroIndex = 0;


    private static final Couleur[] COULEURPENTOTAB = Couleur.values();
    private static int pentoIndex = 0;
    private static int randPento = ran.nextInt(12);
    private static int randCouleurpento = ran.nextInt(12);


    private UsineDePiece() { //RIEN DEDANS
    }

    public static void setMode(int mode) {
        if (mode > 2) {
            throw new IllegalArgumentException("Mode 0, 1 ou 2 autorisés");
        }

        modeDefault = mode;
    }


    public static Tetromino genererTetromino() {
        Tetromino tetromino; //initialisation tetromino

        Coordonnees coord = new Coordonnees(2, 3);
        Tetromino[] tetrominosTab = new Tetromino[7];

        tableauTetro(tetrominosTab);

        switch (modeDefault) { //on va générer le tetromino selon le mode

            case ALEATOIRE_COMPLET:

                Tetromino tetrominoAc = tetrominosTab[rand];
                tetrominoAc.getElements()[0].setCouleur(COULEURTETRO[randCouleur]);
                for (int i = 1; i < 4; i++) {
                    tetrominoAc.getElements()[i].setCouleur(tetrominoAc.getElements()[0].getCouleur());
                }

                tetromino = tetrominoAc;
                rand = ran.nextInt(7);
                randCouleur = ran.nextInt(7);
                break;

            case CYCLIC:

                if (tetroIndex >= tetrominosTab.length || tetroIndex == 0) {
                    tetroIndex = 0;
                }
                tetromino = tetrominosTab[tetroIndex];
                tetroIndex++;
                break;

            case ALEATOIRE_PIECE:
            default:
                tetromino = tetrominosTab[rand];
                rand = ran.nextInt(7);
                break;
        }

        return tetromino;
    }

    public static Pentomino genererPentomino() {
        Pentomino pentomino; //init pentominosTab

        Pentomino[] pentominosTab = new Pentomino[12];

        tableauPento(pentominosTab);

        switch (modeDefault) { //on va générer le pentomino selon le mode

            case ALEATOIRE_COMPLET:

                Pentomino pentominoAc = pentominosTab[randPento];
                pentominoAc.getElements()[0].setCouleur(COULEURPENTOTAB[randCouleurpento]);
                for (int i = 1; i < 5; i++) {
                    pentominoAc.getElements()[i].setCouleur(pentominoAc.getElements()[0].getCouleur());
                }

                pentomino = pentominoAc;
                randPento = ran.nextInt(12);
                randCouleurpento = ran.nextInt(12);
                break;

            case CYCLIC:

                if (pentoIndex >= pentominosTab.length || pentoIndex == 0) {
                    pentoIndex = 0;
                }
                pentomino = pentominosTab[pentoIndex];
                pentoIndex++;
                break;

            case ALEATOIRE_PIECE:
            default:
                pentomino = pentominosTab[randPento];
                randPento = ran.nextInt(12);
                break;
        }
        return pentomino;
    }

    public static void tableauPento(Pentomino[] pentominosTab){
        Coordonnees coord = new Coordonnees(2, 3);

        pentominosTab[0] = new FPentomino(coord, Couleur.ROUGE);
        pentominosTab[1] = new IPentomino(coord, Couleur.BLEU);
        pentominosTab[2] = new LPentomino(coord, Couleur.VIOLET);
        pentominosTab[3] = new NPentomino(coord, Couleur.VERT);
        pentominosTab[4] = new PPentomino(coord, Couleur.JAUNE);
        pentominosTab[5] = new TPentomino(coord, Couleur.CYAN);
        pentominosTab[6] = new UPentomino(coord, Couleur.ROUGE);
        pentominosTab[7] = new VPentomino(coord, Couleur.BLEU);
        pentominosTab[8] = new WPentomino(coord, Couleur.VIOLET);
        pentominosTab[9] = new XPentomino(coord, Couleur.VERT);
        pentominosTab[10] = new YPentomino(coord, Couleur.JAUNE);
        pentominosTab[11] = new ZPentomino(coord, Couleur.CYAN);
    }

    public static void tableauTetro(Tetromino[] tetrominosTab){
        Coordonnees coord = new Coordonnees(2, 3);

        tetrominosTab[0] = new OTetromino(coord, Couleur.ROUGE);
        tetrominosTab[1] = new ITetromino(coord, Couleur.ORANGE);
        tetrominosTab[2] = new TTetromino(coord, Couleur.BLEU);
        tetrominosTab[3] = new LTetromino(coord, Couleur.VERT);
        tetrominosTab[4] = new JTetromino(coord, Couleur.JAUNE);
        tetrominosTab[5] = new ZTetromino(coord, Couleur.CYAN);
        tetrominosTab[6] = new STetromino(coord, Couleur.VIOLET);
    }
}