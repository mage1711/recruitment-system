package tests;

import enums.ApplicationState;
import main.Applicant;
import main.Application;
import main.Database;
import main.Job;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    @Test
    void commitToDatabase() {
        Database.init();
        Job testJob = Job.getAll().get(0);
        Applicant testApplicant = Applicant.getApplicant(1);

        Application testApplication = new Application(testApplicant, testJob, new Date(new java.util.Date().getTime()), ApplicationState.Submitted);
        testApplication.commitToDatabase();
        assertEquals(testApplication.getId(),Database.getApplicationId(testApplicant.getId(),1));
        Database.deleteApplication(testApplication.getId());


    }
    @Test
    void deleteFromDatabase() {
        Database.init();
        Job testJob = Job.getAll().get(0);
        Applicant testApplicant = Applicant.getApplicant(1);

        Application testApplication = new Application(testApplicant,testJob,new Date(new java.util.Date().getTime()), ApplicationState.Submitted);
        testApplication.commitToDatabase();
        assertEquals(testApplication.getId(),Database.getApplicationId(testApplicant.getId(),1));
        Database.deleteApplication(testApplication.getId());


    }
}