package sample;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;

/**
 * Steuerung für die Umschaltung der einzelnen Fenster in der Side-bar.
 */
public class DocumentRouterController {

    @FXML
    private BorderPane mainPane;

    /**
     * Ruft das UI "UI_Dashboard.fxml" in das Hauptfenster.
     * @param actionEvent
     */
    public void handleDashboardButton(javafx.event.ActionEvent actionEvent) {
        FxmlLoader loader = new FxmlLoader();
        Pane pane = loader.getPage("Dashboard/UI_Dashboard");
        mainPane.setCenter(pane);
    }

    /**
     * Ruft das UI "UI_Tarifverwaltung.fxml" in das Hauptfenster.
     * @param actionEvent
     */
    public void handleTarifverwaltungButton(javafx.event.ActionEvent actionEvent) {
        FxmlLoader loader = new FxmlLoader();
        Pane pane = loader.getPage("Tarifverwaltung/UI_Tarifverwaltung");
        mainPane.setCenter(pane);
    }

    /**
     * Ruft das UI "UI_Faktura.fxml" in das Hauptfenster.
     * @param actionEvent
     */
    public void handleFakturaButton(javafx.event.ActionEvent actionEvent) {
        FxmlLoader loader = new FxmlLoader();
        Pane pane = loader.getPage("Faktura/UI_Faktura");
        mainPane.setCenter(pane);
    }
}
