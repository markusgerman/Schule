package Utils.Database;

import Utils.Interfaces.ICrudable;

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

    }

    /**
     * Ließt den Datensatz des übergebenen Parameters in die Klassenattribute.
     * @param ID
     * @throws SQLException
     */
    @Override
    public void read(int ID) throws SQLException {
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

    }

    /**
     * Überprüft den Datensatz auf Nutzernamen und Passwort.
     * @return
     * @throws SQLException
     */
    public boolean readAuthentication() throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(
                "SELECT * FROM fs194.nutzer where (nutzername = ?) and (passwort = ?);"
        );

        stmt.setString(1, nutzername);
        stmt.setString(2, passwort);

        ResultSet rs = stmt.executeQuery();

        if(rs.next() == false){
            return false;
        }
        return true;
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



}
