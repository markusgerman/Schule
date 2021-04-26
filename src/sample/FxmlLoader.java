package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

public class FxmlLoader {

    private Pane view;

    public Pane getPage(String fileName){

        try{
            URL fileUrl = Main.class.getResource("../" + fileName + ".fxml");
            if(fileUrl == null){
                throw new java.io.FileNotFoundException("FXMl nicht gefunden!");
            }

            view = new FXMLLoader().load(fileUrl);

        } catch (Exception e) {
            System.out.println(("Die Seite " + fileName + " wurde nicht gefunden!"));
        }

        return view;
    }

}
