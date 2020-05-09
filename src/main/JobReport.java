package main;

import enums.JobRole;
import enums.ReportTypes;

import java.sql.Date;

public class JobReport extends Report {


    private int id;
    private Job victimJob;

    public JobReport() {
    }

    public JobReport(int id ,User reporter, String description, Date time, Job victimJob) {
        super(reporter, description, time, ReportTypes.ReportOnJobPost);
        this.id = id;
        this.victimJob = victimJob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Job getVictimJob() {
        return victimJob;
    }

    public void setVictimJob(Job victimJob) {
        this.victimJob = victimJob;
    }


    public static JobReport reportJop(int id,int userId, String description,int vId) {

        String jobReport = "INSERT INTO `jobReport` (`id`, `userId`, `description`, `time`, " + "`victimJobId`)" +
                "VALUES (NULL, '" + userId + "', '" + description + "', '" + new Date(new java.util.Date().getTime())+ "', '" + vId + "')";
        Database.query(jobReport);
        return new JobReport();
    }

    public static void main(String[] args) {
        Database.init();
        JobReport jobReport = new JobReport();
        jobReport.reportJop(1, "testtttttttttttttt", 2);
    }
}
