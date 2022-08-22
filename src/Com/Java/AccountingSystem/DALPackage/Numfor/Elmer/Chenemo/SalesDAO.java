package Com.Java.AccountingSystem.DALPackage.Numfor.Elmer.Chenemo;

import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import Com.Java.AccountingSystem.ModelClassPackage.Numfor.Elmer.Chenemo.SalesModel;

public class SalesDAO {

    public static Connection ConnectToDB() {

        final String url = "jdbc:mysql://freedb.tech:3306/freedbtech_dacar";
        final String username = "freedbtech_rooter";
        final String password = "root123";

        try {
            System.out.println("Connecting to Sales Remote Database Table");
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection to Sales Remote Database Table Established");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public static ObservableList<SalesModel> getTableData() {
        ObservableList<SalesModel> salesList = FXCollections.observableArrayList();
        Connection conn = ConnectToDB();
        String sql = "SELECT * FROM salehistory";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                salesList.add(new SalesModel(
                        rs.getString("Id"),
                        rs.getString("Customername"),
                        rs.getString("Phonenumber"),
                        rs.getString("Cardescription"),
                        rs.getString("Quantity"),
                        rs.getString("Totalamount"),
                        rs.getString("Date")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return salesList;
    }

}
