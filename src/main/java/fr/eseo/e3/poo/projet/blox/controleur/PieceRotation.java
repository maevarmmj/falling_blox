package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.Tas;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.SwingUtilities;

public class PieceRotation extends MouseAdapter implements MouseListener {

    private VuePuits vuePuits;
    private Puits puits;

    public PieceRotation(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
        this.puits = vuePuits.getPuits();
        vuePuits.addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent event) {
        super.mouseClicked(event);

        if (vuePuits.getPuits().getPieceActuelle() != null) {

            if (SwingUtilities.isRightMouseButton(event)) {
                try {
                    vuePuits.getPuits().getPieceActuelle().tourner(true);

                } catch (BloxException e) {
                    throw new RuntimeException(e);
                }
                vuePuits.repaint();
            } else if (SwingUtilities.isLeftMouseButton(event)) {
                try {
                    vuePuits.getPuits().getPieceActuelle().tourner(false);

                } catch (BloxException e) {
                    throw new RuntimeException(e);
                }
                vuePuits.repaint();

            }

            clicMolette(event);
        }
    }

    public void clicMolette(MouseEvent event){
        if (SwingUtilities.isMiddleMouseButton(event)) {
            Piece pieceActuelle = vuePuits.getPuits().getPieceActuelle();
            Tas tas = puits.getTas();
            int profondeur = puits.getProfondeur();
            int deltaY = 0;

            try {
                int[] positionsBasses = new int[pieceActuelle.getElements().length];
                for (int i = 0; i < puits.getPieceActuelle().getElements().length; i++) {
                    positionsBasses[i] = profondeur;
                }

                //là on veut maj la positionBasse
                for (int i = 0; i < pieceActuelle.getElements().length; i++) {
                    int abs = pieceActuelle.getElements()[i].getCoordonnees().getAbscisse();
                    for (int ord = pieceActuelle.getElements()[i].getCoordonnees().getOrdonnee() + 1; ord < profondeur; ord++) {
                        if (tas.elementExists(abs, ord)) {
                            positionsBasses[i] = ord - 1;
                            break;
                        }
                    }
                }

                //decalage
                int min = profondeur;
                for (int i = 0; i < pieceActuelle.getElements().length; i++) {
                    int decalage = positionsBasses[i] - pieceActuelle.getElements()[i].getCoordonnees().getOrdonnee();
                    if (decalage < min) {
                        min = decalage;
                    }
                }

                while (deltaY < min) {
                    vuePuits.getPuits().gravite();
                    deltaY++;
                }

            } catch (BloxException e) {
                throw new RuntimeException(e);
            }
            vuePuits.repaint();

        }
    }
}