package cl.duoc.ligranadillo.proyectoprueba.controller.request;

public class ContenidoRequest {
    private String titulo;
    private String descripcion;
    private String tipo;
    private String url;

    public ContenidoRequest() {
    }

    public ContenidoRequest(String titulo, String descripcion, String tipo, String url) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.url = url;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
