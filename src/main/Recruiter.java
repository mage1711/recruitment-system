package main;

import enums.AccountState;
import enums.AccountType;

import java.sql.SQLException;
import java.text.CompactNumberFormat;
import java.util.ArrayList;

public class Recruiter extends User implements Observer {
    private int id;
    private ArrayList<Job> jobs;
    private Company company;

    public Recruiter() {
    }

    public Recruiter(String name, String email, AccountType type, AccountState accountState, int id,
                     ArrayList<Job> jobs, Company company) {
        super(name, email, type, accountState);
        this.id = id;
        this.jobs = jobs;
        this.company = company;
    }

    public void update() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void isApproved() {
    }

    public void addJob(Job job) {
    }

    public void removeJob(Job job) {
    }

    public ArrayList<Job> getOpenJobs() {
        return new ArrayList<>();
    }

    public static Recruiter getRecruiter(int id) {
        Database.query("select * from recruiter where id =  " + id);
        var result = Database.getResult();
        Recruiter recruiter = null;
        try {
            result.next();

            // TODO: Get jobs
            Company company = Company.getCompany(result.getInt("companyId"));
            recruiter = new Recruiter(result.getString("name"), result.getString("email"),
                                                AccountType.Recruiter,
                                                AccountState.valueOf(result.getString("accountState")), id,
                                                new ArrayList<Job>(), company);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return recruiter;
    }

}
