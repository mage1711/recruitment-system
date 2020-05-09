package tests;

import enums.*;
import main.Company;
import main.Database;
import main.Job;
import main.Recruiter;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JobTest {

    @org.junit.jupiter.api.Test
    void create() {
        Database.init();
        Company company = Company.getCompany(1);
        Recruiter recruiter = Recruiter.getRecruiter(1);
        String jobTitle = "job titie";
        CareerLevel careerLevel = CareerLevel.Experienced;
        EducationalLevel educationalLevel = EducationalLevel.Bachelor;
        String jobRequirements = "Johohohohohohoob Requirhhhhhhhements";
        String jobDescription = "Jooohhhhhhohohohohob Descriptiohhhhhhhhhhhhhn";
        ArrayList<JobRole> jobRoles = new ArrayList<>();
        JobType jobType = JobType.FullTime;
        String salaryRange = "10000-15000";
        Date time = new Date(new java.util.Date().getTime());
        int vacanciesCount = 10;
        Job.create(jobTitle, careerLevel, educationalLevel,
                   jobRequirements, jobDescription,
                   jobRoles, jobType, salaryRange, City.Cairo,
                   new Date(new java.util.Date().getTime()), company, recruiter, 10);

        var jobs = Job.getAll();
        Job newJob = null;
        boolean found = false;
        for (var job : jobs) {
            if (job.getJobTitle().equals(jobTitle) && job.getRecruiter().getId() == recruiter.getId()) {
                found = true;
                newJob = job;
                break;
            }
        }
        assertTrue(found);
        newJob.delete();
    }

    @org.junit.jupiter.api.Test
    void getJobWithId() {
        Database.init();
        var allJobs = Job.getAll();
        var job = allJobs.get(0);
        var resultJob = Job.getJobWithId(job.getId());
        assertEquals(job.getId(), resultJob.getId());
    }

    @org.junit.jupiter.api.Test
    void getAll() {
        Database.init();
        String query = "SELECT COUNT(*) as count FROM job";
        Database.query(query);
        var result = Database.getResult();
        try {
            result.next();
            int count = result.getInt("count");
            var resultJobs = Job.getAll().size();
            assertEquals(count, resultJobs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}