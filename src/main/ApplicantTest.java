package main;

import enums.*;

import static org.junit.jupiter.api.Assertions.*;

class ApplicantTest {

    @org.junit.jupiter.api.Test
    void commitToDatabase() {
        String name = "test";
        String email = "test";
        String password = "test";
        Database.init();
        Applicant test = new Applicant(name, email, password, AccountType.Applicant, AccountState.Active, null, null, null, Country.Egypt, City.Cairo, null, null, null, 6000, null, 0, EducationalLevel.Bachelor, null, null, null, null, null, null, null, null);
        assertEquals(Database.getApplicantPassword(email),password);
        Database.deleteApplicant(email);
    }
}