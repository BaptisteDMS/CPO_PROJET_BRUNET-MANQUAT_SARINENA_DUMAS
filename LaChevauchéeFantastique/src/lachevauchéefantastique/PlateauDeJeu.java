/*
 * LA CHEVAUCHEE FANTASTIQUE, 03/12/2023, SARINENA-DUMAS-BRUNET MANQUAT
 */
package lachevauchéefantastique;

import java.util.Random;

/**
 * Cette classe représente un plateau (damier) de caseplateau. Ce plateau est
 * organisée en lignes et en colonnes.
 *
 * @author rembr
 */
public class PlateauDeJeu {

    public CasePlateau[][] matriceCase;
    int nbLignes;
    int nbColonnes;
    int position_verticale; //position verticale du cavalier sur le palteau
    int position_horizontale; //position horizontale du cavalier sur le plateau

    /**
     * Ce constructeur permet de créer une nouvelle grille de cellules
     * lumineuses avec un nombre spécifié de lignes et de colonnes.
     *
     * @param p_nbLignes est le nombre de lignes que l'on souhaite pour notre
     * plateau
     * @param p_nbColonnes est le nombre de colonnes que l'on souhaite pour
     * notre plateau
     */
    public PlateauDeJeu(int p_nbLignes, int p_nbColonnes, int pc_horizontale, int pc_verticale) {
        this.nbLignes = p_nbLignes;
        this.nbColonnes = p_nbColonnes;
        this.position_horizontale = pc_horizontale;
        this.position_verticale = pc_verticale;
        this.matriceCase = new CasePlateau[p_nbLignes][p_nbColonnes];

        // on créer le plateau constitué de ses cases
        for (int i = 0; i < p_nbLignes; i++) {
            for (int j = 0; j < p_nbColonnes; j++) {
                this.matriceCase[i][j] = new CasePlateau();
            }
        }

        // on positionne le cavalier sur le plateau
        this.matriceCase[this.position_verticale][this.position_horizontale].positionnerCavalier();
    }

    /**
     * Permet d'éteindre toutes les case du plateau en passant chaque case en
     * état "éteint".
     */
    public void eteindreToutesLesCases() {
        for (int i = 0; i < this.nbLignes; i++) {
            for (int j = 0; j < this.nbColonnes; j++) {
                if (this.matriceCase[i][j].getEtat() == 1) {
                    this.matriceCase[i][j].eteindreCase();
                }
            }
        }
    }

    /**
     * Permet d'activer de manière aléatoire une case du plateau non alluméee et
     * qui n'a pas le cavalier.
     */
    public void activerCaseAleatoire() {
        int caseActiver = 0;

        while (caseActiver == 0) {
            int nb_alea1;
            int nb_alea2;
            Random generateurAleat = new Random();
            nb_alea1 = generateurAleat.nextInt(this.nbLignes);
            nb_alea2 = generateurAleat.nextInt(this.nbColonnes);

            if (matriceCase[nb_alea1][nb_alea2].getEtat() == 0) {
                matriceCase[nb_alea1][nb_alea2].activerCase();
                caseActiver += 1;
            }
        }
    }

    /**
     * Permet de générer un plateau de case de manière aléatoire à partir d’un
     * nombre spécifié de tours.
     *
     * @param nbTours correspond au nombre de changement aléatoire effectué
     */
    public void melangerMatriceAleatoirement(int nbTours) {
        eteindreToutesLesCases();
        for (int i = 0; i < nbTours; i++) {
            activerCaseAleatoire();
        }
    }
    
