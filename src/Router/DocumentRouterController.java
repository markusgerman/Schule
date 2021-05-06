package Router;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * Steuerung für die Umschaltung der einzelnen Fenster in der Side-bar.
 */
public class DocumentRouterController implements Initializable {

    @FXML
    public BorderPane mainPane;

    /**
     * Ruft das UI "UI_Dashboard.fxml" in das Hauptfenster.
     * @param actionEvent
     */
    public void handleDashboardButton(ActionEvent actionEvent) {
        FxmlLoader loader = new FxmlLoader();
        Pane pane = loader.getPage("Dashboard/UI_Dashboard");
        mainPane.setCenter(pane);
    }

    /**
     * Ruft das UI "UI_Tarifverwaltung.fxml" in das Hauptfenster.
     * @param actionEvent
     */
    public void handleTarifverwaltungButton(ActionEvent actionEvent) {
        FxmlLoader loader = new FxmlLoader();
        Pane pane = loader.getPage("Tarifverwaltung/UI_Tarifverwaltung");
        mainPane.setCenter(pane);
    }

    /**
     * Ruft das UI "UI_Faktura.fxml" in das Hauptfenster.
     * @param actionEvent
     */
    public void handleFakturaButton(ActionEvent actionEvent) {
        FxmlLoader loader = new FxmlLoader();
        Pane pane = loader.getPage("Faktura/UI_Faktura");
        mainPane.setCenter(pane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FxmlLoader loader = new FxmlLoader();
        Pane pane = loader.getPage("Dashboard/UI_Dashboard");
        mainPane.setCenter(pane);
    }
}
