package institutojpa;

import controlador.CarrerasControlador;
import controlador.CursosControlador;
import controlador.EstudiantesControlador;
import controlador.ProfesoresControlador;
import entidades.Carreras;
import entidades.Cursos;
import entidades.Estudiantes;
import entidades.Profesores;

public class InstitutoJpa {
    public static void main(String[] args) {
        // Crear una instancia de CarrerasControlador
        CarrerasControlador carrerasControlador = new CarrerasControlador();
        // Crear una instancia de CursosControlador
        CursosControlador cursosControlador = new CursosControlador();
        // Crear una instancia de EstudiantesControlador
        EstudiantesControlador estudiantesControlador = new EstudiantesControlador();
        // Crear una instancia de ProfesoresControlador
        ProfesoresControlador profesoresControlador = new ProfesoresControlador();

        try {
            // Iniciar una transacción
            carrerasControlador.entityManager().getTransaction().begin();

            // Realizar la operación de inserción para Carreras
            Carreras rc = new Carreras();
            rc.setNombre("elmer");
            rc.setDescripcion("estssssss");
            rc.setDuracion(2);
            carrerasControlador.crear(rc);

            // Realizar la operación de inserción para Cursos
            Cursos curso = new Cursos();
            curso.setNombre("mate");
            curso.setCreditos(20);
            // Establecer los atributos del curso
            cursosControlador.crear(curso);

            // Realizar la operación de inserción para Estudiantes
            Estudiantes es = new Estudiantes();
            es.setNombre("alexander");
            es.setApellido("chahuaaaa");
            // Establecer la fecha de nacimiento
            es.setFechaNacimiento(new java.util.Date(112, 11, 12)); // 12-12-12
            estudiantesControlador.crear(es);

            // Realizar la operación de inserción para Profesores
            Profesores po = new Profesores();
            po.setNombre("jesus");
            po.setApellido("marques");
            po.setEspecialidad("abogado");
            po.setTelefono(91288384);
            profesoresControlador.eliminar(po);

            // Hacer commit de la transacción
            carrerasControlador.entityManager().getTransaction().commit();
        } catch (Exception e) {
            // En caso de error, hacer rollback de la transacción si hay una activa
            if (carrerasControlador.entityManager().getTransaction().isActive()) {
                carrerasControlador.entityManager().getTransaction().rollback();
            }
        } finally {
            // Cerrar los EntityManagers
            carrerasControlador.entityManager().close();
            cursosControlador.entityManager().close();
            estudiantesControlador.entityManager().close();
            profesoresControlador.entityManager().close();
        }
    }
}

