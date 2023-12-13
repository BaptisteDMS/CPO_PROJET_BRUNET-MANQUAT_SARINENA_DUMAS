/*
LA CHEVAUCHEE FANTASTIQUE, 03/12/2023, SARINENA-DUMAS-BRUNET MANQUAT
 */
package lachevauchéefantastique;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import javax.swing.JButton;

/**
 *
 * @author pierr
 */
public class Cellule_Graphique extends JButton {

    int largeur; // largeur en pixel de la cellule
    int hauteur; // hauteur en pixel de la cellule
    CasePlateau celluleLumineuseAssociee;
    int nbLignes;
    int nbColonnes;
    CasePlateau estBlanche;
    

    public Cellule_Graphique(CasePlateau celluleLumineuseAssociee, int largeur, int hauteur, boolean cb) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.celluleLumineuseAssociee = celluleLumineuseAssociee;
        //this.estBlanche = cb;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setText(celluleLumineuseAssociee.toString());
        int w = this.getWidth();
        int h = this.getHeight();
        nbLignes = 5;
        nbColonnes = 5;
        
        int diametre = Math.min(w - 80, h - 80); // Calcul du diamètre du cercle
        int x = 2 + (w - diametre) / 2; // Calcul de la coordonnée x pour centrer le cercle
        int y = 2 + (h - diametre) / 2; // Calcul de la coordonnée y pour centrer le cercle
        /*
        if (cb == 0) {
            g.setColor(Color.white);
            g.fillRect(x, y, w, h);
        } else {
            g.setColor(Color.black);
            g.fillRect(x, y, w, h);
        }
*/
        if (!celluleLumineuseAssociee.estEteint()) {
            g.setColor(Color.yellow);
            g.fillOval(x, y, diametre, diametre);
        }
    }
}
