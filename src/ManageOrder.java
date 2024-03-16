
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import common.OpenPdf;

import dao.ConnectionProvider;
//import dao.TirupatiTradersUtils;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.table.TableModel;

public class ManageOrder extends javax.swing.JFrame {

    private int customerPk = 0;
    private int productPk = 0;
    private float finalTotalPrice = 0.0f;
    private String orderId = "";

    public ManageOrder() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void clearProductFields() {
        productPk = 0;
        txtProductName.setText("");
        txtProductPrice.setText("");
        txtProductDescription.setText("");
        txtOrderQuantity.setText("");

    }

    public String getUniqueId(String prefix) {
        return prefix + System.nanoTime();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCustomer = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableProduct = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableCart = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCustomerName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCustomerMobileNumber = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCustomerEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtProductPrice = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtProductDescription = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtOrderQuantity = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lblFinalTotalPrice = new javax.swing.JLabel();
        btnSaveOrderDetails = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Manage Order");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(614, 12, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setText("Customer List");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 82, -1, -1));

        tableCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Mobile Number", "Email"
            }
        ));
        tableCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCustomerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCustomer);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 115, 400, 300));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setText("Product List");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(649, 82, -1, -1));

        tableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price", "Quantity", "Description", "Category ID", "Category Name"
            }
        ));
        tableProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProductMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableProduct);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(501, 115, 400, 300));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setText("Cart");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1169, 82, -1, -1));

        tableCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Name", "Quantity", "Price", "Description", "Sub Total"
            }
        ));
        tableCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCartMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableCart);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(971, 115, 420, 300));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setText("Selected Customer:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 433, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setText("Name");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 460, -1, -1));

        txtCustomerName.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCustomerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtCustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 487, 306, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel7.setText("Mobile Number");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 518, -1, -1));

        txtCustomerMobileNumber.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCustomerMobileNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerMobileNumberActionPerformed(evt);
            }
        });
        getContentPane().add(txtCustomerMobileNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 545, 306, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel8.setText("Email");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 576, -1, -1));

        txtCustomerEmail.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCustomerEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerEmailActionPerformed(evt);
            }
        });
        getContentPane().add(txtCustomerEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 603, 306, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel9.setText("Selected Product: ");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(667, 433, -1, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel10.setText("Product Name");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(549, 460, -1, -1));

        txtProductName.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtProductName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtProductName, new org.netbeans.lib.awtextra.AbsoluteConstraints(549, 487, 317, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel11.setText("Product Price");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(549, 518, -1, -1));

        txtProductPrice.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtProductPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductPriceActionPerformed(evt);
            }
        });
        getContentPane().add(txtProductPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(549, 545, 317, -1));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel12.setText("Product Description");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(549, 576, 317, -1));

        txtProductDescription.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        getContentPane().add(txtProductDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(549, 603, 317, -1));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel13.setText("Order Quantity");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(549, 634, 317, 18));

        txtOrderQuantity.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtOrderQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOrderQuantityActionPerformed(evt);
            }
        });
        getContentPane().add(txtOrderQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(549, 663, 317, -1));

        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setText("Add to Cart");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 700, 143, -1));

        lblFinalTotalPrice.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblFinalTotalPrice.setText("Total Amount Rs: 000.00");
        getContentPane().add(lblFinalTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(1105, 433, -1, -1));

        btnSaveOrderDetails.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnSaveOrderDetails.setText("Save Order Details");
        btnSaveOrderDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveOrderDetailsActionPerformed(evt);
            }
        });
        getContentPane().add(btnSaveOrderDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(1116, 498, -1, -1));

        jButton3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton3.setText("Reset");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1116, 558, 149, -1));

        jButton4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton4.setText("Close");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1116, 627, 149, -1));
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1570, 890));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:

        txtCustomerName.setEditable(false);
        txtCustomerMobileNumber.setEditable(false);
        txtCustomerEmail.setEditable(false);

        txtProductName.setEditable(false);
        txtProductPrice.setEditable(false);
        txtProductDescription.setEditable(false);

        DefaultTableModel model = (DefaultTableModel) tableCustomer.getModel();
        DefaultTableModel productModel = (DefaultTableModel) tableProduct.getModel();

        try {

            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from customer");
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("customer_pk"), rs.getString("name"), rs.getString("mobileNumber"), rs.getString("email")});

            }

            rs = st.executeQuery("SELECT * from product inner join category on product.category_fk = category.category_pk");
            while (rs.next()) {
                productModel.addRow(new Object[]{rs.getString("product_pk"), rs.getString("name"), rs.getString("price"), rs.getString("quantity"), rs.getString("description"), rs.getString("category_fk"), rs.getString(8)});

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }


    }//GEN-LAST:event_formComponentShown

    private void txtCustomerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomerNameActionPerformed

    private void txtProductPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductPriceActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        String noOfUnits = txtOrderQuantity.getText();
        if (!noOfUnits.equals("")) {

            String productName = txtProductName.getText();
            String productDescription = txtProductDescription.getText();
            String productPrice = txtProductPrice.getText();

            int totalPrice = Integer.parseInt(txtOrderQuantity.getText()) * Integer.parseInt(productPrice);

            int checkStock = 0;
            int checkProductAlreadyExistInCart = 0;
            try {

                Connection con = ConnectionProvider.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * from product where product_pk=" + productPk + "");
                while (rs.next()) {
                    if (rs.getInt("quantity") >= Integer.parseInt(noOfUnits)) {
                        checkStock = 1;
                    } else {

                        JOptionPane.showMessageDialog(null, "Product is out of stock. Only " + rs.getInt("quantity") + " left", "Stock Error", JOptionPane.WARNING_MESSAGE);

                    }
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

            if (checkStock == 1) {

                DefaultTableModel model = (DefaultTableModel) tableCart.getModel();
                if (tableCart.getRowCount() != 0) {
                    for (int i = 0; i < tableCart.getRowCount(); i++) {
                        if (Integer.parseInt(model.getValueAt(i, 0).toString()) == productPk) {
                            checkProductAlreadyExistInCart = 1;
                            JOptionPane.showMessageDialog(null, "Product is already exist in cart", "Cart Error", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }

                if (checkProductAlreadyExistInCart == 0) {
                    model.addRow(new Object[]{productPk, productName, noOfUnits, productPrice, productDescription, totalPrice});
                    finalTotalPrice = finalTotalPrice + totalPrice;
                    clearProductFields();
                }

                // Update the total amount label outside the loop
                lblFinalTotalPrice.setText("Total Amount Rs: " + String.format("%.2f", finalTotalPrice));

                if (checkProductAlreadyExistInCart == 0) {
                    JOptionPane.showMessageDialog(null, "Added Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                }

                clearProductFields();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Please add some product to cart or select a customer", "Order Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtProductNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductNameActionPerformed

    private void btnSaveOrderDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveOrderDetailsActionPerformed
        // TODO add your handling code here:

        if (finalTotalPrice != 0 && !txtCustomerName.getText().equals("")) {
            orderId = getUniqueId("Bill-");

            DefaultTableModel dtm = (DefaultTableModel) tableCart.getModel();
            if (tableCart.getRowCount() != 0) {

                for (int i = 0; i < tableCart.getRowCount(); i++) {
                    try {

                        Connection con = ConnectionProvider.getCon();
                        Statement st = con.createStatement();
                        st.executeUpdate("UPDATE product set quantity=quantity-" + Integer.parseInt(dtm.getValueAt(i, 2).toString()) + " WHERE product_pk=" + Integer.parseInt(dtm.getValueAt(i, 0).toString()));

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            }

            try {

                SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
                Calendar cal = Calendar.getInstance();
                Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement("INSERT into orderDetails(orderId,customer_fk,orderDate,totalPaid) values(?,?,?,?)");
                ps.setString(1, orderId);
                ps.setInt(2, customerPk);
                ps.setString(3, myFormat.format(cal.getTime()));
                ps.setFloat(4, finalTotalPrice);
                ps.executeUpdate();
                //Statement st = con.createStatement();
                //st.executeUpdate("UPDATE product set quantity=quantity-" + Integer.parseInt(dtm.getValueAt(i, 2).toString()) + "WHERE product_pk=" + Integer.parseInt(dtm.getValueAt(i, 0).toString()));

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

            //Creating Document
            com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
            try {
                SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
                Calendar cal = Calendar.getInstance();

                // Get the desktop path
                String desktopPath = System.getProperty("user.home") + "/Desktop/";

                // Create a File object representing the directory
                File desktopDirectory = new File(desktopPath + "Tirupati/");

                // Check if the directory doesn't exist, then create it
                if (!desktopDirectory.exists()) {
                    desktopDirectory.mkdirs(); // This will create parent directories if they don't exist
                }

                PdfWriter.getInstance(doc, new FileOutputStream(desktopPath + "Tirupati/" + orderId + ".pdf"));
                doc.open();

                Paragraph projectName = new Paragraph("Tirupati Traders Management System\n");
                projectName.setAlignment(Element.ALIGN_CENTER);
                doc.add(projectName);

                Paragraph starLine = new Paragraph("*********************************************************");
                starLine.setAlignment(Element.ALIGN_CENTER);
                doc.add(starLine);

                // Format total amount with two decimal places
                String totalAmountFormatted = String.format("%.2f", finalTotalPrice);
                Paragraph details = new Paragraph("\tOrder ID:" + orderId + "\nDate: " + myFormat.format(cal.getTime()) + "\nTotalPaid: " + totalAmountFormatted);
                details.setAlignment(Element.ALIGN_CENTER);
                doc.add(details);

                Paragraph emptyLine = new Paragraph("\n"); // Add an empty line for better spacing
                doc.add(emptyLine);

                PdfPTable tbl = new PdfPTable(5);
                PdfPCell nameCell = new PdfPCell(new Phrase("Name"));
                PdfPCell descriptionCell = new PdfPCell(new Phrase("Description"));
                PdfPCell priceCell = new PdfPCell(new Phrase("Price Per Unit"));
                PdfPCell quantityCell = new PdfPCell(new Phrase("Quantity"));
                PdfPCell subTotalPriceCell = new PdfPCell(new Phrase("Sub Total Price"));

                BaseColor backgroundColor = new BaseColor(255, 204, 51);
                nameCell.setBackgroundColor(backgroundColor);
                descriptionCell.setBackgroundColor(backgroundColor);
                priceCell.setBackgroundColor(backgroundColor);
                quantityCell.setBackgroundColor(backgroundColor);
                subTotalPriceCell.setBackgroundColor(backgroundColor);

                tbl.addCell(nameCell);
                tbl.addCell(descriptionCell);
                tbl.addCell(priceCell);
                tbl.addCell(quantityCell);
                tbl.addCell(subTotalPriceCell);

                for (int i = 0; i < tableCart.getRowCount(); i++) {
                    tbl.addCell(tableCart.getValueAt(i, 1).toString()); // Name
                    tbl.addCell(tableCart.getValueAt(i, 4).toString()); // Description
                    tbl.addCell(tableCart.getValueAt(i, 3).toString()); // Price per Unit
                    tbl.addCell(tableCart.getValueAt(i, 2).toString()); // Quantity

                    // Format sub-total amount with two decimal places
                    String subTotalFormatted = String.format("%.2f", Float.parseFloat(tableCart.getValueAt(i, 5).toString()));
                    tbl.addCell(subTotalFormatted); // Sub Total Price
                }

                doc.add(tbl);
                doc.add(starLine);

                // Center-aligned thanks message
                Paragraph thanksMsg = new Paragraph("*****Thank You, Please Visit Again*****");
                thanksMsg.setAlignment(Element.ALIGN_CENTER);
                doc.add(thanksMsg);

                OpenPdf openPdf = new OpenPdf();
                openPdf.OpenById(orderId);

                //Open PDF
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);

            }

            doc.close();
            setVisible(false);
            new ManageOrder().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Please add some product to cart or select customer");
        }


    }//GEN-LAST:event_btnSaveOrderDetailsActionPerformed

    private void txtOrderQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOrderQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOrderQuantityActionPerformed

    private void txtCustomerEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomerEmailActionPerformed

    private void txtCustomerMobileNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerMobileNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomerMobileNumberActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new ManageOrder().setVisible(true);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void tableCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCustomerMouseClicked
        // TODO add your handling code here:

        int index = tableCustomer.getSelectedRow();
        TableModel model = tableCustomer.getModel();
        String id = model.getValueAt(index, 0).toString();
        customerPk = Integer.parseInt(id);

        String name = model.getValueAt(index, 1).toString();
        txtCustomerName.setText(name);

        String mobileNumber = model.getValueAt(index, 2).toString();
        txtCustomerMobileNumber.setText(mobileNumber);

        String email = model.getValueAt(index, 3).toString();
        txtCustomerEmail.setText(email);

    }//GEN-LAST:event_tableCustomerMouseClicked

    private void tableProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductMouseClicked
        // TODO add your handling code here:

        int index = tableProduct.getSelectedRow();
        TableModel model = tableProduct.getModel();

        String id = model.getValueAt(index, 0).toString();
        productPk = Integer.parseInt(id);

        String productName = model.getValueAt(index, 1).toString();
        txtProductName.setText(productName);

        String productPrice = model.getValueAt(index, 2).toString();
        txtProductPrice.setText(productPrice);

        // Corrected index for the product description
        String productDescription = model.getValueAt(index, 4).toString();
        txtProductDescription.setText(productDescription);
    }//GEN-LAST:event_tableProductMouseClicked

    private void tableCartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCartMouseClicked
        // TODO add your handling code here:

        int index = tableCart.getSelectedRow();
        int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove this product from the cart?",
                "Confirm Removal",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (option == JOptionPane.YES_OPTION) {
            DefaultTableModel model = (DefaultTableModel) tableCart.getModel();
            String subTotal = model.getValueAt(index, 5).toString();
            finalTotalPrice -= Integer.parseInt(subTotal);
            model.removeRow(index);
            //lblFinalTotalPrice.setText("Total Amount Rs: " + finalTotalPrice);
            lblFinalTotalPrice.setText("Total Amount Rs: " + String.format("%.2f", finalTotalPrice));

        }
    }//GEN-LAST:event_tableCartMouseClicked

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
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSaveOrderDetails;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblFinalTotalPrice;
    private javax.swing.JTable tableCart;
    private javax.swing.JTable tableCustomer;
    private javax.swing.JTable tableProduct;
    private javax.swing.JTextField txtCustomerEmail;
    private javax.swing.JTextField txtCustomerMobileNumber;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtOrderQuantity;
    private javax.swing.JTextField txtProductDescription;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtProductPrice;
    // End of variables declaration//GEN-END:variables
}
