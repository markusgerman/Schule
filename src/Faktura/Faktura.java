package Faktura;

import Utils.Database.Nutzer;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class Faktura {

    public void writeAll(File path) throws SQLException, FileNotFoundException {

        Nutzer n = new Nutzer();

        ResultSet rs = n.readFaktura();

        while (rs.next()){
            try {
                FileWriter file = new FileWriter(path.toString() + "\\" + rs.getString("nutzer_nr")
                        + "_" + rs.getString("nachname") +  ".txt", false);

                BufferedWriter out = new BufferedWriter(file);


                int rechnungsnummer = (int) (100000 + new Random().nextFloat() * 900000);

                out.write("RECHNUNG FÜR IHR FITNESSSTUDIO - " + "Rechnungsnummer:" + rechnungsnummer + "\n");
                out.newLine();
                out.write("Vorname: " + rs.getString("vorname"));
                out.newLine();
                out.write("Nachname: " + rs.getString("nachname"));
                out.newLine();
                out.write("-------------------------------------------------");
                out.newLine();
                out.write("Vielen Dank für Ihr Vertrauen!");
                out.newLine();
                out.write("-------------------------------------------------");
                out.newLine();
                out.write("Wir entziehen Ihnen folgenden Betrag von Ihrem Konto: ");
                out.newLine();
                out.write("Betrag: " + rs.getInt("preis") + " Euro");
                out.newLine();

                out.close();

                Desktop desktop = Desktop.getDesktop();
                File dirToOpen = null;

                dirToOpen = new File(path.toString());
                desktop.open(dirToOpen);

            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }




    }

    public void write(File path, ResultSet rs) throws SQLException {

        Nutzer n = new Nutzer();



        try {
            FileWriter file = new FileWriter(path.toString() + "\\" + rs.getString("nutzer_nr")
                    + "_" + rs.getString("nachname") +  ".txt", false);

            BufferedWriter out = new BufferedWriter(file);


            int rechnungsnummer = (int) (100000 + new Random().nextFloat() * 900000);

            out.write("RECHNUNG FÜR IHR FITNESSSTUDIO - " + "Rechnungsnummer:" + rechnungsnummer + "\n");
            out.newLine();
            out.write("Vorname: " + rs.getString("vorname"));
            out.newLine();
            out.write("Nachname: " + rs.getString("nachname"));
            out.newLine();
            out.write("-------------------------------------------------");
            out.newLine();
            out.write("Vielen Dank für Ihr Vertrauen!");
            out.newLine();
            out.write("-------------------------------------------------");
            out.newLine();
            out.write("Wir entziehen Ihnen folgenden Betrag von Ihrem Konto: ");
            out.newLine();
            out.write("Betrag: " + rs.getInt("preis") + " Euro");
            out.newLine();

            out.close();

            Desktop desktop = Desktop.getDesktop();
            File dirToOpen = null;

            dirToOpen = new File(path.toString());
            desktop.open(dirToOpen);

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


}
