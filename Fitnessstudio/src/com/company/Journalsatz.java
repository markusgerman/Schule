package com.company;

import java.time.LocalDate;

/**
 * Die Journalsatz Klasse ist ein
 * Abbild eines Journales
 */
public class Journalsatz {

    private LocalDate datum;
    private int anzahl;
    private Kunde kunde;
    private Artikel artikel;

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public Artikel getArtikel() {
        return artikel;
    }

    public void setArtikel(Artikel artikel) {
        this.artikel = artikel;
    }

    public Journalsatz(LocalDate datum, String kundenummer, int artikelnummer, String bezeichnung, double einzelpreis, int anzahl) {
        this.datum = datum;
        this.anzahl = anzahl;
        this.kunde = new Kunde(kundenummer);
        this.artikel = new Artikel(artikelnummer, bezeichnung, einzelpreis);
    }

    @Override
    public String toString() {
        return "Journalsatz{" +
                "datum=" + datum +
                ", anzahl=" + anzahl +
                ", kunde=" + kunde +
                ", artikel=" + artikel +
                '}';
    }
}
