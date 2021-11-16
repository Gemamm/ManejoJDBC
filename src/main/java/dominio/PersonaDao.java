
package dominio;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import java.sql.*;
import java.util.*;


public class PersonaDao {
    private static final String SQL_SELECT ="SELECT * FROM persona";
    public List<Persona> seleccionar() throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Persona>  persona = new ArrayList<>();
        
        try {
            //establezco la conexion
            conn = getConnection();
            //le paso la consulta
            stmt = conn.prepareStatement(SQL_SELECT);
            //ejecutar el select
            rs = stmt.executeQuery();
            
            while (rs.next()){
                int diPersona = rs.getInt("idPersona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                //crea un objeto y lo añade al array
                persona.add(new Persona(diPersona, nombre, apellido, email, telefono));
                
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally{
            close(rs);
            close(stmt);
            close(conn);
            
            
        }
        return persona;
    
}
}

