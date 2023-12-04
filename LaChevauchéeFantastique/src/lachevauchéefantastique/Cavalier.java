/*
 * LA CHEVAUCHEE FANTASTIQUE, 03/12/2023, SARINENA-DUMAS-BRUNET MANQUAT
 */
package lachevauchéefantastique;

/**
 *
 * @author rembr
 */
public class Cavalier {
    int position_vertical;
    int position_horizontale;
    public CasePlateau[][] matriceCase;
    int nbLignes;
    int nbColonnes;
    
    public void DeplacementCavalier(int option) {
        if (option==1){
            this.matriceCase[position_vertical][position_horizontale].eteindreCase();
            
        }else if (option==2){
            
        }else if (option==3){
            
        }else if (option==4){
            
        }else if (option==5){
            
        }else if (option==6){
            
        }else if (option==7){
            
        }else{
            
        }
    }
    
}
