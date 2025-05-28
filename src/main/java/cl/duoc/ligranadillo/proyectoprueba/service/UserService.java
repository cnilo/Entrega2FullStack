package cl.duoc.ligranadillo.proyectoprueba.service;

import cl.duoc.ligranadillo.proyectoprueba.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserService {

    private final Map<String, User> users = new HashMap<>();
    private final Map<String, String> validationCodes = new HashMap<>();

    public RegisterUserResult registerUser(String username, String password, String email) {
        if (users.containsKey(username)) {
            throw new IllegalArgumentException("El usuario ya existe");
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setValidated(false);

        String userId = UUID.randomUUID().toString();
        user.setId(userId);
        users.put(username, user);

        // Generar un código de validación ficticio
        validationCodes.put(username, "1234");

        return new RegisterUserResult(userId);
    }

    public boolean validateLogin(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password) && user.isValidated();
    }

    public boolean validateUser(String username, String validationCode) {
        if (!validationCodes.containsKey(username)) return false;
        if (!validationCodes.get(username).equals(validationCode)) return false;

        User user = users.get(username);
        if (user == null) return false;

        user.setValidated(true);
        return true;
    }

    public User getUserByUsername(String username) {
        return users.get(username);
    }
}
