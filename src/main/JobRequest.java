package main;

import java.util.Date;

public class JobRequest implements Subject {
    private int ID;
    private Job job;
    private Date time;
    private int approved;

    public JobRequest(int ID, Job job, Date time, int approved) {
        this.ID = ID;
        this.job = job;
        this.time = time;
        this.approved = approved;
    }

    public JobRequest() {
    }

    public JobRequest(Job job, Date time, int approved) {
        this.job = job;
        this.time = time;
        this.approved = approved;
    }

    public int getId() {
        return ID;
    }

    public void setId(int ID) {
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
    public void registerObserver(Observer obj) {

    }

    @Override
    public void removeObserver(Observer obj) {

    }

    @Override
    public void notifyObservers() {

    }
}
