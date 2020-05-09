package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {

        Admin admin = new Admin();
        JobRequest r = new JobRequest();
        r.setId(3);
        admin.rejectJobRequest(r);

        Recruiter rr = new Recruiter();
        rr.setId(1);
        admin.banUser(rr);

    }
}
