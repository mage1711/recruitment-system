package main;

import java.util.Date;

public class AccountRequest implements Subject {
    private int ID;
    private Recruiter account;
    private Date time;
    private int approved;

    public AccountRequest() {
    }

    public AccountRequest(int ID ,Recruiter account, Date time, int approved) {
        this.ID = ID;
        this.account = account;
        this.time = time;
        this.approved = approved;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Recruiter getAccount() {
        return account;
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
