package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PanneauInformation extends JPanel implements PropertyChangeListener {
    private static final Dimension PREFERRED_SIZE = new Dimension(70, 70);
    private static final Color COULEUR_TEXTE = Color.BLACK;
    private static final Font FONT_SCORE = new Font("Calibri", Font.BOLD, 13);
    private static final Font FONT_PAUSE = new Font("Calibri", Font.BOLD, 8);
    private static final String STRING_PAUSE = "To pause the game, press the space bar!";

    private final Puits puits;
    private VuePiece vuePiece;

    public PanneauInformation(Puits puits) {
        this.puits = puits;
        puits.addPropertyChangeListener(this);
        this.setPreferredSize(PREFERRED_SIZE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g.create();

        if (vuePiece != null) {
            vuePiece.afficherPiece(g2D);
        }

        g2D.setColor(COULEUR_TEXTE);
        g2D.setFont(FONT_SCORE);
        g2D.drawString("SCORE: " + puits.getTas().getCompteurJeu(), 10, 90);
        g2D.drawString("LEVEL: " + puits.getTas().getNiveau(), 10, 100);

        g2D.setFont(FONT_PAUSE);

        String[] instructions = STRING_PAUSE.split(", "); //on coupe à la virgule
        for (int i = 0; i < instructions.length; i++) {
            g2D.drawString(instructions[i], 5, 120 + (i * 10));
        }

        g2D.dispose();
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        if (Puits.MODIFICATION_PIECE_SUIVANTE.equals(event.getPropertyName())) {
            Piece piece = (Piece) event.getNewValue();
            this.vuePiece = new VuePiece(piece, 10);
            SwingUtilities.invokeLater(this::repaint);
        }
    }
}
