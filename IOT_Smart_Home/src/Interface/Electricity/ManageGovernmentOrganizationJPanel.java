/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Electricity;

import Business.Ecosystem;
import Business.Enterprise.Enterprise;
import Business.Organisation.Organisation;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Himani Solanki
 */
public class ManageGovernmentOrganizationJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageGovernmentOrganizationJPanel
     */
    JPanel userProcessContainer;
    Enterprise enterprise;

    

    public ManageGovernmentOrganizationJPanel(JPanel userProcessContainer, UserAccount account, Organisation organization, Enterprise enterprise, Ecosystem business) {
       initComponents();
        this.userProcessContainer=userProcessContainer;
        this.enterprise=enterprise;
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
        manageOrganisationButton = new javax.swing.JButton();
        manageAdminsButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Manage Government Organisations");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 19, -1, -1));

        manageOrganisationButton.setText("Manage Organisations");
        manageOrganisationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageOrganisationButtonActionPerformed(evt);
            }
        });
        add(manageOrganisationButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 109, 223, -1));

        manageAdminsButton.setText("Manage Admins of Organisations");
        manageAdminsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageAdminsButtonActionPerformed(evt);
            }
        });
        add(manageAdminsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 150, 223, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void manageOrganisationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageOrganisationButtonActionPerformed
        // TODO add your handling code here:
        Interface.Electricity.CreateGovernmentOrgJPanel imcmojp = new Interface.Electricity.CreateGovernmentOrgJPanel(userProcessContainer,enterprise);
        userProcessContainer.add("CreateGovernmentOrgJPanel",imcmojp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageOrganisationButtonActionPerformed

    private void manageAdminsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageAdminsButtonActionPerformed
        // TODO add your handling code here:
        Interface.Electricity.CreateGovernmentOrganisationAdminJPanel imcmoajp = new Interface.Electricity.CreateGovernmentOrganisationAdminJPanel(userProcessContainer,enterprise);
        userProcessContainer.add("CreateGovernmentOrganisationAdminJPanel",imcmoajp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageAdminsButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton manageAdminsButton;
    private javax.swing.JButton manageOrganisationButton;
    // End of variables declaration//GEN-END:variables
}
