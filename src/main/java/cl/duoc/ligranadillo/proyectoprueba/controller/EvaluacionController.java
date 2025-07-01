package cl.duoc.ligranadillo.proyectoprueba.controller;

import cl.duoc.ligranadillo.proyectoprueba.model.Evaluacion;
import cl.duoc.ligranadillo.proyectoprueba.service.EvaluacionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/evaluaciones")
@Tag(name = "Evaluaciones", description = "Microservicio para gestión de evaluaciones")
public class EvaluacionController {

    private final EvaluacionService evaluacionService;

    @Autowired
    public EvaluacionController(EvaluacionService evaluacionService) {
        this.evaluacionService = evaluacionService;
    }

    @PostMapping("/crear")
    @Operation(summary = "Crear evaluación", description = "Registra una nueva evaluación")
    public ResponseEntity<Evaluacion> crearEvaluacion(@RequestBody Evaluacion evaluacion) {
        return ResponseEntity.status(HttpStatus.CREATED).body(evaluacionService.guardarEvaluacion(evaluacion));
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar evaluaciones", description = "Obtiene todas las evaluaciones registradas")
    public ResponseEntity<List<Evaluacion>> listarEvaluaciones() {
        return ResponseEntity.ok(evaluacionService.obtenerEvaluaciones());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener evaluación por ID", description = "Retorna una evaluación específica según su ID")
    public ResponseEntity<Evaluacion> obtenerEvaluacion(@PathVariable Long id) {
        return evaluacionService.obtenerEvaluacionPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar evaluación", description = "Actualiza una evaluación existente")
    public ResponseEntity<Evaluacion> actualizarEvaluacion(@PathVariable Long id, @RequestBody Evaluacion evaluacion) {
        return evaluacionService.actualizarEvaluacion(id, evaluacion)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar evaluación", description = "Elimina una evaluación por ID")
    public ResponseEntity<Void> eliminarEvaluacion(@PathVariable Long id) {
        boolean eliminado = evaluacionService.eliminarEvaluacion(id);
        return eliminado ? ResponseEntity.noContent().build()
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
