package Utils.Database;

import java.sql.*;
import java.util.Properties;
import java.util.Stack;

public class SqlController {

    private Connection conn;

    private static final String connectionstring = "jdbc:postgresql://157.90.5.140/fs194";
    private final String user = "fs194_gruppe5";
    private final String password = "P@ssw0rd";

    /**
     * Initialisiert die Datenbankverbindung.
     * @throws SQLException
     */
    public SqlController() throws SQLException {
        conn = DriverManager.getConnection(connectionstring, user, password);
    }

    /**
     * Gibt das ResultSet der übergebenen Abfrage zurück.
     * @param query
     * @return
     * @throws SQLException
     */
    public ResultSet querybuilder(String query) throws SQLException {

        Statement st;
        st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);

        return rs;
    }

}
