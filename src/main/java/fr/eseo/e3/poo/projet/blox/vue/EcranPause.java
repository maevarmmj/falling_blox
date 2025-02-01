package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.controleur.Gravite;


import javax.swing.JPanel;
import javax.swing.JFrame;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.BorderLayout;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EcranPause extends JPanel {

    private static final int LONGUEUR = 500;
    private static final int LARGEUR = 400;

    private int size = 50; //taille carré
    private int[] color = {100, 100, 100};

    private JFrame frame;

    private JFrame frame2;

    private Gravite gravite;

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g.create(); //On cree la copie 2D

        g2D.setBackground(Color.WHITE);

        g2D.setFont(new Font("Monospaced", Font.BOLD, 50));
        g2D.setColor(Color.BLACK);
        g2D.drawString("P A U S E", LONGUEUR / 8, LARGEUR / 2);

        g2D.setFont(new Font("Monospaced", Font.BOLD, 20));
        g2D.drawString("Press again to continue!", LONGUEUR / 8, (2 * LARGEUR) / 3);
    }

    public void pressSpaceBar() {
        JFrame f = new JFrame("Pause screen");
        f.setPreferredSize(new Dimension(LARGEUR, LONGUEUR));
        f.getContentPane().add(this, BorderLayout.CENTER);
        f.pack();
        f.setVisible(true);
        f.setLocationRelativeTo(null);

        f.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {

                if ((e.getKeyCode() == KeyEvent.VK_SPACE)) {
                    f.dispose();
                    frame2.setEnabled(true);
                    frame2.toFront();
                    gravite.timerPause();
                }

                repaint();
            }
        });
    }


    public void setFrame2(JFrame frame2) {
        this.frame2 = frame2;
    }

    public void setGravite(Gravite gravite) {
        this.gravite = gravite;
    }
}
