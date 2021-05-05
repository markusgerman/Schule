package Faktura;

import Utils.Database.Nutzer;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import java.sql.Connection;
import java.sql.ResultSet;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;

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
            //We are using non property style for making dynamic table
            final int j = i;
            TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
            col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
                public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
                    return new SimpleStringProperty(param.getValue().get(j).toString());
                }
            });

            tableView.getColumns().addAll(col);
            System.out.println("Column ["+i+"] ");
        }

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
