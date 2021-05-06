package UserAuth;


import Utils.Database.Nutzer;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Main;

import java.io.IOException;
import java.sql.SQLException;

public class Controller {

    public TextField username;
    public PasswordField password;
    public VBox vBox;

    public void LoginController(ActionEvent actionEvent){
        Nutzer loginNutzer = new Nutzer();

        loginNutzer.nutzername = username.getText();
        loginNutzer.passwort = password.getText();



        try {
            if(Main.debug){
                VBox pane = FXMLLoader.load(getClass().getResource("../sample/sample.fxml"));
                vBox.getChildren().setAll(pane);
            }
            if (loginNutzer.readAuthentication() == true){
                VBox pane = FXMLLoader.load(getClass().getResource("../sample/sample.fxml"));
                vBox.getChildren().setAll(pane);
            }
            else {
                System.out.println("falscher Benutzer oder Passwort");
                //Hier muss eine entsprechende Fehlermeldung ausgegeben werden.
            }
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }

    }
}
