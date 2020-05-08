package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {

        Admin admin = new Admin();
        Recruiter r = new Recruiter();
        r.setID(1);
        admin.banUser(r);

    }
}
