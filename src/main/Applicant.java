package main;

import enums.*;

import java.io.File;
import java.sql.SQLException;
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

    private ArrayList<Language> languages;
    private String linkedInProfile;
    private String githubProfile;
    private String achievements;
    private ArrayList<Job> savedJobs;

    public Applicant() {
    }

    public Applicant(String name, String email, int id, AccountType type, AccountState accountState, File CV, ArrayList<Application> applications, String nationality,
                     Country currentCountry, City currentCity, Boolean locatingAbility,
                     ArrayList<JobType> targetJobTypes,
                     ArrayList<JobRole> targetJobRoles, int minSalaryTarget,
                     ArrayList<City> targetWorkCities, int experienceDuration,
                     EducationalLevel currentEducationalLevel, ArrayList<UniversityDegree> universityDegrees,
                     ArrayList<Certification> certifications, ArrayList<String> skills,
                     ArrayList<Language> languages, String linkedInProfile, String githubProfile,
                     String achievements, ArrayList<Job> savedJobs) {
        super(name, email, type, accountState);
        this.birthDate = birthDate;
        this.gender = gender;
        this.CV = CV;
        this.applications = applications;
        this.nationality = nationality;
        this.currentCountry = currentCountry;
        this.currentCity = currentCity;
        this.locatingAbility = locatingAbility;

        this.targetJobTypes = targetJobTypes;
        this.targetJobRoles = targetJobRoles;
        this.minSalaryTarget = minSalaryTarget;
        this.targetWorkCities = targetWorkCities;
        this.experienceDuration = experienceDuration;
        this.currentEducationalLevel = currentEducationalLevel;
        this.universityDegrees = universityDegrees;
        this.certifications = certifications;

        this.languages = languages;
        this.linkedInProfile = linkedInProfile;
        this.githubProfile = githubProfile;
        this.achievements = achievements;
        this.savedJobs = savedJobs;
       this.setId(id);


    }
    public Applicant(String name, String email,String password, AccountType type, AccountState accountState, File CV, ArrayList<Application> applications, String nationality,
                     Country currentCountry, City currentCity, Boolean locatingAbility,
                     ArrayList<JobType> targetJobTypes,
                     ArrayList<JobRole> targetJobRoles, int minSalaryTarget,
                     ArrayList<City> targetWorkCities, int experienceDuration,
                     EducationalLevel currentEducationalLevel, ArrayList<UniversityDegree> universityDegrees,
                     ArrayList<Certification> certifications, ArrayList<String> skills,
                     ArrayList<Language> languages, String linkedInProfile, String githubProfile,
                     String achievements, ArrayList<Job> savedJobs) {
        super(name, email, type, accountState);
        this.CV = CV;
        this.applications = applications;
        this.nationality = nationality;
        this.currentCountry = currentCountry;
        this.currentCity = currentCity;
        this.locatingAbility = locatingAbility;

        this.targetJobTypes = targetJobTypes;
        this.targetJobRoles = targetJobRoles;
        this.minSalaryTarget = minSalaryTarget;
        this.targetWorkCities = targetWorkCities;
        this.experienceDuration = experienceDuration;
        this.currentEducationalLevel = currentEducationalLevel;
        this.universityDegrees = universityDegrees;
        this.certifications = certifications;

        this.languages = languages;
        this.linkedInProfile = linkedInProfile;
        this.githubProfile = githubProfile;
        this.achievements = achievements;
        this.savedJobs = savedJobs;
        this.notifyBehaviour = new NotifyApplicant();
    }

    @Override
    public void update(Object object) {
        Application updatedApplication = (Application) object;
        for (var application : applications) {
            if (application.getId() == updatedApplication.getId()) {
                applications.remove(application);
                applications.add(updatedApplication);
                this.sendNotification(updatedApplication);
                break;
            }
        }
    }

    @Override
    public void sendNotification(Object updatedApplication) {
        this.notifyBehaviour.sendNotification(updatedApplication);
    }

    public void commitToDatabase(String password) {
        String query = "INSERT into applicant(name, email, password, targetSalary, " +
                "currentEducationalLevel,accountState) " +
                "values('"+this.getName()+"','"+this.getEmail()+"','"+ password+"',"+this.getMinSalaryTarget()
                + ",'"+this.currentEducationalLevel+"','"+AccountState.Active+"')";
        Database.query(query);

    }

    public int getMinSalaryTarget() {
        return minSalaryTarget;
    }

    public void addApplication(Application application) {
        applications.add(application);
    }

    public void addJobTypeTarget(JobType jobType) {
        String query = "INSERT INTO applicantTargetJobTypes (`applicantId`,`jobType`) VALUES (" + this.getId() + "," + jobType + ")";

        Database.query(query);
    }

    public void addJobRoleTarget(JobRole jobRole) {
        String query = "INSERT INTO applicantTargetJobRoles(`applicantId`,`jobRole`) VALUES (" + this.getId() + "," + jobRole + ")";
        Database.query(query);
    }

    public void addTargetCity(City city) {

        int cityId = Database.getCityId(city);
        String query = "UPDATE applicant set cityId = " + cityId + " Where email = " + this.getEmail();
        Database.query(query);
    }

    public void addUniversityDegree(UniversityDegree degree) {

    }

    public void addCertification(Certification certification) {
    }

    public void addSkill(String skill) {
    }

    public void addLanguage(Language language) {
        String query = "UPDATE applicant set Language = " + language + " Where email = " + this.getEmail();
        Database.query(query);
    }

    public void saveJob(Job job) {
    }

    public void removeApplication(Application application) {
        String query = "DELETE FROM application Where id = " + this.getId();
        Database.query(query);
    }

    public void removeJobTypeTarget(JobType jobType) {

    }

    public void removeJobRoleTarget(JobRole jobRole) {
    }

    public void removeTargetCity(City city) {
    }

    public void removeUniversityDegree(UniversityDegree degree) {
    }

    public void removeCertification(Certification certification) {
    }

    public void removeSkill(String skill) {
    }

    public void removeLanguage(Language language) {
    }

    public static Applicant getApplicant(int id) {
        String query = "SELECT * from applicant where id = " + id;
        Database.query(query);
        var results = Database.getResult();

        try {
            results.next();

            String name = results.getString("name");
            String email = results.getString("email");
            String password = results.getString("password");
            File cv = null;
//                  results.getBlob("cv");

            String nationality = results.getString("nationality");
            int cityId = results.getInt("cityId");
            boolean locatingAbility = results.getBoolean("locatingAbility");
            int targetSalary = results.getInt("targetSalary");
//          EducationalLevel currentEducationalLevel = EducationalLevel.valueOf(results.getString("currentEducationalLevel"));
            String linkedInProfile = results.getString("linkedInProfile");
            String githubProfile = results.getString("githubProfile");
            String achievements = results.getString("achievements");
//          AccountState accountState = AccountState.valueOf(results.getString("accountState"));
            EducationalLevel currentEducationalLevel = EducationalLevel.Bachelor;
            AccountState accountState = AccountState.valueOf(results.getString("accountState"));

            Applicant applicant = new Applicant(name, email, id, AccountType.Applicant, accountState, cv, null, nationality, Country.Egypt, City.Cairo, locatingAbility, Database.getJobTypes(id, "applicantTargetJobTypes"), Database.getJobRole(id, "applicantTargetJobRoles"), targetSalary, null, 0, currentEducationalLevel, null, null, null, null, linkedInProfile, githubProfile, achievements, null);

            return applicant;


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static void main(String[] args) {
//        Applicant test = new Applicant("fady", "fady@gmail.com", "fady", AccountType.Applicant, AccountState.Active, null, null, null, Country.Egypt, City.Cairo, null, null, null, 6000, null, 0, EducationalLevel.Bachelor, null, null, null, null, null, null, null, null);

    }
}
