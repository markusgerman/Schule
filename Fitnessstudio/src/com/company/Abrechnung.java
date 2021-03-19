package com.company;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Abrechnung {

    public ArrayList<Journalsatz> daten = new ArrayList<>();


    public List getDaten() {
        return this.daten;
    }

    public void erstelleRechnung() {
        String knummer = null;
        Journalsatz js = null;
        ArrayList<Journalsatz> rechnung = new ArrayList<Journalsatz>();
        HashMap<Journalsatz, Double> rechnungG = new HashMap<>();

        for(Journalsatz c : daten){
            if(knummer != c.getKunde().getKundenummer() || knummer == null){
                knummer = c.getKunde().getKundenummer();
                if (js != null)                {
                    rechnung.add(js);
                    rechnungG.put(js, js.getAnzahl() * js.getArtikel().getEinzelpreis());
                    System.out.print(js.toString());
                    System.out.println(" Gesamt: " + rechnungG.get(js));
                }
                js = null;
                System.out.println("Kundenummer: " + c.getKunde().getKundenummer());
            }

            if (js != null){
                if (js.getArtikel().getLeistungsid() == c.getArtikel().getLeistungsid()){
                    c.setAnzahl(c.getAnzahl() + js.getAnzahl());
                }
                else{
                    rechnung.add(js);
                    rechnungG.put(js, js.getAnzahl() * js.getArtikel().getEinzelpreis());

                    System.out.print(js.toString());
                    System.out.println(" Gesamt: " + rechnungG.get(js));
                }
            }
            js = c;
        }
        rechnung.add(js);
        rechnungG.put(js, js.getAnzahl() * js.getArtikel().getEinzelpreis());

        System.out.print(js.toString());
        System.out.println(" Gesamt: " + rechnungG.get(js));
    }
}
