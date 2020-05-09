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

    public Recruiter(String name, String email, String password, AccountType type, AccountState accountState,
                     Company company, boolean isNew) {
        super(name, email, type, accountState);
        this.id = id;
        this.company = company;
        this.notifyBehaviour = new NotifyRecruiter();
        this.isNew = isNew;
        if (isNew) {
            this.commitToDatabase(password);
            this.id = Recruiter.getRecruiter(this.getEmail()).getId();
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

    @Override
    public void deleteAccount() {
        String query = "DELETE FROM recruiter WHERE id =" + this.getId();
        Database.query(query);
    }

    public void commitToDatabase(String password) {
        String query = "INSERT INTO `recruiter` (`id`, `email`, `password`, `name`, `accountState`, `companyId`) " +
                "VALUES (NULL, '" + this.getEmail() + "', '" + password + "', '" + this.getName() + "', '" +
                AccountState.Pending + "', '" + this.company.getId() + "')";
        Database.query(query);
    }

    // Update
    public void commitToDatabase() {
        String query = "UPDATE `recruiter` SET " +
                "`email` = '" + this.getEmail() + "'," +
                "`name` = '" + this.getName() + "'," +
                "`companyId` = '" + this.company.getId() + "'" +
                " WHERE `recruiter`.`id` = " + this.getId();

        Database.query(query);
    }


    public ArrayList<Job> getOpenJobs() {
        return new ArrayList<>();
    }

    public static Recruiter getRecruiter(int id) {
        String query = "select * from recruiter where id =  " + id;
        return retrieveRecruiter(query);
    }

    public static Recruiter getRecruiter(String email) {
        String query = "select * from recruiter where email =  '" + email + "'";
        return retrieveRecruiter(query);
    }

    private static Recruiter retrieveRecruiter(String query) {
        Database.query(query);
        var result = Database.getResult();
        Recruiter recruiter = null;
        try {
            result.next();

            // TODO: Get jobs
            Company company = Company.getCompany(result.getInt("companyId"));
            recruiter = new Recruiter(result.getString("name"), result.getString("email"),
                                      AccountType.Recruiter,
                                      AccountState.valueOf(result.getString("accountState")), result.getInt("id"),
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
