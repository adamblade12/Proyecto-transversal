/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_transversal.Entidades;

import java.time.LocalDate;

/**
 *
 * @author pablo
 */
public class Alumno {
    private int idAlumno;
    private String apellido;
    private String nombre;
    LocalDate fechaNac;
    boolean activo;

<<<<<<< HEAD
<<<<<<< HEAD
    public Alumno(int idAlumno,int dni, String apellido, String nombre, LocalDate fechaNac, boolean activo) {
        this.idAlumno = idAlumno;
        this.dni = dni;
=======
    public Alumno(int idAlumno, String apellido, String nombre, LocalDate fechaNac, boolean activo) {
        this.idAlumno = idAlumno;
>>>>>>> parent of cca2800 (Merge branch 'main' of https://github.com/adamblade12/Proyecto-transversal)
=======
    public Alumno(int idAlumno, String apellido, String nombre, LocalDate fechaNac, boolean activo) {
        this.idAlumno = idAlumno;
>>>>>>> parent of cca2800 (Merge branch 'main' of https://github.com/adamblade12/Proyecto-transversal)
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.activo = activo;
    }

<<<<<<< HEAD
<<<<<<< HEAD
    public Alumno(int dni, String apellido, String nombre, LocalDate fechaNac, boolean activo) {
        this.dni = dni;
=======
    public Alumno(String apellido, String nombre, LocalDate fechaNac, boolean activo) {
>>>>>>> parent of cca2800 (Merge branch 'main' of https://github.com/adamblade12/Proyecto-transversal)
=======
    public Alumno(String apellido, String nombre, LocalDate fechaNac, boolean activo) {
>>>>>>> parent of cca2800 (Merge branch 'main' of https://github.com/adamblade12/Proyecto-transversal)
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.activo = activo;
    }
    
    public Alumno(){}

<<<<<<< HEAD
<<<<<<< HEAD
    public int getIdAlumno() {
        return idAlumno;
    }
    
    public int getDni(){
        return dni;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }
    
    public void setDni(int dni){
        this.dni = dni;
    }
=======
    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }
>>>>>>> parent of cca2800 (Merge branch 'main' of https://github.com/adamblade12/Proyecto-transversal)
=======
    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }
>>>>>>> parent of cca2800 (Merge branch 'main' of https://github.com/adamblade12/Proyecto-transversal)

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> parent of cca2800 (Merge branch 'main' of https://github.com/adamblade12/Proyecto-transversal)
    
=======
>>>>>>> parent of cca2800 (Merge branch 'main' of https://github.com/adamblade12/Proyecto-transversal)
    
}
