/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import BusinessLayerPackage.Staff;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class StaffRegister extends javax.swing.JFrame {

    /**
     * Creates new form StaffRegister
     */
    public StaffRegister() {
        initComponents();
        //
        Staff staffObj = new Staff();
        //
        ArrayList<String> campusList = staffObj.getCampusData();
        for (String c : campusList) {
            cmboCampusLocation1.addItem(c);
        }
        //
        ArrayList<String> departmentList = staffObj.getDepartmentData();
        for (String c : departmentList) {
            cmboDepartment.addItem(c);
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

        txtFirstName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtCell = new javax.swing.JTextField();
        txtStaffUsername = new javax.swing.JTextField();
        txtStaffPassword = new javax.swing.JPasswordField();
        btnBack = new javax.swing.JButton();
        btnRegister = new javax.swing.JButton();
        btnMinimize = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        cmboDepartment = new javax.swing.JComboBox<>();
        cmboCampusLocation1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 628));
        setMinimumSize(new java.awt.Dimension(800, 628));
        setPreferredSize(new java.awt.Dimension(800, 628));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 628));
        getContentPane().setLayout(null);

        txtFirstName.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtFirstName.setToolTipText("Enter First Name");
        txtFirstName.setBorder(null);
        txtFirstName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(txtFirstName);
        txtFirstName.setBounds(110, 170, 200, 20);

        txtLastName.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtLastName.setToolTipText("Enter Last Name");
        txtLastName.setBorder(null);
        txtLastName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(txtLastName);
        txtLastName.setBounds(110, 247, 200, 20);

        txtEmail.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtEmail.setToolTipText("Enter Email");
        txtEmail.setBorder(null);
        txtEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(txtEmail);
        txtEmail.setBounds(110, 320, 200, 20);

        txtCell.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtCell.setToolTipText("Enter Cellphone Number");
        txtCell.setBorder(null);
        txtCell.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(txtCell);
        txtCell.setBounds(110, 393, 200, 20);

        txtStaffUsername.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtStaffUsername.setToolTipText("Enter Username");
        txtStaffUsername.setBorder(null);
        txtStaffUsername.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(txtStaffUsername);
        txtStaffUsername.setBounds(520, 247, 200, 20);

        txtStaffPassword.setToolTipText("Enter Password");
        txtStaffPassword.setBorder(null);
        getContentPane().add(txtStaffPassword);
        txtStaffPassword.setBounds(520, 320, 200, 20);

        btnBack.setBackground(new java.awt.Color(226, 61, 57));
        btnBack.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");
        btnBack.setBorder(null);
        btnBack.setBorderPainted(false);
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack);
        btnBack.setBounds(520, 450, 180, 40);

        btnRegister.setBackground(new java.awt.Color(226, 61, 57));
        btnRegister.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(255, 255, 255));
        btnRegister.setText("Register");
        btnRegister.setBorder(null);
        btnRegister.setBorderPainted(false);
        btnRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegisterMouseClicked(evt);
            }
        });
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegister);
        btnRegister.setBounds(520, 400, 180, 40);

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

        cmboDepartment.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        cmboDepartment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Department" }));
        cmboDepartment.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cmboDepartment.setOpaque(false);
        getContentPane().add(cmboDepartment);
        cmboDepartment.setBounds(510, 170, 210, 30);

        cmboCampusLocation1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        cmboCampusLocation1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Campus" }));
        cmboCampusLocation1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        getContentPane().add(cmboCampusLocation1);
        cmboCampusLocation1.setBounds(100, 470, 210, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/StaffRegistration.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 600);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseClicked
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeMouseClicked

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {                                     
        int selection = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Please Note", JOptionPane.INFORMATION_MESSAGE);
        if (selection == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }                                    

    public Staff staffObj;
    public boolean isValid;

    private void btnRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisterMouseClicked
        staffObj = new Staff();
        isValid = true;
        //
        validateFirstName();
        validateLastName();
        validateEmail();
        validateCell();
        validateUsername();
        validatePassword();
        validateDepartment();
        validateCampus();
        //
        if (isValid) {
            Staff.insertStaff(staffObj);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Please Fix the fields highlighted in red and register again");
        }
    }//GEN-LAST:event_btnRegisterMouseClicked

    public void validateFirstName() {
        staffObj.setFirstName(txtFirstName.getText());
        if (staffObj.getFirstName() == "error") {
            txtFirstName.setBackground(Color.red);
            txtFirstName.setForeground(Color.white);
            txtFirstName.setToolTipText("Between 1 - 50 characters, No digits or special characters");
            isValid = false;
        } else {
            txtFirstName.setBackground(Color.white);
            txtFirstName.setForeground(Color.black);
            txtFirstName.setToolTipText("Validated!");
        }
        //
    }

    public void validateLastName() {
        staffObj.setLastName(txtLastName.getText());
        if (staffObj.getLastName() == "error") {
            txtLastName.setBackground(Color.red);
            txtLastName.setForeground(Color.white);
            txtLastName.setToolTipText("Between 1 - 50 characters, No digits or special characters");
            isValid = false;
        } else {
            txtLastName.setBackground(Color.white);
            txtLastName.setForeground(Color.black);
            txtLastName.setToolTipText("Validated!");
        }
        //
    }

    public void validateEmail() {
        staffObj.setEmail(txtEmail.getText());
        if (staffObj.getEmail() == "error") {
            txtEmail.setBackground(Color.red);
            txtEmail.setForeground(Color.white);
            txtEmail.setToolTipText("Between 5 - 50 characters, must contain @ and . sign");
            isValid = false;
        } else {
            txtEmail.setBackground(Color.white);
            txtEmail.setForeground(Color.black);
            txtEmail.setToolTipText("Validated!");
        }
        //
    }

    public void validateCell() {
        staffObj.setCellphone(txtCell.getText());
        if (staffObj.getCellphone() == "error") {
            txtCell.setBackground(Color.red);
            txtCell.setForeground(Color.white);
            txtCell.setToolTipText("only 10 digits, starting with a 0");
            isValid = false;
        } else {
            txtCell.setBackground(Color.white);
            txtCell.setForeground(Color.black);
            txtCell.setToolTipText("Validated!");
        }
        //
    }

    public void validateUsername() {
        staffObj.setUsername(txtStaffUsername.getText());
        if (staffObj.getUsername() == "error") {
            txtStaffUsername.setBackground(Color.red);
            txtStaffUsername.setForeground(Color.white);
            txtStaffUsername.setToolTipText("Between 5 - 50 characters");
            isValid = false;
        } else if (!Staff.isUniqueUsername(txtStaffUsername.getText())) {
            txtStaffUsername.setBackground(Color.red);
            txtStaffUsername.setForeground(Color.white);
            txtStaffUsername.setToolTipText("Username already exists");
            isValid = false;
        } else {
            txtStaffUsername.setBackground(Color.white);
            txtStaffUsername.setForeground(Color.black);
            txtStaffUsername.setToolTipText("Validated!");
        }
        //
    }

    public void validatePassword() {
        staffObj.setPassword(txtStaffPassword.getText());
        if (staffObj.getPassword() == "error") {
            txtStaffPassword.setBackground(Color.red);
            txtStaffPassword.setForeground(Color.white);
            txtStaffPassword.setToolTipText("Length between 5 and 50 characters");
            isValid = false;
        } else {
            txtStaffPassword.setBackground(Color.white);
            txtStaffPassword.setForeground(Color.black);
            txtStaffPassword.setToolTipText("Validated!");
        }
        //
    }

    public void validateDepartment() {
        staffObj.setDepartment(cmboDepartment.getSelectedIndex());
        if (cmboDepartment.getSelectedIndex() == 0) {
            cmboDepartment.setBackground(Color.red);
            cmboDepartment.setForeground(Color.white);
            cmboDepartment.setToolTipText("Select a department");
            isValid = false;
        } else {
            cmboDepartment.setBackground(Color.white);
            cmboDepartment.setForeground(Color.black);
            cmboDepartment.setToolTipText("Validated!");
        }
        //
    }

    public void validateCampus() {
        staffObj.setCampusLocation(cmboCampusLocation1.getSelectedIndex());
        if (cmboCampusLocation1.getSelectedIndex() == 0) {
            cmboCampusLocation1.setBackground(Color.red);
            cmboCampusLocation1.setForeground(Color.white);
            cmboCampusLocation1.setToolTipText("Select a location");
            isValid = false;
        } else {
            cmboCampusLocation1.setBackground(Color.white);
            cmboCampusLocation1.setForeground(Color.black);
            cmboCampusLocation1.setToolTipText("Validated!");
        }
        //
    }

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegisterActionPerformed

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
            java.util.logging.Logger.getLogger(StaffRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StaffRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StaffRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StaffRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StaffRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnMinimize;
    private javax.swing.JButton btnRegister;
    private javax.swing.JComboBox<String> cmboCampusLocation1;
    private javax.swing.JComboBox<String> cmboDepartment;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtCell;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JPasswordField txtStaffPassword;
    private javax.swing.JTextField txtStaffUsername;
    // End of variables declaration//GEN-END:variables
}
