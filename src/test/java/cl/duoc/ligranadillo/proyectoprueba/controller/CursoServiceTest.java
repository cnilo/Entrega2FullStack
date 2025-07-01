package cl.duoc.ligranadillo.proyectoprueba.controller;

import cl.duoc.ligranadillo.proyectoprueba.model.Curso;
import cl.duoc.ligranadillo.proyectoprueba.service.CursoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class CursoServiceTest {

    @Test
    public void testCrearCursoExitoso() {
        CursoService servicio = new CursoService();
        Curso curso = new Curso(null, "Java Básico", "Intro a Java", "Programación", "2024-07-01", "2024-08-01", "Prof. Juan");
        Curso creado = servicio.crearCurso(curso);
        Assertions.assertNotNull(creado.getId());
    }

    @Test
    public void testListarCursosDevuelveAlMenosUno() {
        CursoService servicio = new CursoService();
        servicio.crearCurso(new Curso(null, "Python Básico", "Intro a Python", "Programación", "2024-07-01", "2024-08-01", "Prof. Ana"));
        Assertions.assertFalse(servicio.listarCursos().isEmpty());
    }

    @Test
    public void testCrearCursoDuplicado() {
        CursoService servicio = new CursoService();
        Curso curso = new Curso(null, "Spring Boot", "Intro a Spring", "Programación", "2024-07-01", "2024-08-01", "Prof. Carlos");
        servicio.crearCurso(curso);
        Assertions.assertThrows(IllegalStateException.class, () -> {
            servicio.crearCurso(curso);
        });
    }

    @Test
    public void testActualizarCurso() {
        CursoService servicio = new CursoService();
        Curso curso = new Curso(null, "Java", "Intro", "Dev", "2024-01", "2024-02", "Juan");
        Curso creado = servicio.crearCurso(curso);

        Curso actualizado = new Curso(null, "Java", "Avanzado", "Dev", "2024-01", "2024-03", "Juan");
        Optional<Curso> modificado = servicio.actualizarCurso(creado.getId(), actualizado);

        Assertions.assertTrue(modificado.isPresent());
        Assertions.assertEquals("Avanzado", modificado.get().getDescripcion());
        Assertions.assertEquals("2024-03", modificado.get().getFechaFin());
    }

    @Test
    public void testActualizarCursoNoExistente() {
        CursoService servicio = new CursoService();
        Curso curso = new Curso(null, "Java", "Intro", "Dev", "2024-01", "2024-02", "Juan");
        Optional<Curso> modificado = servicio.actualizarCurso(999L, curso);
        Assertions.assertTrue(modificado.isEmpty());
    }

    @Test
    public void testEliminarCurso() {
        CursoService servicio = new CursoService();
        Curso curso = new Curso(null, "Python", "Intro", "Dev", "2024-01", "2024-02", "Ana");
        Curso creado = servicio.crearCurso(curso);

        boolean eliminado = servicio.eliminarCurso(creado.getId());
        Assertions.assertTrue(eliminado);
        Assertions.assertTrue(servicio.listarCursos().isEmpty());
    }

}
