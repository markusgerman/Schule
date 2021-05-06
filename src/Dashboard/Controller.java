package Dashboard;

import Utils.Database.Nutzer;
import Utils.Database.Tarif;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.text.Text;
import javafx.util.Callback;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.Console;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class  Controller implements Initializable {
    @FXML private Text kundenAnz;
    @FXML public Text abrechenbarAnz;
    @FXML public Text mitarbeiterAnz;
    private ObservableList<ObservableList> data;

    public void fillText () throws SQLException {
        Nutzer n = new Nutzer();
        int m = n.countAllMitarbeiter();

    }

    public void DashboardController(ActionEvent actionEvent) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            mitarbeiterAnz.setText(Integer.toString(new Nutzer().countAllMitarbeiter()));
            kundenAnz.setText(Integer.toString(new Nutzer().countAllKunden()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //customers.insert(Integer.toString(n.countAllUser()),1);
    }
}
