package sample;

import Utils.Database.CrudPersister;
import Utils.Database.Tarif;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../UserAuth/UI_Login.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();


        Tarif t = new Tarif();

        t.bezeichnung = "Basic";
        t.preis = 10;

        CrudPersister tarif = new CrudPersister();
        tarif.createTarif(t);

    }


    public static void main(String[] args) {
        launch(args);
    }
}
