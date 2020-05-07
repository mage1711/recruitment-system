package main;

import enums.Country;
import enums.EducationalLevel;

public class UniversityDegree {
    private EducationalLevel degreeLevel;
    private Country country;
    private String university;
    private String fieldsOfStudy;
    private int startYear;
    private int endYear;
    private String studiedSubjects;
    private int grade;

    public UniversityDegree() {
    }

    public EducationalLevel getDegreeLevel() {
        return degreeLevel;
    }

    public void setDegreeLevel(EducationalLevel degreeLevel) {
        this.degreeLevel = degreeLevel;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getFieldsOfStudy() {
        return fieldsOfStudy;
    }

    public void setFieldsOfStudy(String fieldsOfStudy) {
        this.fieldsOfStudy = fieldsOfStudy;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public String getStudiedSubjects() {
        return studiedSubjects;
    }

    public void setStudiedSubjects(String studiedSubjects) {
        this.studiedSubjects = studiedSubjects;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
