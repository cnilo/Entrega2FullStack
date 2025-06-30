package cl.duoc.ligranadillo.proyectoprueba.controller;


import cl.duoc.ligranadillo.proyectoprueba.service.CursoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserServiceTest {

    @Test
    public void testRegistrarUsuario() {
        UserService userService = new UserService();
        String resultado = userService.registrar("usuario1", "correo@email.com");
        Assertions.assertTrue(resultado.contains("Registrado"));
    }

    @Test
    public void testListarUsuariosDevuelveListaNoVacia() {
        UserService userService = new UserService();
        userService.registrar("usuario1", "correo@email.com");
        Assertions.assertFalse(userService.listarUsuarios().isEmpty());
    }

    @Test
    public void testRegistrarUsuarioConNombreNulo() {
        UserService userService = new UserService();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.registrar(null, "correo@email.com");
        });
    }
}