
package datos;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    //clase que ira siempre en paquete de datos
    private static final String JDBC_URL= "jdbc:mysql://localhost:33067test_java?"
            +"useSSL=false&useTimezone=true&serverTimezone=UTC&"
            +"allowPublicKeyRetrieval=true";
    private static final String JDBC_USER ="root";
    private static final String JDBC_PASSWORD = "";
    
    public static Connection getConnection()throws SQLException{
        return DriverManager.getConnection(JDBC_URL, JDBC_USER , JDBC_PASSWORD);
        
    }
    public static void close(ResultSet rs)throws SQLException{
        rs.close();
    }
    
    public static void close (Statement stmt)throws SQLException{
        stmt.close();
    }
    
    public static void close (PreparedStatement stmt)throws SQLException{
        stmt.close();
    }
    
    public static void close(Connection conn)throws SQLException{
        conn.close();
    }
}
