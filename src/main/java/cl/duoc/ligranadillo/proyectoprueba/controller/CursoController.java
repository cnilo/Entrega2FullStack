package cl.duoc.ligranadillo.proyectoprueba.controller;

import cl.duoc.ligranadillo.proyectoprueba.model.Curso;
import cl.duoc.ligranadillo.proyectoprueba.service.CursoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/cursos")
@Tag(name = "Cursos", description = "Microservicio para gestión de cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping("/crear")
    @Operation(summary = "Crear curso", description = "Registra un nuevo curso con sus atributos")
    public ResponseEntity<Curso> crearCurso(@RequestBody Curso curso) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cursoService.guardarCurso(curso));
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar cursos", description = "Obtiene todos los cursos registrados")
    public ResponseEntity<List<Curso>> listarCursos() {
        return ResponseEntity.ok(cursoService.obtenerCursos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener curso por ID", description = "Retorna un curso específico según su ID")
    public ResponseEntity<Curso> obtenerCurso(@PathVariable Long id) {
        return cursoService.obtenerCursoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar curso", description = "Actualiza un curso existente según su ID")
    public ResponseEntity<Curso> actualizarCurso(@PathVariable Long id, @RequestBody Curso curso) {
        return cursoService.actualizarCurso(id, curso)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar curso", description = "Elimina un curso existente por su ID")
    public ResponseEntity<Void> eliminarCurso(@PathVariable Long id) {
        boolean eliminado = cursoService.eliminarCurso(id);
        return eliminado ? ResponseEntity.noContent().build()
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
