package cl.duoc.ligranadillo.proyectoprueba.controller;


import cl.duoc.ligranadillo.proyectoprueba.model.Contenido;
import cl.duoc.ligranadillo.proyectoprueba.service.ContenidoService;
import cl.duoc.ligranadillo.proyectoprueba.service.model.contenido;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContenidoServiceTest {

    @Test
    public void testAgregarContenidoExitoso() {
        ContenidoService servicio = new ContenidoService();
        Contenido contenido = new Contenido("Video Java", "Introducción", "video", "http://...");
        String respuesta = servicio.crearContenido(contenido);
        Assertions.assertTrue(respuesta.contains("agregado"));
    }

    @Test
    public void testListarContenidosNoVacio() {
        ContenidoService servicio = new ContenidoService();
        servicio.crearContenido(new Contenido("Java", "Intro", "video", "url"));
        Assertions.assertFalse(servicio.listarContenidos().isEmpty());
    }

    @Test
    public void testAgregarContenidoDuplicado() {
        ContenidoService servicio = new ContenidoService();
        Contenido contenido = new Contenido("Java", "Intro", "video", "url");
        servicio.crearContenido(contenido);
        Assertions.assertThrows(IllegalStateException.class, () -> {
            servicio.crearContenido(contenido);
        });
    }
}