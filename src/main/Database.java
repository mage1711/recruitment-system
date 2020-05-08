package main;


import java.sql.*;

public class Database {
    private static final String user = "mostafa"; //"islamelb_recruitement_system";
    private static final String password = "mostafa"; //"FydL5LYELVYvHK7";
    private static final String name = "recruitment_system";//"islamelb_recruitement_system";
    private static final String params = "?serverTimezone=UTC";
    private static Connection myConn;
    private static ResultSet result;
    private static String error;

    public static void init() {
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + name, user, password);
        } catch (Exception exc) {
            Database.error = exc.toString();
        }
    }

    public static void query(String query) {
        try {
            Statement myStmt = myConn.createStatement();
            if (query.contains("select") || query.contains("SELECT")) {
                result = myStmt.executeQuery(query);
            } else {
                myStmt.executeUpdate(query);
            }
        } catch (NullPointerException | SQLException exc) {
            result = null;
            Database.error = exc.getMessage();
            System.out.println(error);
        }
    }

    public static ResultSet getResult() {
        return result;
    }

    public static String getError() {
        return error;
    }
}
