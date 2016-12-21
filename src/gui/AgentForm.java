/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author Etti
 */
public class AgentForm extends javax.swing.JFrame {

    /**
     * Creates new form AgentForm
     */
    public AgentForm() {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        System.err.println("Activated agentForm");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        agentImage = new javax.swing.JLabel();
        head = new javax.swing.JLabel();
        createShowForm = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        agentImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images.jpg"))); // NOI18N
        getContentPane().add(agentImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, 110));

        head.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        head.setForeground(new java.awt.Color(255, 255, 255));
        head.setText("what do you want to do today?");
        getContentPane().add(head, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 390, -1));

        createShowForm.setFont(new java.awt.Font("Perpetua Titling MT", 1, 11)); // NOI18N
        createShowForm.setText("create new show");
        createShowForm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createShowFormMouseClicked(evt);
            }
        });
        getContentPane().add(createShowForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 160, -1));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg.jpg"))); // NOI18N
        bg.setText("what ");
        bg.setMaximumSize(new java.awt.Dimension(600, 540));
        bg.setMinimumSize(new java.awt.Dimension(600, 540));
        bg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bgMouseClicked(evt);
            }
        });
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 513, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgMouseClicked
        
    }//GEN-LAST:event_bgMouseClicked

    private void createShowFormMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createShowFormMouseClicked
        createShowForm tmp = new createShowForm();
        this.setVisible(false);
        System.err.println("create show logged in");
        tmp.setVisible(true);
    }//GEN-LAST:event_createShowFormMouseClicked

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
            java.util.logging.Logger.getLogger(AgentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgentForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel agentImage;
    private javax.swing.JLabel bg;
    private javax.swing.JButton createShowForm;
    private javax.swing.JLabel head;
    // End of variables declaration//GEN-END:variables
}
