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

    public Cellule_Graphique(CasePlateau celluleLumineuseAssociee, int largeur, int hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.celluleLumineuseAssociee = celluleLumineuseAssociee;

    }

    private void drawTriangle(Graphics k, int x, int y, int size) {
        // Coordonnées des sommets du triangle
        int[] xPoints = {x, x + size, x + size / 2};
        int[] yPoints = {y, y, y - size};

        // Dessiner le triangle
        k.fillPolygon(xPoints, yPoints, 3);
    }

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    this.setText(celluleLumineuseAssociee.toString());
    int w = this.getWidth();
    int h = this.getHeight();

    int diametre = 38; // Calcul du diamètre du cercle
    int x = 2 + (w - diametre) / 2; // Calcul de la coordonnée x pour centrer le cercle
    int y = 2 + (h - diametre) / 2; // Calcul de la coordonnée y pour centrer le cercle

        if (celluleLumineuseAssociee.estCavalier()) {
            // Dessiner un triangle au lieu du cercle
            int[] xPoints = {x, x + diametre, x + diametre / 2};
            int[] yPoints = {y + diametre, y + diametre, y};

            g.setColor(Color.black);
            g.fillPolygon(xPoints, yPoints, 3);
        } if (!celluleLumineuseAssociee.estEteint()) {
            // Dessiner le cercle
            g.setColor(Color.yellow);
            g.fillOval(x, y, diametre, diametre);
        }
    }
}


