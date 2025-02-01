package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.BloxException;


import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece; //interface Piece

import static java.lang.StrictMath.abs;

public abstract class Tetromino implements Piece {
    private Element[] elements;
    Puits puits;


    public Tetromino(Coordonnees coordonnees, Couleur couleur) {
        elements = new Element[4];
        setElements(coordonnees, couleur);
    }

    protected abstract void setElements(Coordonnees coord, Couleur coul);

    public Element[] getElements() {
        return elements;
    }

    public String toString() {
        String message = "";
        for (Element element : elements) {
            message += "\t(" + element.getCoordonnees().getAbscisse() + ", " + element.getCoordonnees().getOrdonnee()
                    + ") - " + element.getCouleur() + "\n";
        }
        return message;
    }

    public void setPosition(int abscisse, int ordonnee) {
        setElements(new Coordonnees(abscisse, ordonnee), elements[0].getCouleur());
    }

    public Puits getPuits() {
        return puits;
    }

    public void setPuits(Puits puits) {
        this.puits = puits;
    }

    public void deplacerDe(int deltaX, int deltaY) throws BloxException {

        if (abs(deltaX) > 1 || deltaY < 0 || deltaY > 1) {
            throw new IllegalArgumentException("Déplacement > 1 !!!");
        }

        if (this.puits != null) {

            for (int i = 0; i < 4; i++) {

                if ((this.elements[i].getCoordonnees().getAbscisse() + deltaX + 1) > (puits.getLargeur())) {
                    throw new BloxException("Largeur du puits dépassée : à droite !", BloxException.BLOX_SORTIE_PUITS);

                } else if ((this.elements[i].getCoordonnees().getAbscisse() + deltaX) < 0) {
                    throw new BloxException("Largeur du puits dépassée : à gauche !", BloxException.BLOX_SORTIE_PUITS);

                } else if ((this.elements[i].getCoordonnees().getOrdonnee() + deltaY + 1) > puits.getProfondeur()) {

                    throw new BloxException("Fond du puits atteint", BloxException.BLOX_COLLISION);

                } else if (getPuits().getTas().elementExists(this.elements[i].getCoordonnees().getAbscisse() +
                        deltaX, this.elements[i].getCoordonnees().getOrdonnee())) {
                    throw new BloxException("Piece du tas atteinte par le côté", BloxException.BLOX_COLLISION);

                } else if (getPuits().getTas().elementExists(this.elements[i].getCoordonnees().getAbscisse(),
                        this.elements[i].getCoordonnees().getOrdonnee() + deltaY))
                    throw new BloxException("Piece du tas atteinte par le haut", BloxException.BLOX_COLLISION);

            }


        }
        for (int i = 0; i < 4; i++) {
            this.elements[i].deplacerDe(deltaX, deltaY);
        }

    }


    public void tourner(boolean sensHoraire) throws BloxException {

        int dx = this.elements[0].getCoordonnees().getAbscisse();
        int dy = this.elements[0].getCoordonnees().getOrdonnee();


        for (int i = 0; i < 4; i++) {
            this.elements[i].deplacerDe(-dx, -dy);
            int abs = this.elements[i].getCoordonnees().getAbscisse();
            int ord = this.elements[i].getCoordonnees().getOrdonnee();

            if (sensHoraire) {
                this.elements[i].getCoordonnees().setAbscisse(-ord);
                this.elements[i].getCoordonnees().setOrdonnee(abs);
            } else {
                this.elements[i].getCoordonnees().setAbscisse(ord);
                this.elements[i].getCoordonnees().setOrdonnee(-abs);
            }

            this.elements[i].deplacerDe(dx, dy);
        }

        //EXCEPTIONS

        if (this.puits != null) {
            for (int i = 0; i < elements.length; i++) {

                if ((this.elements[i].getCoordonnees().getAbscisse() >= puits.getLargeur())) {
                    this.tourner(!sensHoraire);
                    throw new BloxException("Largeur du puits dépassée : sortie à droite !",
                            BloxException.BLOX_SORTIE_PUITS);
                } else if (this.elements[i].getCoordonnees().getAbscisse() < 0) {
                    this.tourner(!sensHoraire);
                    throw new BloxException("Largeur du puits dépassée : sortie à gauche !",
                            BloxException.BLOX_SORTIE_PUITS);

                } else if (this.elements[i].getCoordonnees().getOrdonnee() > puits.getProfondeur() - 1) {
                    this.tourner(!sensHoraire);
                    throw new BloxException("Fond du puits atteint", BloxException.BLOX_COLLISION);

                } else if (getPuits().getTas().elementExists(this.elements[i].getCoordonnees().getAbscisse(),
                        this.elements[i].getCoordonnees().getOrdonnee())) {
                    this.tourner(!sensHoraire);
                    throw new BloxException("Piece du tas atteinte", BloxException.BLOX_COLLISION);
                }
            }
        }
    }


}





