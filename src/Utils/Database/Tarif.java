package Utils.Database;


import Utils.Interfaces.ICrudable;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Tarif extends DatabaseConnection implements ICrudable {

    public int tarifnummer;
    public String bezeichnung;
    public double preis;

    /**
     * Erzeugt einen neuen Tarif aus den Klassenattributen.
     * @throws SQLException
     */
    @Override
    public void create() throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(
                "insert into fs194.tarife (bezeichnung, preis) values (?,?);"
        );

        stmt.setString(1, bezeichnung);
        stmt.setBigDecimal(2, new BigDecimal(preis));
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
                "SELECT * FROM fs194.tarife where tarif_nr=(?);"
        );
        stmt.setInt(1, ID);

        ResultSet rs = stmt.executeQuery();

        rs.next();

        tarifnummer = rs.getInt("tarif_nr");
        bezeichnung = rs.getString("bezeichnung");
        preis = rs.getInt("preis");

        return rs;
    }

    /**
     * Löscht den Datensatz des übergebenen Parameters.
     * @param ID
     * @throws SQLException
     */
    @Override
    public void delete(int ID) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(
                "delete from fs194.tarife where tarif_nr=(?);"
        );

        stmt.setInt(1, ID);
        stmt.executeUpdate();
    }

    /**
     * Erzeugt ein Update des Tarifes.
     * @throws SQLException
     */
    @Override
    public void update() throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(
                "UPDATE fs194.tarife set bezeichnung=?, preis=? where id = ?;"
        );

        stmt.setString(1, bezeichnung);
        stmt.setBigDecimal(2, new BigDecimal(preis));
        stmt.setInt(3, tarifnummer);

        stmt.executeUpdate();
    }

    public ResultSet readTarifVerwaltung() throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(
                "Select n.nutzer_nr, n.vorname, n.nachname, n.tarif_nr, t.preis  From fs194.nutzer n Join fs194.tarife t on n.tarif_nr = t.tarif_nr;"
        );

        ResultSet rs = stmt.executeQuery();

        return rs;
    }


}
