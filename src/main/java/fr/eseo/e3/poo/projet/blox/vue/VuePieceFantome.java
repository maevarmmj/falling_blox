package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Tas;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import java.awt.Graphics2D;
import java.awt.Color;


public class VuePieceFantome {

    private final int taille;
    private final Piece piece;

    //CONSTRUCTEUR
    public VuePieceFantome(Piece piece, int taille) {
        this.taille = taille;
        this.piece = piece;
    }

    public static Color transparence(Color couleur) {
        int alpha = couleur.getAlpha();
        alpha = 100;
        return new Color(couleur.getRed(), couleur.getGreen(), couleur.getBlue(), alpha);
    }


    public void afficherPieceFantome(Graphics2D g2D) {
        Piece pieceActuelle = this.piece;
        Tas tas = piece.getPuits().getTas();
        int profondeur = piece.getPuits().getProfondeur();

        int[] positionsBasses = new int[pieceActuelle.getElements().length];

        for (int i = 0; i < pieceActuelle.getElements().length; i++) {
            positionsBasses[i] = profondeur - 1;
        }

        for (int i = 0; i < pieceActuelle.getElements().length; i++) {
            int x = pieceActuelle.getElements()[i].getCoordonnees().getAbscisse();
            for (int y = pieceActuelle.getElements()[i].getCoordonnees().getOrdonnee() + 1; y < profondeur; y++) {
                if (tas.elementExists(x, y)) {
                    positionsBasses[i] = y - 1;
                    break;
                }
            }
        }
        int min = profondeur;
        for (int i = 0; i < pieceActuelle.getElements().length; i++) {
            int decalage = positionsBasses[i] - pieceActuelle.getElements()[i].getCoordonnees().getOrdonnee();
            if (decalage < min) {
                min = decalage;
            }
        }
      setPieceFantome(pieceActuelle, g2D, min);
    }

    public void setPieceFantome(Piece pieceActuelle, Graphics2D g2D, int min){
        for (int i = 0; i < pieceActuelle.getElements().length; i++) {
            int ordonneeNew = pieceActuelle.getElements()[i].getCoordonnees().getOrdonnee() + min;
            g2D.setColor(transparence(pieceActuelle.getElements()[i].getCouleur().getCouleurPourAffichage()));
            g2D.fill3DRect(pieceActuelle.getElements()[i].getCoordonnees().getAbscisse() * taille, ordonneeNew * taille, taille, taille, false);
        }
    }
}
