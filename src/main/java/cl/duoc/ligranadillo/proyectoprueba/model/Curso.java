package cl.duoc.ligranadillo.proyectoprueba.model;

import lombok.Data;

@Data
public class Curso {
    private Long id;
    private String nombre;
    private String descripcion;
    private String categoria;
    private String fechaInicio;
    private String fechaFin;
    private String instructor;
}