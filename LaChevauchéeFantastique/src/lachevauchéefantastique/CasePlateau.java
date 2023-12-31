/*
 * LA CHEVAUCHEE FANTASTIQUE, 03/12/2023, SARINENA-DUMAS-BRUNET MANQUAT
 */
package lachevauchéefantastique;

import java.awt.Color;

/**
 * Cette classe représente une case du damier qui peut être dans l'état
 * "allumée" ou "éteinte" ou "cavalier dessus".
 *
 * Elle utilise un attribut int nommé "etat" qui indique si la case est allumée
 * ou non et si il y a le cavalier
 *
 * @author rembr
 */
public class CasePlateau {

    private int etat; // 0 pour éteinte ; 1 pour allumer ; 2 pour cavalier

    /**
     * Cette méthode est un constructeur qui permet de créer une nouvelle case
     * automatiquement éteinte.
     */
    public CasePlateau() {
        this.etat = 0;
    }

    /**
     * Cette méthode permet d'allumer la case en la mettant dans l'état allumée
     * ("1"). Si la case était déjà allumée, la méthode ne fait rien.
     */
    public void activerCase() {
        this.etat = 1;
    }

    /**
     * Cette méthode permet d'éteindre la case en la mettant dans l'état éteint
     * ("0"). Si la case était déjà éteinte, la méthode ne fait rien.
     */
    public void eteindreCase() {
        this.etat = 0;
    }

    /**
     * Cette méthode permet de positionner le cavalier sur la case en faisant
     * passer son état a une valeure de 2.
     */
    public void positionnerCavalier() {
        this.etat = 2;
    }

    /**
     * Cette methode vérifie si la case est actuellement éteinte. Elle renvoie
     * true si la case est éteinte et inversement.
     *
     * @return renvoie true si eteinte ou false si allumée.
     */
    public boolean estEteint() {
        if (this.etat == 1) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * cette méthode permet de vérifier si il y a un cavalier sur la case
     *
     * @return elle retourne un true si il y a un cavalier sur la case et un
     * false si elle est allumée ou éteinte
     */
    public boolean estCavalier() {
        if (this.etat != 2) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Cette méthode renvoie l'état actuel de la case.
     *
     * @return renvoie 1 si la case est allumée ou 0 si éteinte ou 3 s'il y a le
     * cavalier dessus.
     */
    public int getEtat() {
        return etat;
    }

    /**
     * Cette methode permet d'afficher " " si la cellule est éteinte, O si
     * allumée et C s'il y a le cavalier
     *
     * @return " " si éteinte, "O" si allumée et "C"
     */
    @Override
    public String toString() {
        if (this.etat == 0) {
            return " ";
        } else if (this.etat == 1) {
            return "O";
        } else {
            return "C";
        }
    }
}
