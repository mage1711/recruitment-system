package main;

import enums.City;
import enums.EmployeesAmount;

import java.sql.SQLException;
import java.util.ArrayList;

public class Company {
    private int id;
    private String overview;
    private EmployeesAmount employeesAmount;
    private ArrayList<Job> jobs;
    private String address;
    private String field;
    private ArrayList<City> locations;
    private String website;

    public Company() {
    }

    public Company(String overview, EmployeesAmount employeesAmount, ArrayList<Job> jobs, String address,
                   String field, ArrayList<City> locations, String website) {
        this.overview = overview;
        this.employeesAmount = employeesAmount;
        this.jobs = jobs;
        this.address = address;
        this.field = field;
        this.locations = locations;
        this.website = website;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getField() {
        return field;
    }

    public void setField(String field) {
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

    public static Company getCompany(int id) {
        String query = "SELECT * FROM company WHERE id=" + id;
        Database.query(query);
        Company company = null;
        var result = Database.getResult();
        try {
            result.next();
            String overview = result.getString("overview");
            String employeesAmountString = result.getString("employeesAmount");
            EmployeesAmount employeesAmount = EmployeesAmount.valueOf(employeesAmountString);
            String address = result.getString("address");
            String field = result.getString("field");
            String website = result.getString("website");
            int adminId = result.getInt("adminId");
            // TODO: get admin object
            company = new Company(overview, employeesAmount, new ArrayList<>(), address, field,
                                  new ArrayList<>(), website);
        } catch (SQLException throwables) {
//            throwables.printStackTrace();
        }
        return company;

    }


}
