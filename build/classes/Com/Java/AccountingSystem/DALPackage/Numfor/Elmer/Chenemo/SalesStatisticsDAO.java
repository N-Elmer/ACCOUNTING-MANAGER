package Com.Java.AccountingSystem.DALPackage.Numfor.Elmer.Chenemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import Com.Java.AccountingSystem.ModelClassPackage.Numfor.Elmer.Chenemo.SalesStatisticsModel;

public class SalesStatisticsDAO {

    public static Connection ConnectToDB() {
        final String url = "jdbc:mysql://freedb.tech:3306/freedbtech_dacar";
        final String username = "freedbtech_rooter";
        final String password = "root123";
        
        try {
            System.out.println("Connecting to Sales Statistics Remote Database Table");
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection to Sales Statistics Remote Database Table Established");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static ObservableList<SalesStatisticsModel> getStatisticsData() {
        ObservableList salesStatisticsList = FXCollections.observableArrayList();
        Connection conn = ConnectToDB();
        String sql = "SELECT SUM(Totalamount) AS Totalamount FROM salehistory";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                salesStatisticsList.add(
                        rs.getInt("Totalamount"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return salesStatisticsList;
    }

}
