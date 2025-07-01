package cl.duoc.ligranadillo.proyectoprueba.service;

import cl.duoc.ligranadillo.proyectoprueba.model.User;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserService {

    private final Map<String, User> users = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong();

    public User registerUser(User user) {
        if (existeUsuario(user.getUsername())) {
            throw new IllegalStateException("El username ya está registrado");
        }
        String id = String.valueOf(idGenerator.incrementAndGet());
        user.setId(id);
        user.setValidated(false);
        users.put(user.getUsername(), user);
        return user;
    }

    public Optional<User> login(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password) && user.isValidated()) {
            return Optional.of(user);
        }
        return Optional.empty();
    }

    public boolean validateUser(String username) {
        User user = users.get(username);
        if (user != null) {
            user.setValidated(true);
            return true;
        }
        return false;
    }

    public boolean existeUsuario(String username) {
        return users.containsKey(username);
    }
}
