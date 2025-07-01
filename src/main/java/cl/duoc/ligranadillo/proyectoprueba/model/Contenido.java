package cl.duoc.ligranadillo.proyectoprueba.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Contenido multimedia o documentos que componen las clases del curso")
public class Contenido {

    @Schema(description = "ID único del contenido", example = "10")
    private Long id;

    @Schema(description = "Título del contenido", example = "Introducción a Java")
    private String titulo;

    @Schema(description = "Tipo de contenido (video, pdf, etc.)", example = "video")
    private String tipo;

    @Schema(description = "URL donde se aloja el recurso", example = "https://example.com/video.mp4")
    private String url;

    @Schema(description = "Descripción breve del contenido", example = "Video explicativo de la instalación de JDK")
    private String descripcion;
}
