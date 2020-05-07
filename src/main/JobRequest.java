package main;

import java.util.Date;

public class JobRequest implements Subject {
    private Job job;
    private Date time;
    private Boolean approved;

    public JobRequest() {
    }

    public JobRequest(Job job, Date time, Boolean approved) {
        this.job = job;
        this.time = time;
        this.approved = approved;
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

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
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
