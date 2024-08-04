package com.dp.main;


import com.dp.dao.EstudianteDAO;
import com.dp.control.Estudiante;

import java.util.Date;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
        EstudianteDAO estudianteDAO = new EstudianteDAO();

        // Crear un nuevo estudiante
        Estudiante nuevoEstudiante = new Estudiante();
        nuevoEstudiante.setNombre("Diego");
        nuevoEstudiante.setApellido("Paszkiewicz");
        nuevoEstudiante.setFechaNacimiento(new Date());
        nuevoEstudiante.setGenero("M");
        nuevoEstudiante.setDireccion("Altos de San Nicolas 6-17");
        nuevoEstudiante.setTelefono("3284-8786");
        nuevoEstudiante.setCorreoElectronico("diegoalejandro12822@gmail.com");
        nuevoEstudiante.setGrado("4rto");
        nuevoEstudiante.setFechaInscripcion(new Date());
        estudianteDAO.insertarEstudiante(nuevoEstudiante);


        Estudiante estudiante = estudianteDAO.obtenerEstudiante(1);
        if (estudiante != null) {
            System.out.println("Estudiante ID: " + estudiante.getId());
            System.out.println("Nombre: " + estudiante.getNombre());
            System.out.println("Apellido: " + estudiante.getApellido());
        } else {
            System.out.println("Estudiante no encontrado.");
        }

   
        List<Estudiante> estudiantes = estudianteDAO.obtenerTodosEstudiantes();
        for (Estudiante est : estudiantes) {
            System.out.println("ID: " + est.getId() + ", Nombre: " + est.getNombre() + ", Apellido: " + est.getApellido());
        }


        if (estudiante != null) {
            estudiante.setNombre("Diego Actualizado");
            estudianteDAO.actualizarEstudiante(estudiante);
        }

        //estudianteDAO.eliminarEstudiante(3);
    }

}
