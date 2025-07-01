package cl.duoc.ligranadillo.proyectoprueba.controller;


import cl.duoc.ligranadillo.proyectoprueba.model.Contenido;
import cl.duoc.ligranadillo.proyectoprueba.service.ContenidoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class ContenidoServiceTest {

    @Test
    public void testAgregarContenidoExitoso() {
        ContenidoService servicio = new ContenidoService();
        Contenido contenido = new Contenido(null, "Video Java", "Introducción", "video", "http://...");
        Contenido creado = servicio.crearContenido(contenido);
        Assertions.assertNotNull(creado.getId());
        Assertions.assertEquals("Video Java", creado.getTitulo());
    }


    @Test
    public void testListarContenidosNoVacio() {
        ContenidoService servicio = new ContenidoService();
        servicio.crearContenido(new Contenido(null,"Java", "Intro", "video", "url"));
        Assertions.assertFalse(servicio.listarContenidos().isEmpty());
    }

    @Test
    public void testAgregarContenidoDuplicado() {
        ContenidoService servicio = new ContenidoService();
        Contenido contenido = new Contenido(null, "Java", "Intro", "video", "url");
        servicio.crearContenido(contenido);
        Assertions.assertThrows(IllegalStateException.class, () -> {
            servicio.crearContenido(contenido);
        });
    }
    @Test
    public void testObtenerContenidoPorIdInexistente() {
        ContenidoService servicio = new ContenidoService();
        Optional<Contenido> contenido = servicio.obtenerContenidoPorId(1000L);
        Assertions.assertTrue(contenido.isEmpty());
    }

    @Test
    public void testListarContenidosDespuesDeEliminar() {
        ContenidoService servicio = new ContenidoService();
        Contenido c1 = servicio.crearContenido(new Contenido(null, "Video Java", "Intro", "video", "http://..."));
        servicio.eliminarContenido(c1.getId());
        Assertions.assertTrue(servicio.listarContenidos().isEmpty());
    }

}