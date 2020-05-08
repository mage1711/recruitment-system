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

    public JobReport reportJop(int id,int userId, String description,int vId) {
        String jobReport = "INSERT INTO `jobReport` (`id`, `userId`, `description`, `time`, " + "`victimJobId`,)" +
                "VALUES (NULL, '" + userId + "', '" + description + "', '" + vId ;
        Database.query(jobReport);
        return new JobReport();
    }
}
