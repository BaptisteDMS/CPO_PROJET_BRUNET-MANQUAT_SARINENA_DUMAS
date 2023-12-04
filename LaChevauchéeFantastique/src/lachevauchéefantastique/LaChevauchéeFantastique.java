/*
LA CHEVAUCHEE FANTASTIQUE, 13/11/2023, SARINENA-DUMAS-BRUNET MANQUAT
 */
package lachevauchéefantastique;

/**
 *
 * @author bapti
 */
public class LaChevauchéeFantastique {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PlateauDeJeu caca=new PlateauDeJeu(5,5);
        caca.melangerMatriceAleatoirement(6);
        System.out.println(caca.toString());
    }
    
}
