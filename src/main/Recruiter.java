package main;

import java.util.ArrayList;

public class Recruiter extends User implements Observer {
    private int id;
    private ArrayList<Job> jobs;
    private Company company;
    private boolean accountApproved;

    public void update() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void isApproved() {}

    public void addJob(Job job) {}

    public void removeJob(Job job) {}

    public ArrayList<Job> getOpenJobs() {
        return new ArrayList<>();
    }

}
