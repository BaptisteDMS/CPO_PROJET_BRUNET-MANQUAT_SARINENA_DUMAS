/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lachevauchéefantastique;

/**
 * cette calsse permet l'affichage de la fenetre de victoire
 * @author bapti
 */
public class Fenetre_Victoire extends javax.swing.JFrame {
    
    int Difficulte;
    int ModeJeu;
    int Nb_Melange;
    int Position_Vert;
    int Position_Hor;
    int TaillePlateau;
       
    /**
     * Constructeur permettant d'afficher la fenetre de victoire
     * @param Diff correspond à la difficultée choisit
     * @param Mode correspond au mode de jeu choisit
     * @param NbMelange correspond aux nombres de lumières à éteidre
     * @param PosVert correspond à la position vertical du cavalier
     * @param PosHor correspond à la position horizontal du cavalier
     * @param Taille correspond à la taille du plateau de jeu
     * @param temps correspond au temps du joueur 
     */
    public Fenetre_Victoire(int Diff, int Mode, int NbMelange, int PosVert, int PosHor, int Taille, String temps) {
        initComponents();
        this.Difficulte=Diff;
        this.ModeJeu=Mode;
        this.Nb_Melange=NbMelange;
        this.Position_Hor=PosHor;
        this.Position_Vert=PosVert;
        this.TaillePlateau=Taille;
        
        if (Difficulte==2){
           Txt_Temps.setText("Votre temps est de "+temps); 
        }else{
           Txt_Temps.setVisible(false);
           Panel_Temps.setVisible(false);
        } 
        
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_Temps = new javax.swing.JPanel();
        Txt_Temps = new javax.swing.JLabel();
        Btn_Rejouer = new javax.swing.JButton();
        Btn_Menu = new javax.swing.JButton();
        Btn_Quitter = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Txt_Temps.setBackground(new java.awt.Color(255, 255, 255));
        Txt_Temps.setText("Temps");
        Panel_Temps.add(Txt_Temps);

        getContentPane().add(Panel_Temps, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, 200, 20));

        Btn_Rejouer.setText("Rejouer");
        Btn_Rejouer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_RejouerActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_Rejouer, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 110, -1));

        Btn_Menu.setText("Menu Principal");
        Btn_Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_MenuActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, -1, -1));

        Btn_Quitter.setText("Quitter");
        Btn_Quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_QuitterActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_Quitter, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 110, -1));

        jLabel2.setFont(new java.awt.Font("Shrek", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 204, 0));
        jLabel2.setText("T'es pas mouru l'âne !");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/FenetrePerdant .jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setToolTipText("");
        jLabel1.setPreferredSize(new java.awt.Dimension(725, 725));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_QuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_QuitterActionPerformed
        System.exit(0);
    }//GEN-LAST:event_Btn_QuitterActionPerformed

    private void Btn_RejouerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_RejouerActionPerformed
        // Fermer la fenêtre
        this.dispose();

        // Ouvrir la fenêtre principale avec le niveau de difficulté sélectionné
        Fenetre_Principale fenetrePrincipale = new Fenetre_Principale(this.Difficulte, this.ModeJeu, this.TaillePlateau, this.Position_Hor,this.Position_Vert,this.Nb_Melange);
        fenetrePrincipale.setVisible(true);

        fenetrePrincipale.setLocationRelativeTo(null);
    }//GEN-LAST:event_Btn_RejouerActionPerformed

    private void Btn_MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_MenuActionPerformed
        // Fermer la fenêtre
        this.dispose();
        
        // Ouvrir le menu
        Fenetre_Demarrer fenetreMenu=new Fenetre_Demarrer();
        fenetreMenu.setVisible(true);
        
        fenetreMenu.setLocationRelativeTo(null);
    }//GEN-LAST:event_Btn_MenuActionPerformed

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
            java.util.logging.Logger.getLogger(Fenetre_Victoire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fenetre_Victoire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fenetre_Victoire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fenetre_Victoire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Menu;
    private javax.swing.JButton Btn_Quitter;
    private javax.swing.JButton Btn_Rejouer;
    private javax.swing.JPanel Panel_Temps;
    private javax.swing.JLabel Txt_Temps;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
