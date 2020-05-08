package main;


import enums.City;

import java.lang.reflect.InvocationTargetException;
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
            Database.error = exc.getMessage();
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
        }
    }

    public static ResultSet getResult() {
        return result;
    }

    public static String getError() {
        return error;
    }

    public static int getCityId(City city) {
        String query = "SELECT id FROM city WHERE city = '" + city + "'";
        System.out.println(query);
        query(query);
        try {
            result.next();
            return result.getInt("id");
        } catch (SQLException exc) {
            Database.error = exc.getMessage();
        }
        return -1;
    }
}
