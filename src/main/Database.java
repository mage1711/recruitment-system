package main;


import java.sql.*;

public class Database {
    private static final String host = "jdbc:mysql://islamelbanna.info:3306/";
    private static final String user = "islamelb_recruitement_system";
    private static final String password = "FydL5LYELVYvHK7";
    private static final String name = "islamelb_recruitement_system";
    private static final String params = "?serverTimezone=UTC";
    private static Connection myConn;
    private static ResultSet result;
    private static String error;

    public static void init() {
        try {
            myConn = DriverManager.getConnection(host + name + params, user, password);
        } catch (Exception exc) {
            Database.error = exc.toString();
        }
    }

    public static void query(String query) {
        try {
            Statement myStmt = myConn.createStatement();

                result = myStmt.executeQuery(query);

        } catch (NullPointerException | SQLException exc) {
            result = null;
            Database.error = exc.toString();
        }
    }

    public static ResultSet getResult() {
        return result;
    }

    public static String getError() {
        return error;
    }
}
