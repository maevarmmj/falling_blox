package fr.eseo.e3.poo.projet.blox.modele.pieces.pentominos;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class FPentomino extends Pentomino {
    public FPentomino(Coordonnees coordonnees, Couleur couleur) {
        super(coordonnees, couleur);
    }

    @Override
    protected void setElements(Coordonnees coord, Couleur coul) {
        this.getElements()[0] = new Element(new Coordonnees(coord.getAbscisse(), coord.getOrdonnee()), coul);
        this.getElements()[1] = new Element(new Coordonnees(coord.getAbscisse() - 1, coord.getOrdonnee()), coul);
        this.getElements()[2] = new Element(new Coordonnees(coord.getAbscisse(), coord.getOrdonnee() + 1), coul);
        this.getElements()[3] = new Element(new Coordonnees(coord.getAbscisse(), coord.getOrdonnee() - 1), coul);
        this.getElements()[4] = new Element(new Coordonnees(coord.getAbscisse() + 1, coord.getOrdonnee() - 1), coul);


    }

    public String toString() {
        return "FPentomino :\n" + super.toString();
    }


}

