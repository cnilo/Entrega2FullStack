package cl.duoc.ligranadillo.proyectoprueba.controller;

import cl.duoc.ligranadillo.proyectoprueba.model.Evaluacion;
import cl.duoc.ligranadillo.proyectoprueba.service.EvaluacionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EvaluacionServiceTest {

    @Test
    public void testCrearEvaluacion() {
        EvaluacionService servicio = new EvaluacionService();
        Evaluacion eval = new Evaluacion(null, "Prueba 1", "cuestionario", 100, "curso1");
        Evaluacion resultado = servicio.crearEvaluacion(eval);
        Assertions.assertNotNull(resultado.getId());
    }

    @Test
    public void testListarEvaluacionesDevuelveAlMenosUna() {
        EvaluacionService servicio = new EvaluacionService();
        servicio.crearEvaluacion(new Evaluacion(null, "Prueba", "cuestionario", 100, "curso1"));
        Assertions.assertFalse(servicio.listarEvaluaciones().isEmpty());
    }

    @Test
    public void testCrearEvaluacionConCursoIdNulo() {
        EvaluacionService servicio = new EvaluacionService();
        Evaluacion eval = new Evaluacion(null, "Prueba", "cuestionario", 100, null);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            servicio.crearEvaluacion(eval);
        });
    }
}
