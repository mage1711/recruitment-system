package main;

import java.util.Date;

public class JobRequest implements Subject {
    private int ID;
    private Job job;
    private Date time;
    private int approved;

    public JobRequest() {
    }

    public JobRequest(Job job, Date time, int approved) {
        this.job = job;
        this.time = time;
        this.approved = approved;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public int getApproved() {
        return approved;
    }

    public void setApproved(int approved) {
        this.approved = approved;
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
