/*
 * LA CHEVAUCHEE FANTASTIQUE, 03/12/2023, SARINENA-DUMAS-BRUNET MANQUAT
 */
package lachevauchéefantastique;

import java.util.Scanner;

/**
 *
 * @author rembr
 */
public class Partie {

    PlateauDeJeu plateau;
    int nbCoups;
    int level;

    /**
     * Ce constructeur permet d'initialiser le compteur nbCoups à zéro.
     */
    public Partie() {
        this.nbCoups = 0;
    }

    public void initialiserPartie(int Difficulte, int ModeJeu) {
        this.level = Difficulte;
        if (ModeJeu == 0) {
            if (Difficulte == 0) { // Facile
                this.plateau = new PlateauDeJeu(5, 5, 2, 2);
                this.plateau.melangerMatriceAleatoirement(5);
                lancerPartieMode1();
            } else if (Difficulte == 1) { //Moyen
                this.plateau = new PlateauDeJeu(9, 9, 4, 4);
                this.plateau.melangerMatriceAleatoirement(15);
                lancerPartieMode1();
            } else if (Difficulte == 2) { // Speedrun
                this.plateau = new PlateauDeJeu(9, 9, 4, 4);
                this.plateau.melangerMatriceAleatoirement(10);
                lancerPartieMode1();
            } else if (Difficulte == 3) { // Chrono
                this.plateau = new PlateauDeJeu(9, 9, 4, 4);
                this.plateau.melangerMatriceAleatoirement(10);
                lancerPartieMode1();
            } else { // Sandbox
                SetSandbox(0);
            }
        } else if (ModeJeu == 1) {
            if (Difficulte == 0) { // Facile
                this.plateau = new PlateauDeJeu(5, 5, 2, 2);
                this.plateau.activerCaseAleatoireFantastique(5);
                lancerPartieMode2();
            } else if (Difficulte == 1) { //Moyen
                this.plateau = new PlateauDeJeu(9, 9, 4, 4);
                this.plateau.activerCaseAleatoireFantastique(15);
                lancerPartieMode2();
            } else if (Difficulte == 2) { // Speedrun
                this.plateau = new PlateauDeJeu(9, 9, 4, 4);
                this.plateau.activerCaseAleatoireFantastique(10);
                lancerPartieMode2();
            } else if (Difficulte == 3) { // Chrono
                this.plateau = new PlateauDeJeu(9, 9, 4, 4);
                this.plateau.activerCaseAleatoireFantastique(10);
                lancerPartieMode2();
            } else { // Sandbox
                SetSandbox(1);
            }
        } else {
            this.plateau = new PlateauDeJeu(8, 8, 4, 0);
            this.plateau.activerTouteCase();
            lancerPartieMode2();
        }
    }

    public void SetSandbox(int ModeJeu) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nSelectionner la taille de votre plateau. (entre 4 et 15)");
        int taille = sc.nextInt();

        System.out.println("\nSelectionner la position horizontale. (entre 0 et " + (taille - 1) + ")");
        int position_hor = sc.nextInt();

        System.out.println("\nSelectionner la position verticale. (entre 0 et " + (taille - 1) + ")");
        int position_vert = sc.nextInt();

        System.out.println("\nSelectionner le nombre de case à activer. (entre 1 et " + ((taille * taille) - 1) + ")");
        int nbMelange = sc.nextInt();

        this.plateau = new PlateauDeJeu(taille, taille, position_hor, position_vert);

