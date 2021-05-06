package Faktura;

import Utils.Database.Nutzer;
import Utils.Database.Tarif;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.util.Callback;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    public TableView tableView;
    private ObservableList<ObservableList> data;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            FillGrid();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void FillGrid() throws SQLException {

        ResultSet rs = new Nutzer().readFaktura();

        data = FXCollections.observableArrayList();

        for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
            final int j = i;
            TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
            col.setCellValueFactory((Callback<CellDataFeatures<ObservableList, String>, ObservableValue<String>>) param ->
                    new SimpleStringProperty(param.getValue().get(j).toString()));

            tableView.getColumns().addAll(col);

        }

        TableColumn rechnungssumme = new TableColumn("Rechnungssumme Netto");
        tableView.getColumns().add(rechnungssumme);



        while(rs.next()){
            Nutzer n = new Nutzer();
            ObservableList<String> row = FXCollections.observableArrayList();
            for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){

                n.nutzer_nr = rs.getString("nutzer_nr");
                n.vorname = rs.getString("vorname");
                n.nachname = rs.getString("nachname");
                n.tarif_nr = rs.getInt("tarif_nr");

                row.add(n.nutzer_nr);
                row.add(n.vorname);
                row.add(n.nachname);
                row.add(Integer.toString(n.tarif_nr));

            }
            data.add(row);
        }

        tableView.setItems(data);




    }

}