    public void activerCaseAleatoireFantastique(){
        int nb_alea;
        int position_vert_variable=this.position_verticale;
        int position_hor_variable=this.position_horizontale;
        int mouv_interdit=-1;
        int activationCase=0;
        Random generateurAleat = new Random();
        nb_alea = generateurAleat.nextInt(8);
        
        
        while (activationCase==0){
            
        }
        if (nb_alea == 0) {
            // deplacemment Nord 1 (haut puis gauche)
            int position_vert_test = position_vert_variable - 2;
            int position_hor_test = position_hor_variable - 1;
            if (position_vert_test < this.nbLignes && position_vert_test > (-1) && position_hor_test < this.nbColonnes && position_hor_test > (-1)) {
                this.matriceCase[position_vert_test][position_hor_test].activerCase();
                position_hor_variable = position_hor_test;
                position_vert_variable = position_vert_test;
                mouv_interdit=3;
                activationCase+=1;
            }

        } else if (nb_alea == 1) {
            // deplacemment Nord 2 (haut puis droite)
            int nv_position_vert = this.position_verticale - 2;
            int nv_position_hor = this.position_horizontale + 1;
            if (nv_position_vert < this.nbLignes && nv_position_vert > (-1) && nv_position_hor < this.nbColonnes && nv_position_hor > (-1)) {
                this.matriceCase[this.position_verticale][this.position_horizontale].eteindreCase();
                this.matriceCase[nv_position_vert][nv_position_hor].positionnerCavalier();
                this.position_horizontale = nv_position_hor;
                this.position_verticale = nv_position_vert;
            }

        } else if (nb_alea == 2) {
            // deplacemment Sud 1 (bas puis gauche)
            int nv_position_vert = this.position_verticale + 2;
            int nv_position_hor = this.position_horizontale - 1;
            if (nv_position_vert < this.nbLignes && nv_position_vert > (-1) && nv_position_hor < this.nbColonnes && nv_position_hor > (-1)) {
                this.matriceCase[this.position_verticale][this.position_horizontale].eteindreCase();
                this.matriceCase[nv_position_vert][nv_position_hor].positionnerCavalier();
                this.position_horizontale = nv_position_hor;
                this.position_verticale = nv_position_vert;
            }

        } else if (nb_alea == 3) {
            // deplacemment Sud 2 (bas puis droite)
            int nv_position_vert = this.position_verticale + 2;
            int nv_position_hor = this.position_horizontale + 1;
            if (nv_position_vert < this.nbLignes && nv_position_vert > (-1) && nv_position_hor < this.nbColonnes && nv_position_hor > (-1)) {
                this.matriceCase[this.position_verticale][this.position_horizontale].eteindreCase();
                this.matriceCase[nv_position_vert][nv_position_hor].positionnerCavalier();
                this.position_horizontale = nv_position_hor;
                this.position_verticale = nv_position_vert;
            }

        } else if (nb_alea == 4) {
            // deplacemment Ouest 1 (gauche puis haut)
            int nv_position_vert = this.position_verticale - 1;
            int nv_position_hor = this.position_horizontale - 2;
            if (nv_position_vert < this.nbLignes && nv_position_vert > (-1) && nv_position_hor < this.nbColonnes && nv_position_hor > (-1)) {
                this.matriceCase[this.position_verticale][this.position_horizontale].eteindreCase();
                this.matriceCase[nv_position_vert][nv_position_hor].positionnerCavalier();
                this.position_horizontale = nv_position_hor;
                this.position_verticale = nv_position_vert;
            }

        } else if (nb_alea == 5) {
            // deplacemment Ouest 2 (gauche puis bas)
            int nv_position_vert = this.position_verticale + 1;
            int nv_position_hor = this.position_horizontale - 2;
            if (nv_position_vert < this.nbLignes && nv_position_vert > (-1) && nv_position_hor < this.nbColonnes && nv_position_hor > (-1)) {
                this.matriceCase[this.position_verticale][this.position_horizontale].eteindreCase();
                this.matriceCase[nv_position_vert][nv_position_hor].positionnerCavalier();
                this.position_horizontale = nv_position_hor;
                this.position_verticale = nv_position_vert;
            }

        } else if (nb_alea == 6) {
            // deplacemment Est 1 (droite puis haut)
            int nv_position_vert = this.position_verticale - 1;
            int nv_position_hor = this.position_horizontale + 2;
            if (nv_position_vert < this.nbLignes && nv_position_vert > (-1) && nv_position_hor < this.nbColonnes && nv_position_hor > (-1)) {
                this.matriceCase[this.position_verticale][this.position_horizontale].eteindreCase();
                this.matriceCase[nv_position_vert][nv_position_hor].positionnerCavalier();
                this.position_horizontale = nv_position_hor;
                this.position_verticale = nv_position_vert;
            }

        } else {
            // deplacemment Est 2 (droite puis bas)
            int nv_position_vert = this.position_verticale + 1;
            int nv_position_hor = this.position_horizontale + 2;
            if (nv_position_vert < this.nbLignes && nv_position_vert > (-1) && nv_position_hor < this.nbColonnes && nv_position_hor > (-1)) {
                this.matriceCase[this.position_verticale][this.position_horizontale].eteindreCase();
                this.matriceCase[nv_position_vert][nv_position_hor].positionnerCavalier();
                this.position_horizontale = nv_position_hor;
                this.position_verticale = nv_position_vert;
            }
        }
        
    }

