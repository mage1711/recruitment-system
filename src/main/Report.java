package main;

import enums.ReportTypes;

import java.util.Date;

public abstract class Report {
    private int ID;
    private User reporter;
    private String description;
    private Date time;
    private ReportTypes type;

    public Report() {
    }

    public Report(User reporter, String description, Date time, ReportTypes type) {
        this.reporter = reporter;
        this.description = description;
        this.time = time;
        this.type = type;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public User getReporter() {
        return reporter;
    }

    public void setReporter(User reporter) {
        this.reporter = reporter;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public ReportTypes getType() {
        return type;
    }

    public void setType(ReportTypes type) {
        this.type = type;
    }
}
