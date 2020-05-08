package main;

import enums.*;

import java.io.File;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Date;

public class UserFactory {
    private AccountType type;

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

    public User createUser(String name, String email, AccountType type, AccountState accountState, Date birthDate,
                           String gender, File CV, ArrayList<Application> applications, String nationality,
                           Country currentCountry, City currentCity, Boolean locatingAbility, String mobileNumber,
                           CareerLevel careerLevel, ArrayList<JobType> targetJobTypes,
                           ArrayList<JobRole> targetJobRoles, int minSalaryTarget,
                           ArrayList<City> targetWorkCities, int experienceDuration,
                           EducationalLevel currentEducationalLevel, ArrayList<UniversityDegree> universityDegrees,
                           ArrayList<Certification> certifications, ArrayList<String> skills,
                           ArrayList<Language> languages, String linkedInProfile, String githubProfile,
                           String achievements, ArrayList<Job> savedJobs) {
        return new Applicant(name, email, type, accountState, birthDate,
                             gender, CV, applications, nationality,
                             currentCountry, currentCity, locatingAbility, mobileNumber,
                             careerLevel, targetJobTypes,
                             targetJobRoles, minSalaryTarget,
                             targetWorkCities, experienceDuration,
                             currentEducationalLevel, universityDegrees,
                             certifications, skills,
                             languages, linkedInProfile, githubProfile,
                             achievements, savedJobs);
    }

    public User createUser(String name, String email, AccountType type, AccountState accountState, int id,
                           ArrayList<Job> jobs, Company company) {
        return new Recruiter(name, email, type, accountState, id, jobs, company);
    }
}
