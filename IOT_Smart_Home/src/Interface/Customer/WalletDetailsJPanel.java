/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Customer;

import Business.Utility.Wallet;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.LinkedHashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ankit
 */
public class WalletDetailsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form WalletDetailsJPanel
     */
    
    String name;
    Wallet wallet;
        JPanel userProcessContainer;


    WalletDetailsJPanel(String name, Wallet wallet,JPanel userProcessContainer) {
                initComponents();
                this.name=name;
                this.wallet=wallet;
                this.userProcessContainer=userProcessContainer;
                populateTable();

                
    }
    
    public void populateTable() {
        
        avaBalTxtFiels.setText("$ "+wallet.getWalletAmount());

        DefaultTableModel dtm = (DefaultTableModel) transJTbl.getModel();
        dtm.setRowCount(0);

        LinkedHashMap<WorkRequest, Double> mp = wallet.getTransactionList();

        Iterator it = mp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            WorkRequest wr = (WorkRequest) pair.getKey();
            double amt = (double) pair.getValue();
            Object Row[] = new Object[4];
            Row[0] = wr.getResolveDate();

            if (amt > 0) {
                Row[1] = wr.getMessage();
                Row[2] = "";
                Row[3] = amt;

            } else {
                Row[1] = wr.getCust() + ", " + wr.getReceiver() + ", " + wr.getMessage() + " on: " + wr.getRequestDate();
                Row[2] = amt;
                Row[3] = "";
            }
            dtm.addRow(Row);

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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        transJTbl = new javax.swing.JTable();
        addMoneyJBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        moneyAmtJTxtField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        avaBalTxtFiels = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Transaction Details");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Welcome to your E-Wallet");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 58, -1, -1));

        transJTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Transaction Date", "Details", "Debit", "Credit"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(transJTbl);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 98, 743, 276));

        addMoneyJBtn.setText("Add Money");
        addMoneyJBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMoneyJBtnActionPerformed(evt);
            }
        });
        add(addMoneyJBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 430, 171, -1));

        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, -1, -1));

        moneyAmtJTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moneyAmtJTxtFieldActionPerformed(evt);
            }
        });
        add(moneyAmtJTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 431, 176, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Available Balance: ");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 392, 171, -1));

        avaBalTxtFiels.setEditable(false);
        add(avaBalTxtFiels, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 392, 179, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pics/M_wallettgroup.jpg"))); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        CustomerWAJPanel cwajp = (CustomerWAJPanel) component;
        cwajp.showJBadgeButton();
        cwajp.populateComboBox();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backBtnActionPerformed

    private void moneyAmtJTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moneyAmtJTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_moneyAmtJTxtFieldActionPerformed

    private void addMoneyJBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMoneyJBtnActionPerformed
        // TODO add your handling code here:
        double amountTOAdd=0;
        
        try {
            amountTOAdd = Double.parseDouble(moneyAmtJTxtField.getText());
            wallet.addMoney(amountTOAdd);
            JOptionPane.showMessageDialog(null, "The money has been successfully added.", "Information", JOptionPane.INFORMATION_MESSAGE);
            populateTable();

            
        } catch (NumberFormatException numberFormatException) {
            
            JOptionPane.showMessageDialog(null, "Please enter a valid value in number format.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
        }
    }//GEN-LAST:event_addMoneyJBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addMoneyJBtn;
    private javax.swing.JTextField avaBalTxtFiels;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField moneyAmtJTxtField;
    private javax.swing.JTable transJTbl;
    // End of variables declaration//GEN-END:variables
}
