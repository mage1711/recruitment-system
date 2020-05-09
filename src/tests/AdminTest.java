package tests;

import main.*;

import java.sql.SQLException;


import static org.junit.jupiter.api.Assertions.*;

class AdminTest {

    @org.junit.jupiter.api.Test
    void getJobReports() {

        Admin admin = new Admin();
        var requests = admin.getJobReports();
        assertEquals(requests.size() , 1);
    }

    @org.junit.jupiter.api.Test
    void getApplicantReports() {
        Admin admin = new Admin();
        var requests = admin.getApplicantReports();
        assertEquals(requests.size() , 1);
    }

    @org.junit.jupiter.api.Test
    void deleteJob() {
        Admin admin = new Admin();
        Job job = new Job();
        job.setId(3);
        admin.deleteJob(job);

        assertNull(Job.getJobWithId(job.getId()));
    }

    @org.junit.jupiter.api.Test
    void deleteJobReport() {
        Admin admin = new Admin();
        JobReport report = new JobReport();
        report.setId(2);
        admin.deleteJobReport(report);
        assertNull(JobReport.getReportWithId(report.getId()));
    }

    @org.junit.jupiter.api.Test
    void deleteApplicantReport() {
        Admin admin = new Admin();
        ApplicantReport report = new ApplicantReport();
        report.setId(2);
        admin.deleteApplicantReport(report);
        assertNull(ApplicantReport.getReportWithId(report.getId()));
    }

    @org.junit.jupiter.api.Test
    void getAccountRequests() {
        Admin admin = new Admin();
        var requests = admin.getAccountRequests();
        assertEquals(requests.size() , 1);
    }

    @org.junit.jupiter.api.Test
    void getJobRequests() {
        Admin admin = new Admin();
        var requests = admin.getJobRequests();
        assertEquals(requests.size() , 2);
    }

    @org.junit.jupiter.api.Test
    void acceptAccountRequest() {
        Admin admin = new Admin();
        AccountRequest r = new AccountRequest();
        r.setId(1);
        admin.acceptAccountRequest(r);
        Database.query("select * from accountRequest where id = " + r.getId());
        var result = Database.getResult();
        try {
            result.next();
            System.out.println(result.toString());
            assertEquals(result.getInt("approved") , 1);
        } catch (SQLException throwables) {
            //throwables.printStackTrace();
        }
    }

    @org.junit.jupiter.api.Test
    void rejectAccountRequest() {
        Admin admin = new Admin();
        AccountRequest r = new AccountRequest();
        r.setId(1);
        admin.rejectAccountRequest(r);
        Database.query("select * from accountRequest where id = " + r.getId());
        var result = Database.getResult();
        try {
            result.next();
            System.out.println(result.toString());
            assertEquals(result.getInt("approved") , -1);
        } catch (SQLException throwables) {
            //throwables.printStackTrace();
        }
    }

    @org.junit.jupiter.api.Test
    void banUser() {
        Admin admin = new Admin();
        Recruiter r = new Recruiter();
        r.setId(1);
        admin.banUser(r);
        Database.query("select accountState from recruiter where id = " + r.getId());
        var result = Database.getResult();
        try {
            result.next();
            assertEquals(result.getString("accountState") , "Banned");
        } catch (SQLException throwables) {
            //throwables.printStackTrace();
        }

    }

    @org.junit.jupiter.api.Test
    void acceptJobRequest() {
        Admin admin = new Admin();
        JobRequest r = new JobRequest();
        r.setId(3);
        admin.acceptJobRequest(r);
        Database.query("select * from jobRequest where id = " + r.getId());
        var result = Database.getResult();
        try {
            result.next();
            System.out.println(result.toString());
            assertEquals(result.getInt("approved") , 1);
        } catch (SQLException throwables) {
            //throwables.printStackTrace();
        }

    }

    @org.junit.jupiter.api.Test
    void rejectJobRequest() {
        Admin admin = new Admin();
        JobRequest r = new JobRequest();
        r.setId(4);
        admin.rejectJobRequest(r);
        Database.query("select * from jobRequest where id = " + r.getId());
        var result = Database.getResult();
        try {
            result.next();
            System.out.println(result.toString());
            assertEquals(result.getInt("approved") , -1);
        } catch (SQLException throwables) {
            //throwables.printStackTrace();
        }
    }
}