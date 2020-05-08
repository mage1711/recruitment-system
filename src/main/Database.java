package main;


import java.sql.*;

public class Database {
    private static String user = "admin";
    private static String password = "admin";
    private static String name = "test";
    private static Connection myConn;
    private static ResultSet result;

    public static void init(){
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "admin", "admin");
            Statement myStmt = myConn.createStatement();

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    public static void Query(String query){
        try {
            Statement myStmt = myConn.createStatement();
            result = myStmt.executeQuery(query);
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    public static  ResultSet GetResult(){
        return result;
    }
}
