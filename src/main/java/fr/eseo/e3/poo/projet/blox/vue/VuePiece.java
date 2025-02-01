package fr.eseo.e3.poo.projet.blox.vue;


import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import java.awt.Graphics2D;
import java.awt.Color;

public class VuePiece {

    public static final double MULTIPLIER_TEINTE = 0.3;
    private final int taille;
    private final Piece piece;

    //CONSTRUCTEUR
    public VuePiece(Piece piece, int taille) {
        this.taille = taille;
        this.piece = piece;
    }

    //POUR MODIFIER LA TEINTE

    public static Color teinte(Color couleur) {
        int r = couleur.getRed();
        int g = couleur.getGreen();
        int b = couleur.getBlue();

        r = (int) (r + (255 - r) * MULTIPLIER_TEINTE);
        g = (int) (g + (255 - g) * MULTIPLIER_TEINTE);
        b = (int) (b + (255 - b) * MULTIPLIER_TEINTE);

        return new Color(r, g, b);
    }

    public static Color transparence(Color couleur) {
        int alpha = couleur.getAlpha();

        alpha = 100;

        return new Color(couleur.getRed(), couleur.getGreen(), couleur.getBlue(), alpha);
    }

    //AFFICHAGE

    public void afficherPiece(Graphics2D g2D) { //pour faire des formes on a besoin de la classe Graphics

        g2D.setColor(teinte(piece.getElements()[0].getCouleur().getCouleurPourAffichage()));
        g2D.fill3DRect(piece.getElements()[0].getCoordonnees().getAbscisse() * taille,
                piece.getElements()[0].getCoordonnees().getOrdonnee() * taille, taille, taille, true);
        for (int i = 1; i < piece.getElements().length; i++) {
            g2D.setColor(piece.getElements()[0].getCouleur().getCouleurPourAffichage());
            g2D.fill3DRect(piece.getElements()[i].getCoordonnees().getAbscisse() * taille,
                    piece.getElements()[i].getCoordonnees().getOrdonnee() * taille, taille, taille, true);
        }

    }
}