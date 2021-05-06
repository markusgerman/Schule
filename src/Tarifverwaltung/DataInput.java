package Tarifverwaltung;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DataInput {
    public DataInput(){}



    private String nutzer_nr;
    private String vorname;
    private String nachname;
    private double preis;
    private int tarif_nr;
    private int inhalt_tarif_nr;

    public DataInput(String nutzer_nr, String vorname, String nachname, double preis, int tarif_nr, int inhalt_tarif_nr){
    this.nutzer_nr = nutzer_nr;
    this.vorname = vorname;
    this.nachname = nachname;
    this.preis = preis;
    this.tarif_nr = tarif_nr;
    this.inhalt_tarif_nr = inhalt_tarif_nr;
}

    public String getNutzer_nr() {
        return nutzer_nr;
    }

    public void setNutzer_nr(String nutzer_nr) {
        this.nutzer_nr = nutzer_nr;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public int getTarif_nr() {
        return tarif_nr;
    }

    public void setTarif_nr(int tarif_nr) {
        this.tarif_nr = tarif_nr;
    }

    public int getInhalt_tarif_nr() {
        return inhalt_tarif_nr;
    }

    public void setInhalt_tarif_nr(int inhalt_tarif_nr) {
        this.inhalt_tarif_nr = inhalt_tarif_nr;
    }

    private final StringProperty option = new SimpleStringProperty(Integer.toString(inhalt_tarif_nr));

    public String getOption() {
        return option.get();
    }

    public void setOption(String value) {
        option.set(Integer.toString(inhalt_tarif_nr));
    }

    public StringProperty optionProperty() {
        return option;
    }
}
