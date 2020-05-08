package main;

import enums.ApplicationState;

import java.util.ArrayList;

public class Recruiter extends User implements Observer {
    private int id;
    private ArrayList<Job> jobs;
    private Company company;
    private boolean accountApproved;
    private ApplicationState state;

    @Override
    public void update(ApplicationState state) {
        this.state=state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    /*public void update(ApplicationState state) {
       this.state = state;
    }
    */
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
