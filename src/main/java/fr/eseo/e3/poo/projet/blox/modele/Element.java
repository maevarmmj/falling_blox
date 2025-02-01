package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Arrays;
import java.util.Objects;

public class Element {

    private Couleur[] couleurTab = Couleur.values();
    private Couleur couleur;
    private Coordonnees coordonnees;

    public Element(Coordonnees coordonnees, Couleur couleur) {
        this.coordonnees = coordonnees;
        this.couleur = couleur;
    }

    public Element(Coordonnees coordonnees) {
        this.coordonnees = coordonnees;
        this.couleur = couleurTab[0];
    }

    public Element(int abscisse, int ordonnee) {
        this.coordonnees = new Coordonnees(abscisse, ordonnee);
        this.couleur = couleurTab[0];
    }

    public Element(int abscisse, int ordonnee, Couleur couleur) {
        this.coordonnees = new Coordonnees(abscisse, ordonnee);
        this.couleur = couleur;
    }


    public String toString() {
        return "(" + coordonnees.getAbscisse() + ", " + coordonnees.getOrdonnee() + ") - " + couleur;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return Arrays.equals(couleurTab, element.couleurTab) && couleur == element.couleur && Objects.equals(coordonnees, element.coordonnees);
    }

    public int hashCode() {
        return 961 + 31 * coordonnees.hashCode() + couleur.hashCode();
    }

    public void deplacerDe(int deltaX, int deltaY) {
        coordonnees.setAbscisse(getCoordonnees().getAbscisse() + deltaX);
        coordonnees.setOrdonnee(getCoordonnees().getOrdonnee() + deltaY);
    }


    //ACCESSEURS
    public Couleur getCouleur() {
        return couleur;
    }

    public Coordonnees getCoordonnees() {
        return coordonnees;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    public void setCoordonnees(Coordonnees coordonnees) {
        this.coordonnees = coordonnees;
    }
}
