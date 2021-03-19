package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {


    public static void main(String[] args)  {
        // erstellt eine Rechnung aus den Beispieldaten der Abrechnungsaufgabe IHK

        DateTimeFormatter datumFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        Abrechnung abrechnung1 = new Abrechnung();

        abrechnung1.getDaten().add(new Journalsatz(LocalDate.parse("01.04.2016", datumFormat),"K00091",100076,"Softgetränke",2.40,2));
        abrechnung1.getDaten().add(new Journalsatz(LocalDate.parse("10.04.2016", datumFormat),"K00091",100076,"Softgetränke",2.40,3));
        abrechnung1.getDaten().add(new Journalsatz(LocalDate.parse("10.04.2016", datumFormat),"K00091",500123,"Buch Fit ohne Anstrengung",15.00,1));
        abrechnung1.getDaten().add(new Journalsatz(LocalDate.parse("03.04.2016", datumFormat),"K01234",200234,"Kraftraumstunde",20.00,1));
        abrechnung1.getDaten().add(new Journalsatz(LocalDate.parse("11.04.2016", datumFormat),"K01234",200234,"Kraftraumstunde",20.00,1));
        abrechnung1.getDaten().add(new Journalsatz(LocalDate.parse("05.04.2016", datumFormat),"K01234",200356,"Saunastunde",15.00,1));
        abrechnung1.getDaten().add(new Journalsatz(LocalDate.parse("13.04.2016", datumFormat),"K01234",200356,"Saunastunde",15.00,1));

        abrechnung1.erstelleRechnung();
    }
}
