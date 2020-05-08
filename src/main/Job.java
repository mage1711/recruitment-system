package main;

import enums.*;

import java.sql.Date;
import java.util.ArrayList;

public class Job {
    private int id;
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
    private Recruiter recruiter;

    public Recruiter getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(Recruiter recruiter) {
        this.recruiter = recruiter;
    }

    private int vacanciesCount;

    public Job() {
    }

    public Job(String jobTitle, CareerLevel careerLevelNeeded, EducationalLevel educationalLevel,
               String jobRequirements, String jobDescription, ArrayList<JobRole> jobRoles, JobType jobType,
               String salaryRange, City location, Date postDate, Company company, Recruiter recruiter,
               int vacanciesCount) {
        this.jobTitle = jobTitle;
        this.careerLevelNeeded = careerLevelNeeded;
        this.educationalLevel = educationalLevel;
        this.jobRequirements = jobRequirements;
        this.jobDescription = jobDescription;
        this.jobRoles = jobRoles;
        this.jobType = jobType;
        this.salaryRange = salaryRange;
        this.location = location;
        this.postDate = postDate;
        this.company = company;
        this.recruiter = recruiter;
        this.vacanciesCount = vacanciesCount;
    }

    public Job(int id, String jobTitle, CareerLevel careerLevelNeeded, EducationalLevel educationalLevel,
               String jobRequirements, String jobDescription, ArrayList<JobRole> jobRoles, JobType jobType,
               String salaryRange, City location, Date postDate, Company company, Recruiter recruiter,
               int vacanciesCount) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.careerLevelNeeded = careerLevelNeeded;
        this.educationalLevel = educationalLevel;
        this.jobRequirements = jobRequirements;
        this.jobDescription = jobDescription;
        this.jobRoles = jobRoles;
        this.jobType = jobType;
        this.salaryRange = salaryRange;
        this.location = location;
        this.postDate = postDate;
        this.company = company;
        this.recruiter = recruiter;
        this.vacanciesCount = vacanciesCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void delete() {
        String query = "DELETE FROM job WHERE id =" + this.id;
        Database.query(query);
        if (Database.getError() != null) {
            System.out.println(Database.getError());
        }
    }

    public static Job create(String jobTitle, CareerLevel careerLevelNeeded, EducationalLevel educationalLevel,
                             String jobRequirements, String jobDescription, ArrayList<JobRole> jobRoles, JobType jobType,
                             String salaryRange, City location, Date postDate, Company company, Recruiter recruiter,
                             int vacanciesCount) {
        String query = "INSERT INTO `job` (`id`, `jobTitle`, `careerLevelNeeded`, `educationalLevelNeeded`, " +
                "`jobRecruitements`, `jobDescription`, `jobType`, `salaryRange`, `cityId`, `postDate`, `companyId`, " +
                "`recruiterId`, `vacanciesCount`) VALUES (NULL, '" + jobTitle + "', '" + careerLevelNeeded + "', '" +
                educationalLevel + "', '" + jobRequirements + "', '" + jobDescription + "', '" + jobType + "', '" +
                salaryRange + "', '" + Database.getCityId(location) + "', '" + postDate + "', '" + company.getId() + "', '" +
                recruiter.getId() + "', '" + vacanciesCount + "')";
        Database.query(query);
        return new Job();
    }

}
