package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;


import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class STetromino extends Tetromino {

    public STetromino(Coordonnees coordonees, Couleur couleur) {
        super(coordonees, couleur);
    }

    @Override
    protected void setElements(Coordonnees coord, Couleur coul) {
        this.getElements()[0] = new Element(new Coordonnees(coord.getAbscisse(), coord.getOrdonnee()), coul);
        this.getElements()[1] = new Element(new Coordonnees(coord.getAbscisse() - 1, coord.getOrdonnee()), coul);
        this.getElements()[2] = new Element(new Coordonnees(coord.getAbscisse(), coord.getOrdonnee() - 1), coul);
        this.getElements()[3] = new Element(new Coordonnees(coord.getAbscisse() + 1, coord.getOrdonnee() - 1), coul);

    }

    public String toString() {
        return "STetromino :\n" + super.toString();
    }
}
