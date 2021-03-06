/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import design.DBConn;
import design.Design;
import entity.Artist;
import entity.Show;
import entity.ShowPlace;
import java.awt.event.ItemEvent;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Etti
 */
public class createShowForm extends javax.swing.JFrame {
    
   String pr;
   String ag;
   java.sql.Date dte;
   ResultSet rs = null;
Map<Integer, String> locationIndex;
    /**
     * Creates new form createShow
     */
    public createShowForm() {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        locationIndex = new HashMap<Integer, String>();
        System.err.println("Activated createShowForm");
     try
    {    
        ResultSet rs = DBConn.query("SELECT * from Artist Where Artist.agentId=\""+DBConn.getAgentConnected().getAgentID()+"\"");
        jComboBoxArtists.removeAllItems();
        jComboBoxArtists.addItem("Select Main Artist");
        jComboBoxPlaces.removeAllItems();
        jComboBoxPlaces.addItem("Select Place");
        txtArtistName.setText("Select Main Artist");
        while(rs.next()){
            String alphanumericCode = rs.getString("alphanumericCode");
            String stageName = rs.getString("stageName");
             
            jComboBoxArtists.addItem(stageName);
        }
        
        ResultSet res = DBConn.query("SELECT showPlace.placeName, showPlace.placeNumber\n" +
                "FROM showPlace INNER JOIN agentChoosePlace ON showPlace.placeNumber = agentChoosePlace.placeNumber\n" +
                "WHERE (((agentChoosePlace.agentId)="+DBConn.getAgentConnected().getAgentID()+") AND ((agentChoosePlace.placeNumber)=[showPlace].[placeNumber]))");
         jComboBoxPlaces.removeAllItems();
         jComboBoxPlaces.addItem("Select place");
         int i=1;
         
         while(res.next()){
            String placeNumber = res.getString("placeNumber");
            String placeName = res.getString("placeName");
            // {001} Zapa : 0
            locationIndex.put(i, placeNumber);
            
            
            i++;
            
            
            jComboBoxPlaces.addItem(placeName);
            

            
         }
        ResultSet ress = DBConn.query("SELECT * from Artist Where Artist.agentId=\""+DBConn.getAgentConnected().getAgentID()+"\"");
         jComboBoxOtherArtists.removeAllItems();
         jComboBoxOtherArtists.addItem("Select Other Artist");
             
         while(ress.next()){
//            String appreciatedArtistId = ress.getString("appreciatedArtistId");
            String stageName = ress.getString("stageName");
            
            jComboBoxOtherArtists.addItem(stageName);
         }
         
            } catch (SQLException ex){
                 Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
    
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

        jScrollPane1 = new javax.swing.JScrollPane();
        lblheadForm = new javax.swing.JLabel();
        mainArtist = new javax.swing.JLabel();
        jComboBoxArtists = new javax.swing.JComboBox<>();
        showPlace = new javax.swing.JLabel();
        jComboBoxPlaces = new javax.swing.JComboBox<>();
        inviteOtherLabel = new javax.swing.JLabel();
        plus3 = new javax.swing.JLabel();
        txtArtistName = new javax.swing.JTextField();
        txtPlace = new javax.swing.JTextField();
        listOtherArtists = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        add = new javax.swing.JButton();
        dates = new javax.swing.JButton();
        jComboBoxOtherArtists = new javax.swing.JComboBox<>();
        back = new javax.swing.JButton();
        date = new javax.swing.JLabel();
        age = new javax.swing.JTextField();
        lblhour = new javax.swing.JLabel();
        txtplaceNumber = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        min = new javax.swing.JSpinner();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        price = new javax.swing.JTextField();
        hour = new javax.swing.JSpinner();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblheadForm.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        lblheadForm.setForeground(new java.awt.Color(255, 255, 255));
        lblheadForm.setText("create new show form");
        getContentPane().add(lblheadForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 340, 40));

        mainArtist.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        mainArtist.setForeground(new java.awt.Color(255, 255, 255));
        mainArtist.setText("choose your main artist ");
        getContentPane().add(mainArtist, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 240, 30));

