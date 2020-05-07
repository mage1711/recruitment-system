package main;

import enums.*;

import java.util.ArrayList;
import java.util.Date;

public class Job {
    private String jobTitle;
    private CareerLevel careerLevelNeeded;
    private EducationalLevel educationalLevel;
    private String jobRequirements;
    private String jobDescription;
    private ArrayList<JobRole> jobRoles;
    private JobType jobType;
    private String salaryRange;
    private City location;
    private Date postDate;
    private Company company;
    private int vacanciesCount;

    public Job() {
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public CareerLevel getCareerLevelNeeded() {
        return careerLevelNeeded;
    }

    public void setCareerLevelNeeded(CareerLevel careerLevelNeeded) {
        this.careerLevelNeeded = careerLevelNeeded;
    }

    public EducationalLevel getEducationalLevel() {
        return educationalLevel;
    }

    public void setEducationalLevel(EducationalLevel educationalLevel) {
        this.educationalLevel = educationalLevel;
    }

    public String getJobRequirements() {
        return jobRequirements;
    }

    public void setJobRequirements(String jobRequirements) {
        this.jobRequirements = jobRequirements;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public ArrayList<JobRole> getJobRoles() {
        return jobRoles;
    }

    public void setJobRoles(ArrayList<JobRole> jobRoles) {
        this.jobRoles = jobRoles;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public String getSalaryRange() {
        return salaryRange;
    }

    public void setSalaryRange(String salaryRange) {
        this.salaryRange = salaryRange;
    }

    public City getLocation() {
        return location;
    }

    public void setLocation(City location) {
        this.location = location;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public int getVacanciesCount() {
        return vacanciesCount;
    }

    public void setVacanciesCount(int vacanciesCount) {
        this.vacanciesCount = vacanciesCount;
    }

    public void deleteJob() {}
}
