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
public class customerForm extends javax.swing.JFrame {

    /**
     * Creates new form customerForm
     */
    public customerForm() {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Customer = new javax.swing.JLabel();
        bak = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Customer.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        Customer.setForeground(new java.awt.Color(255, 255, 255));
        Customer.setText("customer menu");
        getContentPane().add(Customer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 270, 60));

        bak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back-button_1.jpg"))); // NOI18N
        bak.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bakMouseClicked(evt);
            }
        });
        bak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bakActionPerformed(evt);
            }
        });
        getContentPane().add(bak, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 110, 30));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg.jpg"))); // NOI18N
        bg.setMaximumSize(new java.awt.Dimension(600, 540));
        bg.setMinimumSize(new java.awt.Dimension(600, 540));
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bakActionPerformed

    private void bakMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bakMouseClicked
            this.setVisible(false); 
      new LoginForm().setVisible(true);   // TODO add your handling code here:
    }//GEN-LAST:event_bakMouseClicked

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
            java.util.logging.Logger.getLogger(customerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(customerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(customerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(customerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new customerForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Customer;
    private javax.swing.JButton bak;
    private javax.swing.JLabel bg;
    // End of variables declaration//GEN-END:variables
}
