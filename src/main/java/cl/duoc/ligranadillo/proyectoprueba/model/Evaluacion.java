package cl.duoc.ligranadillo.proyectoprueba.model;


import lombok.Data;


@Data
public class Evaluacion {
    private Long id;
    private String titulo;
    private String descripcion;
    private int puntajeMaximo; // en horas

    // Constructor vacío
    public Evaluacion() {}

    // Constructor con parámetros
    public Evaluacion(Long id, String titulo, String descripcion, int puntajeMaximo) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.puntajeMaximo = puntajeMaximo;
    }

    // Getters y Setters
    public Long getId() {return id;}
    public void setId(Long id) { this.id = id; }

    public String getTitulo() {return titulo;}
    public void setItulo(String titulo) {this.titulo = titulo;}

    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    public int getpuntajeMaximo() {return puntajeMaximo; }
    public void setDuracion(int puntajeMaximo) { this.puntajeMaximo = puntajeMaximo; }
}