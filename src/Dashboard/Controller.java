package Dashboard;

import Utils.Database.Nutzer;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.awt.event.ActionEvent;
import java.net.URL;
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
            Nutzer n = new Nutzer();

            mitarbeiterAnz.setText(Integer.toString(n.countAllMitarbeiter()));
            abrechenbarAnz.setText(Integer.toString(n.countAllKundenAbrechenbar()));
            kundenAnz.setText(Integer.toString(n.countAllKunden()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //customers.insert(Integer.toString(n.countAllUser()),1);
    }
}
