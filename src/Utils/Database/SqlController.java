package Utils.Database;

import java.sql.*;
import java.util.Properties;

public class SqlController {

    private Connection conn;

    private static final String connectionstring = "jdbc:postgresql://157.90.5.140/fs194";
    private final String user = "fs194_gruppe5";
    private final String password = "P@ssw0rd";

    public SqlController() throws SQLException {
        conn = DriverManager.getConnection(connectionstring, user, password);
        System.out.println("test");



    }
}
