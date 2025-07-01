package cl.duoc.ligranadillo.proyectoprueba.controller;

import cl.duoc.ligranadillo.proyectoprueba.model.Contenido;
import cl.duoc.ligranadillo.proyectoprueba.service.ContenidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v3/contenidos")
@Tag(name = "Contenidos", description = "Microservicio para gestión de contenidos")
public class ContenidoController {

    @Autowired
    private ContenidoService contenidoService;

    @PostMapping("/crear")
    @Operation(summary = "Crear contenido", description = "Registra un nuevo contenido multimedia o recurso")
    public ResponseEntity<Contenido> crearContenido(@RequestBody Contenido contenido) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contenidoService.crearContenido(contenido));
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar contenidos", description = "Obtiene todos los contenidos registrados")
    public ResponseEntity<List<Contenido>> listarContenidos() {
        return ResponseEntity.ok(contenidoService.listarContenidos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener contenido por ID", description = "Retorna un contenido específico según su ID")
    public ResponseEntity<Contenido> obtenerContenido(@PathVariable Long id) {
        return contenidoService.obtenerContenidoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar contenido", description = "Actualiza un contenido existente según su ID")
    public ResponseEntity<Contenido> actualizarContenido(@PathVariable Long id, @RequestBody Contenido contenido) {
        return contenidoService.actualizarContenido(id, contenido)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar contenido", description = "Elimina un contenido existente por su ID")
    public ResponseEntity<Void> eliminarContenido(@PathVariable Long id) {
        boolean eliminado = contenidoService.eliminarContenido(id);
        return eliminado ? ResponseEntity.noContent().build()
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
