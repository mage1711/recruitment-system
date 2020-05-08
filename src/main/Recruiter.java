package main;

import enums.AccountState;
import enums.AccountType;

import java.util.ArrayList;

public class Recruiter extends User implements Observer {
    private int ID;
    private ArrayList<Job> jobs;
    private Company company;
    private AccountState accountState;

    public Recruiter() {
    }

    public Recruiter(String name, String email, AccountType type, int ID, AccountState accountState) {
        super(name, email, type);
        this.ID = ID;
        this.accountState = accountState;
    }

    public void update() {}

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void isApproved() {}

    public void addJob(Job job) {}

    public void removeJob(Job job) {}

    public ArrayList<Job> getOpenJobs() {
        return new ArrayList<>();
    }

}
