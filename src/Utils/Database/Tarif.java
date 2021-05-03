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
    public void read(int ID) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(
                "SELECT * FROM fs194.tarife where tarif_nr=(?);"
        );
        stmt.setInt(1, ID);

        ResultSet rs = stmt.executeQuery();

        rs.next();

        tarifnummer = rs.getInt("tarif_nr");
        bezeichnung = rs.getString("bezeichnung");
        preis = rs.getInt("preis");
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


}
