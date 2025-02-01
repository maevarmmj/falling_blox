
package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Puits {

    //ATTRIBUTS


    public static final int LARGEUR_PAR_DEFAUT = 5;
    public static final int PROFONDEUR_PAR_DEFAUT = 15;
    private Piece pieceSuivante;
    private Piece pieceActuelle;

    private int largeur;
    private int profondeur;

    public static final String MODIFICATION_PIECE_ACTUELLE = "pieceActuelle";
    public static final String MODIFICATION_PIECE_SUIVANTE = "pieceSuivante";

    private PropertyChangeSupport pcs;

    private PropertyChangeSupport pcsInfo;

    private Tas tas;

    private final int lvl = 2;


    //CONSTRUCTEUR

    public Puits() {
        this.largeur = LARGEUR_PAR_DEFAUT;
        this.profondeur = PROFONDEUR_PAR_DEFAUT;
        this.pcs = new PropertyChangeSupport(this);
        this.pcsInfo = new PropertyChangeSupport(this);
        this.tas = new Tas(this);

    }

    public Puits(int largeur, int profondeur) {
        if (largeur < 5 || largeur > 15) {
            throw new IllegalArgumentException("La largeur doit être comprise entre 5 et 15");
        }
        if (profondeur < 15 || profondeur > 25) {
            throw new IllegalArgumentException("La profondeur doit être comprise entre 15 et 25");
        }
        this.largeur = largeur;
        this.profondeur = profondeur;
        this.pcs = new PropertyChangeSupport(this);
        this.pcsInfo = new PropertyChangeSupport(this);
        this.tas = new Tas(this);

    }

    public Puits(int largeur, int profondeur, int nbElements, int nbLignes) {
        if (largeur < 5 || largeur > 15) {
            throw new IllegalArgumentException("La largeur doit être comprise entre 5 et 15");
        }
        if (profondeur < 15 || profondeur > 25) {
            throw new IllegalArgumentException("La profondeur doit être comprise entre 15 et 25");
        }

        this.largeur = largeur;
        this.profondeur = profondeur;
        this.pcs = new PropertyChangeSupport(this);
        this.pcsInfo = new PropertyChangeSupport(this);
        this.tas = new Tas(this, nbElements, nbLignes);
    }


    public String toString() {
        String message = "";
        message += "Puits : Dimension " + getLargeur() + " x " + getProfondeur() + "\n";
        if (getPieceActuelle() == null) {
            message += "Piece Actuelle : <aucune>\n";
        } else {
            message += "Piece Actuelle : " + getPieceActuelle().toString();
        }

        if (getPieceSuivante() == null) {
            message += "Piece Suivante : <aucune>\n";
        } else {
            message += "Piece Suivante : " + getPieceSuivante().toString();
        }
        return message;
    }


    //ACCESSEURS ET MUTATEURS
    public int getLargeur() {
        if (largeur < 5 || largeur > 15) {
            throw new IllegalArgumentException("La largeur doit être comprise entre 5 et 15");
        }
        return largeur;
    }

    public void setLargeur(int largeur) {
        if (largeur < 5 || largeur > 15) {
            throw new IllegalArgumentException("La largeur doit être comprise entre 5 et 15");
        }
        this.largeur = largeur;
    }

    public int getProfondeur() {
        if (profondeur < 15 || profondeur > 25) {
            throw new IllegalArgumentException("La profondeur doit être comprise entre 15 et 25");
        }
        return profondeur;
    }

    public void setProfondeur(int profondeur) {

        if (profondeur < 15 || profondeur > 25) {
            throw new IllegalArgumentException("La profondeur doit être comprise entre 15 et 25");
        }
        this.profondeur = profondeur;
    }


    public String getMODIFICATIONPIECEACTUELLE() {
        return MODIFICATION_PIECE_ACTUELLE;
    }

    public String getMODIFICATIONPIECESUIVANTE() {
        return MODIFICATION_PIECE_SUIVANTE;
    }

    public Tas getTas() {
        return tas;
    }

    public void setTas(Tas tas) {
        this.tas = tas;
    }


    //**************************************//

    //ACCESSEURS PIECES

    public Piece getPieceActuelle() {
        return pieceActuelle;
    }

    public Piece getPieceSuivante() {
        return pieceSuivante;
    }


    public void setPieceSuivante(Piece pieceSuivante) {
        if (this.pieceSuivante != null) {
            Piece oldPiece = this.pieceActuelle;
            this.pieceActuelle = this.pieceSuivante;
            this.pieceActuelle.setPuits(this);
            pieceActuelle.setPosition(getLargeur() / 2, -4);
            pcs.firePropertyChange(MODIFICATION_PIECE_ACTUELLE, oldPiece, this.pieceActuelle);
            pcsInfo.firePropertyChange(MODIFICATION_PIECE_ACTUELLE, oldPiece, this.pieceActuelle);

        }
        pcs.firePropertyChange(MODIFICATION_PIECE_SUIVANTE, this.pieceSuivante, pieceSuivante);
        pcsInfo.firePropertyChange(MODIFICATION_PIECE_SUIVANTE, this.pieceSuivante, pieceSuivante);
        this.pieceSuivante = pieceSuivante;
        this.pieceSuivante.setPuits(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
        pcsInfo.addPropertyChangeListener(listener);

    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
        pcsInfo.removePropertyChangeListener(listener);

    }

    private void gererCollision() {
        if (pieceActuelle != null) {
            this.tas.ajouterElements(pieceActuelle);
            if (tas.getLignesEntieres() % lvl == 0 && tas.getLignesEntieres() != 0) {
                this.setPieceSuivante(UsineDePiece.genererPentomino());
            } else {
                this.setPieceSuivante(UsineDePiece.genererTetromino());
            }
        }
    }

    public void gravite() throws BloxException {
        if (pieceActuelle != null) {

            try {
                this.pieceActuelle.deplacerDe(0, 1);
            } catch (BloxException ex) {
                this.gererCollision();
            }
        }}

    public int getLvl() {
        return lvl;
    }
}




