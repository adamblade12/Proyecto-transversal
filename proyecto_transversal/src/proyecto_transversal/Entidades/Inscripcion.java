/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_transversal.Entidades;

/**
 *
 * @author pablo
 */
public class Inscripcion {
    private int idInscripcion;
    private Alumno alumno;
    private Materia materia;
    private double nota;
    private boolean activo;

    public Inscripcion(int idInscripcion, Alumno alumno, Materia materia, double nota, boolean activo) {
        this.idInscripcion = idInscripcion;
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
        this.activo = activo;
    }

    public Inscripcion(Alumno alumno, Materia materia, double nota, boolean activo) {
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
        this.activo = activo;
    }
    
    public Inscripcion(){}

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
<<<<<<< HEAD
    
    public boolean isActivo(){
        return activo;
    }
=======
>>>>>>> parent of cca2800 (Merge branch 'main' of https://github.com/adamblade12/Proyecto-transversal)
    
    public void setActivo(boolean activo){
        this.activo = activo;
    }
}
