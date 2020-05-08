package main;

import enums.ApplicationState;

import java.util.Date;

public class Application implements Subject {
    private Applicant applicant;
    private Job job;
    private Date time;
    private ApplicationState state;

    public Application() {
    }

    public Application(Applicant applicant, Job job, Date time, ApplicationState state) {
        this.applicant = applicant;
        this.job = job;
        this.time = time;
        this.state = state;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public ApplicationState getState() {
        return state;
    }

    public void setState(ApplicationState state) {
        this.state = state;
    }

    public void changeState(ApplicationState newState) {}

    public void displayApplication() {}

    public  void commitToDatabase(){

    }

    @Override
    public void registerObserver() {

    }

    @Override
    public void removeObserver() {

    }

    @Override
    public void notifyObserver() {

    }
}
