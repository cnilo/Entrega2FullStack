package cl.duoc.ligranadillo.proyectoprueba.controller;

import cl.duoc.ligranadillo.proyectoprueba.model.User;
import cl.duoc.ligranadillo.proyectoprueba.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserServiceTest {

    @Test
    public void testRegisterUserExitoso() {
        UserService servicio = new UserService();
        User user = new User(null, "cristobal", "pass123", "email@test.com", false);
        User registrado = servicio.registerUser(user);
        Assertions.assertNotNull(registrado.getId());
        Assertions.assertFalse(registrado.isValidated());
    }

    @Test
    public void testRegisterUserDuplicado() {
        UserService servicio = new UserService();
        User user = new User(null, "cristobal", "pass123", "email@test.com", false);
        servicio.registerUser(user);
        Assertions.assertThrows(IllegalStateException.class, () -> {
            servicio.registerUser(new User(null, "cristobal", "otroPass", "email2@test.com", false));
        });
    }

    @Test
    public void testLoginSoloSiValidado() {
        UserService servicio = new UserService();
        User user = new User(null, "cristobal", "pass123", "email@test.com", false);
        servicio.registerUser(user);

        Assertions.assertTrue(servicio.login("cristobal", "pass123").isEmpty());

        servicio.validateUser("cristobal");
        Assertions.assertTrue(servicio.login("cristobal", "pass123").isPresent());
    }

    @Test
    public void testLoginPasswordIncorrecto() {
        UserService servicio = new UserService();
        User user = new User(null, "paula", "pass123", "mail@test.com", false);
        servicio.registerUser(user);
        servicio.validateUser("paula");

        Assertions.assertTrue(servicio.login("paula", "otraPass").isEmpty());
    }

    @Test
    public void testLoginAntesDeValidar() {
        UserService servicio = new UserService();
        User user = new User(null, "paula", "pass123", "mail@test.com", false);
        servicio.registerUser(user);

        Assertions.assertTrue(servicio.login("paula", "pass123").isEmpty());
    }

}
