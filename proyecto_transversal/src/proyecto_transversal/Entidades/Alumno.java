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
    private int dni;
    private String apellido;
    private String nombre;
    LocalDate fechaNac;
    boolean activo;

    public Alumno(int idAlumno, int dni, String apellido, String nombre, LocalDate fechaNac, boolean activo) {
        this.idAlumno = idAlumno;
        this.dni=dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.activo = activo;
    }

    public Alumno(int dni, String apellido, String nombre, LocalDate fechaNac, boolean activo) {
        this.dni= dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.activo = activo;
    }
    
    public Alumno(){}

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

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

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getIdAlumno() {
        return idAlumno;
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

    @Override
    public String toString() {
        return "Alumno{" + "\nidAlumno=" + idAlumno + ", dni=" + dni + ", apellido=" + apellido + ", nombre=" + nombre + ", fechaNac=" + fechaNac + ", activo=" + activo + '}';
    }
    
    
    
}
