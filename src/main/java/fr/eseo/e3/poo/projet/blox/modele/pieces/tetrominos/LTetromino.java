package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;


import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class LTetromino extends Tetromino {

    public LTetromino(Coordonnees coordonees, Couleur couleur) {
        super(coordonees, couleur);
    }

    @Override
    protected void setElements(Coordonnees coord, Couleur coul) {
        this.getElements()[0] = new Element(new Coordonnees(coord.getAbscisse(), coord.getOrdonnee()), coul);
        this.getElements()[1] = new Element(new Coordonnees(coord.getAbscisse() + 1, coord.getOrdonnee()), coul);
        this.getElements()[2] = new Element(new Coordonnees(coord.getAbscisse(), coord.getOrdonnee() - 1), coul);
        this.getElements()[3] = new Element(new Coordonnees(coord.getAbscisse(), coord.getOrdonnee() - 2), coul);

    }

    public String toString() {
        return "LTetromino :\n" + super.toString();
    }
}
