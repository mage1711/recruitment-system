package main;

import enums.AccountState;
import enums.AccountType;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {

    @org.junit.jupiter.api.Test
    void getJobReports() {
    }

    @org.junit.jupiter.api.Test
    void getApplicantReports() {
    }

    @org.junit.jupiter.api.Test
    void deleteJob() {
    }

    @org.junit.jupiter.api.Test
    void getAccountRequests() {
        Database.init();
        Admin admin = new Admin();
        AccountRequest r = new AccountRequest();
        r.setId(1);
        var requests = admin.getAccountRequests();
        ArrayList<AccountRequest> requestsDB = new ArrayList<AccountRequest>();
        Database.query("select * from accountRequest ");
        var result = Database.getResult();

        try {
            while(result.next()){
                Database.query("select * from recruiter where id =  " + result.getInt("recruiterId"));
                var resultt = Database.getResult();
                resultt.next();
                Recruiter recruiter = new Recruiter(resultt.getString("name") , resultt.getString("email") , AccountType.Recruiter, AccountState.valueOf(resultt.getString("accountState")) ,resultt.getInt("id"), null , null);
                requestsDB.add(new AccountRequest(result.getInt("id"),recruiter,result.getDate("time"),result.getBoolean("approved")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        for (int i = 0; i < requests.size(); i++) {
            assertEquals(requests.get(i) , requestsDB.get(i));

        }
    }

    @org.junit.jupiter.api.Test
    void getJobRequests() {
    }

    @org.junit.jupiter.api.Test
    void acceptAccountRequest() {
        Database.init();
        Admin admin = new Admin();
        AccountRequest r = new AccountRequest();
        r.setId(1);
    }

    @org.junit.jupiter.api.Test
    void rejectAccountRequest() {
    }

    @org.junit.jupiter.api.Test
    void banUser() {
        Database.init();
        Admin admin = new Admin();

    }

    @org.junit.jupiter.api.Test
    void acceptJobRequest() {
        Database.init();
        Admin admin = new Admin();
        JobRequest r = new JobRequest();
        r.setId(10);
        admin.acceptJobRequest(r);
        Database.query("select * from jobRequest where id = " + r.getId());
        var result = Database.getResult();
        try {
            result.next();
            System.out.println(result.toString());
            assertEquals(result.getInt("approved") , 1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @org.junit.jupiter.api.Test
    void rejectJobRequest() {
    }
}