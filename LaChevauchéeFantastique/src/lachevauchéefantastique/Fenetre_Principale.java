/*
LA CHEVAUCHEE FANTASTIQUE, 13/11/2023, SARINENA-DUMAS-BRUNET MANQUAT
 */
package lachevauchéefantastique;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;

/**
 *
 * @author pierr
 */
public class Fenetre_Principale extends javax.swing.JFrame {

    PlateauDeJeu plateau;
    int Difficulte;
    int ModeJeu;
    int nbCoups;
    int nbLignes;
    int nbColonnes;
    int nbCoupsMAX;
    int nbTouche;
    boolean perdu = false;
    int Nb_Melange = 0;
    int Position_Vert = 0;
    int Position_Hor = 0;
    int TaillePlateau = 0;
    long tempsLimiteEnMillisecondes = 0;
    long tempsDebut = 0;
    long tempsFin = 0;

    /**
     * Creates new form Fenetre_Principale
     */
    public Fenetre_Principale(int Diff, int Mode) {
        initComponents();

        // Def des attributs
        this.ModeJeu = Mode;
        this.Difficulte = Diff;
        nbTouche = 2;

        // Def panneaux bouton deplacement
        PanneauBoutonHAUT.setLayout(new GridLayout(nbTouche, 1));
        getContentPane().add(PanneauBoutonHAUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 300, nbTouche * 40, 1 * 80));
        this.pack();
        this.revalidate();
        PanneauBoutonGAUCHE.setLayout(new GridLayout(1, nbTouche));
        getContentPane().add(PanneauBoutonGAUCHE, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 250, 1 * 100, nbTouche * 25));
        this.pack();
        this.revalidate();
        PanneauBoutonDROITE.setLayout(new GridLayout(nbTouche, 1));
        getContentPane().add(PanneauBoutonDROITE, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 300, nbTouche * 40, 1 * 80));
        this.pack();
        this.revalidate();
        PanneauBoutonBAS.setLayout(new GridLayout(1, nbTouche));
        getContentPane().add(PanneauBoutonBAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 380, 1 * 100, nbTouche * 25));
        this.pack();
        this.revalidate();
        
        getContentPane().add(Btn_Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 450, 100, 40));
        this.pack();
        this.revalidate();
        
        getContentPane().add(Btn_Quitter, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 500, 100, 40));
        this.pack();
        this.revalidate();

        // Gestion des modes avec timer
        if (this.Difficulte == 2 || this.Difficulte == 3) {
            int tempsLimiteEnSecondes = 180;
            this.tempsLimiteEnMillisecondes = tempsLimiteEnSecondes * 1000;
            this.tempsDebut = System.currentTimeMillis();
        }

        // Lancement jeu
        setLocationRelativeTo(null);
        initialiserPartie();
    }

    public Fenetre_Principale(int Diff, int Mode, int Taille, int PositionHor, int PositionVert, int NbMelange) {
        initComponents();

        // Def des attributs
        this.ModeJeu = Mode;
        this.Difficulte = Diff;
        nbTouche = 2;
        this.TaillePlateau = Taille;
        this.Nb_Melange = NbMelange;
        this.Position_Hor = PositionHor;
        this.Position_Vert = PositionVert;

        // Def panneaux bouton deplacement
        PanneauBoutonHAUT.setLayout(new GridLayout(nbTouche, 1));
        getContentPane().add(PanneauBoutonHAUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 300, nbTouche * 40, 1 * 80));
        this.pack();
        this.revalidate();
        PanneauBoutonGAUCHE.setLayout(new GridLayout(1, nbTouche));
        getContentPane().add(PanneauBoutonGAUCHE, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 250, 1 * 100, nbTouche * 25));
        this.pack();
        this.revalidate();
        PanneauBoutonDROITE.setLayout(new GridLayout(nbTouche, 1));
        getContentPane().add(PanneauBoutonDROITE, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 300, nbTouche * 40, 1 * 80));
        this.pack();
        this.revalidate();
        PanneauBoutonBAS.setLayout(new GridLayout(1, nbTouche));
        getContentPane().add(PanneauBoutonBAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 380, 1 * 100, nbTouche * 25));
        this.pack();
        this.revalidate();
        
        getContentPane().add(Btn_Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 450, 100, 40));
        this.pack();
        this.revalidate();
        
        getContentPane().add(Btn_Quitter, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 500, 100, 40));
        this.pack();
        this.revalidate();

        // Gestion des modes avec timer
        if (this.Difficulte == 2 || this.Difficulte == 3) {
            int tempsLimiteEnSecondes = 180;
            this.tempsLimiteEnMillisecondes = tempsLimiteEnSecondes * 1000;
            this.tempsDebut = System.currentTimeMillis();
        }

        // Lancement jeu
        setLocationRelativeTo(null);
        initialiserPartie();
    }

    public void CreationGrille() {

        PanneauGrille.setLayout(new GridLayout(nbLignes, nbColonnes));
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                JButton Cellule_Graphique = new Cellule_Graphique(plateau.matriceCase[i][j], 36, 36);
                PanneauGrille.add(Cellule_Graphique);
            }
        }

    }

    public void initialiserPartie() {
        if (ModeJeu == 0) {
            if (Difficulte == 0) { // Facile
                this.plateau = new PlateauDeJeu(5, 5, 2, 2);
                this.plateau.melangerMatriceAleatoirement(5);
                this.nbColonnes = 5;
                this.nbLignes = 5;
                CreationGrille();
            } else if (Difficulte == 1) { //Moyen
                this.plateau = new PlateauDeJeu(9, 9, 4, 4);
                this.plateau.melangerMatriceAleatoirement(15);
                this.nbColonnes = 9;
                this.nbLignes = 9;
                CreationGrille();
            } else if (Difficulte == 2) { // Speedrun
                this.plateau = new PlateauDeJeu(9, 9, 4, 4);
                this.plateau.melangerMatriceAleatoirement(10);
                this.nbColonnes = 9;
                this.nbLignes = 9;
                CreationGrille();
            } else if (Difficulte == 3) { // Chrono
                this.plateau = new PlateauDeJeu(9, 9, 4, 4);
                this.plateau.melangerMatriceAleatoirement(10);
                this.nbColonnes = 9;
                this.nbLignes = 9;
                CreationGrille();
            } else { // Sandbox
                this.plateau = new PlateauDeJeu(this.TaillePlateau, this.TaillePlateau, this.Position_Hor, this.Position_Vert);
                this.plateau.melangerMatriceAleatoirement(this.Nb_Melange);
                this.nbColonnes = this.TaillePlateau;
                this.nbLignes = this.TaillePlateau;
                CreationGrille();
            }
        } else if (ModeJeu == 1) {
            if (Difficulte == 0) { // Facile
                this.plateau = new PlateauDeJeu(5, 5, 2, 2);
                this.plateau.activerCaseAleatoireFantastique(5);
                this.nbColonnes = 5;
                this.nbLignes = 5;
                CreationGrille();
            } else if (Difficulte == 1) { //Moyen
                this.plateau = new PlateauDeJeu(9, 9, 4, 4);
                this.plateau.activerCaseAleatoireFantastique(15);
                this.nbColonnes = 9;
                this.nbLignes = 9;
                CreationGrille();
            } else if (Difficulte == 2) { // Speedrun
                this.plateau = new PlateauDeJeu(9, 9, 4, 4);
                this.plateau.activerCaseAleatoireFantastique(10);
                this.nbColonnes = 9;
                this.nbLignes = 9;
                CreationGrille();
            } else if (Difficulte == 3) { // Chrono
                this.plateau = new PlateauDeJeu(9, 9, 4, 4);
                this.plateau.activerCaseAleatoireFantastique(10);
                this.nbColonnes = 9;
                this.nbLignes = 9;
                CreationGrille();
            } else { // Sandbox
                this.plateau = new PlateauDeJeu(this.TaillePlateau, this.TaillePlateau, this.Position_Hor, this.Position_Vert);
                this.plateau.activerCaseAleatoireFantastique(this.Nb_Melange);
                this.nbColonnes = this.TaillePlateau;
                this.nbLignes = this.TaillePlateau;
                CreationGrille();
            }
        } else {
            this.plateau = new PlateauDeJeu(8, 8, 4, 0);
            this.plateau.activerTouteCase();
            this.nbColonnes = 8;
            this.nbLignes = 8;
            CreationGrille();
        }
    }

    public void FinDePartie() {

        if (this.plateau.CaseToutesEteintes() == true && perdu == false) {
            if (this.Difficulte == 2) {
                this.tempsFin=System.currentTimeMillis();
                long tempsEcoule = this.tempsFin - this.tempsDebut; // permet d'avoir le temps de jeu

                // permet de convertir le temps en ms pour  un affichage jolie
                long minutes = tempsEcoule / (60 * 1000);
                long secondes = (tempsEcoule % (60 * 1000)) / 1000;
                long millisecondes = tempsEcoule % 1000;

                // format d'affichage du temps
                String tempsFormate = String.format("%02dmin %02ds %03dms", minutes, secondes, millisecondes);
                
                this.dispose();
                Fenetre_Victoire f = new Fenetre_Victoire(this.Difficulte, this.ModeJeu, this.Nb_Melange, this.Position_Vert, this.Position_Hor, this.TaillePlateau,tempsFormate);
                f.setVisible(true);
            } else {
                this.dispose();
                Fenetre_Victoire f = new Fenetre_Victoire(this.Difficulte, this.ModeJeu, this.Nb_Melange, this.Position_Vert, this.Position_Hor, this.TaillePlateau," ");
                f.setVisible(true);
            }
        } else if (perdu == true) {
            this.dispose();
            Fenetre_Perdant p = new Fenetre_Perdant(this.Difficulte, this.ModeJeu, this.Nb_Melange, this.Position_Vert, this.Position_Hor, this.TaillePlateau, false);
            p.setVisible(true);
        } else if (this.Difficulte == 3) {
            long tempsEcoule = System.currentTimeMillis() - this.tempsDebut;
            if (tempsEcoule >= this.tempsLimiteEnMillisecondes) {
                this.dispose();
                Fenetre_Perdant p = new Fenetre_Perdant(this.Difficulte, this.ModeJeu, this.Nb_Melange, this.Position_Vert, this.Position_Hor, this.TaillePlateau, true);
                p.setVisible(true);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanneauGrille = new javax.swing.JPanel();
        PanneauBoutonHAUT = new javax.swing.JPanel();
        Bouton_GaucheHaut = new javax.swing.JButton();
        Bouton_GaucheBas = new javax.swing.JButton();
        PanneauBoutonGAUCHE = new javax.swing.JPanel();
        Bouton_HautGauche = new javax.swing.JButton();
        Bouton_HautDroite = new javax.swing.JButton();
        PanneauBoutonDROITE = new javax.swing.JPanel();
        Bouton_DroiteHaut = new javax.swing.JButton();
        Bouton_DroiteBas = new javax.swing.JButton();
        PanneauBoutonBAS = new javax.swing.JPanel();
        Bouton_BasDroite = new javax.swing.JButton();
        Bouton_BasGauche = new javax.swing.JButton();
        Btn_Quitter = new javax.swing.JButton();
        Btn_Menu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanneauGrille.setBackground(new java.awt.Color(204, 204, 204));
        PanneauGrille.setPreferredSize(new java.awt.Dimension(600, 600));

        javax.swing.GroupLayout PanneauGrilleLayout = new javax.swing.GroupLayout(PanneauGrille);
        PanneauGrille.setLayout(PanneauGrilleLayout);
        PanneauGrilleLayout.setHorizontalGroup(
            PanneauGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        PanneauGrilleLayout.setVerticalGroup(
            PanneauGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        getContentPane().add(PanneauGrille, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        PanneauBoutonHAUT.setBackground(new java.awt.Color(0, 51, 255));

        Bouton_GaucheHaut.setText("O1");
        Bouton_GaucheHaut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bouton_GaucheHautActionPerformed(evt);
            }
        });

        Bouton_GaucheBas.setText("O2");
        Bouton_GaucheBas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bouton_GaucheBasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanneauBoutonHAUTLayout = new javax.swing.GroupLayout(PanneauBoutonHAUT);
        PanneauBoutonHAUT.setLayout(PanneauBoutonHAUTLayout);
        PanneauBoutonHAUTLayout.setHorizontalGroup(
            PanneauBoutonHAUTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanneauBoutonHAUTLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanneauBoutonHAUTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Bouton_GaucheHaut)
                    .addComponent(Bouton_GaucheBas))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        PanneauBoutonHAUTLayout.setVerticalGroup(
            PanneauBoutonHAUTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanneauBoutonHAUTLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Bouton_GaucheHaut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(Bouton_GaucheBas)
                .addGap(16, 16, 16))
        );

        getContentPane().add(PanneauBoutonHAUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, 90, 110));

        PanneauBoutonGAUCHE.setBackground(new java.awt.Color(0, 51, 255));

        Bouton_HautGauche.setText("N1");
        Bouton_HautGauche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bouton_HautGaucheActionPerformed(evt);
            }
        });

        Bouton_HautDroite.setText("N2");
        Bouton_HautDroite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bouton_HautDroiteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanneauBoutonGAUCHELayout = new javax.swing.GroupLayout(PanneauBoutonGAUCHE);
        PanneauBoutonGAUCHE.setLayout(PanneauBoutonGAUCHELayout);
        PanneauBoutonGAUCHELayout.setHorizontalGroup(
            PanneauBoutonGAUCHELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanneauBoutonGAUCHELayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Bouton_HautGauche)
                .addGap(18, 18, 18)
                .addComponent(Bouton_HautDroite)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        PanneauBoutonGAUCHELayout.setVerticalGroup(
            PanneauBoutonGAUCHELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanneauBoutonGAUCHELayout.createSequentialGroup()
                .addGroup(PanneauBoutonGAUCHELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Bouton_HautGauche)
                    .addComponent(Bouton_HautDroite))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        getContentPane().add(PanneauBoutonGAUCHE, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 40, 180, 40));

        PanneauBoutonDROITE.setBackground(new java.awt.Color(0, 51, 255));

        Bouton_DroiteHaut.setText("E1");
        Bouton_DroiteHaut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bouton_DroiteHautActionPerformed(evt);
            }
        });

        Bouton_DroiteBas.setText("E2");
        Bouton_DroiteBas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bouton_DroiteBasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanneauBoutonDROITELayout = new javax.swing.GroupLayout(PanneauBoutonDROITE);
        PanneauBoutonDROITE.setLayout(PanneauBoutonDROITELayout);
        PanneauBoutonDROITELayout.setHorizontalGroup(
            PanneauBoutonDROITELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanneauBoutonDROITELayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanneauBoutonDROITELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Bouton_DroiteHaut)
                    .addComponent(Bouton_DroiteBas))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        PanneauBoutonDROITELayout.setVerticalGroup(
            PanneauBoutonDROITELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanneauBoutonDROITELayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Bouton_DroiteHaut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(Bouton_DroiteBas)
                .addGap(20, 20, 20))
        );

        getContentPane().add(PanneauBoutonDROITE, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 80, 90, 110));

        PanneauBoutonBAS.setBackground(new java.awt.Color(0, 51, 255));

        Bouton_BasDroite.setText("S2");
        Bouton_BasDroite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bouton_BasDroiteActionPerformed(evt);
            }
        });

        Bouton_BasGauche.setText("S1");
        Bouton_BasGauche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bouton_BasGaucheActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanneauBoutonBASLayout = new javax.swing.GroupLayout(PanneauBoutonBAS);
        PanneauBoutonBAS.setLayout(PanneauBoutonBASLayout);
        PanneauBoutonBASLayout.setHorizontalGroup(
            PanneauBoutonBASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanneauBoutonBASLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Bouton_BasGauche)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(Bouton_BasDroite)
                .addContainerGap())
        );
        PanneauBoutonBASLayout.setVerticalGroup(
            PanneauBoutonBASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanneauBoutonBASLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanneauBoutonBASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Bouton_BasDroite)
                    .addComponent(Bouton_BasGauche))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        getContentPane().add(PanneauBoutonBAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 190, 180, 40));

        Btn_Quitter.setText("Quitter");
        Btn_Quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_QuitterActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_Quitter, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 320, -1, -1));

        Btn_Menu.setText("Menu");
        Btn_Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_MenuActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 270, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Bouton_HautGaucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bouton_HautGaucheActionPerformed
        if (this.plateau.DeplacerCavalier(0) == true && this.ModeJeu != 0) {
            this.perdu = true;
        }
        repaint();
        FinDePartie();

    }//GEN-LAST:event_Bouton_HautGaucheActionPerformed

    private void Bouton_BasDroiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bouton_BasDroiteActionPerformed
        if (this.plateau.DeplacerCavalier(3) == true && this.ModeJeu != 0) {
            this.perdu = true;
        }
        repaint();
        FinDePartie();

    }//GEN-LAST:event_Bouton_BasDroiteActionPerformed

    private void Bouton_HautDroiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bouton_HautDroiteActionPerformed
        if (this.plateau.DeplacerCavalier(1) == true && this.ModeJeu != 0) {
            this.perdu = true;
        }
        repaint();
        FinDePartie();

    }//GEN-LAST:event_Bouton_HautDroiteActionPerformed

    private void Bouton_BasGaucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bouton_BasGaucheActionPerformed
        if (this.plateau.DeplacerCavalier(2) == true && this.ModeJeu != 0) {
            this.perdu = true;
        }
        repaint();
        FinDePartie();

    }//GEN-LAST:event_Bouton_BasGaucheActionPerformed

    private void Bouton_GaucheHautActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bouton_GaucheHautActionPerformed
        if (this.plateau.DeplacerCavalier(4) == true && this.ModeJeu != 0) {
            this.perdu = true;
        }
        repaint();
        FinDePartie();

    }//GEN-LAST:event_Bouton_GaucheHautActionPerformed

    private void Bouton_GaucheBasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bouton_GaucheBasActionPerformed
        if (this.plateau.DeplacerCavalier(5) == true && this.ModeJeu != 0) {
            this.perdu = true;
        }
        repaint();
        FinDePartie();

    }//GEN-LAST:event_Bouton_GaucheBasActionPerformed

    private void Bouton_DroiteHautActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bouton_DroiteHautActionPerformed
        if (this.plateau.DeplacerCavalier(6) == true && this.ModeJeu != 0) {
            this.perdu = true;
        }
        repaint();
        FinDePartie();

    }//GEN-LAST:event_Bouton_DroiteHautActionPerformed

    private void Bouton_DroiteBasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bouton_DroiteBasActionPerformed
        if (this.plateau.DeplacerCavalier(7) == true && this.ModeJeu != 0) {
            this.perdu = true;
        }
        repaint();
        FinDePartie();

    }//GEN-LAST:event_Bouton_DroiteBasActionPerformed

    private void Btn_MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_MenuActionPerformed
        // Fermer la fenêtre
        this.dispose();
        
        // Ouvrir le menu
        Fenetre_Demarrer fenetreMenu=new Fenetre_Demarrer();
        fenetreMenu.setVisible(true);
        
        fenetreMenu.setLocationRelativeTo(null);
    }//GEN-LAST:event_Btn_MenuActionPerformed

    private void Btn_QuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_QuitterActionPerformed
        System.exit(0);
    }//GEN-LAST:event_Btn_QuitterActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Fenetre_Principale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fenetre_Principale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fenetre_Principale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fenetre_Principale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bouton_BasDroite;
    private javax.swing.JButton Bouton_BasGauche;
    private javax.swing.JButton Bouton_DroiteBas;
    private javax.swing.JButton Bouton_DroiteHaut;
    private javax.swing.JButton Bouton_GaucheBas;
    private javax.swing.JButton Bouton_GaucheHaut;
    private javax.swing.JButton Bouton_HautDroite;
    private javax.swing.JButton Bouton_HautGauche;
    private javax.swing.JButton Btn_Menu;
    private javax.swing.JButton Btn_Quitter;
    private javax.swing.JPanel PanneauBoutonBAS;
    private javax.swing.JPanel PanneauBoutonDROITE;
    private javax.swing.JPanel PanneauBoutonGAUCHE;
    private javax.swing.JPanel PanneauBoutonHAUT;
    private javax.swing.JPanel PanneauGrille;
    // End of variables declaration//GEN-END:variables
}
