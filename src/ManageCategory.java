
import dao.ConnectionProvider;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.table.TableModel;

public class ManageCategory extends javax.swing.JFrame {

    private int categoryPk = 0;

    public ManageCategory() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private boolean validateFields() {
        if (!txtName.getText().equals("")) {
            return false;
        } else {
            return true;
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCategory = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Manage Category");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, -1, -1));

        tableCategory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name"
            }
        ));
        tableCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCategoryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCategory);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 73, -1, 515));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setText("Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 275, 300, -1));

        txtName.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 308, 300, -1));

        btnSave.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 345, -1, -1));

        btnUpdate.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(578, 345, -1, -1));

        btnReset.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        getContentPane().add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(667, 345, -1, -1));

        btnClose.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(746, 345, -1, -1));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:

        DefaultTableModel model = (DefaultTableModel) tableCategory.getModel();
        try {

            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from category");
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("category_pk"), rs.getString("name")});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

        btnUpdate.setEnabled(false);


    }//GEN-LAST:event_formComponentShown

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new ManageCategory().setVisible(true);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:

        String name = txtName.getText();
        if (validateFields()) {
            JOptionPane.showMessageDialog(null, "Please fill in all the required fields.", "Validation Error", JOptionPane.WARNING_MESSAGE);

        } else {

            try {

                Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement("INSERT INTO category (name) VALUES (?)");
                ps.setString(1, name);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Category added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                setVisible(false);
                new ManageCategory().setVisible(true);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void tableCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCategoryMouseClicked
        // TODO add your handling code here:
        int index = tableCategory.getSelectedRow();
        TableModel model = tableCategory.getModel();
        String id = model.getValueAt(index, 0).toString();

        categoryPk = Integer.parseInt(id);

        String name = model.getValueAt(index, 1).toString();
        txtName.setText(name);

        btnSave.setEnabled(false);
        btnUpdate.setEnabled(true);
    }//GEN-LAST:event_tableCategoryMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:

        String name = txtName.getText();
        if (validateFields()) {
            JOptionPane.showMessageDialog(null, "Please fill in all the required fields.", "Validation Error", JOptionPane.WARNING_MESSAGE);

        } else {

            try {

                Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement("update category set name=? where category_pk=?");
                ps.setString(1, name);
                ps.setInt(2, categoryPk);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Category updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                setVisible(false);
                new ManageCategory().setVisible(true);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }

    }//GEN-LAST:event_btnUpdateActionPerformed

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
            java.util.logging.Logger.getLogger(ManageCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageCategory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableCategory;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
