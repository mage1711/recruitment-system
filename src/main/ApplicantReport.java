package main;

import enums.AccountState;
import enums.AccountType;
import enums.ReportTypes;

import java.sql.SQLException;
import java.util.Date;

public class ApplicantReport extends Report {
    private int id;
    private Applicant victimApplicant;

    public ApplicantReport() {
    }

    public ApplicantReport(User reporter, String description, Date time, Applicant victimApplicant) {
        super(reporter, description, time, ReportTypes.ReportOnApplicant);
        this.victimApplicant = victimApplicant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Applicant getVictimApplicant() {
        return victimApplicant;
    }

    public void setVictimApplicant(Applicant victimApplicant) {
        this.victimApplicant = victimApplicant;
    }


    public static ApplicantReport getReportWithId(int id){
        Database.init();
        ApplicantReport report = null;
        Database.query("select * from applicantReport where id = " + id);
        var result = Database.getResult();

        try {
            result.next();
            Database.query("select * from recruiter where id =  " + result.getInt("userId"));
            var resultt = Database.getResult();
            resultt.next();
            Recruiter recruiter = new Recruiter(resultt.getString("name") , resultt.getString("email") , AccountType.Recruiter, AccountState.valueOf(resultt.getString("accountState")) ,resultt.getInt("id"), null , null);
            Applicant applicant = Applicant.getApplicant(result.getInt("victimApplicantId"));
            report = new ApplicantReport(recruiter , result.getString("description") , result.getDate("time") , applicant);

        } catch (SQLException throwables) {
            //throwables.printStackTrace();
        }
        return report;
    }


}
