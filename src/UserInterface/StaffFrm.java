/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import BusinessLayerPackage.Staff;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class StaffFrm extends javax.swing.JFrame {

    /**
     * Creates new form Staff
     */
    public StaffFrm() {
        initComponents();
        btnAcceptStaff.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnViewAllStaff = new javax.swing.JButton();
        btnViewPendingStaff = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStaff = new javax.swing.JTable();
        btnAcceptStaff = new javax.swing.JButton();
        btnMinimize = new javax.swing.JButton();
        btnBackLogout = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1031, 665));
        setResizable(false);
        getContentPane().setLayout(null);

        btnViewAllStaff.setBackground(new java.awt.Color(254, 212, 29));
        btnViewAllStaff.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnViewAllStaff.setText("View All Staff");
        btnViewAllStaff.setBorderPainted(false);
        btnViewAllStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewAllStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnViewAllStaffMouseClicked(evt);
            }
        });
        getContentPane().add(btnViewAllStaff);
        btnViewAllStaff.setBounds(170, 170, 190, 37);

        btnViewPendingStaff.setBackground(new java.awt.Color(254, 212, 29));
        btnViewPendingStaff.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnViewPendingStaff.setText("View Pending Staff");
        btnViewPendingStaff.setBorderPainted(false);
        btnViewPendingStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewPendingStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnViewPendingStaffMouseClicked(evt);
            }
        });
        btnViewPendingStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewPendingStaffActionPerformed(evt);
            }
        });
        getContentPane().add(btnViewPendingStaff);
        btnViewPendingStaff.setBounds(390, 170, 240, 37);

        tblStaff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Staff ID", "Username", "Password", "First Name", "Last Name", "Email", "Cell- number", "Department", "Campus Location"
            }
        ));
        jScrollPane1.setViewportView(tblStaff);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(164, 224, 758, 270);

        btnAcceptStaff.setBackground(new java.awt.Color(254, 212, 29));
        btnAcceptStaff.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnAcceptStaff.setText("Accept Staff");
        btnAcceptStaff.setBorderPainted(false);
        btnAcceptStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAcceptStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAcceptStaffMouseClicked(evt);
            }
        });
        getContentPane().add(btnAcceptStaff);
        btnAcceptStaff.setBounds(741, 510, 180, 33);

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
        btnMinimize.setBounds(910, 10, 31, 31);

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
        btnBackLogout.setBounds(950, 10, 31, 31);

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
        btnExit.setBounds(980, 10, 50, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/StaffBG.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1031, 637);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewPendingStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewPendingStaffActionPerformed
        btnAcceptStaff.setVisible(true);
    }//GEN-LAST:event_btnViewPendingStaffActionPerformed

    private void btnMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseClicked
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeMouseClicked

    private void btnBackLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackLogoutMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackLogoutMouseClicked

    private void btnBackLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackLogoutActionPerformed
        Menu menu = new Menu();
        menu.setVisible(true);;
        this.dispose();
    }//GEN-LAST:event_btnBackLogoutActionPerformed

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
         int selection = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Please Note", JOptionPane.INFORMATION_MESSAGE);
        if (selection == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnViewAllStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewAllStaffMouseClicked
        btnAcceptStaff.setVisible(false);

        ArrayList<Staff> staffList = Staff.getStaff("Accepted");
        addTableData(staffList);
    }//GEN-LAST:event_btnViewAllStaffMouseClicked

    private void btnViewPendingStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewPendingStaffMouseClicked
        btnAcceptStaff.setVisible(true);

        ArrayList<Staff> staffList = Staff.getStaff("Pending");
        addTableData(staffList);
    }//GEN-LAST:event_btnViewPendingStaffMouseClicked

    private void btnAcceptStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAcceptStaffMouseClicked
        try {
            int id = (int) tblStaff.getValueAt(tblStaff.getSelectedRow(), 0);
            String name = tblStaff.getValueAt(tblStaff.getSelectedRow(), 3).toString();
            Staff.acceptPendingStaff(name, id);
            //
            ArrayList<Staff> staffList = Staff.getStaff("Pending");
            addTableData(staffList);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please select a valid Staff Request to Accept");
        }
    }//GEN-LAST:event_btnAcceptStaffMouseClicked

    public void addTableData(ArrayList<Staff> staffList) {
        DefaultTableModel model = (DefaultTableModel) tblStaff.getModel();
        model.setRowCount(0);
        Object rowData[] = new Object[9];
        for (Staff s : staffList) {
            rowData[0] = s.getUserID();
            rowData[1] = s.getUsername();
            rowData[2] = s.getPasswordEncrypt();
            rowData[3] = s.getFirstName();
            rowData[4] = s.getLastName();
            rowData[5] = s.getEmail();
            rowData[6] = s.getCellphone();
            rowData[7] = s.getDepartmentName();
            rowData[8] = s.getCampusName();
            model.addRow(rowData);
        }
    }

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
            java.util.logging.Logger.getLogger(StaffFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StaffFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StaffFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StaffFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StaffFrm().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcceptStaff;
    private javax.swing.JButton btnBackLogout;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnMinimize;
    private javax.swing.JButton btnViewAllStaff;
    private javax.swing.JButton btnViewPendingStaff;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblStaff;
    // End of variables declaration//GEN-END:variables
}
