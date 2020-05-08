package main;

import java.util.ArrayList;
import java.util.Date;

public class AccountRequest implements Subject {
    private int id;
    private Recruiter account;
    private Date time;
    private Boolean approved;
    private ArrayList<Observer> observers;

    public AccountRequest() {
    }

    public AccountRequest(int id, Recruiter account, Date time, Boolean approved) {
        this.id = id;
        this.account = account;
        this.time = time;
        this.approved = approved;
    }

    public Recruiter getAccount() {
        return account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAccount(Recruiter account) {
        this.account = account;
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
        this.notifyObservers();
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
