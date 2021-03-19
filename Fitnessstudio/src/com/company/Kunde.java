package com.company;

/**
 * Die Kunde Klasse erstellt ist ein
 * Abbild eines Kunden
 */
public class Kunde {
    private String kundenummer;

    public String getKundenummer() {
        return kundenummer;
    }

    public void setKundenummer(String kundenummer) {
        this.kundenummer = kundenummer;
    }

    public Kunde(String kundenummer) {
        this.kundenummer = kundenummer;
    }

    @Override
    public String toString() {
        return "Kunde{" +
                "kundenummer='" + kundenummer + '\'' +
                '}';
    }
}
