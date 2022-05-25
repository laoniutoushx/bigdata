package sos.haruhi;

import java.sql.*;

public class HiveJdbcDemo {

    private static final String driverName = "org.apache.hive.jdbc.HiveDriver";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName(driverName);

        Connection conn = DriverManager.getConnection("jdbc:hive2://h02:10000/default", "hadoop", "seatone@123");

        Statement statement = conn.createStatement();

        String sql = "select * from my_psn8 limit 5";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println(
                    resultSet.getString(1)
                            + resultSet.getString(2)
                            + resultSet.getString(3)
                            + resultSet.getString(4)
            );
        }
    }
}
