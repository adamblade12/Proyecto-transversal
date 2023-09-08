/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_transversal.AccesoDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import proyecto_transversal.Entidades.Alumno;

/**
 *
 * @author pablo
 */
public class AlumnoData {

    private Connection conexion;

    public AlumnoData() {
        conexion = Conexion.getConexion();
    }

    public void guardarAlumno(Alumno alumno) {
        String sql = "INSERT INTO alumno (dni, apellido, nombre, fecha_nacimiento, estado) VALUES (?,?,?,?,?)";
        PreparedStatement ps;

        try {
            ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setBoolean(5, alumno.isActivo());
            int rdo = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alumno añadido con exito. Filas afectadas= " + rdo);
            ps.close();
        
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al agregar alumno" + ex.getMessage());
    }

    }

    public Alumno buscarAlumno(int id) {
        String sql = "SELECT dni, apellido, nombre, fecha_nacimiento FROM alumno WHERE id_alumno=? AND estado=1";
        PreparedStatement ps;
        Alumno alumno = null;//si no lo inicializamos acá tira error al retornar
        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rdo = ps.executeQuery();
            if (rdo.next()) {//creamos un alumno en java y guardamos sus datos
                alumno = new Alumno();
                alumno.setIdAlumno(id);
                alumno.setApellido(rdo.getString("apellido"));
                alumno.setNombre(rdo.getString("nombre"));
                alumno.setDni(rdo.getInt("dni"));
                alumno.setFechaNac(rdo.getDate("fecha_nacimiento").toLocalDate());
                alumno.setActivo(true);

            } else {
                JOptionPane.showMessageDialog(null, "El alumno con Id= " + id + " no existe");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar alumno" + ex.getMessage());
        }

        return alumno;

    }

    public Alumno buscarAlumnoPorDni(int dni) {
        String sql = "SELECT dni, apellido, nombre, fecha_nacimiento FROM alumno WHERE dni=? AND estado=1";
        PreparedStatement ps;
        Alumno alumno = null;
        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rdo = ps.executeQuery();
            if (rdo.next()) {//creamos un alumno en java y guardamos sus datos
                alumno = new Alumno();
                alumno.setIdAlumno(rdo.getInt("id_alumno"));
                alumno.setApellido(rdo.getString("apellido"));
                alumno.setNombre(rdo.getString("nombre"));
                alumno.setDni(dni);
                alumno.setFechaNac(rdo.getDate("fecha_nacimiento").toLocalDate());
                alumno.setActivo(true);

            } else {
                JOptionPane.showMessageDialog(null, "El alumno con DNI= " + dni + " no existe");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar alumno" + ex.getMessage());
        }

        return alumno;

    }

    public List<Alumno> listarAlumnos() {
        List<Alumno> lista = new ArrayList<>();
        String sql = "SELECT * FROM alumno WHERE estado=1";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rdo = ps.executeQuery();
            while (rdo.next()) {
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rdo.getInt("id_alumno"));
                alumno.setDni(rdo.getInt("dni"));
                alumno.setApellido(rdo.getString("apellido"));
                alumno.setNombre(rdo.getString("nombre"));
                alumno.setFechaNac(rdo.getDate("fecha_nacimiento").toLocalDate());
                alumno.setActivo(true);
                lista.add(alumno);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener lista de alumnos");
        }
        return lista;
    }
    
    public void modificarAlumno(Alumno alumno){
    String sql= "UPDATE alumno SET dni= ?, apellido= ?, nombre= ?, fecha_nacimiento= ?  WHERE id_alumno=?";
        try {
            PreparedStatement ps= conexion.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setInt(5, alumno.getIdAlumno());
            int resultado= ps.executeUpdate();
            if(resultado==1){//encontro el id correspondiente al alumno y modifico todo
            JOptionPane.showMessageDialog(null, "Registro del alumno modificado con exito");
            }
            else{
            JOptionPane.showMessageDialog(null, "No existe alumno con ese Id");
            }
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno "+ ex.getMessage());
        }
    }
    
    public void eliminarAlumno(int id){
    String sql= "UPDATE alumno SET estado=0 WHERE id_alumno= ?";
        try {
            PreparedStatement ps= conexion.prepareStatement(sql);
            ps.setInt(1, id);
            int rdo= ps.executeUpdate();
            if(rdo==1){
            JOptionPane.showMessageDialog(null, "Alumno eliminado");
            }
            else{
            JOptionPane.showMessageDialog(null, "El alumno con ese id no existe");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno "+ ex.getMessage());
        }
    }
    
    }


