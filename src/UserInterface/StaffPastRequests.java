/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;
//t

import BusinessLayerPackage.IRequestDetails;
import BusinessLayerPackage.IStaff;
import BusinessLayerPackage.IStaffRequest;
import BusinessLayerPackage.RequestDetails;
import BusinessLayerPackage.SingleRegistry;
import BusinessLayerPackage.Staff;
import BusinessLayerPackage.StaffRequest;
import DataAccessLayerPackage.StaffRequestHandler;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class StaffPastRequests extends javax.swing.JFrame {

    /**
     * Creates new form StaffPastRequests
     */
    public StaffPastRequests() {
        try {
            this.requestImpl = (IStaffRequest) SingleRegistry.getInstance().getRegistry().lookup("request");
            this.staffRequestsList = requestImpl.getStaffRequests(StaffRequestHandler.requestType.All, StaffLogin.activeUser.getUserID());
            initComponents();
            btnRemoveRequest.setVisible(false);
            parentMode();
        } catch (RemoteException ex) {
            Logger.getLogger(StaffPastRequests.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(StaffPastRequests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void testState(ArrayList<StaffRequest> staffRequests) {
        for (StaffRequest staffRequest : staffRequests) {
            if (RequestDetails.testPackageState(staffRequest.getRequestNr())) {
                staffRequest.updateState(StaffRequestHandler.stateType.Complete, staffRequest.getRequestNr());
            } else {
                staffRequest.updateState(StaffRequestHandler.stateType.Incomplete, staffRequest.getRequestNr());
            }
        }
    }

    public String mode = "";

    public void parentMode() {
        try {
            tblRequests.setEnabled(true);
            btnEnterRequestPackage.setVisible(true);
            btnRemoveRequest.setVisible(false);
            tblRequestDetails.setVisible(false);
            btnCloseRequestPackage.setVisible(false);
            //
            IStaffRequest requestImp = (IStaffRequest) SingleRegistry.getInstance().getRegistry().lookup("request");
            ArrayList<StaffRequest> staffRequests = requestImp.getStaffRequests(StaffRequestHandler.requestType.All, StaffLogin.activeUser.getUserID());
            addParentTableData(staffRequests);
            //
            mode = "p";
        } catch (NotBoundException ex) {
            Logger.getLogger(StaffPastRequests.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(StaffPastRequests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void childMode() {
        try {
            tblRequests.setEnabled(false);
            btnEnterRequestPackage.setVisible(false);
            btnRemoveRequest.setVisible(false);
            tblRequestDetails.setVisible(true);
            btnCloseRequestPackage.setVisible(true);
            //
            IRequestDetails rDetailsImp = (IRequestDetails) SingleRegistry.getInstance().getRegistry().lookup("rDetails");
            ArrayList<RequestDetails> requestDetails = rDetailsImp.getRequestDetails(StaffRequestHandler.requestType.All, StaffLogin.activeUser.getUserID(), requestNr);
            addChildTableData(requestDetails);
            //
            mode = "c";
        } catch (NotBoundException ex) {
            Logger.getLogger(StaffPastRequests.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(StaffPastRequests.class.getName()).log(Level.SEVERE, null, ex);
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
        tblRequests = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRequestDetails = new javax.swing.JTable();
        btnViewIncomRequests = new javax.swing.JButton();
        btnViewAllRequests1 = new javax.swing.JButton();
        btnViewDoneRequests1 = new javax.swing.JButton();
        btnMinimize = new javax.swing.JButton();
        btnBackLogout = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnCloseRequestPackage = new javax.swing.JButton();
        btnEnterRequestPackage = new javax.swing.JButton();
        btnRemoveRequest = new javax.swing.JButton();
        frameMove = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1030, 637));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        tblRequests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request", "Date"
            }
        ));
        jScrollPane1.setViewportView(tblRequests);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(110, 230, 250, 290);

        tblRequestDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Detail ID", "Product", "Manufacturer", "Category", "Quantity", "Date Completed"
            }
        ));
        jScrollPane2.setViewportView(tblRequestDetails);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(380, 230, 550, 290);

        btnViewIncomRequests.setBackground(new java.awt.Color(254, 212, 29));
        btnViewIncomRequests.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnViewIncomRequests.setText("View Incomplete Requests");
        btnViewIncomRequests.setBorderPainted(false);
        btnViewIncomRequests.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewIncomRequests.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnViewIncomRequestsMouseClicked(evt);
            }
        });
        getContentPane().add(btnViewIncomRequests);
        btnViewIncomRequests.setBounds(480, 170, 220, 40);

        btnViewAllRequests1.setBackground(new java.awt.Color(254, 212, 29));
        btnViewAllRequests1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnViewAllRequests1.setText("View All Requests");
        btnViewAllRequests1.setBorderPainted(false);
        btnViewAllRequests1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewAllRequests1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnViewAllRequests1MouseClicked(evt);
            }
        });
        btnViewAllRequests1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAllRequests1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnViewAllRequests1);
        btnViewAllRequests1.setBounds(110, 170, 160, 40);

        btnViewDoneRequests1.setBackground(new java.awt.Color(254, 212, 29));
        btnViewDoneRequests1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnViewDoneRequests1.setText("View Complete Requests");
        btnViewDoneRequests1.setBorderPainted(false);
        btnViewDoneRequests1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewDoneRequests1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnViewDoneRequests1MouseClicked(evt);
            }
        });
        getContentPane().add(btnViewDoneRequests1);
        btnViewDoneRequests1.setBounds(280, 170, 190, 40);

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

        btnCloseRequestPackage.setBackground(new java.awt.Color(226, 61, 57));
        btnCloseRequestPackage.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCloseRequestPackage.setForeground(new java.awt.Color(255, 255, 255));
        btnCloseRequestPackage.setText("Close Package");
        btnCloseRequestPackage.setBorderPainted(false);
        btnCloseRequestPackage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseRequestPackageMouseClicked(evt);
            }
        });
        btnCloseRequestPackage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseRequestPackageActionPerformed(evt);
            }
        });
        getContentPane().add(btnCloseRequestPackage);
        btnCloseRequestPackage.setBounds(790, 530, 140, 30);

        btnEnterRequestPackage.setBackground(new java.awt.Color(226, 61, 57));
        btnEnterRequestPackage.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEnterRequestPackage.setForeground(new java.awt.Color(255, 255, 255));
        btnEnterRequestPackage.setText("Open Package");
        btnEnterRequestPackage.setBorderPainted(false);
        btnEnterRequestPackage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnterRequestPackageMouseClicked(evt);
            }
        });
        btnEnterRequestPackage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterRequestPackageActionPerformed(evt);
            }
        });
        getContentPane().add(btnEnterRequestPackage);
        btnEnterRequestPackage.setBounds(110, 530, 140, 30);

        btnRemoveRequest.setBackground(new java.awt.Color(226, 61, 57));
        btnRemoveRequest.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnRemoveRequest.setForeground(new java.awt.Color(255, 255, 255));
        btnRemoveRequest.setText("Remove Request");
        btnRemoveRequest.setBorderPainted(false);
        btnRemoveRequest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRemoveRequestMouseClicked(evt);
            }
        });
        btnRemoveRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveRequestActionPerformed(evt);
            }
        });
        getContentPane().add(btnRemoveRequest);
        btnRemoveRequest.setBounds(640, 530, 140, 30);

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
        frameMove.setBounds(4, 0, 900, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/requesthistory.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1030, 637);

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
        StaffMenu menu = new StaffMenu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackLogoutActionPerformed

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        int selection = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Please Note", JOptionPane.INFORMATION_MESSAGE);
        if (selection == JOptionPane.YES_OPTION) {
            try {
                IStaff staffImp = (IStaff) SingleRegistry.getInstance().getRegistry().lookup("staff");
                staffImp.updateStaffLoggedIn(StaffLogin.activeUser.getUsername(), 0);
                System.exit(0);
            } catch (RemoteException ex) {
                Logger.getLogger(StaffPastRequests.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(StaffPastRequests.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnRemoveRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveRequestActionPerformed
        //        int option = JOptionPane.showOptionDialog(null, "Edit quantity or remove?", "Option", JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Edit", "Remove"}, "default");
        //        if (option == JOptionPane.OK_OPTION) {
        //            String qty = JOptionPane.showInputDialog(null, "Enter new quantity","Quantity",JOptionPane.OK_CANCEL_OPTION);
        //        }
    }//GEN-LAST:event_btnRemoveRequestActionPerformed

    public int requestNr;
    public IStaffRequest requestImpl;
    public ArrayList<StaffRequest> staffRequestsList;

    private void btnViewAllRequests1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewAllRequests1MouseClicked
        if (mode.equals("p")) {
            try {
                IStaffRequest requestImp = (IStaffRequest) SingleRegistry.getInstance().getRegistry().lookup("request");
                ArrayList<StaffRequest> staffRequests = requestImp.getStaffRequests(StaffRequestHandler.requestType.All, StaffLogin.activeUser.getUserID());
                addParentTableData(staffRequests);
            } catch (NotBoundException ex) {
                Logger.getLogger(StaffPastRequests.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                Logger.getLogger(StaffPastRequests.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (mode.equals("c")) {
            try {
                IRequestDetails rDetailsImp = (IRequestDetails) SingleRegistry.getInstance().getRegistry().lookup("rDetails");
                ArrayList<RequestDetails> requestDetails = rDetailsImp.getRequestDetails(StaffRequestHandler.requestType.All, StaffLogin.activeUser.getUserID(), requestNr);
                addChildTableData(requestDetails);
                btnRemoveRequest.setVisible(false);
            } catch (NotBoundException ex) {
                Logger.getLogger(StaffPastRequests.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                Logger.getLogger(StaffPastRequests.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnViewAllRequests1MouseClicked

    private void btnViewDoneRequests1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewDoneRequests1MouseClicked
        if (mode.equals("p")) {
            try {
                testState(staffRequestsList);
                IStaffRequest requestImp = (IStaffRequest) SingleRegistry.getInstance().getRegistry().lookup("request");
                ArrayList<StaffRequest> staffRequests = requestImp.getStaffRequests(StaffRequestHandler.requestType.Complete, StaffLogin.activeUser.getUserID());
                addParentTableData(staffRequests);
            } catch (RemoteException ex) {
                Logger.getLogger(StaffPastRequests.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(StaffPastRequests.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (mode.equals("c")) {
            try {
                IRequestDetails rDetailsImp = (IRequestDetails) SingleRegistry.getInstance().getRegistry().lookup("rDetails");
                ArrayList<RequestDetails> requestDetails = rDetailsImp.getRequestDetails(StaffRequestHandler.requestType.Complete, StaffLogin.activeUser.getUserID(), requestNr);
                addChildTableData(requestDetails);
                btnRemoveRequest.setVisible(false);
            } catch (RemoteException ex) {
                Logger.getLogger(StaffPastRequests.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(StaffPastRequests.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnViewDoneRequests1MouseClicked

    private void btnViewIncomRequestsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewIncomRequestsMouseClicked
        if (mode.equals("p")) {
            try {
                testState(staffRequestsList);
                IStaffRequest requestImp = (IStaffRequest) SingleRegistry.getInstance().getRegistry().lookup("request");
                ArrayList<StaffRequest> staffRequests = requestImp.getStaffRequests(StaffRequestHandler.requestType.Incomplete, StaffLogin.activeUser.getUserID());
                addParentTableData(staffRequests);
            } catch (NotBoundException ex) {
                Logger.getLogger(StaffPastRequests.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                Logger.getLogger(StaffPastRequests.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (mode.equals("c")) {
            try {
                IRequestDetails rDetailsImp = (IRequestDetails) SingleRegistry.getInstance().getRegistry().lookup("rDetails");
                ArrayList<RequestDetails> requestDetails = rDetailsImp.getRequestDetails(StaffRequestHandler.requestType.Incomplete, StaffLogin.activeUser.getUserID(), requestNr);
                addChildTableData(requestDetails);
                btnRemoveRequest.setVisible(true);
            } catch (NotBoundException ex) {
                Logger.getLogger(StaffPastRequests.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                Logger.getLogger(StaffPastRequests.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnViewIncomRequestsMouseClicked

    private void btnEnterRequestPackageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterRequestPackageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnterRequestPackageActionPerformed

    private void btnCloseRequestPackageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseRequestPackageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCloseRequestPackageActionPerformed

    private void btnEnterRequestPackageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnterRequestPackageMouseClicked
        try {
            requestNr = (int) tblRequests.getValueAt(tblRequests.getSelectedRow(), 0);
            childMode();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please select a valid Request Package to Open");
        }
    }//GEN-LAST:event_btnEnterRequestPackageMouseClicked

    private void btnCloseRequestPackageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseRequestPackageMouseClicked
        testState(staffRequestsList);
        parentMode();
    }//GEN-LAST:event_btnCloseRequestPackageMouseClicked

    private void btnRemoveRequestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveRequestMouseClicked
        try {
            int DetailID = (int) tblRequestDetails.getValueAt(tblRequestDetails.getSelectedRow(), 0);
            //
            //System.out.println(DetailID);
            int selection = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove this request?", "Delete Request", JOptionPane.INFORMATION_MESSAGE);
            if (selection == JOptionPane.YES_OPTION) {
                RequestDetails.deleteRequest(DetailID);
                //testState(staffRequestsList);
                IRequestDetails rDetailsImp = (IRequestDetails) SingleRegistry.getInstance().getRegistry().lookup("rDetails");
                JOptionPane.showMessageDialog(null, "BY YES");
                //
                ArrayList<RequestDetails> requestDetails = rDetailsImp.getRequestDetails(StaffRequestHandler.requestType.All, StaffLogin.activeUser.getUserID(), requestNr);
                addChildTableData(requestDetails);
                btnRemoveRequest.setVisible(false);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please select a valid Request to Remove");
        }
    }//GEN-LAST:event_btnRemoveRequestMouseClicked

    private void btnViewAllRequests1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAllRequests1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnViewAllRequests1ActionPerformed

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

    public void addParentTableData(ArrayList<StaffRequest> staffRequests) {
        DefaultTableModel model = (DefaultTableModel) tblRequests.getModel();
        model.setRowCount(0);
        Object rowData[] = new Object[2];
        for (StaffRequest s : staffRequests) {
            rowData[0] = s.getRequestNr();
            rowData[1] = s.getRequestDate();
            model.addRow(rowData);
        }
    }

    public void addChildTableData(ArrayList<RequestDetails> requestDetails) {
        DefaultTableModel model = (DefaultTableModel) tblRequestDetails.getModel();
        model.setRowCount(0);
        Object rowData[] = new Object[6];
        for (RequestDetails s : requestDetails) {
            rowData[0] = s.getRequestDetailsID();
            rowData[1] = s.getProductName();
            rowData[2] = s.getManufacturer();
            rowData[3] = s.getCategory();
            rowData[4] = s.getQuantity();
            rowData[5] = s.getDateComplete();
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
            java.util.logging.Logger.getLogger(StaffPastRequests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StaffPastRequests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StaffPastRequests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StaffPastRequests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StaffPastRequests().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackLogout;
    private javax.swing.JButton btnCloseRequestPackage;
    private javax.swing.JButton btnEnterRequestPackage;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnMinimize;
    private javax.swing.JButton btnRemoveRequest;
    private javax.swing.JButton btnViewAllRequests1;
    private javax.swing.JButton btnViewDoneRequests1;
    private javax.swing.JButton btnViewIncomRequests;
    private javax.swing.JLabel frameMove;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblRequestDetails;
    private javax.swing.JTable tblRequests;
    // End of variables declaration//GEN-END:variables
}
