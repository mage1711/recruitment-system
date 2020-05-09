package main;

import enums.ApplicationState;

import enums.AccountState;
import enums.AccountType;

import java.sql.SQLException;

import java.util.ArrayList;

public class Recruiter extends User implements Observer {
    private int id;
    private ArrayList<Job> jobs;
    private Company company;
    private boolean isNew;

    public Recruiter() {
        this.isNew = false;
    }

    public Recruiter(String name, String email, AccountType type, AccountState accountState, int id,
                     ArrayList<Job> jobs, Company company) {
        super(name, email, type, accountState);
        this.id = id;
        this.jobs = jobs;
        this.company = company;
        this.notifyBehaviour = new NotifyRecruiter();
        this.isNew = false;
    }

    public Recruiter(String name, String email, String password, AccountType type, AccountState accountState, int id,
                     ArrayList<Job> jobs, Company company, boolean isNew) {
        super(name, email, type, accountState);
        this.id = id;
        this.jobs = jobs;
        this.company = company;
        this.notifyBehaviour = new NotifyRecruiter();
        this.isNew = isNew;
        if (isNew) {
            this.commitToDatabase(password);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void sendNotification(Object o) {
        this.notifyBehaviour.sendNotification(o);
    }

    public void isApproved() {
    }

    public void addJob(Job job) {
    }

    public void removeJob(Job job) {
    }

    public void commitToDatabase(String password) {
        String query = "INSERT INTO `recruiter` (`id`, `email`, `password`, `name`, `accountState`, `companyId`) " +
                "VALUES (NULL, '" + this.getEmail() + "', '" + password + "', '" + this.getName() + "', '" +
                this.accountState + "', '" + this.company.getId() + "')";
        Database.query(query);
    }

    // Update
    public void commitToDatabase() {
        String query = "UPDATE `recruiter` SET (`email`, `name`, `accountState`, `companyId`) " +
                "VALUES ('" + this.getEmail() + "', '" + this.getName() + "', '" +
                this.accountState + "', '" + this.company.getId() + "') WHERE `id`=" + this.getId();

        Database.query(query);
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

    @Override
    public void update(Object updatedObject) {
        this.sendNotification(updatedObject);
    }
}
