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
import Packages.Policy;
import Packages.Policy.InsrncCmpny;
import Packages.Policy.PlicyType;

/**
 *
 * @author dell
 */
public class AddPolicyForm extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    /**
     * Creates new form AddPolicy
     */
    private final Runnable enableFotherFormOfPolicyMyFunc;
    private long per_id;
    private JTable Policytable;
    private Policy policy = null;
    private ArrayList<String> detailsList = null;

    private static Controller sngltn = null;

    static {
        try {
            sngltn = Singelton.getMySingelton();
        } catch (Exception ex) {
            Logger.getLogger(AddCstmrCrdForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    ;
    public AddPolicyForm(long PerId, JTable jtablePolicy, Runnable myfunc) throws Exception {
        enableFotherFormOfPolicyMyFunc = myfunc;
        per_id = PerId;
        Policytable = jtablePolicy;
        detailsList = new ArrayList<String>();
        initComponents();
        java.awt.event.WindowEvent MyWindow = null;
        formWindowOpened(MyWindow);

        ComboBoxPolicyType.setModel(new DefaultComboBoxModel(PlicyType.values()));
        ComboBoxInsuranceCompany.setModel(new DefaultComboBoxModel(InsrncCmpny.values()));
        EnterDetail0.setVisible(true);
        EnterDetail1.setVisible(false);
        EnterDetail2.setVisible(false);
        EnterDetail3.setVisible(false);
        buttonPlus1.setVisible(true);
        buttonPlus2.setVisible(false);
        buttonMinus1.setVisible(false);
        buttonMinus2.setVisible(false);
        buttonMinus3.setVisible(false);

        this.setSize(502, 405);

        TextPerson_Name_ID.setEnabled(false);
        TextPerson_Name_ID.setText("Person Name: "
                + sngltn.GetMyPersonCstmrCrd(per_id).getPerson().getNamePerson() + "\n"
                + "Preson ID: "
                + Long.toString(per_id)
        );
        jSpinnerPolicyId.setValue(sngltn.getActivityId()[0]);

    }

    private AddPolicyForm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {
        int lebar = this.getWidth() / 2;
        int tinggi = this.getHeight() / 2;
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width / 2) - lebar;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height / 2) - tinggi;
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
        jSpinnerPolicyId = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ComboBoxPolicyType = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        ComboBoxInsuranceCompany = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSpinnerPolicyRate = new javax.swing.JSpinner();
        buttonAddThisPolicy = new java.awt.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextPerson_Name_ID = new javax.swing.JTextPane();
        buttonMinus1 = new java.awt.Button();
        buttonMinus2 = new java.awt.Button();
        buttonMinus3 = new java.awt.Button();
        buttonPlus0 = new java.awt.Button();
        buttonPlus1 = new java.awt.Button();
        buttonPlus2 = new java.awt.Button();

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

        EnterRepresentativeName.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        EnterRepresentativeName.setForeground(new java.awt.Color(153, 153, 153));
        EnterRepresentativeName.setText("Enter Representative Name");
        EnterRepresentativeName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                representative_name_cursor_in_handler(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                representative_name_cursor_out_handler(evt);
            }
        });
        getContentPane().add(EnterRepresentativeName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 170, 30));

        jLabel1.setText("Representative Name:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 130, 30));

        jSpinnerOpeningDate.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.DAY_OF_YEAR));
        jSpinnerOpeningDate.setEnabled(false);
        getContentPane().add(jSpinnerOpeningDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 165, -1));

        jLabel2.setText("Opening Date:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 106, -1));

        jLabel3.setText("More Details:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        EnterDetail0.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        EnterDetail0.setForeground(new java.awt.Color(153, 153, 153));
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
        getContentPane().add(EnterDetail0, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 339, -1));

        EnterDetail2.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        EnterDetail2.setForeground(new java.awt.Color(153, 153, 153));
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
        getContentPane().add(EnterDetail2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 339, -1));

        EnterDetail3.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        EnterDetail3.setForeground(new java.awt.Color(153, 153, 153));
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
        getContentPane().add(EnterDetail3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 339, -1));

        EnterDetail1.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        EnterDetail1.setForeground(new java.awt.Color(153, 153, 153));
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
        getContentPane().add(EnterDetail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 339, -1));

        jSpinnerPolicyId.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jSpinnerPolicyId.setEnabled(false);
        getContentPane().add(jSpinnerPolicyId, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 78, -1));

        jLabel4.setText("Policy ID:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel5.setText("* predetermined");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, -1, -1));

        ComboBoxPolicyType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(ComboBoxPolicyType, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 165, -1));

        jLabel6.setText("Policy Type:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        ComboBoxInsuranceCompany.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(ComboBoxInsuranceCompany, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 165, -1));

        jLabel7.setText("Insurance Company:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jLabel8.setText("Policy Rate:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 83, -1));

        jSpinnerPolicyRate.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        getContentPane().add(jSpinnerPolicyRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 98, -1));

        buttonAddThisPolicy.setLabel("Adding the policy");
        buttonAddThisPolicy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddThisPolicyActionPerformed(evt);
            }
        });
        getContentPane().add(buttonAddThisPolicy, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 130, 78));

        jScrollPane1.setViewportView(TextPerson_Name_ID);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 322, 54));

        buttonMinus1.setLabel("-");
        buttonMinus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMinus1ActionPerformed(evt);
            }
        });
        getContentPane().add(buttonMinus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, -1, 21));

        buttonMinus2.setLabel("-");
        buttonMinus2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMinus2ActionPerformed(evt);
            }
        });
        getContentPane().add(buttonMinus2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, 19));

        buttonMinus3.setLabel("-");
        buttonMinus3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMinus3ActionPerformed(evt);
            }
        });
        getContentPane().add(buttonMinus3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 461, -1, 20));

        buttonPlus0.setLabel("+");
        buttonPlus0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPlus0ActionPerformed(evt);
            }
        });
        getContentPane().add(buttonPlus0, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, -1, 21));

        buttonPlus1.setLabel("+");
        buttonPlus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPlus1ActionPerformed(evt);
            }
        });
        getContentPane().add(buttonPlus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, -1, 21));

        buttonPlus2.setLabel("+");
        buttonPlus2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPlus2ActionPerformed(evt);
            }
        });
        getContentPane().add(buttonPlus2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 420, -1, 21));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EnterDetail0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnterDetail0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EnterDetail0ActionPerformed

    private void buttonAddThisPolicyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddThisPolicyActionPerformed
        if (!CheckAllInputText(
                ThereIsText(EnterRepresentativeName.getText()),
                ThereIsText(jSpinnerPolicyRate.getValue().toString()),
                EnterDetail0.isVisible() && ThereIsText(EnterDetail0.getText()),
                !EnterDetail1.isVisible() || (EnterDetail1.isVisible() && ThereIsText(EnterDetail1.getText())),
                !EnterDetail2.isVisible() || (EnterDetail2.isVisible() && ThereIsText(EnterDetail2.getText())),
                !EnterDetail3.isVisible() || (EnterDetail3.isVisible() && ThereIsText(EnterDetail3.getText()))
        )) {
            JOptionPane.showMessageDialog(null, "Insert valid values", "Error", JOptionPane.ERROR_MESSAGE);
        } else if ("Adding the policy".equals(buttonAddThisPolicy.getLabel())) {
            detailsList = exsitDetailsToList(EnterDetail0, EnterDetail1, EnterDetail2, EnterDetail3);
            try {
                policy = new Policy(
                        (PlicyType) ComboBoxPolicyType.getSelectedItem(),
                        (InsrncCmpny) ComboBoxInsuranceCompany.getSelectedItem(),
                        Float.valueOf(jSpinnerPolicyRate.getValue().toString()),
                        EnterRepresentativeName.getText(),
                        (Date) jSpinnerOpeningDate.getValue(),
                        detailsList
                );
            } catch (Exception ex) {
                Logger.getLogger(AddPolicyForm.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                sngltn.AddNewPolicy(policy, sngltn.GetMyPersonCstmrCrd(per_id).getPerson());
            } catch (Exception ex) {
                Logger.getLogger(AddPolicyForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "Adding CustomerCrd.Activity.Policy Successfully", "", JOptionPane.PLAIN_MESSAGE);
            buttonAddThisPolicy.setEnabled(false);
            EnterRepresentativeName.setEnabled(false);
            ComboBoxPolicyType.setEnabled(false);
            ComboBoxInsuranceCompany.setEnabled(false);
            jSpinnerPolicyRate.setEnabled(false);
            buttonMinus3.setEnabled(!buttonMinus3.isVisible());
            buttonMinus2.setEnabled(!buttonMinus2.isVisible());
            buttonMinus1.setEnabled(!buttonMinus1.isVisible());
            buttonPlus0.setEnabled(!buttonPlus0.isVisible());
            buttonPlus1.setEnabled(!buttonPlus1.isVisible());
            buttonPlus2.setEnabled(!buttonPlus2.isVisible());
            EnterDetail3.setEnabled(!EnterDetail3.isVisible());
            EnterDetail2.setEnabled(!EnterDetail2.isVisible());
            EnterDetail1.setEnabled(!EnterDetail1.isVisible());
            EnterDetail0.setEnabled(!EnterDetail0.isVisible());

//            buttonAddThisPolicy.setLabel("Update This Policy");
//            ComboBoxPolicyType.setEnabled(false);
//        }
//        
//        else if("Update This Policy".equals(buttonAddThisPolicy.getLabel()))
//                {            
//                    try 
//                    {
//                        policy=sngltn.GetPolicyById(Long.parseLong(jSpinnerPolicyId.getValue().toString()));
//                    } 
//                    catch (Exception ex) 
//                    {
//                        Logger.getLogger(AddPolicyForm.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    policy.setRepresentativeName(EnterRepresentativeName.getText());
//                    policy.setInsuranceCompany((InsrncCmpny)ComboBoxInsuranceCompany.getSelectedItem());
//                    policy.setPolicyRate(Float.valueOf(jSpinnerPolicyRate.getValue().toString()));
//                    policy.setMoreDetails(exsitDetailsToList(EnterDetail0, EnterDetail1, EnterDetail2, EnterDetail3));
//                    try 
//                    {
//                        sngltn.UpdatePolicy(policy, sngltn.GetMyPersonCstmrCrd(per_id).getPerson());
//                    }
//                    catch (Exception ex) 
//                    {
//                        Logger.getLogger(AddPolicyForm.class.getName()).log(Level.SEVERE, null, ex);
//                    }     
//                    JOptionPane.showMessageDialog(null, "Update Policy Successfully", "",JOptionPane.PLAIN_MESSAGE);        
        }
    }//GEN-LAST:event_buttonAddThisPolicyActionPerformed

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
        this.setSize(502, 445);
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
        this.setSize(502, 485);
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
        this.setSize(502, 515);
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
        this.setSize(502, 485);
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
        this.setSize(502, 445);
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
        this.setSize(502, 405);
    }//GEN-LAST:event_buttonMinus1ActionPerformed

    private void EnterDetail1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnterDetail1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EnterDetail1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            enableFotherFormOfPolicyMyFunc.run();
            DefaultTableModel model = (DefaultTableModel) Policytable.getModel();
            model.setRowCount(0);
            for (Policy policy : sngltn.GetPerPolicies(sngltn.GetMyPersonCstmrCrd(per_id).getPerson())) {
                model.addRow(new Object[]{String.valueOf(policy.getId()), String.valueOf(policy.getOpeningDate()), String.valueOf(policy.getRepresentativeName()), String.valueOf(policy.getPolicyType()), String.valueOf(policy.getInsuranceCompany()), policy.getPolicyRate()});
            }
        } catch (Exception ex) {
            Logger.getLogger(AddCstmrCrdForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

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

    private boolean CheckAllInputText(boolean str1, boolean str2, boolean str3, boolean str4, boolean str5, boolean str6) {
        boolean reslt = true;
        if (str1 == false) {
            EnterRepresentativeName.setBackground(Color.red);
            reslt = false;
        } else {
            EnterRepresentativeName.setBackground(Color.white);
        }

        if (str2 == false) {
            jSpinnerPolicyRate.setBackground(Color.red);
            reslt = false;
        } else {
            jSpinnerPolicyRate.setBackground(Color.white);
        }

        if (str3 == false) {
            EnterDetail0.setBackground(Color.red);
            reslt = false;
        } else {
            EnterDetail0.setBackground(Color.white);
        }

        if (str4 == false) {
            EnterDetail1.setBackground(Color.red);
            reslt = false;
        } else {
            EnterDetail1.setBackground(Color.white);
        }

        if (str5 == false) {
            EnterDetail2.setBackground(Color.red);
            reslt = false;
        } else {
            EnterDetail2.setBackground(Color.white);
        }

        if (str6 == false) {
            EnterDetail3.setBackground(Color.red);
            reslt = false;
        } else {
            EnterDetail3.setBackground(Color.white);
        }

        return reslt;
    }

    private boolean ThereIsText(String str) {
        try {
            int ln = str.length();
            if ((ln == 0) || (str.equals("Enter Representative Name"))) {
                return false;
            }
        } catch (NumberFormatException n) {
            return false;
        }
        return true;
    }

    private static boolean OnlyNumbers(String str) {
        try {
            long l = Long.parseLong(str);
        } catch (NumberFormatException n) {
            return false;
        }
        return true;
    }

    private ArrayList<String> exsitDetailsToList(TextField textfield0, TextField textfield1, TextField textfield2, TextField textfield3) {
        ArrayList<String> DetailList = new ArrayList<String>();
        if (textfield0.isVisible() && !"".equals(textfield0.getText())) {
            DetailList.add(textfield0.getText());
        }
        if (textfield1.isVisible() && !"".equals(textfield1.getText())) {
            DetailList.add(textfield1.getText());
        }
        if (textfield2.isVisible() && !"".equals(textfield2.getText())) {
            DetailList.add(textfield2.getText());
        }
        if (textfield3.isVisible() && !"".equals(textfield3.getText())) {
            DetailList.add(textfield3.getText());
        }
        return DetailList;
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
            java.util.logging.Logger.getLogger(AddPolicyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddPolicyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddPolicyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddPolicyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // new AddPolicyForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboBoxInsuranceCompany;
    private javax.swing.JComboBox ComboBoxPolicyType;
    private java.awt.TextField EnterDetail0;
    private java.awt.TextField EnterDetail1;
    private java.awt.TextField EnterDetail2;
    private java.awt.TextField EnterDetail3;
    private javax.swing.JTextField EnterRepresentativeName;
    private javax.swing.JTextPane TextPerson_Name_ID;
    private java.awt.Button buttonAddThisPolicy;
    private java.awt.Button buttonMinus1;
    private java.awt.Button buttonMinus2;
    private java.awt.Button buttonMinus3;
    private java.awt.Button buttonPlus0;
    private java.awt.Button buttonPlus1;
    private java.awt.Button buttonPlus2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerOpeningDate;
    private javax.swing.JSpinner jSpinnerPolicyId;
    private javax.swing.JSpinner jSpinnerPolicyRate;
    // End of variables declaration//GEN-END:variables

    void show(JTable jTablePolicyView) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
