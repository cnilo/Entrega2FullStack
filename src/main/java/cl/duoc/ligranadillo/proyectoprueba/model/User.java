package cl.duoc.ligranadillo.proyectoprueba.model;

import lombok.Data;

@Data
public class User {
    private String id;
    private String username;
    private String password;
    private String email;
    private boolean validated;
}
