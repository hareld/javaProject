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
import Packages.Person;
import Packages.Policy;

/**
 *
 * @author dell
 */
public class UpdateCstmrCrdForm extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;
    private long per_id;
    
    private final Runnable UpdateCstmrCrdFormMyfunc;
    
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
    public UpdateCstmrCrdForm(long person_id,Runnable myFunc) throws Exception {
        UpdateCstmrCrdFormMyfunc = myFunc;
        
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
            Logger.getLogger(UpdateCstmrCrdForm.class.getName()).log(Level.SEVERE, null, ex);
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
                    
                    DeleteOrUpdateSelectForm deletOrUp = null;
                    try
                    {
                      deletOrUp = new  DeleteOrUpdateSelectForm("p",per_id,jTablePolicyView.getValueAt(row,0),jTablePolicyView);
                    }
                    catch (Exception ex) 
                    {
                        Logger.getLogger(UpdateCstmrCrdForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    deletOrUp .show();
                  }
             }
        });
        
        jTableClaimView.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
               if (e.getClickCount() == 1) {
                    JTable target = (JTable)e.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                    
                    DeleteOrUpdateSelectForm deletOrUp = null;
                    try
                    {
                      deletOrUp = new  DeleteOrUpdateSelectForm("c",per_id,jTableClaimView.getValueAt(row,0),jTableClaimView);
                    }
                    catch (Exception ex) 
                    {
                        Logger.getLogger(UpdateCstmrCrdForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    deletOrUp .show();
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
        buttonUpdatePerson = new java.awt.Button();
        EnterPerName = new javax.swing.JTextField();
        EnterPerId = new javax.swing.JTextField();
        EnterPerPhone = new javax.swing.JTextField();
        EnterPerAddress = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        SelectWhichNewActv = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        SelectActivType = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        PerNameInActivityTab = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePolicyView = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableClaimView = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

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
        AddNewPerson.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 82, -1));

        jLabel2.setText("Person ID:");
        AddNewPerson.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, -1, -1));

        jLabel3.setText("Person Phone:");
        AddNewPerson.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, -1, -1));

        jLabel4.setText("Person Address:");
        AddNewPerson.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, -1));

        buttonUpdatePerson.setLabel("Update Person");
        buttonUpdatePerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdatePersonActionPerformed(evt);
            }
        });
        AddNewPerson.add(buttonUpdatePerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 141, 45));
        buttonUpdatePerson.getAccessibleContext().setAccessibleName("AddNewPerson");

        EnterPerName.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        EnterPerName.setForeground(new java.awt.Color(0, 0, 0));
        EnterPerName.setText("Enter Name");
        EnterPerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnterPerNameActionPerformed(evt);
            }
        });
        EnterPerName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                person_name_cursor_in_handler(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                person_name_cursor_out_handler(evt);
            }
        });
        AddNewPerson.add(EnterPerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 91, 25));

        EnterPerId.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        EnterPerId.setForeground(new java.awt.Color(0, 0, 0));
        EnterPerId.setText("Enter Per ID");
        EnterPerId.setEnabled(false);
        EnterPerId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnterPerIdActionPerformed(evt);
            }
        });
        AddNewPerson.add(EnterPerId, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 91, 24));

        EnterPerPhone.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        EnterPerPhone.setForeground(new java.awt.Color(0, 0, 0));
        EnterPerPhone.setText("Enter Phone");
        EnterPerPhone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                person_phone_cursor_in_handler(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                person_phone_cursor_out_handler(evt);
            }
        });
        AddNewPerson.add(EnterPerPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 91, 25));

        EnterPerAddress.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        EnterPerAddress.setForeground(new java.awt.Color(0, 0, 0));
        EnterPerAddress.setText("Enter Address");
        EnterPerAddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                person_address_cursor_in_handler(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                person_address_cursor_out_handler(evt);
            }
        });
        AddNewPerson.add(EnterPerAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 144, 27));

        jLabel8.setText("*Only Numbers");
        AddNewPerson.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 90, 20));

        jLabel9.setText("*Only Numbers");
        AddNewPerson.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, 90, 20));

        All_Tab.addTab("Person", AddNewPerson);

        SelectWhichNewActv.setEnabled(false);
        SelectWhichNewActv.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Add Activity:");
        SelectWhichNewActv.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, -1, 25));

        SelectActivType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "New Policy", "New Claim" }));
        SelectActivType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectActivTypeActionPerformed(evt);
            }
        });
        SelectWhichNewActv.add(SelectActivType, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 140, -1));

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

        SelectWhichNewActv.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 574, 92));

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

        SelectWhichNewActv.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 574, 90));

        jLabel6.setText("Select Policy to Update\\Delete:");
        SelectWhichNewActv.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 210, -1));

        jLabel7.setText("Select Claim to Update\\Delete:");
        SelectWhichNewActv.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 210, -1));

        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        SelectWhichNewActv.add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, -1, -1));
        SelectWhichNewActv.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 122, 510, 0));
        SelectWhichNewActv.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 540, -1));

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
      
    
    private void buttonUpdatePersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdatePersonActionPerformed
        Person per = null;
        CustomerCrd cstmr = null;
        try 
        {
            cstmr = sngltn.GetMyPersonCstmrCrd(per_id);
        }
        catch (Exception ex) {
            Logger.getLogger(UpdateCstmrCrdForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (!CheckAllInputText(
                                ThereIsText(EnterPerName.getText()),
                                ThereIsText(EnterPerId.getText()) && OnlyNumbers(EnterPerId.getText()),
                                ThereIsText(EnterPerPhone.getText()) && OnlyNumbers(EnterPerPhone.getText()),
                                ThereIsText(EnterPerAddress.getText())
                              )
           )JOptionPane.showMessageDialog(null, "Insert valid values", "Error",JOptionPane.ERROR_MESSAGE);

        else 
        {
           per=cstmr.getPerson();
           per.setNamePerson(EnterPerName.getText());
           per.setPhonePerson(parseLong(EnterPerPhone.getText()));
           per.setAddressPerson(EnterPerAddress.getText());
           cstmr.setPerson(per);
            try {
                sngltn.UpdateCustomerCrd(cstmr);
            } catch (Exception ex) {
                Logger.getLogger(UpdateCstmrCrdForm.class.getName()).log(Level.SEVERE, null, ex);
            }
           JOptionPane.showMessageDialog(null, "Update Preson Successfully", "",JOptionPane.PLAIN_MESSAGE);
            try 
            {
                PerNameInActivityTab.setText("Person Name: "+
                                              sngltn.GetMyPersonCstmrCrd(per.getId()).getPerson().getNamePerson()+ "\n"+
                                              "Preson ID: "+
                                              Long.toString(per.getId())
                                            );
            } 
            catch (Exception ex) 
            {
                Logger.getLogger(UpdateCstmrCrdForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_buttonUpdatePersonActionPerformed

    
    
    @SuppressWarnings({"deprecation", "deprecation"})
    private void SelectActivTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectActivTypeActionPerformed
        //jComboBoxIdSelect
        if (SelectActivType.getSelectedIndex()==0)
        {
            AddPolicyForm AddPolicy = null;
            try
            {
              AddPolicy = new  AddPolicyForm(per_id,jTablePolicyView,
                                            new Runnable() {
                                                      @Override public void run() {
                                                                                    try 
                                                                                    {
                                                                                        EnableThisForm();
                                                                                    }
                                                                                    catch (Exception ex) 
                                                                                    {
                                                                                        Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                                                                                    }
                                                                                  }
                                                    }
                                            );
            }
            catch (Exception ex) 
            {
                Logger.getLogger(UpdateCstmrCrdForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            setEnabled(false);
            AddPolicy.show();
        }
        else if (SelectActivType.getSelectedIndex()==1)
        {
            
            if(jTablePolicyView.getRowCount()==0)
            {
                JOptionPane.showMessageDialog(null, "Sorry, you can't open a new claim unless there is at least one policy.", "",JOptionPane.PLAIN_MESSAGE);
            }
            else
                {
                    AddClaimForm AddClaim=null;
                    try
                    {
                    AddClaim = new  AddClaimForm(per_id,jTableClaimView,
                                                 new Runnable() {
                                                      @Override public void run() {
                                                                                    try 
                                                                                    {
                                                                                        EnableThisForm();
                                                                                    }
                                                                                    catch (Exception ex) 
                                                                                    {
                                                                                        Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                                                                                    }
                                                                                  }
                                                    }
                                                );
                    }
                    catch (Exception ex) 
                    {
                        Logger.getLogger(UpdateCstmrCrdForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    setEnabled(false);
                    AddClaim.show();
                }
        }
    }//GEN-LAST:event_SelectActivTypeActionPerformed

  
    
    private void EnterPerIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnterPerIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EnterPerIdActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
           UpdateCstmrCrdFormMyfunc.run();
    }//GEN-LAST:event_formWindowClosing

    private void person_name_cursor_in_handler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_person_name_cursor_in_handler
        if (EnterPerName.getText().equals("Enter Name")) {
            EnterPerName.setText(null);
            EnterPerName.setFont(new java.awt.Font("Tahoma", 0, 11));
            EnterPerName.setForeground(new java.awt.Color(0, 0, 0));
        }
    }//GEN-LAST:event_person_name_cursor_in_handler

    private void person_name_cursor_out_handler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_person_name_cursor_out_handler
        if(EnterPerName.getText().length() < 1){
           EnterPerName.setText("Enter Name");
           EnterPerName.setFont(new java.awt.Font("Tahoma", 2, 11));
           EnterPerName.setForeground(new java.awt.Color(153, 153, 153));
        }
    }//GEN-LAST:event_person_name_cursor_out_handler

    private void person_phone_cursor_in_handler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_person_phone_cursor_in_handler
        if (EnterPerPhone.getText().equals("Enter Phone")) {
            EnterPerPhone.setText(null);
            EnterPerPhone.setFont(new java.awt.Font("Tahoma", 0, 11));
            EnterPerPhone.setForeground(new java.awt.Color(0, 0, 0));
        }
    }//GEN-LAST:event_person_phone_cursor_in_handler

    private void person_phone_cursor_out_handler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_person_phone_cursor_out_handler
        if(EnterPerPhone.getText().length() < 1){
           EnterPerPhone.setText("Enter Phone");
           EnterPerPhone.setFont(new java.awt.Font("Tahoma", 2, 11));
           EnterPerPhone.setForeground(new java.awt.Color(153, 153, 153));
        }
    }//GEN-LAST:event_person_phone_cursor_out_handler

    private void person_address_cursor_in_handler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_person_address_cursor_in_handler
        if (EnterPerAddress.getText().equals("Enter Address")) {
            EnterPerAddress.setText(null);
            EnterPerAddress.setFont(new java.awt.Font("Tahoma", 0, 11));
            EnterPerAddress.setForeground(new java.awt.Color(0, 0, 0));
        }
    }//GEN-LAST:event_person_address_cursor_in_handler

    private void person_address_cursor_out_handler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_person_address_cursor_out_handler
        if(EnterPerAddress.getText().length() < 1){
           EnterPerAddress.setText("Enter Address");
           EnterPerAddress.setFont(new java.awt.Font("Tahoma", 2, 11));
           EnterPerAddress.setForeground(new java.awt.Color(153, 153, 153));
        }
    }//GEN-LAST:event_person_address_cursor_out_handler

    private void EnterPerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnterPerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EnterPerNameActionPerformed
        
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
        
        private boolean ThereIsText(String str){ 
            try{ 
                int ln=str.length();
                if ((ln == 0) || (str.equals("Enter Name")) || (str.equals("Enter Phone")) || (str.equals("Enter Address")))
                    return false;
            }

            catch(NumberFormatException n){ 
                return false; 
            } 
            return true;
        }
        
         private boolean CheckAllInputText(boolean str1 ,boolean str2 , boolean str3, boolean str4 ){ 
             boolean reslt=true;
             if(!str1) 
                {
                 EnterPerName.setBackground(Color.red);
                 reslt=false;
                }
             else
                 EnterPerName.setBackground(Color.white);
             
             if(!str2) 
                {
                 EnterPerId.setBackground(Color.red);
                 reslt=false;
                }
             else
                 EnterPerId.setBackground(Color.white);
             
             if(!str3) 
                {
                 EnterPerPhone.setBackground(Color.red);
                 reslt=false;
                }
             else
                 EnterPerPhone.setBackground(Color.white);
             
             if(!str4) 
                {
                 EnterPerAddress.setBackground(Color.red);
                 reslt=false;
                }
              else
                 EnterPerAddress.setBackground(Color.white);
             
             return reslt;
        } 
         
    private void EnableThisForm()throws Exception
    {
        setEnabled(true);
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
            java.util.logging.Logger.getLogger(UpdateCstmrCrdForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateCstmrCrdForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateCstmrCrdForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateCstmrCrdForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JComboBox SelectActivType;
    private javax.swing.JPanel SelectWhichNewActv;
    private java.awt.Button buttonUpdatePerson;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTableClaimView;
    private javax.swing.JTable jTablePolicyView;
    // End of variables declaration//GEN-END:variables
}