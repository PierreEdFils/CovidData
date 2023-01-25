package com.careerdevs.CovidData.sql;
import java.sql.*;
public class CovidDataSql {



    public class SQL {
        static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        static final String DB_URL = "jdbc:mysql://hostname:port/dbname";

        static final String USER = "username";
        static final String PASS = "password";

        public static void main(String[] args) {
            Connection conn = null;
            Statement stmt = null;
            try {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();

                // Insert new record
                String sql = "INSERT INTO tablename (column1, column2, column3) VALUES (value1, value2, value3)";
                stmt.executeUpdate(sql);

                // Update existing record
                sql = "UPDATE tablename SET column1 = newValue WHERE id = x";
                stmt.executeUpdate(sql);

                // Retrieve data for display
                sql = "SELECT column1, column2, column3 FROM tablename";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    String col1 = rs.getString("column1");
                    String col2 = rs.getString("column2");
                    String col3 = rs.getString("column3");
                    System.out.print(col1 + " " + col2 + " " + col3);
                }
                rs.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (stmt != null) stmt.close();
                } catch (SQLException se2) {
                }
                try {
                    if (conn != null) conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        }
    }

}
