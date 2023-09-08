
package proyecto_transversal.AccesoDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyecto_transversal.Entidades.Alumno;
import proyecto_transversal.Entidades.Inscripcion;
import proyecto_transversal.Entidades.Materia;

public class InscripcionData {
  private Connection con;
private AlumnoData aluData;
private MateriaData matData;

public InscripcionData(){
con= Conexion.getConexion();
aluData= new AlumnoData();
matData= new MateriaData();
}

public void guardarInscripcion(Inscripcion ins){
    
    String sql= "INSERT INTO inscripcion nota, id_alumno, id_materia VALUES (?, ?, ?)";
   
      try {
          PreparedStatement ps = con.prepareStatement(sql);
          ps.setDouble(1, ins.getNota());
          ps.setInt(2, ins.getAlumno().getIdAlumno());
          ps.setInt(3, ins.getMateria().getIdMateria());
          int rdo= ps.executeUpdate();
          if(rdo==1){
          JOptionPane.showMessageDialog(null, "Inscripción exitosa");
          }
           
      } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Error al inscribir al alumno "+ ex.getMessage());
      }
    

}

public List <Inscripcion> obtenerInscripciones(){
String sql= "SELECT * FROM inscripcion";
List <Inscripcion> lista= new ArrayList<>();
Materia materia=null;
Alumno alumno=null;
Inscripcion insc= null;
      try {
          PreparedStatement ps= con.prepareStatement(sql);
          ResultSet rdo= ps.executeQuery();
          while(rdo.next()){
          insc.setIdInscripcion(rdo.getInt("id_inscripcion"));
          insc.setNota(rdo.getInt("nota"));
          materia.setIdMateria(rdo.getInt("id_materia"));
          alumno.setIdAlumno(rdo.getInt("id_alumno"));
          insc.setAlumno(alumno);
          insc.setMateria(materia);
          lista.add(insc);
          }
        ps.close();  
      } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Error al obtener lista de inscripciones");
      }
return lista;

}

}
