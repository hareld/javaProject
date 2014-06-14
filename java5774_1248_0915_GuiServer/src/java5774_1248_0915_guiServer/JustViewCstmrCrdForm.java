/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package java5774_1248_0915_guiServer;

import DataAccessObject.Controller;
import DataAccessObject.Singelton;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.lang.Long.parseLong;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Packages.Claim;
import Packages.CustomerCrd;
import Packages.Policy;

/**
 *
 * @author dell
 */
public class JustViewCstmrCrdForm extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;
    private long per_id;
    
    private static Controller sngltn = null;
    private DefaultTableModel model1;
    private DefaultTableModel model2;
    static {
                try 
                {
                sngltn=Singelton.getMySingelton();
                } 
                catch (Exception ex) 
                {
                    Logger.getLogger(AddCstmrCrdForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            };
    /**
     * Creates new form AddCstmrCrdForm
     * @param person_id
     * @throws java.lang.Exception
     */
    public JustViewCstmrCrdForm(long person_id) throws Exception {
        per_id=person_id;
        CustomerCrd cstmr=sngltn.GetMyPersonCstmrCrd(per_id);
        initComponents();
        model1 = (DefaultTableModel)jTablePolicyView.getModel();
        model2 = (DefaultTableModel)jTableClaimView.getModel();
        java.awt.event.WindowEvent MyWindow = null;
        formWindowOpened(MyWindow);
        
        EnterPerName.setText(cstmr.getPerson().getNamePerson().toString());
        EnterPerId.setText(String.valueOf(cstmr.getPerson().getId()));
        EnterPerPhone.setText("0"+String.valueOf(cstmr.getPerson().getPhonePerson()));
        EnterPerAddress.setText(cstmr.getPerson().getAddressPerson().toString());
        try 
        {
            PerNameInActivityTab.setText("Person Name: "+
                                          sngltn.GetMyPersonCstmrCrd(per_id).getPerson().getNamePerson()+ "\n"+
                                          "Preson ID: "+
                                          Long.toString(per_id)
                                        );
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(JustViewCstmrCrdForm.class.getName()).log(Level.SEVERE, null, ex);
        }

         try 
        {
            for(Policy policy : sngltn.GetPerPolicies(cstmr.getPerson()))
            {
                model1.addRow(new Object[] {String.valueOf(policy.getId()),String.valueOf(policy.getOpeningDate()),String.valueOf(policy.getRepresentativeName()),String.valueOf(policy.getPolicyType()),String.valueOf(policy.getInsuranceCompany()),policy.getPolicyRate()});
            }                         
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(AddCstmrCrdForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          try 
        {
            for(Claim claim : sngltn.GetPerClaims(cstmr.getPerson()))
            {
                model2.addRow(new Object[] {String.valueOf(claim.getId()),String.valueOf(claim.getRepresentativeName()),String.valueOf(claim.getInsuranceClaimStatus()),String.valueOf(claim.getEventType()),String.valueOf(claim.getEventTime()),String.valueOf(claim.getEventPlace())});
            }                         
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(AddCstmrCrdForm.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        jTablePolicyView.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
               if (e.getClickCount() == 1) {
                    JTable target = (JTable)e.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                    
                    JustViewPolicyForm ViewPolicyForm= null;
                    try
                    {
                      ViewPolicyForm = new  JustViewPolicyForm(per_id,model1.getValueAt(row,0));
                    }
                    catch (Exception ex) 
                    {
                        Logger.getLogger(UpdateCstmrCrdForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ViewPolicyForm .show();
                  }
             }
        });
        
        jTableClaimView.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
               if (e.getClickCount() == 1) {
                    JTable target = (JTable)e.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                    
                    JustViewClaimForm ViewClaimForm= null;
                    try
                    {
                      ViewClaimForm = new  JustViewClaimForm(per_id,model2.getValueAt(row,0));
                    }
                    catch (Exception ex) 
                    {
                        Logger.getLogger(UpdateCstmrCrdForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ViewClaimForm .show();
                  }
             }
        });
    }
    
     private void formWindowOpened(java.awt.event.WindowEvent evt) {                                  
        int lebar = this.getWidth()/2;
        int tinggi = this.getHeight()/2;
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width/2)-lebar;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height/2)-tinggi;
        this.setLocation(x, y);
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
        All_Tab = new javax.swing.JTabbedPane();
        AddNewPerson = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        EnterPerName = new javax.swing.JTextField();
        EnterPerId = new javax.swing.JTextField();
        EnterPerPhone = new javax.swing.JTextField();
        EnterPerAddress = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        SelectWhichNewActv = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PerNameInActivityTab = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePolicyView = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableClaimView = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(574, 460));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        AddNewPerson.setEnabled(false);
        AddNewPerson.setPreferredSize(new java.awt.Dimension(574, 460));
        AddNewPerson.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Person Name:");
        AddNewPerson.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 82, -1));

        jLabel2.setText("Person ID:");
        AddNewPerson.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, -1, -1));

        jLabel3.setText("Person Phone:");
        AddNewPerson.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, -1, -1));

        jLabel4.setText("Person Address:");
        AddNewPerson.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, -1));

        EnterPerName.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        EnterPerName.setText("Enter Name");
        EnterPerName.setEnabled(false);
        AddNewPerson.add(EnterPerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 91, 25));

        EnterPerId.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        EnterPerId.setText("Enter Per ID");
        EnterPerId.setEnabled(false);
        EnterPerId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnterPerIdActionPerformed(evt);
            }
        });
        AddNewPerson.add(EnterPerId, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 91, 24));

        EnterPerPhone.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        EnterPerPhone.setText("Enter Phone");
        EnterPerPhone.setEnabled(false);
        AddNewPerson.add(EnterPerPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 91, 25));

        EnterPerAddress.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        EnterPerAddress.setText("Enter Address");
        EnterPerAddress.setEnabled(false);
        AddNewPerson.add(EnterPerAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 144, 27));

        jLabel5.setText("*Only Numbers");
        AddNewPerson.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, -1, 30));

        jLabel8.setText("*Only Numbers");
        AddNewPerson.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, -1, 20));

        All_Tab.addTab("Person", AddNewPerson);

        SelectWhichNewActv.setEnabled(false);
        SelectWhichNewActv.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PerNameInActivityTab.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        PerNameInActivityTab.setEnabled(false);
        jScrollPane1.setViewportView(PerNameInActivityTab);

        SelectWhichNewActv.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 250, 70));

        jTablePolicyView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Opening Date", "Representative", "Type", "Company", "Rate"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePolicyView.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(jTablePolicyView);
        jTablePolicyView.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTablePolicyView.getColumnModel().getColumnCount() > 0) {
            jTablePolicyView.getColumnModel().getColumn(0).setPreferredWidth(2);
            jTablePolicyView.getColumnModel().getColumn(2).setPreferredWidth(5);
            jTablePolicyView.getColumnModel().getColumn(3).setPreferredWidth(10);
            jTablePolicyView.getColumnModel().getColumn(4).setPreferredWidth(10);
            jTablePolicyView.getColumnModel().getColumn(5).setPreferredWidth(5);
        }

        SelectWhichNewActv.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 574, 92));

        jTableClaimView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Representative", "Status", "Type", "Event time", "Event place"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableClaimView.setColumnSelectionAllowed(true);
        jScrollPane3.setViewportView(jTableClaimView);
        jTableClaimView.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        SelectWhichNewActv.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 574, 90));

        jLabel6.setText("Select Policy to View:");
        SelectWhichNewActv.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 160, -1));

        jLabel7.setText("Select Claim to view:");
        SelectWhichNewActv.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 160, -1));

        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        SelectWhichNewActv.add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, -1, -1));

        All_Tab.addTab("Activity", SelectWhichNewActv);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(All_Tab)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(All_Tab, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
      
    
    private void EnterPerIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnterPerIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EnterPerIdActionPerformed

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
            java.util.logging.Logger.getLogger(JustViewCstmrCrdForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JustViewCstmrCrdForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JustViewCstmrCrdForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JustViewCstmrCrdForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JPanel AddNewPerson;
    private javax.swing.JTabbedPane All_Tab;
    private javax.swing.JTextField EnterPerAddress;
    private javax.swing.JTextField EnterPerId;
    private javax.swing.JTextField EnterPerName;
    private javax.swing.JTextField EnterPerPhone;
    private javax.swing.JTextPane PerNameInActivityTab;
    private javax.swing.JPanel SelectWhichNewActv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableClaimView;
    private javax.swing.JTable jTablePolicyView;
    // End of variables declaration//GEN-END:variables
}