        if (ModeJeu == 0) {
            this.plateau.melangerMatriceAleatoirement(nbMelange);
            lancerPartieMode1();
        } else {
            this.plateau.activerCaseAleatoireFantastique(nbMelange);
            lancerPartieMode2();
        }
    }

    public void lancerPartieMode1() {
        Scanner sc = new Scanner(System.in);
        boolean perdue = false;
        long tempsLimiteEnMillisecondes=0;
        long tempsDebut=0;
        long tempsFin=0;

        if (this.level == 2 || this.level == 3) {
            int tempsLimiteEnSecondes = 300;
            tempsLimiteEnMillisecondes = tempsLimiteEnSecondes * 1000;
            tempsDebut = System.currentTimeMillis();
        }
        
        System.out.println(this.plateau.toString());

        while (this.plateau.CaseToutesEteintes() == false && perdue == false) {
            System.out.println("\nSelectionner l'action que vous voulez faire. (0 => N1 ; 1 => N2 ; 2 => S1 ; 3 => S2 ; 4 => O1 ; 5 => O2 ; 6 => E1 ; 7 => E2)");
            int saisie = sc.nextInt(8);
            this.plateau.DeplacerCavalier(saisie);
            this.nbCoups += 1;
            System.out.println("\nVotre nombre de coups joués est de : " + this.nbCoups);
            System.out.println("\n" + this.plateau.toString());
            
            if (this.level == 3) {
                long tempsEcoule = System.currentTimeMillis() - tempsDebut;
                if (tempsEcoule >= tempsLimiteEnMillisecondes) {
                    perdue = true;
                }
            }
        }
        
        tempsFin = System.currentTimeMillis();
        
        if (perdue==true){
            System.out.println("Temps écoulé ! Vous avez perdu !");
        }else if (this.level==2){
            System.out.println("\nVous avez réussi !\nVotre nombre de coups est de : " + this.nbCoups);
            
            long tempsEcoule = tempsFin - tempsDebut; // permet d'avoir le temps de jeu
            
            // permet de convertir le temps en ms pour  un affichage jolie
            long minutes = tempsEcoule / (60 * 1000);
            long secondes = (tempsEcoule % (60 * 1000)) / 1000;                    
            long millisecondes = tempsEcoule % 1000;
            
            // format d'affichage du temps
            String tempsFormate = String.format("%02dmin %02ds %03dms", minutes, secondes, millisecondes);
            System.out.println("\nVotre temps est de : "+tempsFormate);            
        }else{
            System.out.println("\nVous avez réussi !\nVotre nombre de coups est de : " + this.nbCoups);
        }
        
    }

    public void lancerPartieMode2() {
        Scanner sc = new Scanner(System.in);
        boolean perdu = false;
        long tempsLimiteEnMillisecondes=0;
        long tempsDebut=0;
        long tempsFin=0;
        
        if (this.level == 2 || this.level == 3) {
            int tempsLimiteEnSecondes = 300;
            tempsLimiteEnMillisecondes = tempsLimiteEnSecondes * 1000;
            tempsDebut = System.currentTimeMillis();
        }
        
        System.out.println("\n" + this.plateau.toString());

        while (this.plateau.CaseToutesEteintes() == false && perdu == false) {
            System.out.println("\nSelectionner l'action que vous voulez faire. (0 => N1 ; 1 => N2 ; 2 => S1 ; 3 => S2 ; 4 => O1 ; 5 => O2 ; 6 => E1 ; 7 => E2)");
            int saisie = sc.nextInt(8);
            if (this.plateau.DeplacerCavalier(saisie) == true) {
                perdu = true;
            }
            this.nbCoups += 1;
            System.out.println("\nVotre nombre de coups joués est de : " + this.nbCoups);
            System.out.println("\n" + this.plateau.toString());
            
            if (this.level == 3) {
                long tempsEcoule = System.currentTimeMillis() - tempsDebut;
                if (tempsEcoule >= tempsLimiteEnMillisecondes) {
                    perdu = true;
                    System.out.println("\nTemps écoulé ! Vous avez perdu !");
                }
            }
        }
        
        tempsFin = System.currentTimeMillis();

        if (perdu == true) {
            System.out.println("\nVous avez perdu ! bouhouhou !\nVotre nombre de coups est de : " + this.nbCoups);
        }else if (this.level==2){
            System.out.println("\nVous avez réussi !\nVotre nombre de coups est de : " + this.nbCoups);
            
            long tempsEcoule = tempsFin - tempsDebut; // permet d'avoir le temps de jeu
            
            // permet de convertir le temps en ms pour  un affichage jolie
            long minutes = tempsEcoule / (60 * 1000);
            long secondes = (tempsEcoule % (60 * 1000)) / 1000;                    
            long millisecondes = tempsEcoule % 1000;
            
            // format d'affichage du temps
            String tempsFormate = String.format("%02dmin %02ds %03dms", minutes, secondes, millisecondes);
            System.out.println("\nVotre temps est de : "+tempsFormate);            
        }else{
           System.out.println("\nVous avez réussi !\nVotre nombre de coups est de : " + this.nbCoups); 
        }
    }

    public int SelectionDifficulte() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Selectionnez la difficulté. (0 => Facile ; 1 => Moyenne ; 2 => Speedrun ; 3 => Chrono ; 4 => Sandbox)");
        int difficulte = sc.nextInt(5);
        return difficulte;
    }

    public int SelectionModeJeu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Selectionnez le mode de jeu. (0 => Déplacement libre ; 1 => Déplacement fantastique ; 2 => Enigme)");
        int modejeu = sc.nextInt(3);
        return modejeu;
    }

    public void DemarrerJeu() {
        int ModeJeu = SelectionModeJeu();
        if (ModeJeu == 2) {
            initialiserPartie(0, 2);
        } else {
            int Difficulte = SelectionDifficulte();
            initialiserPartie(Difficulte, ModeJeu);
        }
    }
}
