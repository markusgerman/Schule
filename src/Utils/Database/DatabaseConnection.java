package Utils.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Erzeugt ein Objekt um die Datenbankverbing zu initialisieren.
 */
public class DatabaseConnection {

    public Connection conn = null;
    public final String connectionstring = "jdbc:postgresql://157.90.5.140/fs194";
    public final String user = "fs194_gruppe5";
    public final String password = "P@ssw0rd";

    public DatabaseConnection() {
        try {
            this.conn = DriverManager.getConnection(connectionstring, user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
