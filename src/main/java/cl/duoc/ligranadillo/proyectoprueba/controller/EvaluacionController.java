package cl.duoc.ligranadillo.proyectoprueba.controller;

import cl.duoc.ligranadillo.proyectoprueba.model.Evaluacion;
import cl.duoc.ligranadillo.proyectoprueba.service.EvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v4/evaluaciones")
public class EvaluacionController {

    @Autowired
    private EvaluacionService evaluacionService;

    @PostMapping("/crear")
    public ResponseEntity<Evaluacion> crearEvaluacion(@RequestBody Evaluacion evaluacion) {
        return ResponseEntity.status(HttpStatus.CREATED).body(evaluacionService.guardarEvaluacion(evaluacion));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Evaluacion>> listarEvaluaciones() {
        return ResponseEntity.ok(evaluacionService.obtenerEvaluaciones());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evaluacion> obtenerEvaluacion(@PathVariable Long id) {
        Optional<Evaluacion> evaluacion = evaluacionService.obtenerEvaluacionPorId(id);
        return evaluacion.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evaluacion> actualizarEvaluacion(@PathVariable Long id, @RequestBody Evaluacion evaluacion) {
        Optional<Evaluacion> actualizado = evaluacionService.actualizarEvaluacion(id, evaluacion);
        return actualizado.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEvaluacion(@PathVariable Long id) {
        boolean eliminado = evaluacionService.eliminarEvaluacion(id);
        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}