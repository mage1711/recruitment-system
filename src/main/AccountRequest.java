package main;

import java.util.Date;

public class AccountRequest implements Subject {
    private Recruiter account;
    private Date time;
    private Boolean approved;

    public AccountRequest() {
    }

    public AccountRequest(Recruiter account, Date time, Boolean approved) {
        this.account = account;
        this.time = time;
        this.approved = approved;
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

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    @Override
    public void registerObserver(Observer obj) {

    }

    @Override
    public void removeObserver(Observer obj) {

    }

    @Override
    public void notifyObserver() {

    }
}
