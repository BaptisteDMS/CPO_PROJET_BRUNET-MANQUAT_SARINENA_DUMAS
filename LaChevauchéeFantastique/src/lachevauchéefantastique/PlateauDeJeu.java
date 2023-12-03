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
    
    /**
     * Ce constructeur permet de créer une nouvelle grille de cellules
     * lumineuses avec un nombre spécifié de lignes et de colonnes.
     *
     * @param p_nbLignes est le nombre de lignes que l'on souhaite pour notre
     * plateau
     * @param p_nbColonnes est le nombre de colonnes que l'on souhaite pour
     * notre plateau
     */
    public PlateauDeJeu(int p_nbLignes, int p_nbColonnes) {
        this.nbLignes = p_nbLignes;
        this.nbColonnes = p_nbColonnes;
        this.matriceCase = new CasePlateau[p_nbLignes][p_nbColonnes];

        for (int i = 0; i < p_nbLignes; i++) {
            for (int j = 0; j < p_nbColonnes; j++) {
                this.matriceCase[i][j] = new CasePlateau();
            }
        }
    }
    
    /**
     * Permet d'éteindre toutes les case du plateau en passant chaque
     * case en état "éteint".
     */
    public void eteindreToutesLesCases() {
        for (int i = 0; i < this.nbLignes; i++) {
            for (int j = 0; j < this.nbColonnes; j++) {
                this.matriceCase[i][j].eteindreCase();
            }
        }
    }
    
    /**
     * Permet d'activer de manière aléatoire une case du plateau non alluméee et
     * qui n'a pas le cavalier.
     */
    public void activerCaseAleatoire() {
        int nb_alea1;
        int nb_alea2;
        Random generateurAleat = new Random();
        nb_alea1 = generateurAleat.nextInt(this.nbLignes);
        nb_alea2 = generateurAleat.nextInt(this.nbColonnes);
        
        if (matriceCase[nb_alea1][nb_alea2].getEtat()==0){
            matriceCase[nb_alea1][nb_alea2].activerCase();
        }
    }
    
    /**
     * Permet de générer un plateau de cellules lumineuses de manière aléatoire
     * à partir d’un nombre spécifié de tours.
     *
     * @param nbTours correspond au nombre de changement aléatoire effectué
     */
    public void melangerMatriceAleatoirement(int nbTours) {
        eteindreToutesLesCases();
        for (int i = 0; i < nbTours; i++) {
            activerCaseAleatoire();
        }
    }
}
