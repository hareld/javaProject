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
import Packages.Activity;
import Packages.Claim;
import Packages.CustomerCrd;

/**
 *
 * @author dell
 */
public class ClaimsTableViewForm extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;
    
    private static Controller sngltn = null;
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
    public ClaimsTableViewForm(String buttonText) throws Exception {
        initComponents();
        model2 = (DefaultTableModel)jTableClaimView.getModel();
        java.awt.event.WindowEvent MyWindow = null;
        formWindowOpened(MyWindow);
        

        if (buttonText=="View All Claims")
        {
            JTextPaneClaimViewDescription.setText(buttonText);  
            try 
           {
               model2.setRowCount(0);
               for(Claim claim : sngltn.GetAllClaims())
               {
                   model2.addRow(new Object[] {getPerIdByClaimId(claim.getId()),String.valueOf(claim.getId()),String.valueOf(claim.getRepresentativeName()),String.valueOf(claim.getInsuranceClaimStatus()),String.valueOf(claim.getEventType()),String.valueOf(claim.getEventTime()),String.valueOf(claim.getEventPlace())});
               }                         
           } 
           catch (Exception ex) 
           {
               Logger.getLogger(AddCstmrCrdForm.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        
        else if (buttonText=="View All Open Claims")
        {
            JTextPaneClaimViewDescription.setText(buttonText);  
            try 
           {
               model2.setRowCount(0);
               for(Claim claim : sngltn.GetAllOpenClaims())
               {
                   model2.addRow(new Object[] {getPerIdByClaimId(claim.getId()),String.valueOf(claim.getId()),String.valueOf(claim.getRepresentativeName()),String.valueOf(claim.getInsuranceClaimStatus()),String.valueOf(claim.getEventType()),String.valueOf(claim.getEventTime()),String.valueOf(claim.getEventPlace())});
               }                         
           } 
           catch (Exception ex) 
           {
               Logger.getLogger(AddCstmrCrdForm.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        
        jTableClaimView.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
               if (e.getClickCount() == 1) {
                    JTable target = (JTable)e.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                    
                    JustViewClaimForm ViewClaimForm= null;
                    try
                    {
                      ViewClaimForm = new  JustViewClaimForm((long) model2.getValueAt(row,0),model2.getValueAt(row,1));
                    }
                    catch (Exception ex) 
                    {
                        Logger.getLogger(UpdateCstmrCrdForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ViewClaimForm.show();
                  }
             }
        });
    }
    
    public ClaimsTableViewForm(String buttonText , Claim.ClaimStat claimStat) throws Exception 
    {
        initComponents();
        model2 = (DefaultTableModel)jTableClaimView.getModel();
        java.awt.event.WindowEvent MyWindow = null;
        formWindowOpened(MyWindow);

                
        if ("View all Claim with this stauts".equals(buttonText))
        {
            JTextPaneClaimViewDescription.setText("View all Claims with claim status: "+claimStat.toString());  
            try 
           {
               model2.setRowCount(0);
               for(CustomerCrd ctmrCrd :sngltn.GetAllCustemers())
               {    
                    for(Claim claim : sngltn.GetMyStatusClaims(claimStat, ctmrCrd.getPerson()))
                    {
                         model2.addRow(new Object[] {getPerIdByClaimId(claim.getId()),String.valueOf(claim.getId()),String.valueOf(claim.getRepresentativeName()),String.valueOf(claim.getInsuranceClaimStatus()),String.valueOf(claim.getEventType()),String.valueOf(claim.getEventTime()),String.valueOf(claim.getEventPlace())});
                    }
               }                         
           } 
           catch (Exception ex) 
           {
               Logger.getLogger(AddCstmrCrdForm.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        
        jTableClaimView.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
               if (e.getClickCount() == 1) {
                    JTable target = (JTable)e.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                    
                    JustViewClaimForm ViewClaimForm= null;
                    try
                    {
                      ViewClaimForm = new  JustViewClaimForm((long) model2.getValueAt(row,0),model2.getValueAt(row,1));
                    }
                    catch (Exception ex) 
                    {
                        Logger.getLogger(UpdateCstmrCrdForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ViewClaimForm.show();
                  }
             }
        });
    }
    
    public ClaimsTableViewForm(String buttonText , Claim.EvntType eventType) throws Exception 
    {
        initComponents();
        model2 = (DefaultTableModel)jTableClaimView.getModel();
        java.awt.event.WindowEvent MyWindow = null;
        formWindowOpened(MyWindow);

                
        if ("View all Claim with this Event Type".equals(buttonText))
        {
            JTextPaneClaimViewDescription.setText("View all Claims with EventType: "+eventType.toString());  
            try 
           {
               model2.setRowCount(0);
               for(CustomerCrd ctmrCrd :sngltn.GetAllCustemers())
               {    
                    for(Claim claim : sngltn.GetMyEventClaims(eventType, ctmrCrd.getPerson()))
                    {
                         model2.addRow(new Object[] {getPerIdByClaimId(claim.getId()),String.valueOf(claim.getId()),String.valueOf(claim.getRepresentativeName()),String.valueOf(claim.getInsuranceClaimStatus()),String.valueOf(claim.getEventType()),String.valueOf(claim.getEventTime()),String.valueOf(claim.getEventPlace())});
                    }
               }                         
           } 
           catch (Exception ex) 
           {
               Logger.getLogger(AddCstmrCrdForm.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        
        jTableClaimView.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
               if (e.getClickCount() == 1) {
                    JTable target = (JTable)e.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                    
                    JustViewClaimForm ViewClaimForm= null;
                    try
                    {
                      ViewClaimForm = new  JustViewClaimForm((long) model2.getValueAt(row,0),model2.getValueAt(row,1));
                    }
                    catch (Exception ex) 
                    {
                        Logger.getLogger(UpdateCstmrCrdForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ViewClaimForm.show();
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
        SelectWhichNewActv = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTextPaneClaimViewDescription = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableClaimView = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();

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

        JTextPaneClaimViewDescription.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        JTextPaneClaimViewDescription.setEnabled(false);
        jScrollPane1.setViewportView(JTextPaneClaimViewDescription);

        SelectWhichNewActv.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 250, 70));

        jTableClaimView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Person ID", "Claim ID", "Representative", "Status", "Type", "Event time", "Event place"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jTableClaimView.setColumnSelectionAllowed(true);
        jScrollPane3.setViewportView(jTableClaimView);
        jTableClaimView.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        SelectWhichNewActv.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 580, 320));

        jLabel7.setText("Claims  Table:");
        SelectWhichNewActv.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 160, -1));

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
        
     private long getPerIdByClaimId(long claimId) throws Exception
     {
      for (CustomerCrd cstmr :sngltn.GetAllCustemers())
        {
          for (Activity act:cstmr.getActivities())
          {
              if (act instanceof Claim)
              {
                  Claim claim=(Claim)act;
                  if (claim.getId()==claimId)
                      return cstmr.getPerson().getId();
              }
          }
        }
        return 0;
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
            java.util.logging.Logger.getLogger(ClaimsTableViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClaimsTableViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClaimsTableViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClaimsTableViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JTextPane JTextPaneClaimViewDescription;
    private javax.swing.JPanel SelectWhichNewActv;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableClaimView;
    // End of variables declaration//GEN-END:variables
}