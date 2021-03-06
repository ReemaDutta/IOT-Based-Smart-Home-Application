/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Retailer;

import Business.Ecosystem;
import Business.Enterprise.Enterprise;
import Business.Organisation.Grocery.GroceryOrganisation;
import Business.Organisation.Grocery.GroceryProduct;
import Business.Organisation.Organisation;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author ajaygoel
 */
public class ManageProductsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageProductsJPanel
     */
    
    JPanel userProcessContainer;
    UserAccount account;
    GroceryOrganisation organization;
    Enterprise enterprise;
    Ecosystem business;
    Organisation organisation1;
    GroceryOrganisation groceryOrganisation;
    

    ManageProductsJPanel(JPanel userProcessContainer, UserAccount account, Organisation organisation1, Enterprise enterprise, Ecosystem business, GroceryOrganisation groceryOrganisation) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
            this.account=account;
            this.organization= organization;
            this.business=business;
            this.enterprise=enterprise;
            this.groceryOrganisation=groceryOrganisation;
            populate_table();
    }
    
    public void populate_table()
    {
        DefaultTableModel dtm = (DefaultTableModel) productCatalogTbl.getModel();
        productCatalogTbl.getColumn("Image").setCellRenderer(new LabelRenderer());
        dtm.setRowCount(0);

        try {
            for (GroceryProduct gp : groceryOrganisation.getGroceryProductDirectory()) {
                JLabel label = new JLabel();
                label.setBounds(100, 100, 200, 200);
                ImageIcon i1 = new ImageIcon(gp.getImgLoc());
                Image img = i1.getImage();
                Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon iFinal = new ImageIcon(newImg);
                label.setIcon(iFinal);
                
                Object Row[] = new Object[5];
                Row[0] = gp;
                Row[1] = gp.getModelNumber();
                Row[2] = gp.getPrice();
                Row[3] = gp.getAvail();
                Row[4] = label;
                dtm.addRow(Row);
            }
        } catch (Exception e) {
            System.out.println("here");
        }
        
    }
    
    class LabelRenderer implements TableCellRenderer{

        @Override
        public Component getTableCellRendererComponent(JTable jtable, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            TableColumn tc= productCatalogTbl.getColumn("Image");
            tc.setMinWidth(200);
            tc.setMaxWidth(200);
            productCatalogTbl.setRowHeight(200);
            
            return (Component)value;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        productCatalogTbl = new javax.swing.JTable();
        delButton5 = new javax.swing.JButton();
        backButton4 = new javax.swing.JButton();
        createPButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Manage Product Catalog");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 11, -1, -1));

        productCatalogTbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        productCatalogTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Product ID", "Price", "Available Units", "Image"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(productCatalogTbl);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 52, 761, 400));

        delButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        delButton5.setText("Delete Product");
        delButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delButton5ActionPerformed(evt);
            }
        });
        add(delButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 455, 144, -1));

        backButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        backButton4.setText("<< Back");
        backButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton4ActionPerformed(evt);
            }
        });
        add(backButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 521, 144, -1));

        createPButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        createPButton.setText("Create New Product");
        createPButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createPButtonActionPerformed(evt);
            }
        });
        add(createPButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 455, 184, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void delButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delButton5ActionPerformed
        // TODO add your handling code here:
        int row = productCatalogTbl.getSelectedRow();
        if(row<0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        GroceryProduct gp = (GroceryProduct)productCatalogTbl.getValueAt(row, 0);
        groceryOrganisation.removeProd(gp);
        populate_table();
    }//GEN-LAST:event_delButton5ActionPerformed

    private void backButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton4ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButton4ActionPerformed

    private void createPButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createPButtonActionPerformed
        Interface.Retailer.CreateProductPanel ircppp = new Interface.Retailer.CreateProductPanel(userProcessContainer, groceryOrganisation);
        userProcessContainer.add("Interface.Retailer.CreateProductsJPanel",ircppp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_createPButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton4;
    private javax.swing.JButton createPButton;
    private javax.swing.JButton delButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable productCatalogTbl;
    // End of variables declaration//GEN-END:variables
}
