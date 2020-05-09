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
        r.setId(1);
        //admin.acceptJobRequest(r);
        Recruiter rr = new Recruiter();
        rr.setId(1);
        //System.out.println(Job.getJobWithId(1).getJobTitle());
        //admin.banUser(rr);
        var req = admin.getJobRequests();
        //System.out.println(req.get(0).toString());
        //System.out.println(admin.getJobRequests().get(0).getTime());
        //JobReport.reportJop(1 , 1 , "gdhjhsdgh" , 1);


    }
}
