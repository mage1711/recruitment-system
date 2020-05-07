package main;

import java.util.ArrayList;

public class Admin implements Account {
    private String name;
    private String email;

    public Admin() {
    }

    public Admin(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Report> getReports() {
        return new ArrayList<>();
    }

    public void deleteJob() {

    }

    public ArrayList<AccountRequest> getAccountRequests() {
        return new ArrayList<>();
    }

    public void acceptUser(User user) {

    }

    public void rejectUser(User user) {

    }

    public void banUser(User user) {

    }

    public void acceptJob(Job job) {

    }

    public void rejectJob(Job job) {

    }

    public void deleteJob(Job job) {

    }

    public void addAdminAccount() {

    }

    @Override
    public void login() {

    }
}
