package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static final boolean debug = true;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("../UserAuth/UI_Login.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("../UserAuth/UI_Login.fxml"));

        primaryStage.setTitle("Abrechnungs- und Tarifverwaltungmodul");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
