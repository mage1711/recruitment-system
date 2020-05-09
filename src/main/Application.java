package main;

import enums.AccountState;
import enums.ApplicationState;

import java.sql.*;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Map;

public class Application implements Subject {
    private int id;
    private Applicant applicant;
    private Job job;
    private Date time;
    private ApplicationState state;
    private ArrayList<Observer> observers;
    private boolean changed;


    public Application() {
        Database.init();
        this.observers = new ArrayList<>();
    }

    public Application(int id, Applicant applicant, Job job, Date time, ApplicationState state) {
        this.applicant = applicant;
        this.job = job;
        this.time = time;
        this.state = state;
        this.observers = new ArrayList<>();
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        this.notifyObservers();
    }

    public void changeState(ApplicationState newState) {
        Database.query("select state from application");
        var result = Database.getResult();
        try {
            result.next();
            System.out.println(result.getString("state"));
            newState = ApplicationState.valueOf(result.getString("state"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<Application> displayApplication() {
        ArrayList<Application> applications = new ArrayList<Application>();
        Database.query("select * from application");
        var result = Database.getResult();
        try {
            //TODO
            while (result.next()) {
                int appID = (result.getInt("id"));
                int applicantID = (result.getInt("applicantId"));
                int jobId = (result.getInt("jobId"));
                System.out.println(result.getDate("time"));
                System.out.println(result.getString("state"));
                Application app = new Application(result.getInt("id"), Applicant.getApplicant(appID),
                                                  Job.getJobs("select * from job where job =" + jobId).get(0),
                                                  result.getDate("time"),
                                                  ApplicationState.valueOf(result.getString("state")));
                applications.add(app);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return applications;
    }


    public void commitToDatabase() {
        String query = "INSERT into application(applicantId, jobId, time, state)"+
                "values("+this.getApplicant().getId()+","+1+",'"+new Date(new java.util.Date().getTime())+"','"+this.getState()+"')";
        Database.query(query);
        this.id = Database.getApplicationId(this.getApplicant().getId(),1);

    }

    public int getId() {
        return id;
    }

    @Override
    public void registerObserver(Observer obj) {
        if (obj == null) throw new NullPointerException("Null Observer");
        if (!observers.contains(obj)) observers.add(obj);
    }

    @Override
    public void removeObserver(Observer obj) {
        observers.remove(obj);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}
