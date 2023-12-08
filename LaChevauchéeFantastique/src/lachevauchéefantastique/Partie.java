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

    /**
     * Ce constructeur permet d'initialiser le compteur nbCoups à zéro.
     */
    public Partie() {
        this.nbCoups = 0;
    }
    
    public void initialiserPartie(int Difficulte, int ModeJeu){
        if (ModeJeu==0){
            if (Difficulte==0){
                this.plateau=new PlateauDeJeu(5,5,3,3);
                this.plateau.melangerMatriceAleatoirement(5);
            }
        }else if (ModeJeu==1){
            
        }else{
            
        }
        this.plateau=new PlateauDeJeu(8,8,0,0);
        this.plateau.melangerMatriceAleatoirement(5);
    }
    
    public void lancerPartie(){
        Scanner sc= new Scanner(System.in);
        System.out.println(this.plateau.toString());
        
        while (this.plateau.CaseToutesEteintes()==false){
            System.out.println("\nSelectionner l'action que vous voulez faire. (0 => N1 ; 1 => N2 ; 2 => S1 ; 3 => S2 ; 4 => O1 ; 5 => O2 ; 6 => E1 ; 7 => E2)");
            int saisie=sc.nextInt(8);
            this.plateau.DeplacerCavalier(saisie);
            this.nbCoups+=1;
            System.out.println("\nVotre nombre de coups joués est de : "+this.nbCoups);
            System.out.println("\n"+this.plateau.toString());
        }
        
        System.out.println("\nVous avez réussi !\nVotre nombre de coups est de : "+this.nbCoups);
    }
    
    public int SelectionDifficulte(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Selectionnez la difficulté. (0 => Facile ; 1 => Moyenne ; 2 => Speedrun ; 3 => Chrono ; 4 => Sandbox)");
        int difficulte=sc.nextInt(5);
        return difficulte;
    }
    
    public int SelectionModeJeu(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Selectionnez le mode de jeu. (0 => Déplacement libre ; 1 => Déplacement fantastique ; 2 => Enigme)");
        int modejeu=sc.nextInt(3);
        return modejeu;
    }
}
