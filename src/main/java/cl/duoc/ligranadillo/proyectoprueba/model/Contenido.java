package cl.duoc.ligranadillo.proyectoprueba.model;


import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
public class Contenido {
    private Long id;
    private String titulo;
    private String tipoArchivo;
    private String urlAlmacenamiento;
    // Otros campos y métodos según sea necesario

    // Constructor vacío
    public Contenido() {}

    // Constructor con parámetros
    public Contenido(Long id, String titulo, String tipoArchivo, String urlAlmacenamiento) {
        this.id = id;
        this.titulo = titulo;
        this.tipoArchivo = tipoArchivo;
        this.urlAlmacenamiento = urlAlmacenamiento;
    }

    // Getters y Setters
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String titulo() {return titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo;}

    public String getTipoArchivo() {return tipoArchivo;}
    public void setTipoArchivo(String tipoArchivo) {this.tipoArchivo = tipoArchivo;}

    public String getUrlAlmacenamiento() {return urlAlmacenamiento;}
    public void setUrlAlmacenamiento(String urlAlmacenamiento) {this.urlAlmacenamiento = urlAlmacenamiento;}
}