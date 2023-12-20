/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lachevauchéefantastique;

/**
 *
 * @author rembr
 */
public class Fenetre_Demarrer extends javax.swing.JFrame {
    
    int Difficulte;
    int ModeJeu;

    /**
     * Creates new form Fenetre_Demarrer
     */
    public Fenetre_Demarrer() {
        initComponents();
        Btn_Facile.setVisible(false);
        Btn_Moyen.setVisible(false);
        Btn_Speedrun.setVisible(false);
        Btn_Chrono.setVisible(false);
        Btn_Sandbox.setVisible(false);
        Txt_Selection_Diff.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Btn_Mode_libre = new javax.swing.JButton();
        Btn_Mode_fantas = new javax.swing.JButton();
        Btn_Mode_enigme = new javax.swing.JButton();
        Txt_Bienv = new javax.swing.JLabel();
        Txt_Selection_Mode = new javax.swing.JLabel();
        Btn_Quitter = new javax.swing.JButton();
        Btn_Facile = new javax.swing.JButton();
        Btn_Moyen = new javax.swing.JButton();
        Btn_Speedrun = new javax.swing.JButton();
        Btn_Chrono = new javax.swing.JButton();
        Btn_Sandbox = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();
        Txt_Selection_Diff = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Mode_libre.setText("Déplacement libre");
        Btn_Mode_libre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Mode_libreActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_Mode_libre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, -1, -1));

        Btn_Mode_fantas.setText("Déplacement Fantastique");
        Btn_Mode_fantas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Mode_fantasActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_Mode_fantas, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, -1, -1));

        Btn_Mode_enigme.setText("Enigme");
        Btn_Mode_enigme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Mode_enigmeActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_Mode_enigme, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, -1, -1));

        Txt_Bienv.setText("Bienvenue sur la Chevauché fantastique Shrek édition");
        getContentPane().add(Txt_Bienv, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 280, 20));

        Txt_Selection_Mode.setText("Sélectionnez le mode de jeu :");
        getContentPane().add(Txt_Selection_Mode, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, -1, 20));

        Btn_Quitter.setText("Quitter");
        Btn_Quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_QuitterActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_Quitter, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, -1, -1));

        Btn_Facile.setText("Facile");
        Btn_Facile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_FacileActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_Facile, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, -1, -1));

        Btn_Moyen.setText("Moyenne");
        Btn_Moyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_MoyenActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_Moyen, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, -1, -1));

        Btn_Speedrun.setText("Speedrun");
        Btn_Speedrun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_SpeedrunActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_Speedrun, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, -1, -1));

        Btn_Chrono.setText("Chrono");
        Btn_Chrono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ChronoActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_Chrono, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, -1, -1));

        Btn_Sandbox.setText("Sandbox");
        Btn_Sandbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_SandboxActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_Sandbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, -1, -1));
        getContentPane().add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, -1, -1));

        Txt_Selection_Diff.setText("Sélectionnez la difficultée :");
        getContentPane().add(Txt_Selection_Diff, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, -1, -1));

        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_Mode_fantasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Mode_fantasActionPerformed
        this.ModeJeu=1;
        
        // Désafficher mode jeu
        Btn_Mode_fantas.setVisible(false);
        Btn_Mode_libre.setVisible(false);
        Btn_Mode_enigme.setVisible(false);
        
        // Afficher difficulte
        Btn_Facile.setVisible(true);
        Btn_Moyen.setVisible(true);
        Btn_Speedrun.setVisible(true);
        Btn_Chrono.setVisible(true);
        Btn_Sandbox.setVisible(true); 
        
        // Afficher bon txt
        Txt_Selection_Diff.setVisible(true);
        Txt_Selection_Mode.setVisible(false);
    }//GEN-LAST:event_Btn_Mode_fantasActionPerformed

    private void Btn_Mode_libreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Mode_libreActionPerformed
        this.ModeJeu=0;
        
        // Désafficher mode jeu
        Btn_Mode_fantas.setVisible(false);
        Btn_Mode_libre.setVisible(false);
        Btn_Mode_enigme.setVisible(false);
        
        // Afficher difficulte
        Btn_Facile.setVisible(true);
        Btn_Moyen.setVisible(true);
        Btn_Speedrun.setVisible(true);
        Btn_Chrono.setVisible(true);
        Btn_Sandbox.setVisible(true); 
        
        // Afficher bon txt
        Txt_Selection_Diff.setVisible(true);
        Txt_Selection_Mode.setVisible(false);
    }//GEN-LAST:event_Btn_Mode_libreActionPerformed

    private void Btn_Mode_enigmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Mode_enigmeActionPerformed
        this.ModeJeu=2;
        
        // Désafficher mode jeu
        Btn_Mode_fantas.setVisible(false);
        Btn_Mode_libre.setVisible(false);
        Btn_Mode_enigme.setVisible(false);
        
        // Afficher difficulte
        Btn_Facile.setVisible(true);
        Btn_Moyen.setVisible(true);
        Btn_Speedrun.setVisible(true);
        Btn_Chrono.setVisible(true);
        Btn_Sandbox.setVisible(true); 
        
        // Afficher bon txt
        Txt_Selection_Diff.setVisible(true);
        Txt_Selection_Mode.setVisible(false);
    }//GEN-LAST:event_Btn_Mode_enigmeActionPerformed

    private void Btn_ChronoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ChronoActionPerformed
        this.Difficulte=3;
        
        // Fermer la fenêtre de démarrage
        this.dispose();

        // Ouvrir la fenêtre principale avec le niveau de difficulté sélectionné
        Fenetre_Principale fenetrePrincipale = new Fenetre_Principale(this.Difficulte,this.ModeJeu);
        fenetrePrincipale.setVisible(true);
        
        fenetrePrincipale.setLocationRelativeTo(null);
    }//GEN-LAST:event_Btn_ChronoActionPerformed

    private void Btn_SandboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_SandboxActionPerformed
        this.Difficulte=0;
        
        // Fermer la fenêtre de démarrage
        this.dispose();

        // Ouvrir la fenêtre principale avec le niveau de difficulté sélectionné
        Fenetre_Principale fenetrePrincipale = new Fenetre_Principale(this.Difficulte,this.ModeJeu);
        fenetrePrincipale.setVisible(true);
        
        fenetrePrincipale.setLocationRelativeTo(null);
    }//GEN-LAST:event_Btn_SandboxActionPerformed

    private void Btn_QuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_QuitterActionPerformed
        System.exit(0);
    }//GEN-LAST:event_Btn_QuitterActionPerformed

    private void Btn_SpeedrunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_SpeedrunActionPerformed
        this.Difficulte=2;
        
        // Fermer la fenêtre de démarrage
        this.dispose();

        // Ouvrir la fenêtre principale avec le niveau de difficulté sélectionné
        Fenetre_Principale fenetrePrincipale = new Fenetre_Principale(this.Difficulte,this.ModeJeu);
        fenetrePrincipale.setVisible(true);
        
        fenetrePrincipale.setLocationRelativeTo(null);
    }//GEN-LAST:event_Btn_SpeedrunActionPerformed

    private void Btn_MoyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_MoyenActionPerformed
        this.Difficulte=1;
        
        // Fermer la fenêtre de démarrage
        this.dispose();

        // Ouvrir la fenêtre principale avec le niveau de difficulté sélectionné
        Fenetre_Principale fenetrePrincipale = new Fenetre_Principale(this.Difficulte,this.ModeJeu);
        fenetrePrincipale.setVisible(true);
        
        fenetrePrincipale.setLocationRelativeTo(null);
    }//GEN-LAST:event_Btn_MoyenActionPerformed

    private void Btn_FacileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_FacileActionPerformed
        this.Difficulte=0;
        
        // Fermer la fenêtre de démarrage
        this.dispose();

        // Ouvrir la fenêtre principale avec le niveau de difficulté sélectionné
        Fenetre_Principale fenetrePrincipale = new Fenetre_Principale(this.Difficulte,this.ModeJeu);
        fenetrePrincipale.setVisible(true);
        
        fenetrePrincipale.setLocationRelativeTo(null);
    }//GEN-LAST:event_Btn_FacileActionPerformed

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
            java.util.logging.Logger.getLogger(Fenetre_Demarrer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fenetre_Demarrer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fenetre_Demarrer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fenetre_Demarrer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fenetre_Demarrer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Chrono;
    private javax.swing.JButton Btn_Facile;
    private javax.swing.JButton Btn_Mode_enigme;
    private javax.swing.JButton Btn_Mode_fantas;
    private javax.swing.JButton Btn_Mode_libre;
    private javax.swing.JButton Btn_Moyen;
    private javax.swing.JButton Btn_Quitter;
    private javax.swing.JButton Btn_Sandbox;
    private javax.swing.JButton Btn_Speedrun;
    private javax.swing.JLabel Txt_Bienv;
    private javax.swing.JLabel Txt_Selection_Diff;
    private javax.swing.JLabel Txt_Selection_Mode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSpinner jSpinner1;
    // End of variables declaration//GEN-END:variables
}
