package main;

import enums.*;

import java.io.File;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Date;

public class UserFactory {
    private AccountType type;

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public UserFactory() {
    }

    public UserFactory(AccountType type) {
        this.type = type;
    }

    public User createUser() {
        if (type == AccountType.Recruiter) {
            return new Recruiter();
        } else if (type == AccountType.Applicant) {
            return new Applicant();
        } else {
            throw new InvalidParameterException();
        }
    }

    // Create new applicant object
    public User createUser(String name, String email, String password, AccountType type, AccountState accountState,
                           File CV,
                           ArrayList<Application> applications, String nationality,
                           Country currentCountry, City currentCity, Boolean locatingAbility,
                           ArrayList<JobType> targetJobTypes,
                           ArrayList<JobRole> targetJobRoles, int minSalaryTarget,
                           ArrayList<City> targetWorkCities, int experienceDuration,
                           EducationalLevel currentEducationalLevel, ArrayList<UniversityDegree> universityDegrees,
                           ArrayList<Certification> certifications, ArrayList<String> skills,
                           ArrayList<Language> languages, String linkedInProfile, String githubProfile,
                           String achievements, ArrayList<Job> savedJobs) {
        return new Applicant(name, email, password, type, accountState, CV, applications, nationality,
                             currentCountry, currentCity, locatingAbility, targetJobTypes, targetJobRoles,
                             minSalaryTarget,
                             targetWorkCities, experienceDuration, currentEducationalLevel, universityDegrees,
                             certifications, skills, languages, linkedInProfile, githubProfile, achievements,
                             savedJobs);
    }

    // Create existing applicant object
    public User createUser(String name, String email, AccountType type, int id, AccountState accountState, File CV,
                           ArrayList<Application> applications, String nationality,
                           Country currentCountry, City currentCity, Boolean locatingAbility,
                           ArrayList<JobType> targetJobTypes,
                           ArrayList<JobRole> targetJobRoles, int minSalaryTarget,
                           ArrayList<City> targetWorkCities, int experienceDuration,
                           EducationalLevel currentEducationalLevel, ArrayList<UniversityDegree> universityDegrees,
                           ArrayList<Certification> certifications, ArrayList<String> skills,
                           ArrayList<Language> languages, String linkedInProfile, String githubProfile,
                           String achievements, ArrayList<Job> savedJobs) {
        return new Applicant(name, email, id, type, accountState, CV, applications, nationality,
                             currentCountry, currentCity, locatingAbility, targetJobTypes, targetJobRoles,
                             minSalaryTarget,
                             targetWorkCities, experienceDuration, currentEducationalLevel, universityDegrees,
                             certifications, skills, languages, linkedInProfile, githubProfile, achievements,
                             savedJobs);
    }

    // Create existing recruiter object
    public User createUser(String name, String email, AccountType type, AccountState accountState, int id,
                           ArrayList<Job> jobs, Company company) {
        return new Recruiter(name, email, type, accountState, id, jobs, company);
    }

    // Create new recruiter object
    public User createUser(String name, String email, String password, AccountType type, AccountState accountState,
                           Company company) {
        return new Recruiter(name, email, password, type, accountState, company, true);
    }
}
