
package proyecto_transversal.AccesoDatos;

<<<<<<< HEAD
<<<<<<< HEAD
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import proyecto_transversal.Entidades.Alumno;

=======
>>>>>>> parent of cca2800 (Merge branch 'main' of https://github.com/adamblade12/Proyecto-transversal)
=======
>>>>>>> parent of cca2800 (Merge branch 'main' of https://github.com/adamblade12/Proyecto-transversal)
/**
 *
 * @author pablo
 */
public class AlumnoData {
<<<<<<< HEAD
<<<<<<< HEAD
    Connection con;

    public AlumnoData() {
        con = Conexion.getConexion();
    }
    
    public void guardarAlumno(Alumno alumno){
        String sql="INSERT INTO alumno (dni, apellido, nombre, fecha_nacimiento, estado) VALUES(?,?,?,?,?)";
        try{
            PreparedStatement ps= con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setBoolean(5, alumno.isActivo());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                alumno.setIdAlumno(rs.getInt("id_alumno"));
                JOptionPane.showMessageDialog(null, "Alumno añadido con exito");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al añadir alumno "+ ex.getMessage());
        }
        
    }
    
    public Alumno buscarAlumno(int idAlumno){
        Alumno alumno=null;
        String sql="SELECT dni,apellido,nombre,fecha_nacimiento FROM alumno "
                + "WHERE id_alumno = ? AND estado = 1";
        PreparedStatement ps=null;
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                alumno = new Alumno();
                alumno.setIdAlumno(idAlumno);
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fecha_nacimiento").toLocalDate());
                alumno.setActivo(true);
            }else{
                JOptionPane.showMessageDialog(null, "No existe el alumno");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumnos "+ex.getMessage());
        }
        return alumno;
        }
    
    public Alumno buscarPorDni(int dni){
        Alumno alumno=null;
        String sql="SELECT dni, apellido, nombre, estado FROM alumno "
                + "WHERE dni = ? AND estado = 1";
        PreparedStatement ps=null;
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("id_alumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fecha_nacimiento").toLocalDate());
                alumno.setActivo(true);
            }else{
                JOptionPane.showMessageDialog(null, "No existe el alumno");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumnos " + ex.getMessage());
        }
        return alumno;
    }
    
    public List<Alumno> listarAlumnos(){
        List<Alumno> alumnos = new ArrayList();
        try{
            String sql = "SELECT * FROM alumno WHERE estado = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Alumno alumno = new Alumno();
                
                alumno.setIdAlumno(rs.getInt("id_alumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fecha_nacimiento").toLocalDate());
                alumno.setActivo(rs.getBoolean("estado"));
                alumnos.add(alumno);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumnos "+ex.getMessage());
        }
        return alumnos;
    }
    
    public void modificarAlumno(Alumno alumno){
        String sql = "UPDATE alumno "
                + "SET dni=?, apellido=?, nombre=?, fecha_nacimiento=?, estado=? "
                + "WHERE id_alumno=?";
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setBoolean(5, alumno.isActivo());
            ps.setInt(6, alumno.getIdAlumno());
            int exito = ps.executeUpdate();
            
            if(exito == 1){
                JOptionPane.showMessageDialog(null, "Modificado exitosamente");
            }else{
                JOptionPane.showMessageDialog(null, "El alumno no existe");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumnos "+ ex.getMessage());
        }
    }
    
    public void eliminarAlumno(int idAlumno){
        try{
            String sql="UPDATE alumno SET estado = 0 WHERE id_alumno = ?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            int fila = ps.executeUpdate();
            
            if(fila == 1){
                JOptionPane.showMessageDialog(null, "Se elimino al alumno");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumnos "+ ex.getMessage());
        }
    }
=======
    
>>>>>>> parent of cca2800 (Merge branch 'main' of https://github.com/adamblade12/Proyecto-transversal)
=======
    
>>>>>>> parent of cca2800 (Merge branch 'main' of https://github.com/adamblade12/Proyecto-transversal)
}
