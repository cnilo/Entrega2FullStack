package cl.duoc.ligranadillo.proyectoprueba.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Usuario registrado en el sistema")
public class User {

    @Schema(description = "ID único del usuario (podría ser UUID)", example = "a1b2c3")
    private String id;

    @Schema(description = "Nombre de usuario para login", example = "cristobal")
    private String username;

    @Schema(description = "Contraseña del usuario", example = "pass123")
    private String password;

    @Schema(description = "Email del usuario", example = "email@test.com")
    private String email;

    @Schema(description = "Indica si el usuario ya validó su cuenta", example = "false")
    private boolean validated;
}
