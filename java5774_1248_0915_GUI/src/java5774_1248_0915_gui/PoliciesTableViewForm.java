/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java5774_1248_0915_gui;

import DataAccessObject.Controller;
import DataAccessObject.Singelton;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Packages.Activity;
import Packages.CustomerCrd;
import Packages.Policy;

/**
 * @author dell
 */
public class PoliciesTableViewForm extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    private ArrayList<Policy> arrPolicy = null;

    private static Controller sngltn = null;
    private DefaultTableModel model1;

    static {
        try {
            sngltn = Singelton.getMySingelton();
        } catch (Exception ex) {
            Logger.getLogger(AddCstmrCrdForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Ctor - veiw the policies in the table
    public PoliciesTableViewForm(String buttonText) throws Exception {

        initComponents();
        model1 = (DefaultTableModel) jTablePolicyView.getModel();
        java.awt.event.WindowEvent MyWindow = null;
        formWindowOpened(MyWindow);

        if (buttonText == "View All Policies") {
            JTextPanePolicyViewDescription.setText(buttonText);
            try {
                model1.setRowCount(0);
                for (Policy policy : sngltn.GetAllPolicies()) {
                    model1.addRow(new Object[]{getPerIdByPolicyId(policy.getId()), String.valueOf(policy.getId()), String.valueOf(policy.getOpeningDate()), String.valueOf(policy.getRepresentativeName()), String.valueOf(policy.getPolicyType()), String.valueOf(policy.getInsuranceCompany()), policy.getPolicyRate()});
                }
            } catch (Exception ex) {
                Logger.getLogger(AddCstmrCrdForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        jTablePolicyView.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    JTable target = (JTable) e.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();

                    JustViewPolicyForm ViewPolicyForm = null;
                    try {
                        ViewPolicyForm = new JustViewPolicyForm((long) model1.getValueAt(row, 0), model1.getValueAt(row, 1));
                    } catch (Exception ex) {
                        Logger.getLogger(UpdateCstmrCrdForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ViewPolicyForm.show();
                }
            }
        });
    }

    // Ctor - view the claims in table according the recieved policy type
    public PoliciesTableViewForm(String buttonText, Policy.PlicyType polcyType) throws Exception {

        initComponents();
        model1 = (DefaultTableModel) jTablePolicyView.getModel();
        java.awt.event.WindowEvent MyWindow = null;
        formWindowOpened(MyWindow);

        if ("View all Policies with this policy type".equals(buttonText)) {
            JTextPanePolicyViewDescription.setText("View all Policies with policy type: " + polcyType.toString());
            try {
                model1.setRowCount(0);
                for (CustomerCrd ctmrCrd : sngltn.GetAllCustemers()) {
                    for (Policy policy : sngltn.GetMyTypePolicies(polcyType, ctmrCrd.getPerson())) {
                        model1.addRow(new Object[]{getPerIdByPolicyId(policy.getId()), String.valueOf(policy.getId()), String.valueOf(policy.getOpeningDate()), String.valueOf(policy.getRepresentativeName()), String.valueOf(policy.getPolicyType()), String.valueOf(policy.getInsuranceCompany()), policy.getPolicyRate()});
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(AddCstmrCrdForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        jTablePolicyView.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    JTable target = (JTable) e.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();

                    JustViewPolicyForm ViewPolicyForm = null;
                    try {
                        ViewPolicyForm = new JustViewPolicyForm((long) model1.getValueAt(row, 0), model1.getValueAt(row, 1));
                    } catch (Exception ex) {
                        Logger.getLogger(UpdateCstmrCrdForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ViewPolicyForm.show();
                }
            }
        });

    }

    // alignment the window
    private void formWindowOpened(java.awt.event.WindowEvent evt) {
        int lebar = this.getWidth() / 2;
        int tinggi = this.getHeight() / 2;
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width / 2) - lebar;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height / 2) - tinggi;
        this.setLocation(x, y);
    }

    // get the person id by the policy id of the customer card
    private long getPerIdByPolicyId(long policyId) throws Exception {
        for (CustomerCrd cstmr : sngltn.GetAllCustemers()) {
            for (Activity act : cstmr.getActivities()) {
                if (act instanceof Policy) {
                    Policy plcy = (Policy) act;
                    if (plcy.getId() == policyId) {
                        return cstmr.getPerson().getId();
                    }
                }
            }
        }
        return 0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        SelectWhichNewActv = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTextPanePolicyViewDescription = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePolicyView = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(574, 460));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        SelectWhichNewActv.setEnabled(false);
        SelectWhichNewActv.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JTextPanePolicyViewDescription.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        JTextPanePolicyViewDescription.setEnabled(false);
        jScrollPane1.setViewportView(JTextPanePolicyViewDescription);

        SelectWhichNewActv.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 250, 70));

        jTablePolicyView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Person ID", "Policy ID", "Opening Date", "Representative", "Type", "Company", "Rate"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePolicyView.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(jTablePolicyView);
        jTablePolicyView.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTablePolicyView.getColumnModel().getColumnCount() > 0) {
            jTablePolicyView.getColumnModel().getColumn(1).setPreferredWidth(2);
            jTablePolicyView.getColumnModel().getColumn(3).setPreferredWidth(5);
            jTablePolicyView.getColumnModel().getColumn(4).setPreferredWidth(10);
            jTablePolicyView.getColumnModel().getColumn(5).setPreferredWidth(10);
            jTablePolicyView.getColumnModel().getColumn(6).setPreferredWidth(5);
        }

        SelectWhichNewActv.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 574, 340));

        jLabel6.setText(" Policies  table:");
        SelectWhichNewActv.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 160, -1));

        jLabel1.setText("Select Policy to View:");
        SelectWhichNewActv.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(SelectWhichNewActv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addComponent(SelectWhichNewActv, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(PoliciesTableViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PoliciesTableViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PoliciesTableViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PoliciesTableViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //   new UpdateCstmrCrdForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane JTextPanePolicyViewDescription;
    private javax.swing.JPanel SelectWhichNewActv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTablePolicyView;
    // End of variables declaration//GEN-END:variables
}
