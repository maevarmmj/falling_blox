package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.Tas;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gravite implements ActionListener {

    private VuePuits vuePuits;
    private Puits puits;

    private Timer timer;
    private int periodicite;
    private static final int VIT_GRAVITE = 100;


    public Gravite(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
        this.puits = vuePuits.getPuits();
        this.periodicite = 200;
        timer = new Timer(this.periodicite, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            puits.gravite();
        } catch (BloxException e) {
            throw new RuntimeException(e);
        }
        vuePuits.repaint();
        setVitesse();
    }

    public int getPeriodicite() {
        return this.periodicite;
    }

    public void setPeriodicite(int periodicite) {
        this.periodicite = periodicite;
    }

    private void setVitesse() {
        Tas tas = puits.getTas();
        if (tas.getLignesEntieres() % puits.getLvl() == 0 && tas.getLignesEntieres() != 0 && periodicite > VIT_GRAVITE) {
            periodicite -= VIT_GRAVITE;
            timer.setDelay(periodicite);
            tas.setLignesEntieres(0);
        }
    }

    public void timerPause() {
        if (this.timer.isRunning()) {
            this.timer.stop();
        } else {
            this.timer.start();
        }
    }

}



