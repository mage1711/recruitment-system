package main;

import enums.ReportTypes;

import java.util.Date;

public class ApplicantReport extends Report {
    private Applicant victimApplicant;

    public ApplicantReport() {
    }

    public ApplicantReport(User reporter, String description, Date time, Applicant victimApplicant) {
        super(reporter, description, time, ReportTypes.ReportOnApplicant);
        this.victimApplicant = victimApplicant;
    }

    public Applicant getVictimApplicant() {
        return victimApplicant;
    }

    public void setVictimApplicant(Applicant victimApplicant) {
        this.victimApplicant = victimApplicant;
    }
}
