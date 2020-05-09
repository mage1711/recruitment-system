package main;

import enums.AccountState;
import enums.AccountType;

import java.util.ArrayList;

import java.sql.SQLException;


public class Admin implements Account {
    int id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        ArrayList<JobReport> reports = new ArrayList<>();
        Database.query("select * from jobReport ");
        var result = Database.getResult();

        try {
            while (result.next()) {
                Applicant applicant = Applicant.getApplicant(result.getInt("userId"));
                Job job = Job.getJobWithId(result.getInt("victimJobId"));
                reports.add(new JobReport(result.getInt("id"), applicant, result.getString("description"),
                                          result.getDate("time"), job));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return reports;
    }

    public ArrayList<ApplicantReport> getApplicantReports() {
        ArrayList<ApplicantReport> reports = new ArrayList<>();
        Database.query("select * from applicantReport ");
        var result = Database.getResult();

        try {
            while (result.next()) {
                Database.query("select * from recruiter where id =  " + result.getInt("userId"));
                var resultt = Database.getResult();
                resultt.next();
                Recruiter recruiter = new Recruiter(resultt.getString("name"), resultt.getString("email"),
                                                    AccountType.Recruiter,
                                                    AccountState.valueOf(resultt.getString("accountState")),
                                                    resultt.getInt("id"), null, null);
                Applicant applicant = Applicant.getApplicant(result.getInt("victimApplicantId"));
                reports.add(new ApplicantReport(recruiter, result.getString("description"), result.getDate("time"),
                                                applicant));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return reports;
    }

    public void deleteJobReport(JobReport report) {
        Database.query("delete from jobReport where id = " + report.getId());
    }

    public void deleteApplicantReport(ApplicantReport report) {
        Database.query("delete from applicantReport where id = " + report.getId());
    }

    public void deleteJob(Job job) {

        Database.query("delete from job where id = " + job.getId());

    }


    public ArrayList<AccountRequest> getAccountRequests() {
        ArrayList<AccountRequest> requests = new ArrayList<>();
        Database.query("select * from accountRequest ");
        var result = Database.getResult();

        try {
            while (result.next()) {
                Database.query("select * from recruiter where id =  " + result.getInt("recruiterId"));
                var resultt = Database.getResult();
                resultt.next();
                Recruiter recruiter = new Recruiter(resultt.getString("name"), resultt.getString("email"),
                                                    AccountType.Recruiter,
                                                    AccountState.valueOf(resultt.getString("accountState")),
                                                    resultt.getInt("id"), null, null);
                requests.add(new AccountRequest(result.getInt("id"), recruiter, result.getDate("time"),
                                                result.getBoolean("approved")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return requests;
    }

    public ArrayList<JobRequest> getJobRequests() {
        Database.init();
        ArrayList<JobRequest> requests = new ArrayList<>();
        Database.query("select * from jobRequest");
        var result = Database.getResult();

        try {

            while (result.next()) {
                Job job = Job.getJobWithId(result.getInt("jobId"));
                requests.add(
                        new JobRequest(result.getInt("id"), job, result.getDate("time"), result.getInt("approved")));
            }
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }


        return requests;
    }

    public void acceptAccountRequest(AccountRequest request) {
        Database.query("select * from accountRequest where id = " + request.getId());
        var result = Database.getResult();
        try {
            result.next();
            Database.query("update accountRequest set approved = 1 where id = " + request.getId());
            Database.query("update recruiter set accountState = 'Active' where id = " + result.getInt("recruiterId"));


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void rejectAccountRequest(AccountRequest request) {

        Database.query("select * from accountRequest where id = " + request.getId());
        var result = Database.getResult();

        try {
            result.next();
            Database.query("update accountRequest set approved = -1 where id = " + request.getId());
            Database.query("update recruiter set accountState = 'Rejected' where id = " + result.getInt("recruiterId"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void banUser(User user) {

        if (user.getClass().getName().contains("Applicant")) {
            Database.query("update applicant set accountState = 'Banned' where id = " + user.getId());
        } else if (user.getClass().getName().contains("Recruiter")) {
            Database.query("update recruiter set accountState = 'Banned' where id = " + user.getId());
        }
    }

    public void acceptJobRequest(JobRequest request) {
        Database.init();
        Database.query("update jobRequest set approved = 1 where id = " + request.getId());

    }

    public void rejectJobRequest(JobRequest request) {
        Database.query("update jobRequest set approved = -1 where id = " + request.getId());
    }

    public void addAdminAccount() {

    }

    @Override
    public boolean login(String email, String password) {
        Database.query("select * from admin where email = '" + email + "' AND password = '" + password + "'");
        var result = Database.getResult();
        try {
            result.next();
            this.id = result.getInt("id");
            this.email = result.getString("email");
            this.name = result.getString("name");
            return true;
        } catch (SQLException throwables) {
            System.out.println("Admin email doesn't exist");
            throwables.printStackTrace();
        }
        return false;
    }
}
