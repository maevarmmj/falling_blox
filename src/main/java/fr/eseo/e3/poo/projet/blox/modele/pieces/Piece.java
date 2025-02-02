package fr.eseo.e3.poo.projet.blox.modele.pieces;


import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;

public interface Piece {

    Element[] getElements(); //meme synthaxe sans le corps de fonction dans une interface

    void setPosition(int abscisse, int ordonnee);

    Puits getPuits();

    void setPuits(Puits puits);

    void deplacerDe(int deltaX, int deltaY) throws BloxException;


    void tourner(boolean sensHoraire) throws BloxException; //true : sens horaire |false : sens anti-horaire


}
