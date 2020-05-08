package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        Database.init();
        Database.query("SELECT * FROM applicant");
        ResultSet resultSet = Database.getResult();

        try {
            resultSet.next();
            System.out.println(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        launch(args);
    }
}
