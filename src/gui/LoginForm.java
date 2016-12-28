/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import design.DBConn;
import entity.Artist;
import entity.Agent;
import entity.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import entity.Show;

/**
 *
 * @author Etti
 */
public class LoginForm extends javax.swing.JFrame {

    Boolean skipLogin = true;

    /**
     * Creates new form createNewShow
     */
    public LoginForm() {
        setUndecorated(true);
        if (skipLogin) {
            Agent a = new Agent("111111111", "1");
            DBConn.setAgentConnected(a);
            JOptionPane.showMessageDialog(null, "Logged in as Agent!");
            System.err.println("Agent logged in");
            AgentForm ag = new AgentForm();
            this.setVisible(false);
            ag.setVisible(true);
            return;
        }
        initComponents();
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

        jUserNameField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        lblPassword = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        lblExit = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblbackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(640, 500));
        getContentPane().setLayout(null);
        getContentPane().add(jUserNameField1);
        jUserNameField1.setBounds(220, 330, 130, 30);
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(220, 370, 130, 30);

        lblPassword.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword.setText("Password");
        getContentPane().add(lblPassword);
        lblPassword.setBounds(110, 370, 110, 40);

        lblLogin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblLogin.setForeground(new java.awt.Color(255, 255, 255));
        lblLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login.png"))); // NOI18N
        lblLogin.setMaximumSize(new java.awt.Dimension(10, 8));
        lblLogin.setMinimumSize(new java.awt.Dimension(50, 30));
        lblLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLoginMouseClicked(evt);
            }
        });
        getContentPane().add(lblLogin);
        lblLogin.setBounds(230, 410, 100, 43);

        lblUserName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblUserName.setForeground(new java.awt.Color(255, 255, 255));
        lblUserName.setText("UserName");
        getContentPane().add(lblUserName);
        lblUserName.setBounds(110, 320, 100, 50);

        lblExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        lblExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExitMouseClicked(evt);
            }
        });
        getContentPane().add(lblExit);
        lblExit.setBounds(20, 460, 40, 40);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(20, 460, 40, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/muza.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(180, 230, 190, 90);

        lblbackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bgColdpla.jpg"))); // NOI18N
        getContentPane().add(lblbackground);
        lblbackground.setBounds(0, 0, 530, 530);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoginMouseClicked

        String ext = new String(jPasswordField1.getPassword());
        String user = jUserNameField1.getText();
        String pass = jPasswordField1.getText();

        //Cycle through customers
        //Search if user = customer
        try {
            ResultSet rs = DBConn.query("select * from Customer where Customer.customerId=\"" + user + "\" AND Customer.Password=\"" + pass + "\"");

            while (rs.next()) {

                //Found Customer
                String CustomerID = rs.getString("customerId");
                String firstName = rs.getString("FirstName");
                //continue

                Customer c = new Customer(CustomerID, firstName);
                DBConn.setCustomerConnected(c);
                JOptionPane.showMessageDialog(null, "Logged in as Customer!");
                customerForm Cus = new customerForm();
                this.setVisible(false);
                Cus.setVisible(true);
                return;

            }

            rs = DBConn.query("select * from Agent where agentId=\"" + user + "\" AND Password=\"" + pass + "\"");

            while (rs.next()) {
                //Found Agent
                String AgentID = rs.getString("agentId");
                String FirstName = rs.getString("firstName");

                Agent a = new Agent(AgentID, FirstName);
                DBConn.setAgentConnected(a);
                JOptionPane.showMessageDialog(null, "Logged in as Agent!");
                System.err.println("Agent logged in");
                AgentForm ag = new AgentForm();
                this.setVisible(false);
                ag.setVisible(true);
                return;

            }
            rs = DBConn.query("select * from Artist Where alphanumericCode=\"" + user + "\" AND Password=\"" + pass + "\"");

            while (rs.next()) {
                // Found artist
                String alphanumericCode = rs.getString("alphanumericCode");
                String Password = rs.getString("Password");
                System.err.println("etti");
                Artist art = new Artist(alphanumericCode, Password);
                DBConn.setArtistConnected(art);
                JOptionPane.showMessageDialog(null, "Login successful as Artist !");
                artistForm af = new artistForm();
                this.setVisible(false);
                af.setVisible(true);
                return;
            }
            //Cycle through agents
            //Search if user = agent

            //.....
        } catch (SQLException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Login Faild!");
        return;


    }//GEN-LAST:event_lblLoginMouseClicked

    private void lblExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseClicked
        this.setVisible(false);
         }//GEN-LAST:event_lblExitMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jButton1.setVisible(false);
        jButton1.setText(null);

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jUserNameField1;
    private javax.swing.JLabel lblExit;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JLabel lblbackground;
    // End of variables declaration//GEN-END:variables
}
