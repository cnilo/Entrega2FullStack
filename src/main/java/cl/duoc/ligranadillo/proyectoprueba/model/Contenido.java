package cl.duoc.ligranadillo.proyectoprueba.model;

import lombok.Data;

@Data
public class Contenido {
    private Long id;
    private String titulo;
    private String tipo; // video, texto, pdf, etc.
    private String url;
    private String descripcion;
}
