package Utils.Interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ICrudable{
    void create() throws SQLException;
    void delete(int ID) throws SQLException;
    void update() throws SQLException;
    ResultSet read(int ID) throws SQLException;
}
