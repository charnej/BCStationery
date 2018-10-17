/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import BusinessLayerPackage.Staff;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class StaffLogin extends javax.swing.JFrame {

    /**
     * Creates new form StaffLogin
     */
    public StaffLogin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtStaffUsername = new javax.swing.JTextField();
        btnMinimize = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnStaffRegister = new javax.swing.JButton();
        btnStaffLogin1 = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        btnAdmin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 628));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 628));
        getContentPane().setLayout(null);

        txtStaffUsername.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtStaffUsername.setText("Username");
        txtStaffUsername.setBorder(null);
        txtStaffUsername.setName(""); // NOI18N
        txtStaffUsername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtStaffUsernameMouseClicked(evt);
            }
        });
        txtStaffUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStaffUsernameActionPerformed(evt);
            }
        });
        getContentPane().add(txtStaffUsername);
        txtStaffUsername.setBounds(480, 230, 220, 30);

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
        btnMinimize.setBounds(720, 10, 30, 30);

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
        btnExit.setBounds(760, 10, 30, 30);

        btnStaffRegister.setBackground(new java.awt.Color(226, 61, 57));
        btnStaffRegister.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnStaffRegister.setForeground(new java.awt.Color(255, 255, 255));
        btnStaffRegister.setText("REGISTER");
        btnStaffRegister.setBorder(null);
        btnStaffRegister.setBorderPainted(false);
        btnStaffRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnStaffRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStaffRegisterActionPerformed(evt);
            }
        });
        getContentPane().add(btnStaffRegister);
        btnStaffRegister.setBounds(430, 430, 280, 40);

        btnStaffLogin1.setBackground(new java.awt.Color(226, 61, 57));
        btnStaffLogin1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnStaffLogin1.setForeground(new java.awt.Color(255, 255, 255));
        btnStaffLogin1.setText("LOGIN");
        btnStaffLogin1.setBorder(null);
        btnStaffLogin1.setBorderPainted(false);
        btnStaffLogin1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnStaffLogin1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStaffLogin1MouseClicked(evt);
            }
        });
        btnStaffLogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStaffLogin1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnStaffLogin1);
        btnStaffLogin1.setBounds(430, 360, 280, 40);

        txtPassword.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtPassword.setText("password");
        txtPassword.setToolTipText("Enter Password");
        txtPassword.setBorder(null);
        txtPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPasswordMouseClicked(evt);
            }
        });
        getContentPane().add(txtPassword);
        txtPassword.setBounds(470, 300, 230, 30);

        btnAdmin.setBackground(new java.awt.Color(255, 255, 255));
        btnAdmin.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        btnAdmin.setForeground(new java.awt.Color(226, 61, 57));
        btnAdmin.setText("Admin");
        btnAdmin.setToolTipText("Admin Department");
        btnAdmin.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        btnAdmin.setBorderPainted(false);
        btnAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdmin);
        btnAdmin.setBounds(10, 560, 90, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/StaffLogin.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 600);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtStaffUsernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtStaffUsernameMouseClicked
        txtStaffUsername.setText("");
    }//GEN-LAST:event_txtStaffUsernameMouseClicked

    private void btnMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseClicked
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeMouseClicked

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        int selection = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Please Note", JOptionPane.INFORMATION_MESSAGE);
        if (selection == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitMouseClicked

    private void txtPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMouseClicked
        txtPassword.setText("");
    }//GEN-LAST:event_txtPasswordMouseClicked

    private void btnStaffRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStaffRegisterActionPerformed
        StaffRegister register = new StaffRegister();
        register.setVisible(true);
    }//GEN-LAST:event_btnStaffRegisterActionPerformed

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
        AdminLogin adminLogin = new AdminLogin();
        adminLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAdminActionPerformed
    private int logInAtempts = 0;
    private void btnStaffLogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStaffLogin1ActionPerformed

        //Get all staff user objects
        Staff objHolder = new Staff();
        List<Staff> allStaff = objHolder.getStaff("All");
        boolean UserFound = false;
        for (Staff staffItem : allStaff) {
            if (staffItem.getUsername().equals(txtStaffUsername.getText())) {
                if (staffItem.getPassword().equals(txtPassword.getText())) {
                    //log in user user valid
                    UserFound = true;
                }
            }
        }
        if (UserFound) {
            //log in user
            StaffMenu staffMenu = new StaffMenu();
            staffMenu.setVisible(true);
            this.dispose();
        } else {
            //throw warning
            JOptionPane.showMessageDialog(null, "Wrong credentials", "Please Note", JOptionPane.WARNING_MESSAGE);
            //increase log in attempts
            logInAtempts++;
        }
    }//GEN-LAST:event_btnStaffLogin1ActionPerformed

    private void txtStaffUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStaffUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStaffUsernameActionPerformed

    private void btnStaffLogin1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStaffLogin1MouseClicked

    }//GEN-LAST:event_btnStaffLogin1MouseClicked

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
            java.util.logging.Logger.getLogger(StaffLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StaffLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StaffLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StaffLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StaffLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnMinimize;
    private javax.swing.JButton btnStaffLogin1;
    private javax.swing.JButton btnStaffRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtStaffUsername;
    // End of variables declaration//GEN-END:variables
}
//T
