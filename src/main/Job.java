package main;

import enums.*;

import java.sql.Date;
import java.sql.SQLException;
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
                             String jobRequirements, String jobDescription, ArrayList<JobRole> jobRoles,
                             JobType jobType,
                             String salaryRange, City location, Date postDate, Company company, Recruiter recruiter,
                             int vacanciesCount) {
        String query = "INSERT INTO `job` (`id`, `jobTitle`, `careerLevelNeeded`, `educationalLevelNeeded`, " +
                "`jobRecruitements`, `jobDescription`, `jobType`, `salaryRange`, `cityId`, `postDate`, `companyId`, " +
                "`recruiterId`, `vacanciesCount`) VALUES (NULL, '" + jobTitle + "', '" + careerLevelNeeded + "', '" +
                educationalLevel + "', '" + jobRequirements + "', '" + jobDescription + "', '" + jobType + "', '" +
                salaryRange + "', '" + Database.getCityId(
                location) + "', '" + postDate + "', '" + company.getId() + "', '" +
                recruiter.getId() + "', '" + vacanciesCount + "')";
        Database.query(query);
        return new Job();
    }

    public static ArrayList<Job> getAll() {
        String query = "SELECT * FROM job";
        return getJobs(query);
    }

    public static ArrayList<Job> search(String term) {
        String query = "SELECT * FROM job WHERE jobTitle LIKE '%" + term + "%'";
        return getJobs(query);
    }

    private static ArrayList<Job> getJobs(String query) {
        Database.init();
        Database.query(query);
        ArrayList<Job> jobs = new ArrayList<Job>();
        Job currentJob;
        var result = Database.getResult();
        try {
            while (result.next()) {
                int id = result.getInt("id");
                String jobTitle = result.getString("jobTitle");
                String careerLevelNeededString = result.getString("careerLevelNeeded");
                CareerLevel careerLevelNeeded = CareerLevel.valueOf(careerLevelNeededString);
                String educationalLevelNeededString = result.getString("educationalLevelNeeded");
                EducationalLevel educationalLevelNeeded = EducationalLevel.valueOf(educationalLevelNeededString);
                String jobRequirements = result.getString("jobRecruitements");
                String jobDescription = result.getString("jobDescription");
                String jobTypeString = result.getString("jobType");
                JobType jobType = JobType.valueOf(jobTypeString);
                String salaryRange = result.getString("salaryRange");
                int cityId = result.getInt("cityId");
                City city = Database.getCityWithId(cityId);
                Date postDate = result.getDate("postDate");
                int companyId = result.getInt("companyId");
                Company company = Company.getCompany(companyId);
                int recruiterId = result.getInt("recruiterId");
                Recruiter recruiter = Recruiter.getRecruiter(recruiterId);
                int vacanciesCount = result.getInt("vacanciesCount");
                currentJob = new Job(jobTitle, careerLevelNeeded, educationalLevelNeeded, jobRequirements,
                                     jobDescription, new ArrayList<JobRole>(), jobType, salaryRange, city, postDate,
                                     company, recruiter, vacanciesCount);
                jobs.add(currentJob);
            }
        } catch (SQLException | NullPointerException throwables) {
            throwables.printStackTrace();
        }
        return jobs;
    }

    public static void main(String args[]) {
        var jobs = Job.getAll();

        for (Job job : jobs) {
            System.out.println(job.getJobTitle());
        }
    }
}
