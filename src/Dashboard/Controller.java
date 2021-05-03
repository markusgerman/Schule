package Dashboard;

import Utils.Database.Nutzer;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.Console;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class  Controller implements Initializable {
    public Text customers;

    public void DashboardController(ActionEvent actionEvent) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Nutzer n = new Nutzer();
        try {
            customers.setText(Integer.toString(n.countAllUser()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //customers.insert(Integer.toString(n.countAllUser()),1);
    }
}
