package UserAuth;


import Utils.Database.Nutzer;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Main;
import javax.xml.soap.Text;
import java.io.IOException;
import java.sql.SQLException;

public class Controller {

    public TextField username;
    public PasswordField password;
    public VBox vBox;
    public Label error;

    public void LoginController(ActionEvent actionEvent){
        Nutzer loginNutzer = new Nutzer();

        loginNutzer.nutzername = username.getText();
        loginNutzer.passwort = password.getText();

        try {
            if(Main.debug){
                Parent root = FXMLLoader.load(getClass().getResource("../sample/sample.fxml"));

                Stage primaryStage = new Stage();
                primaryStage.setTitle("Abrechnungs- und Tarifverwaltungmodul");
                primaryStage.setScene(new Scene(root,1000,600));
                primaryStage.show();
                primaryStage.setResizable(true);
                ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
            }
            if (loginNutzer.readAuthentication() == true){
                VBox pane = FXMLLoader.load(getClass().getResource("../sample/sample.fxml"));
                vBox.getChildren().setAll(pane);
            }
            else {
                System.out.println("falscher Benutzer oder Passwort");
                error.setVisible(true);
                //Hier muss eine entsprechende Fehlermeldung ausgegeben werden.
            }
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }

    }
}
