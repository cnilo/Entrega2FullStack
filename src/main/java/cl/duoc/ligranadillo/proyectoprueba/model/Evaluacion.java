package cl.duoc.ligranadillo.proyectoprueba.model;

import lombok.Data;

@Data
public class Evaluacion {
    private Long id;
    private String titulo;
    private String tipo; // cuestionario, tarea, etc.
    private int puntajeMaximo;
    private String cursoId;
}
