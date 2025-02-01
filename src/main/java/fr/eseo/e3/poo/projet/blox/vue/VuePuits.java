package fr.eseo.e3.poo.projet.blox.vue;


import fr.eseo.e3.poo.projet.blox.controleur.PieceDeplacement;
import fr.eseo.e3.poo.projet.blox.controleur.PieceRotation;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;


import javax.swing.JFrame;
import javax.swing.JPanel;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;


import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseListener;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;


public class VuePuits extends JPanel implements PropertyChangeListener {
    private Puits puits;
    public static final int TAILLE_PAR_DEFAUT = 30;

    private int taille;

    private JFrame jFrame;

    private VuePiece vuePiece;
    private VuePieceFantome vuePieceFantome;
    private final VueTas vueTas;

    private PieceDeplacement pieceDeplacement;
    private PieceRotation pieceRotation;

    private MouseMotionListener mml;
    private MouseWheelListener mwl;
    private MouseListener mlPieceD;
    private MouseListener mlPieceR;


    //Constructeurs


    public VuePuits(Puits puits) {
        this.taille = TAILLE_PAR_DEFAUT;
        this.puits = puits;
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(this.taille * puits.getLargeur(),
                this.taille * puits.getProfondeur()));
        puits.addPropertyChangeListener(this);
        pieceDeplacement = new PieceDeplacement(this);
        pieceRotation = new PieceRotation(this);

        this.mml = this.pieceDeplacement;
        this.mwl = this.pieceDeplacement;
        this.mlPieceD = this.pieceDeplacement;
        this.mlPieceR = this.pieceRotation;
        this.vueTas = new VueTas(this);


    }

    public VuePuits(Puits puits, int taille) {
        this.puits = puits;
        this.taille = taille;
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(this.taille * puits.getLargeur(),
                this.taille * puits.getProfondeur()));
        puits.addPropertyChangeListener(this);
        pieceDeplacement = new PieceDeplacement(this);
        pieceRotation = new PieceRotation(this);

        this.mml = this.pieceDeplacement;
        this.mwl = this.pieceDeplacement;
        this.mlPieceD = this.pieceDeplacement;
        this.mlPieceR = this.pieceRotation;
        this.vueTas = new VueTas(this);

    }

    public void setPuits(Puits puits) {
        this.puits.removePropertyChangeListener(this);
        this.removeMouseWheelListener(pieceDeplacement);
        this.removeMouseMotionListener(pieceDeplacement);
        this.removeMouseListener(pieceDeplacement);
        this.removeMouseListener(pieceRotation);
        this.puits = puits;
        pieceDeplacement = new PieceDeplacement(this);
        pieceRotation = new PieceRotation(this);

        puits.addPropertyChangeListener(this);
        this.mml = this.pieceDeplacement;
        this.mwl = this.pieceDeplacement;
        this.mlPieceD = this.pieceDeplacement;
        this.mlPieceR = this.pieceRotation;

        setPreferredSize(new Dimension(this.taille * puits.getLargeur(),
                this.taille * puits.getProfondeur()));
    }

    public void setTaille(int taille) {
        this.taille = taille;
        setPreferredSize(new Dimension(this.taille * puits.getLargeur(),
                this.taille * puits.getProfondeur()));
    }

    public Puits getPuits() {
        return puits;
    }

    public int getTaille() {
        return taille;
    }

    public VuePiece getVuePiece() {
        return vuePiece;
    }

    public VueTas getVueTas() {
        return vueTas;
    }

    private void setVuePiece(VuePiece vuePiece) {
        this.vuePiece = vuePiece;
    }

    private void setVuePieceFantome(VuePieceFantome vuePieceFantome) {
        this.vuePieceFantome = vuePieceFantome;
    }

    public JFrame getjFrame() {
        return jFrame;
    }

    public void setjFrame(JFrame jFrame) {
        this.jFrame = jFrame;
    }

    protected void paintComponent(Graphics g) { //pour faire des formes on a besoin de la classe Graphics
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g.create(); //On cree la copie 2D
        g2D.setColor(Color.WHITE);
        g2D.fillRect(0, 0, puits.getLargeur() * taille, puits.getProfondeur() * taille);

        for (int x = 0; x <= (puits.getLargeur() * taille) - 1; x += taille) {
            for (int y = 0; y <= (puits.getProfondeur() * taille) - 1; y += taille) {

                g2D.setColor(Color.LIGHT_GRAY);
                g2D.drawRect(x, y, taille, taille);
            }
        }
        if (vuePiece != null) {
            this.vuePiece.afficherPiece(g2D);
        }

        if (vuePieceFantome != null) {
            this.vuePieceFantome.afficherPieceFantome(g2D);
        }

        if (puits.getTas() != null)
            this.vueTas.afficher(g2D);

        this.endGame(g2D);

        g2D.dispose();
    }


    void endGame(Graphics2D g2D) {
        List<Element> piecesTas = puits.getTas().getElements();
        for (int i = 0; i < piecesTas.size(); i++) {
            if (piecesTas.get(i).getCoordonnees().getOrdonnee() <= 0) {

                if (this.jFrame != null) {
                    this.jFrame.removeAll();
                    g2D.setColor(new Color(255, 153, 156, 100));
                    g2D.fill3DRect(this.taille * puits.getLargeur() / 5, this.taille * puits.getProfondeur() / 7,
                            (this.taille * puits.getLargeur() * 2) / 3,
                            this.taille * puits.getProfondeur() / 3, true);

                    g2D.setColor(Color.BLACK);

                    g2D.setFont(new Font("Monospaced", Font.BOLD, (5 * this.getTaille()) / 6));
                    g2D.drawString("G A M E  O V E R !", this.taille * puits.getLargeur() / 4,
                            this.taille * puits.getProfondeur() / 4);

                    g2D.setFont(new Font("Monospaced", Font.BOLD, (4 * this.getTaille()) / 6));
                    g2D.drawString("t r y  a g a i n !", this.taille * puits.getLargeur() / 4,
                            (this.taille * puits.getProfondeur() + 4 * puits.getProfondeur()) / 4);


                    g2D.setFont(new Font("Monospaced", Font.BOLD, (2 * this.getTaille()) / 3));
                    g2D.drawString("SCORE: " + (puits.getTas().getCompteurJeu()),
                            (2 * this.taille * puits.getLargeur()) / 5, this.taille * puits.getProfondeur() / 3);
                    g2D.drawString("LEVEL: " + (puits.getTas().getNiveau()),
                            (2 * this.taille * puits.getLargeur()) / 5,
                            (this.taille * puits.getProfondeur() + 4 * puits.getProfondeur()) / 3);
                }

            }
        }
    }


    @Override
    public void propertyChange(PropertyChangeEvent event) {
        if ((event.getPropertyName().equals(puits.getMODIFICATIONPIECEACTUELLE()))) {
            setVuePiece(new VuePiece((Piece) event.getNewValue(), taille));
            setVuePieceFantome(new VuePieceFantome((Piece) event.getNewValue(), taille));

        }
    }
}