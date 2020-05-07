package main;

import enums.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class Applicant extends User implements Observer {
    private Date birthDate;
    private String gender;
    private File CV;
    private ArrayList<Application> applications;
    private String nationality;
    private Country currentCountry;
    private City currentCity;
    private Boolean locatingAbility;
    private String mobileNumber;
    private CareerLevel careerLevel;
    private ArrayList<JobType> targetJobTypes;
    private ArrayList<JobRole> targetJobRoles;
    private int minSalaryTarget;
    private ArrayList<City> targetWorkCities;
    private int experienceDuration;
    private EducationalLevel currentEducationalLevel;
    private ArrayList<UniversityDegree> universityDegrees;
    private ArrayList<Certification> certifications;
    private ArrayList<String> skills;
    private ArrayList<Language> languages;
    private String linkedInProfile;
    private String githubProfile;
    private String achievements;
    private ArrayList<Job> savedJobs;

    public Applicant() {
    }

    public Applicant(String name, String email, AccountType type, Date birthDate, String gender, File CV, ArrayList<Application> applications, String nationality, Country currentCountry, City currentCity, Boolean locatingAbility, String mobileNumber, CareerLevel careerLevel, ArrayList<JobType> targetJobTypes, ArrayList<JobRole> targetJobRoles, int minSalaryTarget, ArrayList<City> targetWorkCities, int experienceDuration, EducationalLevel currentEducationalLevel, ArrayList<UniversityDegree> universityDegrees, ArrayList<Certification> certifications, ArrayList<String> skills, ArrayList<Language> languages, String linkedInProfile, String githubProfile, String achievements, ArrayList<Job> savedJobs) {
        super(name, email, type);
        this.birthDate = birthDate;
        this.gender = gender;
        this.CV = CV;
        this.applications = applications;
        this.nationality = nationality;
        this.currentCountry = currentCountry;
        this.currentCity = currentCity;
        this.locatingAbility = locatingAbility;
        this.mobileNumber = mobileNumber;
        this.careerLevel = careerLevel;
        this.targetJobTypes = targetJobTypes;
        this.targetJobRoles = targetJobRoles;
        this.minSalaryTarget = minSalaryTarget;
        this.targetWorkCities = targetWorkCities;
        this.experienceDuration = experienceDuration;
        this.currentEducationalLevel = currentEducationalLevel;
        this.universityDegrees = universityDegrees;
        this.certifications = certifications;
        this.skills = skills;
        this.languages = languages;
        this.linkedInProfile = linkedInProfile;
        this.githubProfile = githubProfile;
        this.achievements = achievements;
        this.savedJobs = savedJobs;
    }

    @Override
    public void update() {}

    public void addApplication(Application application) {}

    public void addJobTypeTarget(JobType jobType) {}

    public void addJobRoleTarget(JobRole jobRole) {}

    public void addTargetCity(City city) {}

    public void addUniversityDegree(UniversityDegree degree) {}

    public void addCertification(Certification certification) {}

    public void addSkill(String skill) {}

    public void addLanguage(Language language) {}

    public void saveJob(Job job) {}

    public void removeApplication(Application application) {}

    public void removeJobTypeTarget(JobType jobType) {}

    public void removeJobRoleTarget(JobRole jobRole) {}

    public void removeTargetCity(City city) {}

    public void removeUniversityDegree(UniversityDegree degree) {}

    public void removeCertification(Certification certification) {}

    public void removeSkill(String skill) {}

    public void removeLanguage(Language language) {}
}