        jComboBoxArtists.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxArtists.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxArtistsItemStateChanged(evt);
            }
        });
        jComboBoxArtists.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxArtistsActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxArtists, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 100, 20));

        showPlace.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        showPlace.setForeground(new java.awt.Color(255, 255, 255));
        showPlace.setText("choose show place");
        getContentPane().add(showPlace, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 170, 30));

        jComboBoxPlaces.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxPlaces.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxPlacesItemStateChanged(evt);
            }
        });
        jComboBoxPlaces.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPlacesActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxPlaces, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 100, -1));

        inviteOtherLabel.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        inviteOtherLabel.setForeground(new java.awt.Color(255, 255, 255));
        inviteOtherLabel.setText("invite other artists");
        getContentPane().add(inviteOtherLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 190, 30));

        plus3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plus.jpg"))); // NOI18N
        getContentPane().add(plus3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 60, 60));

        txtArtistName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtArtistNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtArtistName, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 90, -1));

        txtPlace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlaceActionPerformed(evt);
            }
        });
        getContentPane().add(txtPlace, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 60, -1));

        jList1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        listOtherArtists.setViewportView(jList1);

        getContentPane().add(listOtherArtists, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, 80, 130));

        add.setText("add show");
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
        });
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        getContentPane().add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 490, -1, -1));

        dates.setText("check place datails");
        dates.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                datesItemStateChanged(evt);
            }
        });
        dates.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                datesMouseClicked(evt);
            }
        });
        dates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datesActionPerformed(evt);
            }
        });
        getContentPane().add(dates, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 170, -1));

        jComboBoxOtherArtists.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxOtherArtists.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxOtherArtistsItemStateChanged(evt);
            }
        });
        jComboBoxOtherArtists.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxOtherArtistsActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxOtherArtists, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, 140, -1));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back-button.jpg"))); // NOI18N
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 100, 30));

        date.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        date.setForeground(new java.awt.Color(255, 255, 255));
        date.setText("choose Show Date");
        getContentPane().add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 170, -1));
        getContentPane().add(age, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 90, -1));

        lblhour.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        lblhour.setForeground(new java.awt.Color(255, 255, 255));
        lblhour.setText("choose Show hour(HH:MM)");
        getContentPane().add(lblhour, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 240, -1));
        getContentPane().add(txtplaceNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, 60, -1));

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ticket price");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, -1));

        jLabel2.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("minimum age");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));
        getContentPane().add(min, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 40, -1));
        getContentPane().add(jXDatePicker1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, -1, -1));
        getContentPane().add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 90, -1));
        getContentPane().add(hour, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 40, -1));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg.jpg"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxOtherArtistsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxOtherArtistsActionPerformed
    }//GEN-LAST:event_jComboBoxOtherArtistsActionPerformed

    private void jComboBoxOtherArtistsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxOtherArtistsItemStateChanged
        if(evt.getStateChange() != ItemEvent.SELECTED)
            return;
 
        DefaultListModel lisrArt = new DefaultListModel();
        for(int i=0 ; i < 10 ; i++){
            lisrArt.addElement(jComboBoxArtists.getSelectedItem().toString());
        }
        jList1.setModel(lisrArt);
            
    }//GEN-LAST:event_jComboBoxOtherArtistsItemStateChanged

    private void txtPlaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlaceActionPerformed

    private void jComboBoxArtistsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxArtistsActionPerformed
        
    }//GEN-LAST:event_jComboBoxArtistsActionPerformed
 
    
    private void txtArtistNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtArtistNameActionPerformed
        
    }//GEN-LAST:event_txtArtistNameActionPerformed

    private void jComboBoxArtistsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxArtistsItemStateChanged
        if(evt.getStateChange() != ItemEvent.SELECTED)
            return;
        if(evt.getItem().equals("Select Main Artist"))
            return;
        txtArtistName.setText(jComboBoxArtists.getSelectedItem().toString());       
    }//GEN-LAST:event_jComboBoxArtistsItemStateChanged

    private void jComboBoxPlacesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPlacesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPlacesActionPerformed

    private void jComboBoxPlacesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxPlacesItemStateChanged
        if(evt.getStateChange() != ItemEvent.SELECTED)
            return;
        
        if(evt.getItem().equals("Select Place"))
            return;
        txtPlace.setText(jComboBoxPlaces.getSelectedItem().toString());
        
        txtplaceNumber.setText(""+jComboBoxPlaces.getSelectedIndex());
        
    }//GEN-LAST:event_jComboBoxPlacesItemStateChanged

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
        //Show newShow = new Show(txtArtistName.getText(), txtPlace.getText());
            // TODO add your handling code here:
    }//GEN-LAST:event_addMouseClicked

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
     //  try{
    //       String sql = "Insert Into Show(showNumber,mainArtist, dateAndHourOfShow, placeNumber, status, ticketPrice,minimumAge,numberOfLeftTickets,agentcreatedId "
    //   }
     //  catch{  
    //   }
    }//GEN-LAST:event_addActionPerformed

    private void datesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datesActionPerformed
   //     ShowPlace Ptmp = new ShowPlace();
     //   this.setVisible(false);
     //   System.err.println("check availble dates logged in");
    //    Ptmp.setVisible(true);    
    }//GEN-LAST:event_datesActionPerformed

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
      this.setVisible(false); 
      new AgentForm().setVisible(true);   
    }//GEN-LAST:event_backMouseClicked

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_backActionPerformed

    private void datesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datesMouseClicked
        this.setVisible(false); 
      new PlaceDetails(this, locationIndex.get(jComboBoxPlaces.getSelectedIndex())).setVisible(true);   
    }//GEN-LAST:event_datesMouseClicked

    private void datesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_datesItemStateChanged
       
    }//GEN-LAST:event_datesItemStateChanged

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
            java.util.logging.Logger.getLogger(createShowForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createShowForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createShowForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createShowForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createShowForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JTextField age;
    private javax.swing.JButton back;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel date;
    private javax.swing.JButton dates;
    private javax.swing.JSpinner hour;
    private javax.swing.JLabel inviteOtherLabel;
    private javax.swing.JComboBox<String> jComboBoxArtists;
    private javax.swing.JComboBox<String> jComboBoxOtherArtists;
    private javax.swing.JComboBox<String> jComboBoxPlaces;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private javax.swing.JLabel lblheadForm;
    private javax.swing.JLabel lblhour;
    private javax.swing.JScrollPane listOtherArtists;
    private javax.swing.JLabel mainArtist;
    private javax.swing.JSpinner min;
    private javax.swing.JLabel plus3;
    private javax.swing.JTextField price;
    private javax.swing.JLabel showPlace;
    private javax.swing.JTextField txtArtistName;
    private javax.swing.JTextField txtPlace;
    private javax.swing.JTextField txtplaceNumber;
    // End of variables declaration//GEN-END:variables
}
