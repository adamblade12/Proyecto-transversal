/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_transversal.AccesoDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyecto_transversal.Entidades.Alumno;
import proyecto_transversal.Entidades.Inscripcion;
import proyecto_transversal.Entidades.Materia;

/**
 *
 * @author pablo
 */
public class InscripcionData {
    Connection con;
    MateriaData matData;
    AlumnoData alumnoData;
    
    public InscripcionData(){}
    
    public void guardarInscripcion(Inscripcion inscripcion){
        String sql="INSERT INTO inscripcion (nota, id_alumno, id_materia) VALUES(?,?,?)";
        try{
            PreparedStatement ps= con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, inscripcion.getNota());
            ps.setInt(2, inscripcion.getMateria().getIdMateria());
            ps.setInt(3, inscripcion.getAlumno().getIdAlumno());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                inscripcion.setIdInscripcion(rs.getInt("id_inscripcion"));
                JOptionPane.showMessageDialog(null, "Inscripcion añadida con exito");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla de inscripciones "+ ex.getMessage());
        }
    }
    
    public List<Inscripcion> obtenerInscripciones(){
        List<Inscripcion> inscripciones = new ArrayList<>();
        try{
            String sql = "SELECT * FROM inscripcion WHERE estado = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Inscripcion inscripcion = new Inscripcion();
                AlumnoData aData = new AlumnoData();
                MateriaData mData = new MateriaData();
                inscripcion.setIdInscripcion(rs.getInt("id_inscripcion"));
                inscripcion.setNota(rs.getDouble("nota"));
                inscripcion.setAlumno(aData.buscarAlumno(rs.getInt("id_alumno")));
                inscripcion.setMateria(mData.buscarMateria(rs.getInt("id_materia")));
                inscripcion.setActivo(rs.getBoolean("estado"));
                inscripciones.add(inscripcion);
            }
            ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla de inscripciones "+ ex.getMessage());
        }
        return inscripciones;
    }
    
    public List<Inscripcion> obtenerInscripcionesPorAlumno(int idAlumno){
        Inscripcion inscripcion=null;
        List <Inscripcion> inscripciones = new ArrayList<>();
        String sql="SELECT * FROM inscripcion "
                + "WHERE id_alumno = ? AND estado = 1";
        PreparedStatement ps=null;
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            AlumnoData aData = new AlumnoData();
            MateriaData mData = new MateriaData();
            
            if(rs.next()){
                inscripcion = new Inscripcion();
                inscripcion.setIdInscripcion(rs.getInt("id_inscripcion"));
                inscripcion.setNota(rs.getInt("nota"));
                inscripcion.setAlumno(aData.buscarAlumno(rs.getInt("id_alumno")));
                inscripcion.setMateria(mData.buscarMateria(rs.getInt("id_materia")));
                inscripcion.setActivo(true);
            }else{
                JOptionPane.showMessageDialog(null, "La inscripcion no existe");
            }
            ps.close();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla de inscripciones "+ ex.getMessage());
        }
        return inscripciones;
    }
    
    public List<Materia> obtenerMateriasCursadas(int idMateria){
        Materia materia = null;
        List <Materia> materias = new ArrayList<>();
        String sql="SELECT * FROM inscripcion "
                + "WHERE id_materia=? AND estado = 1";
        PreparedStatement ps=null;
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ResultSet rs = ps.executeQuery();
            MateriaData mData = new MateriaData();
            
            if(rs.next()){
                materia = new Materia();
                materia.setIdMateria(rs.getInt("id_materia"));
                materia.setNombre(mData.buscarMateria(idMateria).getNombre());
                materia.setAnioMateria(mData.buscarMateria(idMateria).getAnioMateria());
                materia.setActivo(true);
            }else{
                JOptionPane.showMessageDialog(null, "La materia no existe");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return materias;
    }
    
    //OBTIENE LA LISTA DE MATERIAS CURSADAS SEGUN EL ID DEL ALUMNO. VER PAG 19 PDF
    public List <Materia> obtenerMateriasCursadas2(int IdAlumno){
        ArrayList <Materia> lista= new ArrayList<>();
        String sql= "SELECT * FROM materia m JOIN inscripcion i "+
                "ON m.id_materia= i.id_materia JOIN alumno a ON i.id_alumno= (a.id_alumno=?);";
     
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, IdAlumno);
            ResultSet rdo= ps.executeQuery();
            if (rdo.next()){
            Materia mat= new Materia();
            mat.setIdMateria(rdo.getInt("id_materia"));
            mat.setNombre(rdo.getString("nombre"));
            mat.setAnioMateria(rdo.getInt("año"));
            lista.add(mat);
         }
            else{
            JOptionPane.showMessageDialog(null, "El alumno no curso ninguna materia");
            }
           ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos "+ ex.getMessage());
        }
   
    return lista;
    }
      //OBTIENE LA LISTA DE MATERIAS NO CURSADAS SEGUN EL ID DEL ALUMNO. VER PAG 19 PDF 
        public List <Materia> obtenerMateriasNoCursadas2(int IdAlumno){
        ArrayList <Materia> lista= new ArrayList<>();
        String sql= "SELECT * FROM materia m WHERE NOT EXISTS SELECT ? FROM inscripcion i WHERE m.id_materia = i.id_materia" +
"    AND i.id_alumno = ?;";
     
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, IdAlumno);
            ps.setInt(2, IdAlumno);
            ResultSet rdo= ps.executeQuery();
            if (rdo.next()){
            Materia mat= new Materia();
            mat.setIdMateria(rdo.getInt("id_materia"));
            mat.setNombre(rdo.getString("nombre"));
            mat.setAnioMateria(rdo.getInt("año"));
            lista.add(mat);
         }
            else{
            JOptionPane.showMessageDialog(null, "El alumno curso todas las materias");
            }
           ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos "+ ex.getMessage());
        }
   
    return lista;
    }
    
    public List<Materia> obtenerMateriasNoCursadas(int idMateria){
        Materia materia = null;
        List <Materia> materias = new ArrayList();
        String sql="SELECT * FROM inscripcion "
                + "WHERE id_materia=? AND estado = 0";
        PreparedStatement ps=null;
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ResultSet rs = ps.executeQuery();
            MateriaData mData = new MateriaData();
            
            if(rs.next()){
                materia = new Materia();
                materia.setIdMateria(rs.getInt("id_materia"));
                materia.setNombre(mData.buscarMateria(idMateria).getNombre());
                materia.setAnioMateria(mData.buscarMateria(idMateria).getAnioMateria());
                materia.setActivo(true);
            }else{
                JOptionPane.showMessageDialog(null, "La materia no existe");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return materias;
    }
    
    public void borrarInscripcionPorAlumno(int idAlumno, int idMateria){
        try{
            String sql="UPDATE inscripcion SET estado = 0 "
                    + "WHERE id_materia = ? AND id_alumno = ?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ps.setInt(2, idAlumno);
            int fila = ps.executeUpdate();
            
            if(fila == 1){
                JOptionPane.showMessageDialog(null, "Se elimino la inscripcion");
            }
            ps.close();
        } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, "Error al conectarse a la tabla inscripciones "+ ex.getMessage());
        }
    }
    
    public void actualizarNota(int idAlumno, int idMateria, double nota){
        try{
            String sql="UPDATE inscripcion SET nota = ? WHERE id_materia = ? AND id_alumno = ?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idMateria);
            ps.setInt(3, idAlumno);
            int fila = ps.executeUpdate();
            
            if(fila == 1){
                JOptionPane.showMessageDialog(null, "Se actualizo la nota");
            }
            ps.close();
        } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, "Error al actualizar nota "+ ex.getMessage());
        }
    }
    
    public List<Alumno> obtenerAlumnoXMateria(int idMateria){
        Alumno alumno = null;
        List<Alumno> alumnos = new ArrayList();
        String sql="SELECT * FROM inscripcion "
                + "WHERE id_materia = ? AND estado = 1";
        PreparedStatement ps=null;
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ResultSet rs = ps.executeQuery();
            AlumnoData aData = new AlumnoData();
            
            if(rs.next()){
                alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("id_alumno"));
                alumno.setDni(aData.buscarAlumno(rs.getInt("id_alumno")).getDni());
                alumno.setNombre(aData.buscarAlumno(rs.getInt("id_alumno")).getNombre());
                alumno.setApellido(aData.buscarAlumno(rs.getInt("id_alumno")).getApellido());
                alumno.setFechaNac(aData.buscarAlumno(rs.getInt("id_alumno")).getFechaNac());
                alumno.setActivo(true);
            }else{
                JOptionPane.showMessageDialog(null, "No hay alumnos inscriptos en la materia");
            }
            ps.close();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error al acceder a base de datos "+ ex.getMessage());
        }
        return alumnos;
    }
    
}
