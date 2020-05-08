package sample;

import enums.CareerLevel;
import enums.City;
import enums.EducationalLevel;
import enums.JobType;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.Company;
import main.Database;
import main.Job;
import main.Recruiter;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("Applicant.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1024, 768));
        primaryStage.show();
    }


    public static void main(String[] args) {
        Database.init();
//        Job job = Job.create("Test", CareerLevel.EntryLevel, EducationalLevel.Bachelor, "testhahahahhahahha",
//                "testhahahahahhahah", new ArrayList<>(), JobType.Freelance, "1000", City.Cairo,
//                new Date(new java.util.Date().getTime()), new Company(), new Recruiter(), 10);
        Job job = new Job();
        job.setId(5);
        job.delete();
        System.out.println(Database.getError());
        launch(args);
    }
}
