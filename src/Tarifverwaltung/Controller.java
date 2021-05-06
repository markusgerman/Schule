package Tarifverwaltung;

import Utils.Database.Nutzer;
import Utils.Database.Tarif;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.StringPropertyBase;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import javax.swing.*;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public TableView tableView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            FillGrid();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void FillGrid() throws SQLException {

        ResultSet rs = new Tarif().readTarifVerwaltung();

        TableColumn<DataInput, String> column1 = new TableColumn<>("Nutzer Nummer");
        column1.setCellValueFactory(new PropertyValueFactory<>("nutzer_nr"));

        TableColumn<DataInput, String> column2 = new TableColumn<>("Vorname");
        column2.setCellValueFactory(new PropertyValueFactory<>("vorname"));

        TableColumn<DataInput, String> column3 = new TableColumn<>("Nachname");
        column3.setCellValueFactory(new PropertyValueFactory<>("nachname"));

        TableColumn<DataInput, String> column4 = new TableColumn<>("Tarif Nummer");
        column4.setCellValueFactory(new PropertyValueFactory<>("tarif_nr"));

        TableColumn<DataInput, String> column5 = new TableColumn<>("Preis");
        column5.setCellValueFactory(new PropertyValueFactory<>("preis"));

        TableColumn<DataInput, StringProperty> actionCol = new TableColumn<>("Tarifauswahl");
        TableCell<DataInput, StringProperty> c = new TableCell<>();
        Callback<TableColumn<DataInput, StringProperty>, TableCell<DataInput, StringProperty>> cellFactory =
                new Callback<TableColumn<DataInput, StringProperty>, TableCell<DataInput, StringProperty>>()
                {
                    @Override
                    public TableCell call(final TableColumn<DataInput, StringProperty> param)
                    {
                        final TableCell<DataInput, StringProperty> cell = new TableCell<DataInput, StringProperty>()
                        {
                            ObservableList<String> options = FXCollections.observableArrayList(
                                "1",
                                "2",
                                "3",
                                "4"
                            );

                            final ComboBox<String> comboBox = new ComboBox<>(options);

                            @Override
                            public void updateItem(StringProperty item, boolean empty)
                            {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                }
                                else
                                {
                                    comboBox.setOnAction(event -> {
                                        DataInput dataInput = getTableView().getItems().get(getIndex());
                                        Nutzer nutzer = new Nutzer();
                                        try {
                                            nutzer.updateTarif(comboBox.valueProperty().getValue() , dataInput.getNutzer_nr());
                                            FillGrid();
                                        } catch (SQLException throwables) {
                                            throwables.printStackTrace();
                                        }
                                        System.out.println(comboBox.valueProperty().getValue() + "   " + dataInput.getNachname());
                                    });
                                    setGraphic(comboBox);
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };

        actionCol.setCellFactory(cellFactory);

       //actionCol.setCellValueFactory(i -> {
       //    final StringProperty value = new SimpleStringProperty((String) i.getValue().getOption());
       //    return Bindings.createObjectBinding(() -> value);
       //});


        tableView.getColumns().addAll(column1,column2,column3,column4,column5,actionCol);

        while(rs.next()){
            Tarif t = new Tarif();
            Nutzer n = new Nutzer();

            for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                n.nutzer_nr = rs.getString("nutzer_nr");
                n.vorname = rs.getString("vorname");
                n.nachname = rs.getString("nachname");
                n.tarif_nr = rs.getInt("tarif_nr");
                t.preis = rs.getDouble("preis");
            }
            tableView.getItems().add(new DataInput(n.nutzer_nr, n.vorname, n.nachname, t.preis, n.tarif_nr, n.tarif_nr));
        }
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
}