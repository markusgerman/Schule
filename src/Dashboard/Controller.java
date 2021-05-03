package Dashboard;

import Utils.Database.Nutzer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.Console;
import java.sql.SQLException;

public class Controller {
    public TextArea customers;

    public Controller() throws SQLException {
        System.out.println("test");
        Nutzer n = new Nutzer();
        n.countAllUser();
    }

    public void DashboardController(ActionEvent actionEvent) {

    }
}
