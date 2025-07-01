package cl.duoc.ligranadillo.proyectoprueba.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Evaluación o prueba asignada a un curso")
public class Evaluacion {

    @Schema(description = "ID único de la evaluación", example = "5")
    private Long id;

    @Schema(description = "Título de la evaluación", example = "Prueba Parcial Java")
    private String titulo;

    @Schema(description = "Tipo de evaluación (cuestionario, tarea, etc.)", example = "cuestionario")
    private String tipo;

    @Schema(description = "Puntaje máximo posible", example = "100")
    private int puntajeMaximo;

    @Schema(description = "ID del curso al que pertenece la evaluación", example = "1")
    private String cursoId;
}
