package main;

import enums.AccountType;

import java.util.ArrayList;

public class Recruiter extends User implements Observer {
    private int id;
    private ArrayList<Job> jobs;
    private Company company;
    private boolean accountApproved;

    public Recruiter() {
    }

    public Recruiter(String name, String email, AccountType type, int id, ArrayList<Job> jobs, Company company,
                     boolean accountApproved) {
        super(name, email, type);
        this.id = id;
        this.jobs = jobs;
        this.company = company;
        this.accountApproved = accountApproved;
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

}
