package fr.eseo.e3.poo.projet.blox.modele;

public class Coordonnees {
    private int abscisse;
    private int ordonnee;

    public Coordonnees(int abscisse, int ordonnee) {
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
    }

    public String toString() {
        return "(" + getAbscisse() + ", " + getOrdonnee() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordonnees that = (Coordonnees) o;
        return abscisse == that.abscisse && ordonnee == that.ordonnee;
    }

    public int hashCode() {
        return 961 + abscisse * 31 + ordonnee;
    }

    public int getAbscisse() {
        return abscisse;
    }

    public int getOrdonnee() {
        return ordonnee;
    }

    public void setAbscisse(int abscisse) {
        this.abscisse = abscisse;
    }

    public void setOrdonnee(int ordonnee) {
        this.ordonnee = ordonnee;
    }

}
