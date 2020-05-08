package main;

import enums.AccountState;
import enums.AccountType;

import java.util.ArrayList;
import java.sql.*;
public class Admin implements Account {
    private String name;
    private String email;

    public Admin() {
        Database.init();
    }

    public Admin(String name, String email) {
        Database.init();
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<JobReport> getJobReports() {
        ArrayList<JobReport> reports = new ArrayList<JobReport>();

        return reports;
    }

    public ArrayList<ApplicantReport> getApplicantReports() {
        ArrayList<ApplicantReport> reports = new ArrayList<ApplicantReport>();
        Database.query("select * from applicantReports ");
        var result = Database.getResult();

        try {
            while(result.next()){
                Database.query("select * from recruiter where id =  " + result.getInt("userId"));
                var resultt = Database.getResult();
                resultt.next();
                Recruiter recruiter = new Recruiter(resultt.getString("name") , resultt.getString("email") , AccountType.Recruiter , resultt.getInt("id"), AccountState.valueOf(resultt.getString("accountState")));
                Database.query("select * from applicant where id =  " + result.getInt("applicantId"));
                resultt = Database.getResult();
                resultt.next();
                Applicant applicant = new Applicant();
                requests.add(new AccountRequest(result.getInt("id"),recruiter,result.getDate("time"),result.getInt("approved")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return reports;
    }

    public void deleteReport(Report report){
        Database.query("delete from report where id = " + report.getID());
    }

    public void deleteJob(Job job) {

        Database.query("delete from job where id = " + job.getID());

    }


    public ArrayList<AccountRequest> getAccountRequests() {
        ArrayList<AccountRequest> requests = new ArrayList<AccountRequest>();
        Database.query("select * from accountRequest ");
        var result = Database.getResult();

            try {
                while(result.next()){
                    Database.query("select * from recruiter where id =  " + result.getInt("recruiterId"));
                    var resultt = Database.getResult();
                    resultt.next();
                    Recruiter recruiter = new Recruiter(resultt.getString("name") , resultt.getString("email") , AccountType.Recruiter , resultt.getInt("id"), AccountState.valueOf(resultt.getString("accountState")));
                    requests.add(new AccountRequest(result.getInt("id"),recruiter,result.getDate("time"),result.getInt("approved")));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


        return requests;
    }

    public ArrayList<JobRequest> getJobRequests() {
        ArrayList<JobRequest> requests = new ArrayList<JobRequest>();
        Database.query("select * from jobRequest ");
        var result = Database.getResult();

        try {
            while(result.next()){
                Database.query("select * from job where id =  " + result.getInt("jobId"));
                var resultt = Database.getResult();
                resultt.next();
                Job job = new Job(resultt.getString("name") , resultt.getString("email") , AccountType.Recruiter , resultt.getInt("id"), AccountState.valueOf(resultt.getString("accountState")));
                requests.add(new JobRequest(result.getInt("id"),recruiter,result.getDate("time"),result.getInt("approved")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return requests;
    }

    public void acceptAccountRequest(AccountRequest request) {
        Database.query("select * from accountRequest where id = " + request.getID());
        var result = Database.getResult();
        try {
            result.next();
            Database.query("update accountRequest set approved = 1 where id = " + request.getID());
            Database.query("update recruiter set accountState = 'Active' where id = " + result.getInt("recruiterId"));


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void rejectAccountRequest(AccountRequest request) {
        Database.query("select * from accountRequest where id = " + request.getID());
        var result = Database.getResult();
        try {
            result.next();
            Database.query("update accountRequest set approved = -1 where id = " + request.getID());
            Database.query("update recruiter set accountState = 'Rejected' where id = " + result.getInt("recruiterId"));


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void banUser(User user) {

        if(user.getClass().getName().contains("Applicant")){
            Database.query("update applicant set accountState = 'Banned' where id = " + user.getID());
        } else if (user.getClass().getName().contains("Recruiter")){
            Database.query("update recruiter set accountState = 'Banned' where id = " + user.getID());
        }
    }

    public void acceptJobRequest(JobRequest request) {
        Database.query("update jobRequest set approved = 1 where id = " + request.getID());
    }

    public void rejectJobRequest(JobRequest request) {
        Database.query("update jobRequest set approved = -1 where id = " + request.getID());
    }

    public void addAdminAccount() {

    }

    @Override
    public void login() {

    }
}
