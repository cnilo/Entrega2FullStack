package cl.duoc.ligranadillo.proyectoprueba.controller.request;

public class ContenidoRequest {
    private String titulo;
    private String descripcion;
    private String urlImagen;
    private String urlVideo;

    public ContenidoRequest() {
    }

    public ContenidoRequest(String titulo, String descripcion, String urlImagen, String urlVideo) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
        this.urlVideo = urlVideo;
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

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }
}
