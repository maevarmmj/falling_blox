package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Tas;

import java.awt.Color;
import java.awt.Graphics2D;


public class VueTas {

    private final Tas tas;
    private final VuePuits vuePuits;
    public static final double MULTIPLIER_NUANCE = 0.4;

    public VueTas(VuePuits vuePuits, int taille) {
        this.vuePuits = vuePuits;
        tas = vuePuits.getPuits().getTas();
        taille = vuePuits.getTaille();
    }

    public VueTas(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
        tas = vuePuits.getPuits().getTas();
    }

    public VuePuits getVuePuits() {
        return vuePuits;
    }

    public static Color nuance(Color color) {
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();

        r = (int) (r * (1 - MULTIPLIER_NUANCE));
        g = (int) (g * (1 - MULTIPLIER_NUANCE));
        b = (int) (b * (1 - MULTIPLIER_NUANCE));

        return new Color(r, g, b);
    }

    public void afficher(Graphics2D g2D) {
        if (!tas.getElements().isEmpty()) {

            for (int i = 0; i < tas.getElements().size(); i++) {
                g2D.setColor(nuance(tas.getElements().get(i).getCouleur().getCouleurPourAffichage()));
                g2D.fill3DRect(tas.getElements().get(i).getCoordonnees().getAbscisse() * vuePuits.getTaille(),
                        tas.getElements().get(i).getCoordonnees().getOrdonnee() * vuePuits.getTaille(),
                        vuePuits.getTaille(), vuePuits.getTaille(), false);
            }
        }

    }
}
