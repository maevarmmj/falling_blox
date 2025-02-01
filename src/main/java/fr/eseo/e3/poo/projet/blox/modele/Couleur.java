package fr.eseo.e3.poo.projet.blox.modele;

import java.awt.Color;

public enum Couleur {
    ROUGE(Color.RED),
    ORANGE(Color.ORANGE),
    BLEU(Color.BLUE),
    VERT(Color.GREEN),
    JAUNE(Color.YELLOW),
    CYAN(Color.CYAN),
    VIOLET(Color.MAGENTA),
    BLEU_CLAIR(Color.BLUE.brighter()),
    CYAN_FONCE(Color.CYAN.darker()),
    ROSE(Color.PINK),
    VIOLET_FONCE(Color.MAGENTA.darker()),
    VERT_FONCE(Color.GREEN.darker());


    private final Color couleurPourAffichage;


    Couleur(Color couleurPourAffichage) {
        this.couleurPourAffichage = couleurPourAffichage;
    }

    public Color getCouleurPourAffichage() {
        return couleurPourAffichage;
    }
}
