/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Garbage;

import Business.Ecosystem;
import Business.Enterprise.Enterprise;
import Business.Organisation.Organisation;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author ajaygoel
 */
public class SocietyEnterpriseWAJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CreateSocityOrgEmpJPanel
     */
    JPanel userProcessContainer;
    UserAccount account;
    Organisation organization;
    Enterprise enterprise;
    Ecosystem business;

    public SocietyEnterpriseWAJPanel(JPanel userProcessContainer, UserAccount account, Organisation organization, Enterprise enterprise, Ecosystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.organization = organization;
        this.business = business;
        this.enterprise = enterprise;
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
        manageorganisations = new javax.swing.JButton();
        ManageAdmins = new javax.swing.JButton();
        enterpriseReqJBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Manage Society Organisations");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        manageorganisations.setText("Manage Organisations");
        manageorganisations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageorganisationsActionPerformed(evt);
            }
        });
        add(manageorganisations, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 51, 311, -1));

        ManageAdmins.setText("Manage Admins of Organisations");
        ManageAdmins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageAdminsActionPerformed(evt);
            }
        });
        add(ManageAdmins, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 92, 311, -1));

        enterpriseReqJBtn.setText("Manage Work Request to Other Enterprise");
        enterpriseReqJBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterpriseReqJBtnActionPerformed(evt);
            }
        });
        add(enterpriseReqJBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 133, 311, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void manageorganisationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageorganisationsActionPerformed
        // TODO add your handling code here:
        Interface.Garbage.CreateSocietyOrgJPanel igcsojp = new Interface.Garbage.CreateSocietyOrgJPanel(userProcessContainer, account, organization, enterprise, business);
        userProcessContainer.add("CreateSocietyOrgJPanel", igcsojp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageorganisationsActionPerformed

    private void ManageAdminsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageAdminsActionPerformed
        // TODO add your handling code here:
        Interface.Garbage.CreateSocietyAdminWAJPanel igcsawjp = new Interface.Garbage.CreateSocietyAdminWAJPanel(userProcessContainer, account, organization, enterprise, business);
        userProcessContainer.add("CreateSocietyAdminWAJPanel", igcsawjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_ManageAdminsActionPerformed

    private void enterpriseReqJBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterpriseReqJBtnActionPerformed
        // TODO add your handling code here:
        SocietyEnterpriseWRJPanel igcsawjp = new SocietyEnterpriseWRJPanel(userProcessContainer, enterprise,account, business);
        userProcessContainer.add("SocietyEnterpriseWRJPanel", igcsawjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_enterpriseReqJBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ManageAdmins;
    private javax.swing.JButton enterpriseReqJBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton manageorganisations;
    // End of variables declaration//GEN-END:variables
}
