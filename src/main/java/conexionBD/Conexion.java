package conexionBD;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author BetsabeJunior
 */
public class Conexion {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/trabajadores?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String JDBC_USER = "root";
    private static final String PASSWORD = "";

    private static BasicDataSource ds;

    public static DataSource getDataSource() {
        if (ds == null) {
            ds = new BasicDataSource();
            ds.setUrl(JDBC_URL);
            ds.setUsername(JDBC_USER);
            ds.setPassword(PASSWORD);
            ds.setInitialSize(50);
        }
        return ds;
    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(PreparedStatement stmt) {
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

}
