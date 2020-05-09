package main;


import enums.City;
import enums.JobRole;
import enums.JobType;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;

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
        Database.query(query);
        try {
            result.next();
            return result.getInt("id");
        } catch (SQLException exc) {
            Database.error = exc.getMessage();
        }
        return -1;
    }

    public static City getCityWithId(int id) {
        City city = null;
        if (id != 0) {
            String query = "SELECT city FROM city WHERE id=" + id;
            Database.query(query);
            try {
                result.next();
                String cityString = result.getString("city");
                city = City.valueOf(cityString);
            } catch (SQLException throwables) {
                System.out.println(throwables.getMessage());
            }
        }
        return city;
    }
    public static  int getApplicantId(String email){
        String query = "SELECT id from applicant where email = "+"'"+email+"'";
        Database.query(query);
        try {
            result.next();
            return result.getInt("id");
        } catch (SQLException exc) {
            Database.error = exc.getMessage();
        }
        return -1;
    }
    public static String getApplicantPassword(String email){
        String query = "SELECT password from applicant where email = "+"'"+email+"'";
        Database.query(query);
        try {
            result.next();
            return result.getString("password");
        } catch (SQLException exc) {
            Database.error = exc.getMessage();
        }
        return "";
    }
    public static ArrayList<JobType> getJobTypes(int id,String table){
        String query = "SELECT * from"+ table+" where applicantId = " +id;
        Database.query(query);
        ArrayList<JobType> jobTypes = new ArrayList<>();
        if (result != null) {
            try {
                System.out.print(result.next());
                while (result.next()) {


                    System.out.print(result.getString("jobType"));
                    jobTypes.add(JobType.valueOf(result.getString("jobType")));

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  jobTypes;
    }
    public static ArrayList<JobRole> getJobRole(int id, String table){
        String query = "SELECT * from"+ table+" where applicantId = " +id;
        Database.query(query);
        ArrayList<JobRole> jobRoles = new ArrayList<>();
        if (result != null) {
            try {
                while (result.next()) {
                    System.out.print(result.getString("jobRole"));
                    jobRoles.add(JobRole.valueOf(result.getString("jobType")));

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  jobRoles;
    }
    public static void deleteApplicant(String email){
        String query = "DELETE FROM applicant Where email = " +"'"+email+"'";
        Database.query(query);
    }
    public static void deleteApplication(int id){
        String query = "DELETE FROM application Where id = " +id;
        Database.query(query);
    }
    public static  int getApplicationId(int applicantId,int jobId){
        String query = "SELECT id from application where applicantId ="+applicantId+" and  jobId = "+jobId;
        Database.query(query);
        try {
            result.next();
            return result.getInt("id");
        } catch (SQLException exc) {
            Database.error = exc.getMessage();
        }
        return -1;
    }


}
