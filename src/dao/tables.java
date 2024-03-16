package dao;

import java.sql.Statement;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class tables {

    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        try {
            con = ConnectionProvider.getCon();
            st = con.createStatement();

            // Inserting a record into the appuser table without specifying appuser_pk
            //String insertQuery = "INSERT INTO appuser(userRole, name, mobileNumber, email, password, address, status) " +
            //         "VALUES('superAdmin', 'super Admin', '12345', 'superadmin@testemail.com', 'admin', 'Nepal', 'Active')";
            // st.executeUpdate(insertQuery);
            //st.executeUpdate("create table category(category_pk INT AUTO_INCREMENT primary key, name varchar(200))");
            // st.executeUpdate("create table product(product_pk INT AUTO_INCREMENT primary key, name varchar(200), quantity int, price int, description varchar(500), category_fk int)");
            //st.executeUpdate("create table customer(customer_pk INT AUTO_INCREMENT primary key, name varchar(200), mobileNumber varchar(50), email varchar(200))");
            st.executeUpdate("create table orderDetails(order_pk INT AUTO_INCREMENT primary key, orderId varchar(200), customer_fk INT, orderDate varchar(200), totalPaid INT)");

            JOptionPane.showMessageDialog(null, "The 'orderDetails' table has been created successfully.", "Table Created", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
