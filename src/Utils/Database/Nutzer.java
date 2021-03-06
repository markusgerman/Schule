package Utils.Database;

import Utils.Interfaces.ICrudable;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Nutzer extends DatabaseConnection implements ICrudable {

    public String nutzer_nr;
    public String adresse;
    public String mail;
    public Date geburtstag;
    public String nachname;
    public String nutzername;
    public String passwort;
    public Object profilbild;
    public int rollen_nr;
    public int tarif_nr;
    public String vorname;
    public Date letzte_abrechnung;

    /**
     * Erzeugt einen neuen Nutzer aus den Klassenattributen.
     * @throws SQLException
     */
    @Override
    public void create() throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(
                "insert into fs194.tarife (nutzer_nr, adresse, mail, geburtstag, nachname, nutzername, passwort, profilbild, rollen_nr, tarif_nr, vorname) " +
                        "values (?,?,?,?,?,?,?,?,?,?,?);"
        );

        stmt.setString(1, nutzer_nr);
        stmt.setString(2, adresse);
        stmt.setString(3, mail);
        stmt.setDate(4, geburtstag);
        stmt.setString(5, nachname);
        stmt.setString(6, nutzername);
        stmt.setString(7, passwort);
        stmt.setString(8, null);
        stmt.setInt(9, rollen_nr);
        stmt.setInt(10, tarif_nr);
        stmt.setString(11, vorname);

        stmt.executeUpdate();
    }

    /**
     * Funktion ist aus Sicherheitsgründen erstmal deaktiviert.
     * @param ID
     * @throws SQLException
     */
    @Override
    public void delete(int ID) throws SQLException {

    }

    /**
     * Funktion ist aus Sicherheitsgründen erstmal deaktiviert.
     * @throws SQLException
     */
    @Override
    public void update() throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(
                "UPDATE fs194.nutzer set letzte_abrechnung = CURRENT_DATE;"
        );

        stmt.executeUpdate();
    }

    public void update(int id) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(
                "UPDATE fs194.nutzer set letzte_abrechnung = CURRENT_DATE where nutzer_nr = ?;"
        );

        stmt.setInt(1, id);

        stmt.executeUpdate();
    }
    /**
     * Ließt den Datensatz des übergebenen Parameters in die Klassenattribute.
     * @param ID
     * @throws SQLException
     */
    @Override
    public ResultSet read(int ID) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(
                "SELECT * FROM fs194.nutzer where nutzer_nr = ?;"
        );

        stmt.setInt(1, ID);

        ResultSet rs = stmt.executeQuery();

        rs.next();

        nutzer_nr = rs.getString("nutzer_nr");
        adresse = rs.getString("adresse");
        mail = rs.getString("email");
        geburtstag = rs.getDate("geburtstag");
        nachname = rs.getString("nachname");
        nutzername = rs.getString("nutzername");
        passwort = rs.getString("passwort");
        profilbild = rs.getObject("profilbild");
        rollen_nr = rs.getInt("rollen_nr");
        tarif_nr = rs.getInt("tarif_nr");
        vorname = rs.getString("vorname");
        letzte_abrechnung = rs.getDate("letzte_abrechnung");

        return rs;
    }

    /**
     * Ließt alle Datensaetze aus der Tabelle Nutzer in die Klassenattribute.
     * @throws SQLException
     */

    public ResultSet readAllUser() throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(
                "SELECT * FROM fs194.nutzer;"
        );


        ResultSet rs = stmt.executeQuery();

        rs.next();

        nutzer_nr = rs.getString("nutzer_nr");
        adresse = rs.getString("adresse");
        mail = rs.getString("email");
        geburtstag = rs.getDate("geburtstag");
        nachname = rs.getString("nachname");
        nutzername = rs.getString("nutzername");
        passwort = rs.getString("passwort");
        profilbild = rs.getObject("profilbild");
        rollen_nr = rs.getInt("rollen_nr");
        tarif_nr = rs.getInt("tarif_nr");
        vorname = rs.getString("vorname");
        letzte_abrechnung = rs.getDate("letzte_abrechnung");

        return rs;
    }

    /**
     * Überprüft den Datensatz auf Nutzernamen und Passwort.
     * @return
     * @throws SQLException
     */
    public boolean readAuthentication() throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(
                "SELECT * FROM fs194.nutzer where (nutzername = ?) and (passwort = ?) and (rollen_nr != 1);"
        );

        stmt.setString(1, nutzername);
        stmt.setString(2, passwort);

        ResultSet rs = stmt.executeQuery();

        if(rs.next() == false){
            return false;
        }
        return true;
    }

    /**
     * Gibt alle Datensätze der Nutzertabelle zurück.
     * @throws SQLException
     */
    public ResultSet readFaktura() throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(
                "Select n.nutzer_nr, n.vorname, n.nachname, n.tarif_nr, n.letzte_abrechnung, t.preis From fs194.nutzer n Join fs194.tarife t on n.tarif_nr = t.tarif_nr;"
        );

        ResultSet rs = stmt.executeQuery();

        return rs;
    }

    public ResultSet readFaktura(int id) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(
                "Select n.nutzer_nr, n.vorname, n.nachname, n.tarif_nr, n.letzte_abrechnung, t.preis From fs194.nutzer n Join fs194.tarife t on n.tarif_nr = t.tarif_nr where n.nutzer_nr = ?;"
        );

        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        rs.next();

        return rs;
    }

    public void updateTarif(String tarifNummer, String nutzerNummer) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(
                "UPDATE fs194.nutzer set tarif_nr = ? where nutzer_nr = ?;"
        );

        stmt.setInt(1, Integer.parseInt(tarifNummer));
        stmt.setInt(2, Integer.parseInt(nutzerNummer));
                //setString(2, nutzerNummer);

        stmt.executeUpdate();
    }


    public int countAllUser() throws SQLException {

        PreparedStatement stmt = conn.prepareStatement(
                "SELECT * FROM fs194.nutzer;"
        );


        ResultSet rs = stmt.executeQuery();
        int records = 0;
        while (rs.next()) {
            records = rs.getInt(1);
        }
        return records;

    }

    public int countAllMitarbeiter() throws SQLException {

        PreparedStatement stmt = conn.prepareStatement(
                "SELECT * FROM fs194.nutzer WHERE rollen_nr = 2 OR rollen_nr = 3;"
        );


        ResultSet rs = stmt.executeQuery();
        int records = 0;
        while (rs.next()) {
            records ++;
        }
        return records;

    }

    public int countAllKunden() throws SQLException {

        PreparedStatement stmt = conn.prepareStatement(
                "SELECT * FROM fs194.nutzer WHERE rollen_nr = 1;"
        );


        ResultSet rs = stmt.executeQuery();
        int records = 0;
        while (rs.next()) {
            records ++;
        }
        return records;

    }

    public int countAllKundenAbrechenbar() throws SQLException {

        PreparedStatement stmt = conn.prepareStatement(
                "SELECT * FROM fs194.nutzer WHERE rollen_nr = 1 and (letzte_abrechnung < date_trunc('month', current_date - interval '1' month) or letzte_abrechnung = NULL);"
        );


        ResultSet rs = stmt.executeQuery();
        int records = 0;
        while (rs.next()) {
            records ++;
        }
        return records;

    }



}
