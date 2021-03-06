
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java5774_1248_0915_guiServer;

import DAOAdapters.Java_5774_1248_0915_BackedDAOAdapters;
import DAOAdapters.Singelton;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import Packages.Activity;
import Packages.Claim;
import Packages.CustomerCrd;
import Packages.Person;

/**
 *
 * @author dell
 */
public class MainForm extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    private static Java_5774_1248_0915_BackedDAOAdapters sngltn = null;

    static {
        try {
            sngltn = Singelton.getMySingelton();
        } catch (Exception ex) {
            Logger.getLogger(AddCstmrCrdForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    ;
    /**
     * Creates new form MainForm
     * @throws java.lang.Exception
     */
    public MainForm() throws Exception {
        initComponents();

        java.awt.event.WindowEvent MyWindow = null;
        formWindowOpened(MyWindow);
        LockOrUnlockButtons();
        AllRelevantDeleteCstmrCrdPersonsID();
        if (buttonUpdateCstmrCrd.isEnabled()) {
            ArrayList<Long> AllPersonsID = new ArrayList<Long>();
            for (CustomerCrd CstmrCrd : sngltn.GetAllCustemers()) {
                AllPersonsID.add(Long.valueOf(CstmrCrd.getPerson().getId()));
            }
            jComboBoxSeclectPerId1.setModel(new DefaultComboBoxModel(AllPersonsID.toArray()));
        }
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        buttonAddNewCstmrCrd = new java.awt.Button();
        buttonExist = new java.awt.Button();
        buttonQueriesViewData = new java.awt.Button();
        jLayeredUpdateCstmrCrd = new javax.swing.JLayeredPane();
        buttonUpdateCstmrCrd = new java.awt.Button();
        labelSeclectPerId1 = new javax.swing.JLabel();
        jComboBoxSeclectPerId1 = new javax.swing.JComboBox();
        jLayeredDeleteCstmrCrd = new javax.swing.JLayeredPane();
        buttonDeleteCstmrCrd = new java.awt.Button();
        labelSeclectPerId2 = new javax.swing.JLabel();
        jComboBoxSeclectPerId2 = new javax.swing.JComboBox();
        buttonCleanAllData = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        buttonAddNewCstmrCrd.setLabel("Add New Customer Card");
        buttonAddNewCstmrCrd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddNewCstmrCrdActionPerformed(evt);
            }
        });

        buttonExist.setLabel("Exit");
        buttonExist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExistActionPerformed(evt);
            }
        });

        buttonQueriesViewData.setLabel("Queries and viewing data");
        buttonQueriesViewData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonQueriesViewDataActionPerformed(evt);
            }
        });

        jLayeredUpdateCstmrCrd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLayeredUpdateCstmrCrdMouseExited(evt);
            }
        });
        jLayeredUpdateCstmrCrd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonUpdateCstmrCrd.setLabel("Update Customer Card");
        buttonUpdateCstmrCrd.setMaximumSize(new java.awt.Dimension(134, 25));
        buttonUpdateCstmrCrd.setMinimumSize(new java.awt.Dimension(134, 25));
        buttonUpdateCstmrCrd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonUpdateCstmrCrdMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonUpdateCstmrCrdMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buttonUpdateCstmrCrdMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                buttonUpdateCstmrCrdMouseReleased(evt);
            }
        });
        buttonUpdateCstmrCrd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateCstmrCrdActionPerformed(evt);
            }
        });
        jLayeredUpdateCstmrCrd.add(buttonUpdateCstmrCrd, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, 60));

        labelSeclectPerId1.setText("Select Person Id:");
        jLayeredUpdateCstmrCrd.add(labelSeclectPerId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 110, -1));

        jComboBoxSeclectPerId1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxSeclectPerId1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxSeclectPerId1ItemStateChanged(evt);
            }
        });
        jComboBoxSeclectPerId1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSeclectPerId1ActionPerformed(evt);
            }
        });
        jLayeredUpdateCstmrCrd.add(jComboBoxSeclectPerId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 100, -1));

        jLayeredDeleteCstmrCrd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLayeredDeleteCstmrCrdMouseExited(evt);
            }
        });
        jLayeredDeleteCstmrCrd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonDeleteCstmrCrd.setLabel("Delete customer card");
        buttonDeleteCstmrCrd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buttonDeleteCstmrCrdMousePressed(evt);
            }
        });
        buttonDeleteCstmrCrd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteCstmrCrdActionPerformed(evt);
            }
        });
        jLayeredDeleteCstmrCrd.add(buttonDeleteCstmrCrd, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, 60));

        labelSeclectPerId2.setText("Select CustmerCard.Person Id:");
        jLayeredDeleteCstmrCrd.add(labelSeclectPerId2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 190, 20));

        jComboBoxSeclectPerId2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxSeclectPerId2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSeclectPerId2ActionPerformed(evt);
            }
        });
        jLayeredDeleteCstmrCrd.add(jComboBoxSeclectPerId2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 130, 30));

        buttonCleanAllData.setBackground(new java.awt.Color(255, 0, 0));
        buttonCleanAllData.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buttonCleanAllData.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        buttonCleanAllData.setForeground(new java.awt.Color(255, 255, 255));
        buttonCleanAllData.setLabel("Delete all exsit data");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, buttonCleanAllData, org.jdesktop.beansbinding.ELProperty.create("${background}"), buttonCleanAllData, org.jdesktop.beansbinding.BeanProperty.create("background"));
        bindingGroup.addBinding(binding);

        buttonCleanAllData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCleanAllDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(45, 45, 45)
                            .addComponent(jLayeredUpdateCstmrCrd, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLayeredDeleteCstmrCrd, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(buttonExist, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(buttonQueriesViewData, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(buttonCleanAllData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(buttonAddNewCstmrCrd, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(buttonAddNewCstmrCrd, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredUpdateCstmrCrd, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredDeleteCstmrCrd, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonQueriesViewData, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(buttonExist, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(buttonCleanAllData, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        buttonQueriesViewData.getAccessibleContext().setAccessibleName("");

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonExistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExistActionPerformed
        try {
            if (!(sngltn.GetAllCustemers().isEmpty())) {
                int code = JOptionPane.showConfirmDialog(null, "Do you want to exit this program?\n"
                        + "Relax, all the information you just typed will save in my data base. ", "", JOptionPane.YES_NO_OPTION);
                if (code == JOptionPane.OK_OPTION) {
                    WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
                    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
                } else {
                }
            } else {
                int code = JOptionPane.showConfirmDialog(null, "Do you really want to exit the program?", "", JOptionPane.YES_NO_OPTION);
                if (code == JOptionPane.OK_OPTION) {
                    WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
                    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
                } else {
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonExistActionPerformed

    private void buttonDeleteCstmrCrdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteCstmrCrdActionPerformed

    }//GEN-LAST:event_buttonDeleteCstmrCrdActionPerformed

    private void buttonQueriesViewDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonQueriesViewDataActionPerformed
        QueriesAndViewingDataForm QueriesViewData = null;
        try {
            QueriesViewData = new QueriesAndViewingDataForm(new Runnable() {
                @Override
                public void run() {
                    try {
                        EnableThisForm();
                    } catch (Exception ex) {
                        Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            );
        } catch (Exception ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        setEnabled(false);
        QueriesViewData.show();
    }//GEN-LAST:event_buttonQueriesViewDataActionPerformed

    private void buttonAddNewCstmrCrdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddNewCstmrCrdActionPerformed
        AddCstmrCrdForm addCstmr = null;
        try {
            addCstmr = new AddCstmrCrdForm(new Runnable() {
                @Override
                public void run() {
                    try {
                        myfunc1();
                    } catch (Exception ex) {
                        Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            );
        } catch (Exception ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        setEnabled(false);
        addCstmr.show();
    }//GEN-LAST:event_buttonAddNewCstmrCrdActionPerformed

    private void jComboBoxSeclectPerId1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSeclectPerId1ActionPerformed
        UpdateCstmrCrdForm UpdateCstmr = null;
        try {
            UpdateCstmr = new UpdateCstmrCrdForm(
                    Long.valueOf(jComboBoxSeclectPerId1.getSelectedItem().toString()),
                    new Runnable() {
                        @Override
                        public void run() {
                            try {
                                myfunc2();
                            } catch (Exception ex) {
                                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
            );

        } catch (Exception ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        setEnabled(false);
        UpdateCstmr.show();
    }//GEN-LAST:event_jComboBoxSeclectPerId1ActionPerformed

    private void buttonUpdateCstmrCrdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateCstmrCrdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonUpdateCstmrCrdActionPerformed

    private void buttonUpdateCstmrCrdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonUpdateCstmrCrdMouseEntered

    }//GEN-LAST:event_buttonUpdateCstmrCrdMouseEntered

    private void buttonUpdateCstmrCrdMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonUpdateCstmrCrdMouseExited

    }//GEN-LAST:event_buttonUpdateCstmrCrdMouseExited

    private void buttonUpdateCstmrCrdMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonUpdateCstmrCrdMousePressed
        if (buttonUpdateCstmrCrd.isEnabled()) {
            buttonUpdateCstmrCrd.setVisible(false);
            labelSeclectPerId1.setVisible(true);
            jComboBoxSeclectPerId1.setVisible(true);
        }
    }//GEN-LAST:event_buttonUpdateCstmrCrdMousePressed

    private void buttonUpdateCstmrCrdMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonUpdateCstmrCrdMouseReleased

    }//GEN-LAST:event_buttonUpdateCstmrCrdMouseReleased

    private void jLayeredUpdateCstmrCrdMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLayeredUpdateCstmrCrdMouseExited
        if (buttonUpdateCstmrCrd.isEnabled()) {
            buttonUpdateCstmrCrd.setVisible(true);
        }
        labelSeclectPerId1.setVisible(false);
        jComboBoxSeclectPerId1.setVisible(false);
    }//GEN-LAST:event_jLayeredUpdateCstmrCrdMouseExited

    private void jComboBoxSeclectPerId1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxSeclectPerId1ItemStateChanged

    }//GEN-LAST:event_jComboBoxSeclectPerId1ItemStateChanged

    private void buttonDeleteCstmrCrdMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonDeleteCstmrCrdMousePressed
        if (buttonDeleteCstmrCrd.isEnabled()) {
            buttonDeleteCstmrCrd.setVisible(false);
            labelSeclectPerId2.setVisible(true);
            jComboBoxSeclectPerId2.setVisible(true);
        }
    }//GEN-LAST:event_buttonDeleteCstmrCrdMousePressed

    private void jLayeredDeleteCstmrCrdMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLayeredDeleteCstmrCrdMouseExited
        if (buttonDeleteCstmrCrd.isEnabled()) {
            buttonDeleteCstmrCrd.setVisible(true);
        }
        labelSeclectPerId2.setVisible(false);
        jComboBoxSeclectPerId2.setVisible(false);
    }//GEN-LAST:event_jLayeredDeleteCstmrCrdMouseExited

    private void jComboBoxSeclectPerId2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSeclectPerId2ActionPerformed
        try {
            if (sngltn.GetPerPolicies(getPerByPerId(Long.valueOf(jComboBoxSeclectPerId2.getSelectedItem().toString()))).size() > 0) {
                int code2 = JOptionPane.showConfirmDialog(null, "You can't delete this customer card.\n"
                        + "At least one policy or claim is exsit for this customerCard.", "", JOptionPane.PLAIN_MESSAGE);
            } else {
                int code = JOptionPane.showConfirmDialog(null, "NOTE! You are about to delete this Custmer Card! \n"
                        + "Is this what you wanted to do?", "", JOptionPane.YES_NO_OPTION);
                if (code == JOptionPane.OK_OPTION) {
                    sngltn.DeleteCustomerCrd(sngltn.GetMyPersonCstmrCrd(Long.valueOf(jComboBoxSeclectPerId2.getSelectedItem().toString())));

                    int code2 = JOptionPane.showConfirmDialog(null, "Delete Custmer Card Successfully", "", JOptionPane.OK_OPTION);
                    if (code2 == JOptionPane.OK_OPTION || code == JOptionPane.CLOSED_OPTION) {
                        myfunc1();
                        buttonUpdateCstmrCrd.setVisible(true);
                        buttonDeleteCstmrCrd.setVisible(true);
                    }
                } else {
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBoxSeclectPerId2ActionPerformed

    private void buttonCleanAllDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCleanAllDataActionPerformed
        int code = JOptionPane.showConfirmDialog(null, "Notice: Dangerous operation! \n"
                + "The system get a request to delete all the data. \n"
                + "This will immediately delete any information you have entered so far in the system, and you can not restore it. \n"
                + "Do you really want to do it?", "", JOptionPane.YES_NO_OPTION);
        if (code == JOptionPane.OK_OPTION) {
            try {
                ArrayList<CustomerCrd> allCstmrCrd = sngltn.GetAllCustemers();
                for(int i = 0; i< allCstmrCrd.size(); i++) {
                    sngltn.DeleteCustomerCrd(allCstmrCrd.get(i));
                }
                
                JOptionPane.showConfirmDialog(null, "Delete all data Successfully", "", JOptionPane.OK_OPTION);
            } catch (Exception ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
        }
        try {
            if (sngltn.GetAllCustemers().isEmpty()) {
                myfunc1();
            }
        } catch (Exception ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonCleanAllDataActionPerformed

    private void myfunc1() throws Exception {
        LockOrUnlockButtons();
        AddAllPersonsID1();
        myfunc2();
    }

    private void myfunc2() throws Exception {
        EnableThisForm();
        if (AllRelevantDeleteCstmrCrdPersonsID()) {
            buttonDeleteCstmrCrd.setEnabled(true);
        } else {
            buttonDeleteCstmrCrd.setEnabled(false);
        }
    }

    private void EnableThisForm() throws Exception {
        setEnabled(true);
    }

    private void LockOrUnlockButtons() throws Exception {
        boolean status = !sngltn.GetAllCustemers().isEmpty();
        buttonCleanAllData.setEnabled(status);
        buttonUpdateCstmrCrd.setEnabled(status);
        buttonDeleteCstmrCrd.setEnabled(status);
        buttonQueriesViewData.setEnabled(status);
    }

    private void AddAllPersonsID1() throws Exception {
        ArrayList<Long> AllPersonsID = new ArrayList<Long>();
        for (CustomerCrd CstmrCrd : sngltn.GetAllCustemers()) {
            AllPersonsID.add(Long.valueOf(CstmrCrd.getPerson().getId()));
        }
        jComboBoxSeclectPerId1.setModel(new DefaultComboBoxModel(AllPersonsID.toArray()));
    }

    private boolean AllRelevantDeleteCstmrCrdPersonsID() throws Exception {
        ArrayList<Long> RlvntDltCstmrCrdPrsnID = new ArrayList<Long>();
        if (sngltn.GetAllCustemers().isEmpty()) {
            return false;
        } else {
            for (CustomerCrd cstmrCrd : sngltn.GetAllCustemers()) {
                boolean stat = true;
                for (Activity act : cstmrCrd.getActivities()) {
                    if (act instanceof Claim) {
                        Claim cl = (Claim) act;
                        if ("Treatment".equals(cl.getInsuranceClaimStatus().toString()) && "SeeInMoreDetails".equals(cl.getInsuranceClaimStatus().toString())) {
                            stat = false;
                        } else {
                            stat = true;
                            break;
                        }
                    }
                }
                if (stat) {
                    RlvntDltCstmrCrdPrsnID.add(Long.valueOf(cstmrCrd.getPerson().getId()));
                }
            }

            if (RlvntDltCstmrCrdPrsnID.size() > 0) {
                jComboBoxSeclectPerId2.setModel(new DefaultComboBoxModel(RlvntDltCstmrCrdPrsnID.toArray()));
                return true;
            } else {
                return false;
            }
        }
    }

    private Person getPerByPerId(long personId) throws Exception {
        for (CustomerCrd cstmr : sngltn.GetAllCustemers()) {
            if (cstmr.getPerson().getId() == personId) {
                return cstmr.getPerson();
            }
        }
        return null;
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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new MainForm().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button buttonAddNewCstmrCrd;
    private java.awt.Button buttonCleanAllData;
    private java.awt.Button buttonDeleteCstmrCrd;
    private java.awt.Button buttonExist;
    private java.awt.Button buttonQueriesViewData;
    private java.awt.Button buttonUpdateCstmrCrd;
    private javax.swing.JComboBox jComboBoxSeclectPerId1;
    private javax.swing.JComboBox jComboBoxSeclectPerId2;
    private javax.swing.JLayeredPane jLayeredDeleteCstmrCrd;
    private javax.swing.JLayeredPane jLayeredUpdateCstmrCrd;
    private javax.swing.JLabel labelSeclectPerId1;
    private javax.swing.JLabel labelSeclectPerId2;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