    /**
     * Permet de vérifier si toutes les cases du plateau sont éteintes. Elle
     * retourne true si toutes les cellules sont éteintes, et false sinon. Elle
     * permet de tester même avec le cavalier.
     */
    public boolean CaseToutesEteintes() {
        int verif = 0;
        for (int i = 0; i < this.nbLignes; i++) {
            for (int j = 0; j < this.nbColonnes; j++) {
                if (this.matriceCase[i][j].estEteint() == false) {
                    verif += 1;
                }
            }
        }
        if (verif != 0) {
            return false;
        } else {
            return true;
        }
    }

    public void DeplacerCavalier(int option) {
        if (option == 0) {
            // deplacemment Nord 1 (haut puis gauche)
            int nv_position_vert = this.position_verticale - 2;
            int nv_position_hor = this.position_horizontale - 1;
            if (nv_position_vert < this.nbLignes && nv_position_vert > (-1) && nv_position_hor < this.nbColonnes && nv_position_hor > (-1)) {
                this.matriceCase[this.position_verticale][this.position_horizontale].eteindreCase();
                this.matriceCase[nv_position_vert][nv_position_hor].positionnerCavalier();
                this.position_horizontale = nv_position_hor;
                this.position_verticale = nv_position_vert;
            }

        } else if (option == 1) {
            // deplacemment Nord 2 (haut puis droite)
            int nv_position_vert = this.position_verticale - 2;
            int nv_position_hor = this.position_horizontale + 1;
            if (nv_position_vert < this.nbLignes && nv_position_vert > (-1) && nv_position_hor < this.nbColonnes && nv_position_hor > (-1)) {
                this.matriceCase[this.position_verticale][this.position_horizontale].eteindreCase();
                this.matriceCase[nv_position_vert][nv_position_hor].positionnerCavalier();
                this.position_horizontale = nv_position_hor;
                this.position_verticale = nv_position_vert;
            }

        } else if (option == 2) {
            // deplacemment Sud 1 (bas puis gauche)
            int nv_position_vert = this.position_verticale + 2;
            int nv_position_hor = this.position_horizontale - 1;
            if (nv_position_vert < this.nbLignes && nv_position_vert > (-1) && nv_position_hor < this.nbColonnes && nv_position_hor > (-1)) {
                this.matriceCase[this.position_verticale][this.position_horizontale].eteindreCase();
                this.matriceCase[nv_position_vert][nv_position_hor].positionnerCavalier();
                this.position_horizontale = nv_position_hor;
                this.position_verticale = nv_position_vert;
            }

        } else if (option == 3) {
            // deplacemment Sud 2 (bas puis droite)
            int nv_position_vert = this.position_verticale + 2;
            int nv_position_hor = this.position_horizontale + 1;
            if (nv_position_vert < this.nbLignes && nv_position_vert > (-1) && nv_position_hor < this.nbColonnes && nv_position_hor > (-1)) {
                this.matriceCase[this.position_verticale][this.position_horizontale].eteindreCase();
                this.matriceCase[nv_position_vert][nv_position_hor].positionnerCavalier();
                this.position_horizontale = nv_position_hor;
                this.position_verticale = nv_position_vert;
            }

        } else if (option == 4) {
            // deplacemment Ouest 1 (gauche puis haut)
            int nv_position_vert = this.position_verticale - 1;
            int nv_position_hor = this.position_horizontale - 2;
            if (nv_position_vert < this.nbLignes && nv_position_vert > (-1) && nv_position_hor < this.nbColonnes && nv_position_hor > (-1)) {
                this.matriceCase[this.position_verticale][this.position_horizontale].eteindreCase();
                this.matriceCase[nv_position_vert][nv_position_hor].positionnerCavalier();
                this.position_horizontale = nv_position_hor;
                this.position_verticale = nv_position_vert;
            }

        } else if (option == 5) {
            // deplacemment Ouest 2 (gauche puis bas)
            int nv_position_vert = this.position_verticale + 1;
            int nv_position_hor = this.position_horizontale - 2;
            if (nv_position_vert < this.nbLignes && nv_position_vert > (-1) && nv_position_hor < this.nbColonnes && nv_position_hor > (-1)) {
                this.matriceCase[this.position_verticale][this.position_horizontale].eteindreCase();
                this.matriceCase[nv_position_vert][nv_position_hor].positionnerCavalier();
                this.position_horizontale = nv_position_hor;
                this.position_verticale = nv_position_vert;
            }

        } else if (option == 6) {
            // deplacemment Est 1 (droite puis haut)
            int nv_position_vert = this.position_verticale - 1;
            int nv_position_hor = this.position_horizontale + 2;
            if (nv_position_vert < this.nbLignes && nv_position_vert > (-1) && nv_position_hor < this.nbColonnes && nv_position_hor > (-1)) {
                this.matriceCase[this.position_verticale][this.position_horizontale].eteindreCase();
                this.matriceCase[nv_position_vert][nv_position_hor].positionnerCavalier();
                this.position_horizontale = nv_position_hor;
                this.position_verticale = nv_position_vert;
            }

        } else {
            // deplacemment Est 2 (droite puis bas)
            int nv_position_vert = this.position_verticale + 1;
            int nv_position_hor = this.position_horizontale + 2;
            if (nv_position_vert < this.nbLignes && nv_position_vert > (-1) && nv_position_hor < this.nbColonnes && nv_position_hor > (-1)) {
                this.matriceCase[this.position_verticale][this.position_horizontale].eteindreCase();
                this.matriceCase[nv_position_vert][nv_position_hor].positionnerCavalier();
                this.position_horizontale = nv_position_hor;
                this.position_verticale = nv_position_vert;
            }
        }
    }

    /**
     * Permer d'afficher l'état du plateau de jeu sous forme d'une
     * représentation visuelle organisée. Elle crée une chaîne de caractères
     * avec des indices pour les lignes et les colonnes, ainsi que des
     * caractères " ", "O" et "C" pour représenter l'état des cellules.
     *
     * @return correspond à la grille de jeu à afficher
     */
    @Override
    public String toString() {
        String grille = "   |"; // initialistaion de la première ligne
        for (int i = 0; i < this.nbColonnes; i++) {
            grille += " " + i + " |";
        }

        grille += "\n";
        for (int i = 0; i < this.nbColonnes + 1; i++) {
            grille += "----";
        }

        for (int i = 0; i < this.nbLignes * 2; i++) {
            grille += "\n";
            if (i % 2 == 0) {
                for (int j = 0; j < this.nbColonnes + 1; j++) {
                    if (j == 0) {
                        grille += " " + i / 2 + " |";
                    } else {
                        grille += " " + this.matriceCase[i / 2][j - 1].toString() + " |";
                    }
                }
            } else {
                for (int j = 0; j < this.nbColonnes + 1; j++) {
                    grille += "----";
                }
            }
        }
        return grille;
    }
}
