package main;

import enums.City;
import enums.CompanyField;
import enums.EmployeesAmount;

import java.util.ArrayList;

public class Company {
    private String overview;
    private EmployeesAmount employeesAmount;
    private ArrayList<Job> jobs;
    private String address;
    private CompanyField field;
    private ArrayList<City> locations;
    private String website;

    public Company() {
    }

    public Company(String overview, EmployeesAmount employeesAmount, ArrayList<Job> jobs, String address, CompanyField field, ArrayList<City> locations, String website) {
        this.overview = overview;
        this.employeesAmount = employeesAmount;
        this.jobs = jobs;
        this.address = address;
        this.field = field;
        this.locations = locations;
        this.website = website;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public EmployeesAmount getEmployeesAmount() {
        return employeesAmount;
    }

    public void setEmployeesAmount(EmployeesAmount employeesAmount) {
        this.employeesAmount = employeesAmount;
    }

    public ArrayList<Job> getJobs() {
        return jobs;
    }

    public void setJobs(ArrayList<Job> jobs) {
        this.jobs = jobs;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CompanyField getField() {
        return field;
    }

    public void setField(CompanyField field) {
        this.field = field;
    }

    public ArrayList<City> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<City> locations) {
        this.locations = locations;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }


}
