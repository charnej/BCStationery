/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import BusinessLayerPackage.Category;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class AddStock extends javax.swing.JFrame {

    /**
     * Creates new form AddStock
     */
    public AddStock() {
        initComponents();
        //fill dropdown with possible catagories
            //get all catagories
        Category objCategoryHolder = new Category();
        for (Category cat : objCategoryHolder.getCategories()) {
            //fill with all possible names
            cmboCategoryAdd.addItem(cat.getName());
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

        txtProductNameAdd = new javax.swing.JTextField();
        txtManufacturerAdd = new javax.swing.JTextField();
        cmboCategoryAdd = new javax.swing.JComboBox<>();
        spnQtyAdd = new javax.swing.JSpinner();
        spnPriceAdd = new javax.swing.JSpinner();
        btnItemAdd = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnMinimize = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 628));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 628));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        txtProductNameAdd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtProductNameAdd.setBorder(null);
        getContentPane().add(txtProductNameAdd);
        txtProductNameAdd.setBounds(140, 220, 190, 30);

        txtManufacturerAdd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtManufacturerAdd.setBorder(null);
        getContentPane().add(txtManufacturerAdd);
        txtManufacturerAdd.setBounds(140, 310, 200, 30);

        cmboCategoryAdd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        getContentPane().add(cmboCategoryAdd);
        cmboCategoryAdd.setBounds(130, 410, 210, 30);

        spnQtyAdd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        getContentPane().add(spnQtyAdd);
        spnQtyAdd.setBounds(500, 310, 130, 30);

        spnPriceAdd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        getContentPane().add(spnPriceAdd);
        spnPriceAdd.setBounds(500, 220, 130, 30);

        btnItemAdd.setBackground(new java.awt.Color(226, 61, 57));
        btnItemAdd.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnItemAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnItemAdd.setText("Add Item");
        btnItemAdd.setBorder(null);
        btnItemAdd.setBorderPainted(false);
        btnItemAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnItemAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnItemAdd);
        btnItemAdd.setBounds(490, 400, 180, 40);

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
        btnBack.setBounds(490, 450, 180, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/AddSTock.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 600);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnItemAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemAddActionPerformed
        //check all fields are entered && of the right type
        boolean prodName = (!txtProductNameAdd.getText().equals(""));
        boolean manName = (!txtManufacturerAdd.getText().equals(""));
        boolean catagoryName = (!cmboCategoryAdd.getSelectedItem().equals(""));
        boolean prodPrice = ((int)spnPriceAdd.getValue()>0);
        boolean prodQuantity = ((int)spnQtyAdd.getValue()>0);
        if (prodName&&manName&&catagoryName&&prodPrice&&prodQuantity) {
            //create object of Stock
            //send object of stock to db
        }else{
           //show error 
        }
        
    }//GEN-LAST:event_btnItemAddActionPerformed

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseClicked
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeMouseClicked

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        //JOptionPane.showMessageDialog(null,"hi");
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(AddStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddStock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnItemAdd;
    private javax.swing.JButton btnMinimize;
    private javax.swing.JComboBox<String> cmboCategoryAdd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSpinner spnPriceAdd;
    private javax.swing.JSpinner spnQtyAdd;
    private javax.swing.JTextField txtManufacturerAdd;
    private javax.swing.JTextField txtProductNameAdd;
    // End of variables declaration//GEN-END:variables
}
