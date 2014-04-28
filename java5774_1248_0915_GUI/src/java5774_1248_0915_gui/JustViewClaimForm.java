/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package java5774_1248_0915_gui;

import MyPackages.Claim;
import MyPackages.Claim.ClaimStat;
import MyPackages.Claim.Documents;
import MyPackages.Claim.EvntType;
import DataAccessObject.IBackend_DAO_List_impl;
import DataAccessObject.Singelton;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dell
 */
public class JustViewClaimForm extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;

    /**
     * Creates new form AddClaim
     */
    private long per_id;
    private long claim_id;
    private ArrayList<String> receivedDocumnt;
    
    private Claim claim=null;
    
    private static IBackend_DAO_List_impl sngltn = null;
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
    
    public JustViewClaimForm(long PerId,Object ClaimID) throws Exception {
        this.receivedDocumnt = new ArrayList<String>();
        
        per_id=PerId;
        claim_id=Long.valueOf(ClaimID.toString());

        claim =new Claim();
        claim=sngltn.GetClaimById(claim_id);
        
        int NumOfDetails=claim.getMoreDetails().size();
        
        initComponents();
        java.awt.event.WindowEvent MyWindow = null;
        formWindowOpened(MyWindow);
        
        ArrayList<Documents> arr=SetReqDucmntsListByEvent(claim.getEventType());
        
        ComboBoxEventType.setModel(new DefaultComboBoxModel(EvntType.values()));
        ComboBoxInsuranceClaimStatus.setModel(new DefaultComboBoxModel(ClaimStat.values()));
        
        DetailsFieldsFirstDesplay(NumOfDetails);
        
        TextPerson_Name_ID.setEnabled(false);
        TextPerson_Name_ID.setText("Person Name: "+ 
                                    sngltn.GetMyPersonCstmrCrd(per_id).getPer().getPerName() + "\n"+
                                    "Preson ID: "+
                                    Long.toString(per_id)
                                    );
        EnterRepresentativeName.setText(claim.getRepresentativeName());
        jSpinnerClaimId.setValue(claim_id);
        ComboBoxInsuranceClaimStatus.setSelectedItem(claim.getInsuranceClaimStatus());
        jSpinnerOpeningDate.setValue(claim.getOpeningDate());
        ComboBoxEventType.setSelectedItem(claim.getEventType());
        jSpinnerEventTime.setValue(claim.getEventTime());
        EnterEventPlace.setText(claim.getEventPlace());
        if (NumOfDetails==1)
                                    EnterDetail0.setText(claim.getMoreDetails().get(0));
        else if (NumOfDetails==2)
                                {
                                    EnterDetail0.setText(claim.getMoreDetails().get(0));
                                    EnterDetail1.setText(claim.getMoreDetails().get(1));
                                }
        else if (NumOfDetails==3)
                                {
                                    EnterDetail0.setText(claim.getMoreDetails().get(0));
                                    EnterDetail1.setText(claim.getMoreDetails().get(1));
                                    EnterDetail2.setText(claim.getMoreDetails().get(2));
                                }
         else if (NumOfDetails==4)
                                {
                                    EnterDetail0.setText(claim.getMoreDetails().get(0));
                                    EnterDetail1.setText(claim.getMoreDetails().get(1));
                                    EnterDetail2.setText(claim.getMoreDetails().get(2));
                                    EnterDetail3.setText(claim.getMoreDetails().get(3));
                                }
        try 
        {
            DefaultTableModel model=(DefaultTableModel)jTableDocumentsRequired.getModel();
            model.setRowCount(0);
            for(Documents doc : arr)
            {
                model.addRow(new Object[] {String.valueOf(doc),false});
            }                           
        }
        catch (Exception ex) 
        {
            Logger.getLogger(AddCstmrCrdForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i=0;i<jTableDocumentsRequired.getRowCount();i++)
        {
            for (String doc :claim.getDocumentsReceived())
            {   
                if(jTableDocumentsRequired.getValueAt(i, 0).toString().equals(doc))
                jTableDocumentsRequired.setValueAt(true,i, 1);
            }
        }
        
       
    }

//    private JustViewClaimForm() {
//        this.receivedDocumnt = new ArrayList<String>();
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
  
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

        EnterRepresentativeName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jSpinnerOpeningDate = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        EnterDetail0 = new java.awt.TextField();
        EnterDetail2 = new java.awt.TextField();
        EnterDetail3 = new java.awt.TextField();
        EnterDetail1 = new java.awt.TextField();
        jSpinnerClaimId = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ComboBoxEventType = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        ComboBoxInsuranceClaimStatus = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSpinnerEventTime = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextPerson_Name_ID = new javax.swing.JTextPane();
        jLabel9 = new javax.swing.JLabel();
        EnterEventPlace = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableDocumentsRequired = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        EnterRepresentativeName.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        EnterRepresentativeName.setText("Enter Representative Name");
        EnterRepresentativeName.setEnabled(false);
        getContentPane().add(EnterRepresentativeName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 170, 30));

        jLabel1.setText("Representative Name:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 130, 30));

        jSpinnerOpeningDate.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jSpinnerOpeningDate.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.DAY_OF_YEAR));
        jSpinnerOpeningDate.setEnabled(false);
        getContentPane().add(jSpinnerOpeningDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 165, 30));

        jLabel2.setText("Opening Date:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 106, -1));

        jLabel3.setText("More Details:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, -1, -1));

        EnterDetail0.setEnabled(false);
        EnterDetail0.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        EnterDetail0.setMaximumSize(new java.awt.Dimension(72, 21));
        EnterDetail0.setText("Enter Detail");
        EnterDetail0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnterDetail0ActionPerformed(evt);
            }
        });
        getContentPane().add(EnterDetail0, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, 339, -1));

        EnterDetail2.setEnabled(false);
        EnterDetail2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        EnterDetail2.setMaximumSize(new java.awt.Dimension(72, 21));
        EnterDetail2.setText("Enter Detail");
        getContentPane().add(EnterDetail2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 470, 339, -1));

        EnterDetail3.setEnabled(false);
        EnterDetail3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        EnterDetail3.setMaximumSize(new java.awt.Dimension(72, 21));
        EnterDetail3.setText("Enter Detail");
        getContentPane().add(EnterDetail3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 510, 339, -1));

        EnterDetail1.setEnabled(false);
        EnterDetail1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        EnterDetail1.setMaximumSize(new java.awt.Dimension(72, 21));
        EnterDetail1.setText("Enter Detail");
        EnterDetail1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnterDetail1ActionPerformed(evt);
            }
        });
        getContentPane().add(EnterDetail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, 339, -1));

        jSpinnerClaimId.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jSpinnerClaimId.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jSpinnerClaimId.setEnabled(false);
        getContentPane().add(jSpinnerClaimId, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 78, -1));

        jLabel4.setText("Claim  ID:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel5.setText("* predetermined");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, -1, -1));

        ComboBoxEventType.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        ComboBoxEventType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboBoxEventType.setEnabled(false);
        ComboBoxEventType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxEventTypeActionPerformed(evt);
            }
        });
        getContentPane().add(ComboBoxEventType, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 165, -1));

        jLabel6.setText("Event  Type:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        ComboBoxInsuranceClaimStatus.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        ComboBoxInsuranceClaimStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboBoxInsuranceClaimStatus.setEnabled(false);
        getContentPane().add(ComboBoxInsuranceClaimStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 165, -1));

        jLabel7.setText("Insurance Claim Status:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jLabel8.setText("Event Time:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 70, 20));

        jSpinnerEventTime.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jSpinnerEventTime.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1397040165906L), new java.util.Date(536450400000L), null, java.util.Calendar.DAY_OF_MONTH));
        jSpinnerEventTime.setEnabled(false);
        getContentPane().add(jSpinnerEventTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 160, 30));

        TextPerson_Name_ID.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jScrollPane1.setViewportView(TextPerson_Name_ID);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 322, 54));

        jLabel9.setText("Event Place:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        EnterEventPlace.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        EnterEventPlace.setText("Enter Place");
        EnterEventPlace.setEnabled(false);
        getContentPane().add(EnterEventPlace, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 100, -1));

        jTableDocumentsRequired.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jTableDocumentsRequired.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Document", "Received (Y/N)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableDocumentsRequired);
        if (jTableDocumentsRequired.getColumnModel().getColumnCount() > 0) {
            jTableDocumentsRequired.getColumnModel().getColumn(0).setPreferredWidth(15);
            jTableDocumentsRequired.getColumnModel().getColumn(1).setPreferredWidth(2);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 190, 110));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 300, 10));

        jLabel10.setText("Documents Required:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 140, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EnterDetail0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnterDetail0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EnterDetail0ActionPerformed

    private void EnterDetail1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnterDetail1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EnterDetail1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
                                    
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       
    }//GEN-LAST:event_formWindowClosing

    private void ComboBoxEventTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxEventTypeActionPerformed
        EvntType evntType=(EvntType)ComboBoxEventType.getSelectedItem();
        ArrayList<Documents> arr=SetReqDucmntsListByEvent(evntType);
        try 
        {
            int counter=1;
            DefaultTableModel model=(DefaultTableModel)jTableDocumentsRequired.getModel();
            model.setRowCount(0);
            for(Documents doc : arr)
            {
                model.addRow(new Object[] {String.valueOf(doc),false});
            }                           
        }
        catch (Exception ex) 
        {
            Logger.getLogger(AddCstmrCrdForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ComboBoxEventTypeActionPerformed
         
        
        private ArrayList<Claim.Documents> SetReqDucmntsListByEvent(EvntType myevent) //dagan
        {
            ArrayList<Claim.Documents> arr=new ArrayList<Claim.Documents>();
            if (myevent.equals(EvntType.Vehicle))
            {
                arr.add(Documents.IDPhoto);
                arr.add(Documents.VehicleLicense);
                arr.add(Documents.DriverLicense);
                arr.add(Documents.ReferenceAppraisers);
                arr.add(Documents.MedicalReview);
            }
            else if (myevent.equals(EvntType.Health))
            {
                arr.add(Documents.IDPhoto);
                arr.add(Documents.ConsentForm);
                arr.add(Documents.MedicalReview);
            }
            else if (myevent.equals(EvntType.Personally))
            {
                arr.add(Documents.IDPhoto);
                arr.add(Documents.ConsentForm);
                arr.add(Documents.MedicalReview);
                arr.add(Documents.GeneralReference);
            }
            else if (myevent.equals(EvntType.Work))
            {
                arr.add(Documents.IDPhoto);
                arr.add(Documents.ConsentForm);
                arr.add(Documents.MedicalReview);
                arr.add(Documents.GeneralReference);
                arr.add(Documents.ReferenceFromEmployer);
            }
            return arr;
        }
        
        private void DetailsFieldsFirstDesplay(int list_lentgh)
        {
            if (list_lentgh==1)
                          {
                            EnterDetail0.setVisible(true);
                            EnterDetail1.setVisible(false);
                            EnterDetail2.setVisible(false);
                            EnterDetail3.setVisible(false);
                            this.setSize(531, 450);
                          }
        else if (list_lentgh==2)
                                {
                                  EnterDetail0.setVisible(true);
                                  EnterDetail1.setVisible(true);
                                  this.setSize(531, 490);
                                }
        
        else if (list_lentgh==3)
                                {
                                EnterDetail0.setVisible(true);
                                EnterDetail1.setVisible(true);
                                EnterDetail2.setVisible(true);
                                this.setSize(531, 530);
                                }
        else if (list_lentgh==4)
                                {
                                 EnterDetail0.setVisible(true);
                                 EnterDetail1.setVisible(true);
                                 EnterDetail2.setVisible(true);
                                 EnterDetail3.setVisible(true);  
                                 this.setSize(531, 570);
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JustViewClaimForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JustViewClaimForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JustViewClaimForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JustViewClaimForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
             //   new JustViewClaimForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboBoxEventType;
    private javax.swing.JComboBox ComboBoxInsuranceClaimStatus;
    private java.awt.TextField EnterDetail0;
    private java.awt.TextField EnterDetail1;
    private java.awt.TextField EnterDetail2;
    private java.awt.TextField EnterDetail3;
    private javax.swing.JTextField EnterEventPlace;
    private javax.swing.JTextField EnterRepresentativeName;
    private javax.swing.JTextPane TextPerson_Name_ID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner jSpinnerClaimId;
    private javax.swing.JSpinner jSpinnerEventTime;
    private javax.swing.JSpinner jSpinnerOpeningDate;
    private javax.swing.JTable jTableDocumentsRequired;
    // End of variables declaration//GEN-END:variables

    void show(JTable jTableClaimView) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
