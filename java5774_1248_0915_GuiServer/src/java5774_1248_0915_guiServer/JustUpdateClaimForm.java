/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package java5774_1248_0915_guiServer;

import DataAccessObject.Controller;
import DataAccessObject.Singelton;
import java.awt.Color;
import java.awt.TextField;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Packages.Claim;
import Packages.Claim.ClaimStat;
import Packages.Claim.Documents;
import Packages.Claim.EvntType;

/**
 *
 * @author dell
 */
public class JustUpdateClaimForm extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;

    /**
     * Creates new form AddClaim
     */
    private long per_id;
    private long claim_id;
    private JTable Claimtable;
    private ArrayList<String> receivedDocumnt;
    
    private Claim claim=null;
    
    private static Controller sngltn = null;
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
    
    public JustUpdateClaimForm(long PerId,Object ClaimID,JTable jtableClaim) throws Exception {
        this.receivedDocumnt = new ArrayList<String>();
        
        per_id=PerId;
        claim_id=Long.valueOf(ClaimID.toString());
        Claimtable=jtableClaim;

        claim =new Claim();
        claim=sngltn.GetClaimById(claim_id);
        
        int NumOfDetails=claim.getMoreDetailsSize();
        
        initComponents();
        java.awt.event.WindowEvent MyWindow = null;
        formWindowOpened(MyWindow);
        
        ArrayList<Documents> arr=SetReqDucmntsListByEvent(claim.getEventType());
        
        ComboBoxEventType.setModel(new DefaultComboBoxModel(EvntType.values()));
        ComboBoxInsuranceClaimStatus.setModel(new DefaultComboBoxModel(ClaimStat.values()));
        
        DetailsFieldsFirstDesplay(NumOfDetails);
        
        TextPerson_Name_ID.setEnabled(false);
        TextPerson_Name_ID.setText("Person Name: "+ 
                                    sngltn.GetMyPersonCstmrCrd(per_id).getPerson().getNamePerson()+ "\n"+
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
                                    EnterDetail0.setText(claim.getMoreDetailsValues().get(0));
        else if (NumOfDetails==2)
                                {
                                    EnterDetail0.setText(claim.getMoreDetailsValues().get(0));
                                    EnterDetail1.setText(claim.getMoreDetailsValues().get(1));
                                }
        else if (NumOfDetails==3)
                                {
                                    EnterDetail0.setText(claim.getMoreDetailsValues().get(0));
                                    EnterDetail1.setText(claim.getMoreDetailsValues().get(1));
                                    EnterDetail2.setText(claim.getMoreDetailsValues().get(2));
                                }
         else if (NumOfDetails==4)
                                {
                                    EnterDetail0.setText(claim.getMoreDetailsValues().get(0));
                                    EnterDetail1.setText(claim.getMoreDetailsValues().get(1));
                                    EnterDetail2.setText(claim.getMoreDetailsValues().get(2));
                                    EnterDetail3.setText(claim.getMoreDetailsValues().get(3));
                                }
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
        
        for(int i=0;i<jTableDocumentsRequired.getRowCount();i++)
        {
            for (String doc :claim.getDocumentsReceivedValues())
            {   
                if(jTableDocumentsRequired.getValueAt(i, 0).toString().equals(doc))
                jTableDocumentsRequired.setValueAt(true,i, 1);
            }
        }
        
       
    }

    private JustUpdateClaimForm() {
        this.receivedDocumnt = new ArrayList<String>();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        buttonUpdateThisClaim = new java.awt.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextPerson_Name_ID = new javax.swing.JTextPane();
        buttonMinus1 = new java.awt.Button();
        buttonMinus2 = new java.awt.Button();
        buttonMinus3 = new java.awt.Button();
        buttonPlus0 = new java.awt.Button();
        buttonPlus1 = new java.awt.Button();
        buttonPlus2 = new java.awt.Button();
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

        EnterRepresentativeName.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        EnterRepresentativeName.setForeground(new java.awt.Color(0, 0, 0));
        EnterRepresentativeName.setText("Enter Representative Name");
        EnterRepresentativeName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnterRepresentativeNameActionPerformed(evt);
            }
        });
        EnterRepresentativeName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                representative_name_cursor_in_handler(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                representative_name_cursor_out_handler(evt);
            }
        });
        getContentPane().add(EnterRepresentativeName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 170, 30));

        jLabel1.setText("Representative Name:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 130, 30));

        jSpinnerOpeningDate.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.DAY_OF_YEAR));
        jSpinnerOpeningDate.setEnabled(false);
        getContentPane().add(jSpinnerOpeningDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 165, 30));

        jLabel2.setText("Opening Date:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 106, -1));

        jLabel3.setText("More Details:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, -1, -1));

        EnterDetail0.setForeground(new java.awt.Color(0, 0, 0));
        EnterDetail0.setMaximumSize(new java.awt.Dimension(72, 21));
        EnterDetail0.setText("Enter Detail");
        EnterDetail0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnterDetail0ActionPerformed(evt);
            }
        });
        EnterDetail0.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                detail0_cursor_in_handler(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                detail0_cursor_out_handler(evt);
            }
        });
        getContentPane().add(EnterDetail0, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, 339, -1));

        EnterDetail2.setForeground(new java.awt.Color(0, 0, 0));
        EnterDetail2.setMaximumSize(new java.awt.Dimension(72, 21));
        EnterDetail2.setText("Enter Detail");
        EnterDetail2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                detail2_cursor_in_handler(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                detail2_cursor_out_handler(evt);
            }
        });
        getContentPane().add(EnterDetail2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 470, 339, -1));

        EnterDetail3.setForeground(new java.awt.Color(0, 0, 0));
        EnterDetail3.setMaximumSize(new java.awt.Dimension(72, 21));
        EnterDetail3.setText("Enter Detail");
        EnterDetail3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                detail3_cursor_in_handler(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                detail3_cursor_out_handler(evt);
            }
        });
        getContentPane().add(EnterDetail3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 510, 339, -1));

        EnterDetail1.setForeground(new java.awt.Color(0, 0, 0));
        EnterDetail1.setMaximumSize(new java.awt.Dimension(72, 21));
        EnterDetail1.setText("Enter Detail");
        EnterDetail1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnterDetail1ActionPerformed(evt);
            }
        });
        EnterDetail1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                detail1_cursor_in_handler(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                detail1_cursor_out_handler(evt);
            }
        });
        getContentPane().add(EnterDetail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, 339, -1));

        jSpinnerClaimId.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jSpinnerClaimId.setEnabled(false);
        getContentPane().add(jSpinnerClaimId, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 78, -1));

        jLabel4.setText("Claim  ID:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel5.setText("* predetermined");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, -1, -1));

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

        ComboBoxInsuranceClaimStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(ComboBoxInsuranceClaimStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 165, -1));

        jLabel7.setText("Insurance Claim Status:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jLabel8.setText("Event Time:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 70, 20));

        jSpinnerEventTime.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1397040165906L), new java.util.Date(536450400000L), null, java.util.Calendar.DAY_OF_MONTH));
        getContentPane().add(jSpinnerEventTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 160, 30));

        buttonUpdateThisClaim.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buttonUpdateThisClaim.setLabel("Update this claim");
        buttonUpdateThisClaim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateThisClaimActionPerformed(evt);
            }
        });
        getContentPane().add(buttonUpdateThisClaim, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 130, 78));

        jScrollPane1.setViewportView(TextPerson_Name_ID);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 322, 54));

        buttonMinus1.setLabel("-");
        buttonMinus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMinus1ActionPerformed(evt);
            }
        });
        getContentPane().add(buttonMinus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, -1, 21));

        buttonMinus2.setLabel("-");
        buttonMinus2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMinus2ActionPerformed(evt);
            }
        });
        getContentPane().add(buttonMinus2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, -1, 19));

        buttonMinus3.setLabel("-");
        buttonMinus3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMinus3ActionPerformed(evt);
            }
        });
        getContentPane().add(buttonMinus3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, -1, 20));

        buttonPlus0.setLabel("+");
        buttonPlus0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPlus0ActionPerformed(evt);
            }
        });
        getContentPane().add(buttonPlus0, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 390, -1, 21));

        buttonPlus1.setLabel("+");
        buttonPlus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPlus1ActionPerformed(evt);
            }
        });
        getContentPane().add(buttonPlus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 430, -1, 21));

        buttonPlus2.setLabel("+");
        buttonPlus2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPlus2ActionPerformed(evt);
            }
        });
        getContentPane().add(buttonPlus2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 470, -1, 21));

        jLabel9.setText("Event Place:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        EnterEventPlace.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        EnterEventPlace.setForeground(new java.awt.Color(0, 0, 0));
        EnterEventPlace.setText("Enter Place");
        EnterEventPlace.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                event_place_cursor_in_handler(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                event_place_cursor_out_handler(evt);
            }
        });
        getContentPane().add(EnterEventPlace, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 100, -1));

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
                false, true
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
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 130, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EnterDetail0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnterDetail0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EnterDetail0ActionPerformed

    private void buttonUpdateThisClaimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateThisClaimActionPerformed
        if (!CheckAllInputText(
                                ThereIsText(EnterRepresentativeName.getText()),
                                ThereIsText(jSpinnerEventTime.getValue().toString()),
                                 EnterDetail0.isVisible() && ThereIsText(EnterDetail0.getText()),
                                !EnterDetail1.isVisible()||(EnterDetail1.isVisible() && ThereIsText(EnterDetail1.getText())),
                                !EnterDetail2.isVisible()||(EnterDetail2.isVisible() && ThereIsText(EnterDetail2.getText())),
                                !EnterDetail3.isVisible()||(EnterDetail3.isVisible() && ThereIsText(EnterDetail3.getText())),
                                ThereIsText(EnterEventPlace.getText())
                              )
           )JOptionPane.showMessageDialog(null, "Insert valid values", "Error",JOptionPane.ERROR_MESSAGE);

        else if("Update this claim".equals(buttonUpdateThisClaim.getLabel()))
                {   
                    claim=new Claim();
                    try 
                    {
                      claim=sngltn.GetClaimById(Long.parseLong(jSpinnerClaimId.getValue().toString()));
                    }
                    
                    catch (Exception ex) 
                    {
                        Logger.getLogger(JustUpdateClaimForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    for (int i=0;i<receivedDocumnt.size();i++)
                    {
                        receivedDocumnt.remove(i);
                    }
                    
                    
                    for (int i=0;i<jTableDocumentsRequired.getRowCount();i++)
                    {
                        if((boolean)jTableDocumentsRequired.getValueAt(i, 1))
                        receivedDocumnt.add((String) jTableDocumentsRequired.getValueAt(i, 0));
                    }
                    
                    claim.setRepresentativeName(EnterRepresentativeName.getText());
                    claim.setInsuranceClaimStatus((ClaimStat)ComboBoxInsuranceClaimStatus.getSelectedItem());
                    claim.setEventTime((Date) jSpinnerEventTime.getValue());
                    claim.setEventPlace(EnterEventPlace.getText());
                    claim.setMoreDetails(exsitDetailsToList(EnterDetail0, EnterDetail1, EnterDetail2, EnterDetail3));
                    claim.setDocumentsReceived(receivedDocumnt);
                    try 
                    {
                        sngltn.UpdateClaim(claim, sngltn.GetMyPersonCstmrCrd(per_id).getPerson());
                    }
                    catch (Exception ex) 
                    {
                        Logger.getLogger(JustUpdateClaimForm.class.getName()).log(Level.SEVERE, null, ex);
                    }     
                    JOptionPane.showMessageDialog(null, "Update Claim Successfully", "",JOptionPane.PLAIN_MESSAGE);        
                }
    }//GEN-LAST:event_buttonUpdateThisClaimActionPerformed

    private void buttonPlus0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPlus0ActionPerformed
        EnterDetail0.setVisible(true);
        EnterDetail1.setVisible(true);
        buttonPlus0.setEnabled(false);
        buttonPlus0.setVisible(false);
        buttonPlus1.setVisible(true);
        buttonPlus1.setEnabled(true);
        buttonMinus1.setVisible(true);
        buttonMinus1.setEnabled(true);
        buttonMinus2.setEnabled(false);
        buttonMinus2.setVisible(false);
        buttonMinus3.setEnabled(false);
        buttonMinus3.setVisible(false);
        this.setSize(532, 490);
    }//GEN-LAST:event_buttonPlus0ActionPerformed

    private void buttonPlus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPlus1ActionPerformed
        EnterDetail0.setVisible(true);
        EnterDetail1.setVisible(true);
        EnterDetail2.setVisible(true);
        buttonPlus0.setVisible(false);
        buttonPlus0.setEnabled(false);
        buttonPlus1.setVisible(false);
        buttonPlus1.setEnabled(false);
        buttonPlus2.setVisible(true);
        buttonPlus2.setEnabled(true);
        buttonMinus1.setEnabled(false);
        buttonMinus1.setVisible(false);
        buttonMinus2.setVisible(true);
        buttonMinus2.setEnabled(true);
        buttonMinus3.setEnabled(false);
        buttonMinus3.setVisible(false);
        this.setSize(532, 530);
    }//GEN-LAST:event_buttonPlus1ActionPerformed

    private void buttonPlus2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPlus2ActionPerformed
        EnterDetail0.setVisible(true);
        EnterDetail1.setVisible(true);
        EnterDetail2.setVisible(true);
        EnterDetail3.setVisible(true);  
        buttonPlus0.setVisible(false);
        buttonPlus0.setEnabled(false);
        buttonPlus1.setVisible(false);
        buttonPlus1.setEnabled(false);
        buttonPlus2.setVisible(false);
        buttonPlus2.setEnabled(false);
        buttonMinus1.setEnabled(false);
        buttonMinus1.setVisible(false);
        buttonMinus2.setVisible(false);
        buttonMinus2.setEnabled(false);
        buttonMinus3.setVisible(true);
        buttonMinus3.setEnabled(true);
        this.setSize(532, 570);
    }//GEN-LAST:event_buttonPlus2ActionPerformed

    private void buttonMinus3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMinus3ActionPerformed
         EnterDetail3.setVisible(false);
        buttonPlus0.setVisible(false);
        buttonPlus0.setEnabled(false);
        buttonPlus1.setVisible(false);
        buttonPlus1.setEnabled(false);
        buttonPlus2.setVisible(true);
        buttonPlus2.setEnabled(true);
        buttonMinus1.setEnabled(false);
        buttonMinus1.setVisible(false);
        buttonMinus2.setVisible(true);
        buttonMinus2.setEnabled(true);
        buttonMinus3.setEnabled(false);
        buttonMinus3.setVisible(false);
        this.setSize(532, 530);
    }//GEN-LAST:event_buttonMinus3ActionPerformed

    private void buttonMinus2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMinus2ActionPerformed
        EnterDetail3.setVisible(false);
        EnterDetail2.setVisible(false);
        buttonPlus0.setVisible(false);
        buttonPlus0.setEnabled(false);
        buttonPlus1.setVisible(true);
        buttonPlus1.setEnabled(true);
        buttonPlus2.setVisible(false);
        buttonPlus2.setEnabled(false);
        buttonMinus1.setEnabled(true);
        buttonMinus1.setVisible(true);
        buttonMinus2.setVisible(false);
        buttonMinus2.setEnabled(false);
        buttonMinus3.setEnabled(false);
        buttonMinus3.setVisible(false);
        this.setSize(532, 490);
    }//GEN-LAST:event_buttonMinus2ActionPerformed

    private void buttonMinus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMinus1ActionPerformed
        EnterDetail3.setVisible(false);
        EnterDetail2.setVisible(false);
        EnterDetail1.setVisible(false);
        EnterDetail0.setVisible(true);
        buttonPlus0.setVisible(true);
        buttonPlus0.setEnabled(true);
        buttonPlus1.setVisible(false);
        buttonPlus1.setEnabled(false);
        buttonPlus2.setVisible(false);
        buttonPlus2.setEnabled(false);
        buttonMinus1.setEnabled(false);
        buttonMinus1.setVisible(false);
        buttonMinus2.setVisible(false);
        buttonMinus2.setEnabled(false);
        buttonMinus3.setEnabled(false);
        buttonMinus3.setVisible(false);
        this.setSize(532, 450);
    }//GEN-LAST:event_buttonMinus1ActionPerformed

    private void EnterDetail1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnterDetail1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EnterDetail1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
                                    
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try 
        {
            int counter=1;
            DefaultTableModel model=(DefaultTableModel)Claimtable.getModel();
            model.setRowCount(0);
            for(Claim Claim : sngltn.GetPerClaims(sngltn.GetMyPersonCstmrCrd(per_id).getPerson()))
            {
                model.addRow(new Object[] {String.valueOf(Claim.getId()),String.valueOf(Claim.getRepresentativeName()),String.valueOf(Claim.getInsuranceClaimStatus()),String.valueOf(Claim.getEventType()),String.valueOf(Claim.getEventTime()),String.valueOf(Claim.getEventPlace())});
            }                           
        }
        catch (Exception ex) 
        {
            Logger.getLogger(AddCstmrCrdForm.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    private void EnterRepresentativeNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnterRepresentativeNameActionPerformed
        
    }//GEN-LAST:event_EnterRepresentativeNameActionPerformed

    private void representative_name_cursor_in_handler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_representative_name_cursor_in_handler
        if (EnterRepresentativeName.getText().equals("Enter Representative Name")) {
            EnterRepresentativeName.setText(null);
            EnterRepresentativeName.setFont(new java.awt.Font("Tahoma", 0, 11));
            EnterRepresentativeName.setForeground(new java.awt.Color(0, 0, 0));
        }
    }//GEN-LAST:event_representative_name_cursor_in_handler

    private void representative_name_cursor_out_handler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_representative_name_cursor_out_handler
        if (EnterRepresentativeName.getText().length() < 1) {
            EnterRepresentativeName.setText("Enter Representative Name");
            EnterRepresentativeName.setFont(new java.awt.Font("Tahoma", 2, 11));
            EnterRepresentativeName.setForeground(new java.awt.Color(153, 153, 153));
        }
    }//GEN-LAST:event_representative_name_cursor_out_handler

    private void event_place_cursor_in_handler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_event_place_cursor_in_handler
        if (EnterEventPlace.getText().equals("Enter Place")) {
            EnterEventPlace.setText(null);
            EnterEventPlace.setFont(new java.awt.Font("Tahoma", 0, 11));
            EnterEventPlace.setForeground(new java.awt.Color(0, 0, 0));
        }
    }//GEN-LAST:event_event_place_cursor_in_handler

    private void event_place_cursor_out_handler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_event_place_cursor_out_handler
        if (EnterEventPlace.getText().length() < 1) {
            EnterEventPlace.setText("Enter Place");
            EnterEventPlace.setFont(new java.awt.Font("Tahoma", 2, 11));
            EnterEventPlace.setForeground(new java.awt.Color(153, 153, 153));
        }
    }//GEN-LAST:event_event_place_cursor_out_handler

    private void detail0_cursor_in_handler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_detail0_cursor_in_handler
        if (EnterDetail0.getText().equals("Enter Detail")) {
            EnterDetail0.setText(null);
            EnterDetail0.setFont(new java.awt.Font("Tahoma", 0, 12));
            EnterDetail0.setForeground(new java.awt.Color(0, 0, 0));
        }
    }//GEN-LAST:event_detail0_cursor_in_handler

    private void detail1_cursor_in_handler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_detail1_cursor_in_handler
        if (EnterDetail1.getText().equals("Enter Detail")) {
            EnterDetail1.setText(null);
            EnterDetail1.setFont(new java.awt.Font("Tahoma", 0, 12));
            EnterDetail1.setForeground(new java.awt.Color(0, 0, 0));
        }
    }//GEN-LAST:event_detail1_cursor_in_handler

    private void detail2_cursor_in_handler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_detail2_cursor_in_handler
        if (EnterDetail2.getText().equals("Enter Detail")) {
            EnterDetail2.setText(null);
            EnterDetail2.setFont(new java.awt.Font("Tahoma", 0, 12));
            EnterDetail2.setForeground(new java.awt.Color(0, 0, 0));
        }
    }//GEN-LAST:event_detail2_cursor_in_handler

    private void detail3_cursor_in_handler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_detail3_cursor_in_handler
        if (EnterDetail3.getText().equals("Enter Detail")) {
            EnterDetail3.setText(null);
            EnterDetail3.setFont(new java.awt.Font("Tahoma", 0, 12));
            EnterDetail3.setForeground(new java.awt.Color(0, 0, 0));
        }
    }//GEN-LAST:event_detail3_cursor_in_handler

    private void detail3_cursor_out_handler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_detail3_cursor_out_handler
        if (EnterDetail3.getText().length() < 1) {
            EnterDetail3.setText("Enter Detail");
            EnterDetail3.setFont(new java.awt.Font("Tahoma", 2, 12));
            EnterDetail3.setForeground(new java.awt.Color(153, 153, 153));
        }
    }//GEN-LAST:event_detail3_cursor_out_handler

    private void detail2_cursor_out_handler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_detail2_cursor_out_handler
        if (EnterDetail2.getText().length() < 1) {
            EnterDetail2.setText("Enter Detail");
            EnterDetail2.setFont(new java.awt.Font("Tahoma", 2, 12));
            EnterDetail2.setForeground(new java.awt.Color(153, 153, 153));
        }
    }//GEN-LAST:event_detail2_cursor_out_handler

    private void detail1_cursor_out_handler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_detail1_cursor_out_handler
        if (EnterDetail1.getText().length() < 1) {
            EnterDetail1.setText("Enter Detail");
            EnterDetail1.setFont(new java.awt.Font("Tahoma", 2, 12));
            EnterDetail1.setForeground(new java.awt.Color(153, 153, 153));
        }
    }//GEN-LAST:event_detail1_cursor_out_handler

    private void detail0_cursor_out_handler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_detail0_cursor_out_handler
        if (EnterDetail0.getText().length() < 1) {
            EnterDetail0.setText("Enter Detail");
            EnterDetail0.setFont(new java.awt.Font("Tahoma", 2, 12));
            EnterDetail0.setForeground(new java.awt.Color(153, 153, 153));
        }
    }//GEN-LAST:event_detail0_cursor_out_handler
        
    private boolean CheckAllInputText(boolean str1 ,boolean str2 , boolean str3, boolean str4 , boolean str5 , boolean str6 , boolean str7 ){ 
             boolean reslt=true;
             if(str1==false) 
                {
                 EnterRepresentativeName.setBackground(Color.red);
                 reslt=false;
                }
             else
                 EnterRepresentativeName.setBackground(Color.white);
             
             if(str2==false) 
                {
                 jSpinnerEventTime.setBackground(Color.red);
                 reslt=false;
                }
             else
                 jSpinnerEventTime.setBackground(Color.white);
             
             if(str3==false) 
                {
                 EnterDetail0.setBackground(Color.red);
                 reslt=false;
                }
             else
                 EnterDetail0.setBackground(Color.white);
             
             if(str4==false) 
                {
                 EnterDetail1.setBackground(Color.red);
                 reslt=false;
                }
              else
                 EnterDetail1.setBackground(Color.white);
             
              if(str5==false) 
                {
                 EnterDetail2.setBackground(Color.red);
                 reslt=false;
                }
              else
                 EnterDetail2.setBackground(Color.white);
              
              if(str6==false) 
                {
                 EnterDetail3.setBackground(Color.red);
                 reslt=false;
                }
              else
                 EnterDetail3.setBackground(Color.white);
              
               if(str7==false) 
                {
                 EnterEventPlace.setBackground(Color.red);
                 reslt=false;
                }
              else
                 EnterEventPlace.setBackground(Color.white);
             
             return reslt;
    }
    
    
        private boolean ThereIsText(String str){ 
            try{ 
                int ln=str.length();
                if ((ln == 0) || (str.equals("Enter Representative Name")) || (str.equals("Enter Place"))) 
                    return false;
            }

            catch(NumberFormatException n){ 
                return false; 
            } 
            return true;
        }
    
            private static boolean OnlyNumbers(String str){ 
            try{ 
                long l = Long.parseLong(str); 
            }

            catch(NumberFormatException n)
            { 
                return false; 
            } 
            return true;
        }
        
        private ArrayList<String> exsitDetailsToList (TextField textfield0,TextField textfield1,TextField textfield2,TextField textfield3)
        {
           ArrayList<String> DetailList = new ArrayList<String>();
           if(textfield0.isVisible() && !"".equals(textfield0.getText())) DetailList.add(textfield0.getText());
           if(textfield1.isVisible() && !"".equals(textfield1.getText())) DetailList.add(textfield1.getText());
           if(textfield2.isVisible() && !"".equals(textfield2.getText())) DetailList.add(textfield2.getText());
           if(textfield3.isVisible() && !"".equals(textfield3.getText())) DetailList.add(textfield3.getText());
           return DetailList;   
        }
        
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
                            buttonPlus1.setVisible(true);
                            buttonPlus2.setVisible(false);
                            buttonMinus1.setVisible(false);
                            buttonMinus2.setVisible(false);
                            buttonMinus3.setVisible(false);
                            this.setSize(530, 450);
                          }
        else if (list_lentgh==2)
                                {
                                  EnterDetail0.setVisible(true);
                                  EnterDetail1.setVisible(true);
                                  buttonPlus0.setEnabled(false);
                                  buttonPlus0.setVisible(false);
                                  buttonPlus1.setVisible(true);
                                  buttonPlus1.setEnabled(true);
                                  buttonMinus1.setVisible(true);
                                  buttonMinus1.setEnabled(true);
                                  buttonMinus2.setEnabled(false);
                                  buttonMinus2.setVisible(false);
                                  buttonMinus3.setEnabled(false);
                                  buttonMinus3.setVisible(false);
                                  this.setSize(530, 485);
                                }
        
        else if (list_lentgh==3)
                                {
                                EnterDetail0.setVisible(true);
                                EnterDetail1.setVisible(true);
                                EnterDetail2.setVisible(true);
                                buttonPlus0.setVisible(false);
                                buttonPlus0.setEnabled(false);
                                buttonPlus1.setVisible(false);
                                buttonPlus1.setEnabled(false);
                                buttonPlus2.setVisible(true);
                                buttonPlus2.setEnabled(true);
                                buttonMinus1.setEnabled(false);
                                buttonMinus1.setVisible(false);
                                buttonMinus2.setVisible(true);
                                buttonMinus2.setEnabled(true);
                                buttonMinus3.setEnabled(false);
                                buttonMinus3.setVisible(false);
                                this.setSize(530, 525);
                                }
        else if (list_lentgh==4)
                                {
                                 EnterDetail0.setVisible(true);
                                 EnterDetail1.setVisible(true);
                                 EnterDetail2.setVisible(true);
                                 EnterDetail3.setVisible(true);  
                                 buttonPlus0.setVisible(false);
                                 buttonPlus0.setEnabled(false);
                                 buttonPlus1.setVisible(false);
                                 buttonPlus1.setEnabled(false);
                                 buttonPlus2.setVisible(false);
                                 buttonPlus2.setEnabled(false);
                                 buttonMinus1.setEnabled(false);
                                 buttonMinus1.setVisible(false);
                                 buttonMinus2.setVisible(false);
                                 buttonMinus2.setEnabled(false);
                                 buttonMinus3.setVisible(true);
                                 buttonMinus3.setEnabled(true);
                                 this.setSize(530, 565);
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
            java.util.logging.Logger.getLogger(JustUpdateClaimForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JustUpdateClaimForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JustUpdateClaimForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JustUpdateClaimForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JustUpdateClaimForm().setVisible(true);
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
    private java.awt.Button buttonMinus1;
    private java.awt.Button buttonMinus2;
    private java.awt.Button buttonMinus3;
    private java.awt.Button buttonPlus0;
    private java.awt.Button buttonPlus1;
    private java.awt.Button buttonPlus2;
    private java.awt.Button buttonUpdateThisClaim;
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
