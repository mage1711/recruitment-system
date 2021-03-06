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

    public Applicant(String name, String email, int id, AccountType type, AccountState accountState, File CV,
                     ArrayList<Application> applications, String nationality,
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
        this.setId(id);


    }

    public Applicant(String name, String email, String password, AccountType type, AccountState accountState, File CV,
                     ArrayList<Application> applications, String nationality,
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
        this.commitToDatabase(password);
        int id = Database.getApplicantId(this.getEmail());
        this.setId(id);
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

    @Override
    public boolean login(String email, String password) {
        String query = "SELECT * FROM applicant WHERE email='" + email + "' AND password='" + password + "'";
        Database.query(query);
        var result = Database.getResult();
        try {
            result.next();
            this.setId(result.getInt("id"));
            this.setName(result.getString("name"));
            this.nationality = result.getString("nationality");
            int cityId = result.getInt("cityId");
            this.currentCity = Database.getCityWithId(cityId);
            this.locatingAbility = result.getBoolean("locatingAbility");
            this.linkedInProfile = result.getString("linkedInProfile");
            this.githubProfile = result.getString("githubProfile");
            this.achievements = result.getString("achievements");
            this.currentEducationalLevel = EducationalLevel.Bachelor;
            this.accountState = AccountState.valueOf(result.getString("accountState"));
            return true;
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
        return false;
    }

    public void commitToDatabase(String password) {
        String query = "INSERT into applicant(name, email, password, targetSalary, " +
                "currentEducationalLevel,accountState) " +
                "values('" + this.getName() + "','" + this.getEmail() + "','" + password + "'," + this.getMinSalaryTarget()
                + ",'" + this.currentEducationalLevel + "','" + AccountState.Active + "')";
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
        this.universityDegrees.add(degree);

    }

    public void addCertification(Certification certification) {
        this.certifications.add(certification);
    }

    public void addLanguage(Language language) {
        String query = "UPDATE applicant set language = " + language + " Where email = " + this.getEmail();
        Database.query(query);
        this.languages.add(language);
    }

    public void saveJob(Job job) {
    }

    public void removeApplication(Application application) {
        String query = "DELETE FROM application Where applicantId = " + this.getId();
        Database.query(query);
        this.applications.remove(application);
    }

    public void removeJobTypeTarget(JobType jobType) {
        this.targetJobTypes.remove(jobType);
    }

    public void removeJobRoleTarget(JobRole jobRole) {
        this.targetJobRoles.remove(jobRole);
    }

    public void removeTargetCity(City city) {
        this.targetWorkCities.remove(city);
    }

    public void removeUniversityDegree(UniversityDegree degree) {
        this.universityDegrees.remove(degree);
    }

    public void removeCertification(Certification certification) {
        this.certifications.remove(certification);
    }

    public void removeLanguage(Language language) {
        this.languages.remove(language);
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
            String nationality = results.getString("nationality");
            int cityId = results.getInt("cityId");
            boolean locatingAbility = results.getBoolean("locatingAbility");
            int targetSalary = results.getInt("targetSalary");
            String linkedInProfile = results.getString("linkedInProfile");
            String githubProfile = results.getString("githubProfile");
            String achievements = results.getString("achievements");
            EducationalLevel currentEducationalLevel = EducationalLevel.Bachelor;
            AccountState accountState = AccountState.valueOf(results.getString("accountState"));

            return new Applicant(name, email, id, AccountType.Applicant, accountState, cv, null,
                                 nationality, Country.Egypt, City.Cairo, locatingAbility,
                                 Database.getJobTypes(id, "applicantTargetJobTypes"),
                                 Database.getJobRole(id, "applicantTargetJobRoles"), targetSalary, null,
                                 0, currentEducationalLevel, null, null, null, null, linkedInProfile,
                                 githubProfile, achievements, null);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}
