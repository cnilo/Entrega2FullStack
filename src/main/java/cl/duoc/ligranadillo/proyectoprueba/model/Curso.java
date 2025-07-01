package cl.duoc.ligranadillo.proyectoprueba.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Entidad que representa un curso impartido por la plataforma")
public class Curso {

    @Schema(description = "ID único del curso", example = "1")
    private Long id;

    @Schema(description = "Nombre del curso", example = "Java Básico")
    private String nombre;

    @Schema(description = "Descripción del curso", example = "Curso introductorio a Java")
    private String descripcion;

    @Schema(description = "Categoría del curso", example = "Programación")
    private String categoria;

    @Schema(description = "Fecha de inicio del curso", example = "2025-07-01")
    private String fechaInicio;

    @Schema(description = "Fecha de término del curso", example = "2025-08-01")
    private String fechaFin;

    @Schema(description = "Nombre del instructor del curso", example = "Juan Pérez")
    private String instructor;
}
