package main;

import enums.ReportTypes;

import java.util.Date;

public class JobReport extends Report {
    private Job victimJob;

    public JobReport() {
    }

    public JobReport(User reporter, String description, Date time, Job victimJob) {
        super(reporter, description, time, ReportTypes.ReportOnJobPost);
        this.victimJob = victimJob;
    }

    public Job getVictimJob() {
        return victimJob;
    }

    public void setVictimJob(Job victimJob) {
        this.victimJob = victimJob;
    }
}
