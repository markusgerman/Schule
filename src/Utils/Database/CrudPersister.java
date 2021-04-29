package Utils.Database;

import java.sql.*;
import java.text.MessageFormat;

public class CrudPersister {

    Connection conn = null;
    private static final String connectionstring = "jdbc:postgresql://157.90.5.140/fs194";
    private final String user = "fs194_gruppe5";
    private final String password = "P@ssw0rd";


    public CrudPersister() throws SQLException {
        conn = DriverManager.getConnection(connectionstring, user, password);
    }

    public void createTarif(Tarif tarif) throws SQLException {

        String statementString = MessageFormat.format("insert into fs194.tarife (bezeichnung, preis) values ({0},{1});",
                 "'" + tarif.bezeichnung + "'",
                tarif.preis
        );
        System.out.println(statementString);

        PreparedStatement stmt = conn.prepareStatement(statementString);

        stmt.executeUpdate();
    }

}
