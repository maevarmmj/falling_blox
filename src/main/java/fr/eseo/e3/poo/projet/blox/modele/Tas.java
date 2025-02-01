package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Tas {
    private Puits puits;
    private List<Element> elements = new ArrayList<>();
    private int compteurJeu = 0, lignesEntieres = 0, niveau = 1;
    private static final int INCREMENT = 10, INCR_NIVEAU = 1, INCR_LIGNES = 1;
    private static final String MESSAGE_EX = "Nombre d'élements non correct";


    public Tas(Puits puits) {
        this.puits = puits;
    }

    public Tas(Puits puits, int nbElements) {

        this.puits = puits;
        int n = nbElements / puits.getLargeur() + 1;

        if (nbElements >= puits.getLargeur() * n)
            throw new IllegalArgumentException(MESSAGE_EX);

        construireTas(nbElements, n, new Random());
    }

    public Tas(Puits puits, int nbElements, int nbLignes) {
        if (nbElements >= puits.getLargeur() * nbLignes)
            throw new IllegalArgumentException(MESSAGE_EX);

        this.puits = puits;
        construireTas(nbElements, nbLignes, new Random());
    }

    public Tas(Puits puits, int nbElements, int nbLignes, Random rand) {
        if (nbElements >= puits.getLargeur() * nbLignes)
            throw new IllegalArgumentException(MESSAGE_EX);

        this.puits = puits;
        construireTas(nbElements, nbLignes, rand);
    }

    public Puits getPuits() {
        return puits;
    }

    public List<Element> getElements() {
        return elements;
    }
    private void construireTas(int nbElements, int nbLignes, Random rand) {
        if (nbElements >= puits.getLargeur() * nbLignes)
            throw new IllegalArgumentException(MESSAGE_EX);

        int nbElementsPlace = 0;

        while (nbElementsPlace < nbElements) {
            int ordon = puits.getProfondeur() - (rand.nextInt(nbLignes) + 1), absci = rand.nextInt(puits.getLargeur());
            if (!elementExists(absci, ordon)) {
                Element elementNew = new Element(absci, ordon);
                Couleur[] couleurTab = Couleur.values();
                elementNew.setCouleur(couleurTab[rand.nextInt(couleurTab.length)]);
                elements.add(nbElementsPlace, elementNew);
                nbElementsPlace++;
            }
        }
    }

    public boolean elementExists(int absci, int ordon) {
        for (Element element : elements) {
            if (element.getCoordonnees().getAbscisse() == absci && element.getCoordonnees().getOrdonnee() == ordon)
                return true;
        }
        return false;
    }
    void supprimerLignes() {
        for (int y = 0; y < puits.getProfondeur(); y++) {
            if (estLigneComplete(y)) {
                int finalY = y;
                elements.removeIf(element -> element.getCoordonnees().getOrdonnee() == finalY);
                for (Element element : elements) {
                    if (element.getCoordonnees().getOrdonnee() < finalY)
                        element.getCoordonnees().setOrdonnee(element.getCoordonnees().getOrdonnee() + 1);
                }
            }
        }
    }
    public void ajouterElements(Piece piece) {
        elements.addAll(Arrays.asList(piece.getElements()));
        supprimerLignes();
    }

    public boolean estLigneComplete(int y) {
        for (int x = 0; x < puits.getLargeur(); x++) {
            if (!elementExists(x, y))
                return false;
        }
        compteurJeu += INCREMENT;
        lignesEntieres += INCR_LIGNES;
        niveau += INCR_NIVEAU;

        return true;
    }

    public int getCompteurJeu() {
        return compteurJeu;
    }

    public int getLignesEntieres() {
        return lignesEntieres;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setLignesEntieres(int lignesEntieres) {
        this.lignesEntieres = lignesEntieres;
    }
}