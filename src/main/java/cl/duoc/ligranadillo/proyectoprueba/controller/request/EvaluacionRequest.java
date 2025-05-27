package cl.duoc.ligranadillo.proyectoprueba.controller.request;

public class EvaluacionRequest {
    private String idUsuario;
    private String idPregunta;
    private String respuesta;

    public EvaluacionRequest() {
    }

    public EvaluacionRequest(String idUsuario, String idPregunta, String respuesta) {
        this.idUsuario = idUsuario;
        this.idPregunta = idPregunta;
        this.respuesta = respuesta;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(String idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
