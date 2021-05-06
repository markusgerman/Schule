package Faktura;

import Utils.Database.Nutzer;
import Utils.Database.Tarif;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.util.Callback;

import javafx.event.ActionEvent;

import javax.swing.*;
import javax.xml.transform.Result;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    public TableView tableView;

    public Button btnPrintAll;

    private ObservableList<ObservableList> data;

    @FXML private TableColumn<Nutzer, String> UserId;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            FillGrid();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void FillGrid() throws SQLException {

        ResultSet rs = new Nutzer().readFaktura();

        data = FXCollections.observableArrayList();

        for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
            final int j = i;
            TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
            col.setCellValueFactory((Callback<CellDataFeatures<ObservableList, String>, ObservableValue<String>>) param ->
                    new SimpleStringProperty(param.getValue().get(j).toString()));

            tableView.getColumns().addAll(col);
        }

        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);


        while(rs.next()){
            Nutzer n = new Nutzer();
            Tarif t = new Tarif();
            ObservableList<String> row = FXCollections.observableArrayList();
            for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){

                n.nutzer_nr = rs.getString("nutzer_nr");
                n.vorname = rs.getString("vorname");
                n.nachname = rs.getString("nachname");
                n.tarif_nr = rs.getInt("tarif_nr");
                n.letzte_abrechnung = rs.getDate(("letzte_abrechnung"));
                t.preis = rs.getDouble("preis");

                row.add(n.nutzer_nr);
                row.add(n.vorname);
                row.add(n.nachname);
                row.add(Integer.toString(n.tarif_nr));
                row.add(String.valueOf(n.letzte_abrechnung));
                row.add(Double.toString(t.preis));

            }
            data.add(row);
        }
        tableView.setItems(data);

    }

    public void rechnungenAusgebenController(ActionEvent actionEvent) throws SQLException, FileNotFoundException {

        Faktura faktura = new Faktura();

        JFileChooser chooser = new JFileChooser();

        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        chooser.setToolTipText("Bitte wählen Sie einen Ordner aus.");
        chooser.showSaveDialog(null);

        Nutzer n = new Nutzer();
        n.update();


        try{
            faktura.writeAll(chooser.getSelectedFile());
        }
        catch (Exception e){

        }

    }


    public void rechnungEinzeltAusgeben(ActionEvent actionEvent) throws SQLException {


       String l = tableView.getSelectionModel().getSelectedItems().get(0).toString();

       String value = "";
        for (int i = 1; i < l.length(); i++) {
            if(l.charAt(i) == ','){
                break;
            }
            value += l.charAt(i);
        }

        Nutzer n = new Nutzer();

        ResultSet r = n.readFaktura(Integer.parseInt(value));

        JFileChooser chooser = new JFileChooser();

        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        chooser.setToolTipText("Bitte wählen Sie einen Ordner aus.");
        chooser.showSaveDialog(null);

        Faktura rechnung = new Faktura();

        rechnung.write(chooser.getSelectedFile(), r);


        n.update(Integer.parseInt(value));


    }
}
