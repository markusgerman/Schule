package com.company;

public class Artikel {

    private int leistungsid;
    private String bezeichnung;
    private double einzelpreis;

    public int getLeistungsid() {
        return leistungsid;
    }

    public void setLeistungsid(int leistungsid) {
        this.leistungsid = leistungsid;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public double getEinzelpreis() {
        return einzelpreis;
    }

    public void setEinzelpreis(double einzelpreis) {
        this.einzelpreis = einzelpreis;
    }

    public Artikel(int leistungsid, String bezeichnung, double einzelpreis) {
        this.leistungsid = leistungsid;
        this.bezeichnung = bezeichnung;
        this.einzelpreis = einzelpreis;
    }

    @Override
    public String toString() {
        return "Artikel{" +
                "leistungsid=" + leistungsid +
                ", bezeichnung='" + bezeichnung + '\'' +
                ", einzelpreis=" + einzelpreis +
                '}';
    }
}
