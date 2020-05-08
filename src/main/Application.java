package main;

import enums.ApplicationState;
import java.sql.*;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class Application implements Subject {
    private  int id;
    private Applicant applicant;
    private Job job;
    private Date time;
    private ApplicationState state;
    private List<Observer> observers;
    //Semaphores – Restrict the number of threads that can access a resource.
    // Example, limit max 10 connections to access a file simultaneously.(MUTEX)
    private final Object MUTEX= new Object();
    private boolean changed;



    public Application() {
        Database.init();
    }

    public Application(int id,Applicant applicant, Job job, Date time, ApplicationState state) {
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

    public void changeState(ApplicationState newState) {
        Database.query("select state from application");
        var result = Database.getResult();
        try {
            result.next();
            System.out.println(result.getString("state"));
            newState=ApplicationState.valueOf(result.getString("state"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void displayApplication() {
        ArrayList<Application> applications = new ArrayList<Application>();
        Database.query("select * from application");
        var result = Database.getResult();
        try {
            //TODO
            while (result.next()){
            System.out.println(result.getInt("id"));
            System.out.println(result.getInt("applicantId"));
            System.out.println(result.getInt("jobId"));
            System.out.println(result.getDate("time"));
            System.out.println(result.getString("state"));
//            Application app= new Application(result.getInt("id"),result.getInt("applicantId"),result.getInt("jobId"),result.getDate("time"),ApplicationState.valueOf(result.getString("state")));
//            applications.add(app);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        return applications;
    }


    public  void commitToDatabase(){

    }

    @Override
    public void registerObserver(Observer obj) {
        if(obj == null) throw new NullPointerException("Null Observer");
        if(!observers.contains(obj)) observers.add(obj);

    }

    @Override
    public void removeObserver(Observer obj) {
        observers.remove(obj);
    }

    @Override
    public void notifyObserver() {
        List<Observer> observersLocal = null;
        //synchronization is used to make sure any observer registered after message is received is not notified
        synchronized (MUTEX) {
            if (!changed)
                return;
            observersLocal = new ArrayList<>(this.observers);
            this.changed=false;
        }
        for (Observer obj : observersLocal) {
            obj.update();
        }


    }
   /* public void notifyObserverr() {
        for (int j=0 ;j<observers.size();j++){
            observers observer=(observers)observer.get(j);
            observer.update();
        }*/
    public Object getUpdate(Observer obj) {
        return this.state;
    }
    public void sendNotification(ApplicationState S){
        System.out.println("Your State is:"+S);
        this.state=S;
        this.changed=true;
        notifyObserver();
    }


}
