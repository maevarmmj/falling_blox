package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;


public class PieceDeplacement extends MouseAdapter {


    private VuePuits vuePuits;
    private Puits puits;
    int colActuelle = 0;


    public PieceDeplacement(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
        this.puits = vuePuits.getPuits();
        vuePuits.addMouseMotionListener(this);
        vuePuits.addMouseWheelListener(this);
        vuePuits.addMouseListener(this);

    }

    @Override
    public void mouseMoved(MouseEvent e) { //qd on bouge le curseur (pcq mathis bah il était pas content qd j'ai écrit ma merde)
        if (vuePuits.getPuits().getPieceActuelle() != null) {

            if (colActuelle == 0) {
                colActuelle = e.getX() / vuePuits.getTaille();
            } else if (colActuelle < e.getX() / vuePuits.getTaille()) {
                try {
                    vuePuits.getPuits().getPieceActuelle().deplacerDe(1, 0);

                } catch (BloxException ex) {
                    throw new RuntimeException(ex);
                }
                vuePuits.repaint();
                colActuelle = e.getX() / vuePuits.getTaille();
            } else if (colActuelle > e.getX() / vuePuits.getTaille()) {
                try {
                    vuePuits.getPuits().getPieceActuelle().deplacerDe(-1, 0);

                } catch (BloxException ex) {
                    throw new RuntimeException(ex);
                }
                vuePuits.repaint();
                colActuelle = e.getX() / vuePuits.getTaille();


            }


        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        colActuelle = 0;

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

        if (vuePuits.getPuits().getPieceActuelle() != null) {

            if (e.getWheelRotation() > 0) {
                try {
                    vuePuits.getPuits().gravite();
                } catch (BloxException ex) {
                    throw new RuntimeException(ex);
                }
                vuePuits.repaint();
            }

        }
    }
}


