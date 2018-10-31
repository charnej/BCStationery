/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import BusinessLayerPackage.RequestDetails;
import BusinessLayerPackage.Staff;
import BusinessLayerPackage.StaffRequest;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class RequestItems extends javax.swing.JFrame {

    /**
     * Creates new form RequestItems
     */
    public RequestItems() {
        initComponents();
        //
        bindData();
    }

    public void bindData() {
        txtProductName.setText(StaffItems.chosenItem.getProductName());
        txtManufacturer.setText(StaffItems.chosenItem.getManufacturer());
        txtCategory.setText(StaffItems.chosenItem.getCategory());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnMinimize = new javax.swing.JButton();
        btnBackLogout = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnSendRequest = new javax.swing.JButton();
        txtManufacturer = new javax.swing.JTextField();
        spnQtyAdd = new javax.swing.JSpinner();
        txtProductName = new javax.swing.JTextField();
        txtCategory = new javax.swing.JTextField();
        frameMove = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        btnMinimize.setBackground(new java.awt.Color(255, 255, 255));
        btnMinimize.setForeground(new java.awt.Color(255, 255, 255));
        btnMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/minimize.png"))); // NOI18N
        btnMinimize.setToolTipText("Minimize");
        btnMinimize.setBorder(null);
        btnMinimize.setBorderPainted(false);
        btnMinimize.setContentAreaFilled(false);
        btnMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseClicked(evt);
            }
        });
        getContentPane().add(btnMinimize);
        btnMinimize.setBounds(680, 10, 31, 31);

        btnBackLogout.setBackground(new java.awt.Color(255, 255, 255));
        btnBackLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnBackLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back.png"))); // NOI18N
        btnBackLogout.setToolTipText("Back");
        btnBackLogout.setBorder(null);
        btnBackLogout.setBorderPainted(false);
        btnBackLogout.setContentAreaFilled(false);
        btnBackLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBackLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBackLogoutMouseClicked(evt);
            }
        });
        btnBackLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackLogoutActionPerformed(evt);
            }
        });
        getContentPane().add(btnBackLogout);
        btnBackLogout.setBounds(720, 10, 31, 31);

        btnExit.setBackground(new java.awt.Color(255, 255, 255));
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/exit.png"))); // NOI18N
        btnExit.setToolTipText("Exit");
        btnExit.setBorderPainted(false);
        btnExit.setContentAreaFilled(false);
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });
        getContentPane().add(btnExit);
        btnExit.setBounds(750, 10, 50, 30);

        btnSendRequest.setBackground(new java.awt.Color(254, 212, 29));
        btnSendRequest.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSendRequest.setText("Send Request");
        btnSendRequest.setBorderPainted(false);
        btnSendRequest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSendRequestMouseClicked(evt);
            }
        });
        btnSendRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendRequestActionPerformed(evt);
            }
        });
        getContentPane().add(btnSendRequest);
        btnSendRequest.setBounds(500, 390, 140, 30);

        txtManufacturer.setEditable(false);
        txtManufacturer.setBackground(new java.awt.Color(255, 255, 255));
        txtManufacturer.setBorder(null);
        getContentPane().add(txtManufacturer);
        txtManufacturer.setBounds(140, 310, 200, 30);

        spnQtyAdd.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));
        spnQtyAdd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        getContentPane().add(spnQtyAdd);
        spnQtyAdd.setBounds(500, 220, 130, 30);

        txtProductName.setEditable(false);
        txtProductName.setBackground(new java.awt.Color(255, 255, 255));
        txtProductName.setBorder(null);
        getContentPane().add(txtProductName);
        txtProductName.setBounds(140, 220, 190, 30);

        txtCategory.setEditable(false);
        txtCategory.setBackground(new java.awt.Color(255, 255, 255));
        txtCategory.setBorder(null);
        getContentPane().add(txtCategory);
        txtCategory.setBounds(140, 400, 200, 30);

        frameMove.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                frameMoveMouseDragged(evt);
            }
        });
        frameMove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                frameMoveMousePressed(evt);
            }
        });
        getContentPane().add(frameMove);
        frameMove.setBounds(4, 0, 670, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/itemRequestForm1.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 600);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseClicked
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeMouseClicked

    private void btnBackLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackLogoutMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackLogoutMouseClicked

    private void btnBackLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackLogoutActionPerformed
        StaffItems staffItems = new StaffItems();
        staffItems.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackLogoutActionPerformed

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        int selection = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Please Note", JOptionPane.INFORMATION_MESSAGE);
        if (selection == JOptionPane.YES_OPTION) {
           Staff.updateStaffLoggedIn(StaffLogin.activeUser.getUsername(), 0);
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnSendRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendRequestActionPerformed

    }//GEN-LAST:event_btnSendRequestActionPerformed

    private void btnSendRequestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSendRequestMouseClicked
        int selection = JOptionPane.showConfirmDialog(null, "Send Item Request", "Item Request", JOptionPane.INFORMATION_MESSAGE);
        if (selection == JOptionPane.YES_OPTION) {
            int packageNum = StaffRequest.isPackage(Date.valueOf(LocalDate.now()), StaffLogin.activeUser.getUserID());//checks if a package has been created already
            if (packageNum == -1) { // packages created based on dates
                StaffRequest.insertStaffRequest(Date.valueOf(LocalDate.now()), StaffLogin.activeUser.getUserID());
                packageNum = StaffRequest.isPackage(Date.valueOf(LocalDate.now()), StaffLogin.activeUser.getUserID());
            }
            //
            if (RequestDetails.testPackageItem(packageNum, StaffItems.chosenItem.getStockID())) {
                int qty = (int) spnQtyAdd.getValue();
                RequestDetails.insertRequestDetails(packageNum, StaffItems.chosenItem.getStockID(), qty);
            } else {
                JOptionPane.showMessageDialog(null, "This Package already contains this Item\nYou can Request this Item again Tomorrow");
            }

        }
    }//GEN-LAST:event_btnSendRequestMouseClicked

    int xMouse;
    int yMouse;
    private void frameMoveMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_frameMoveMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xMouse, y - yMouse);

    }//GEN-LAST:event_frameMoveMouseDragged

    private void frameMoveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_frameMoveMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_frameMoveMousePressed

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
                if ("Windows Classic".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RequestItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RequestItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RequestItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RequestItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RequestItems().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackLogout;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnMinimize;
    private javax.swing.JButton btnSendRequest;
    private javax.swing.JLabel frameMove;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSpinner spnQtyAdd;
    private javax.swing.JTextField txtCategory;
    private javax.swing.JTextField txtManufacturer;
    private javax.swing.JTextField txtProductName;
    // End of variables declaration//GEN-END:variables
}
