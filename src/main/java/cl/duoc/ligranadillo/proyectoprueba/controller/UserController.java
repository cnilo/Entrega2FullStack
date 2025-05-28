package cl.duoc.ligranadillo.proyectoprueba.controller;

import cl.duoc.ligranadillo.proyectoprueba.controller.request.LoginRequest;
import cl.duoc.ligranadillo.proyectoprueba.controller.request.RegisterRequest;
import cl.duoc.ligranadillo.proyectoprueba.controller.response.LoginResponse;
import cl.duoc.ligranadillo.proyectoprueba.controller.response.RegisterResponse;
import cl.duoc.ligranadillo.proyectoprueba.service.RegisterUserResult;
import cl.duoc.ligranadillo.proyectoprueba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@Validated @RequestBody RegisterRequest request) {
        RegisterUserResult result = userService.registerUser(request.getUsername(), request.getPassword(), request.getEmail());
        RegisterResponse response = new RegisterResponse(result.getUserId(), "Usuario Registrado Exitosamente");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Validated @RequestBody LoginRequest request) {
        boolean validated = userService.validateLogin(request.getUsername(), request.getPassword());
        if (validated) {
            return ResponseEntity.ok(new LoginResponse("Login exitoso"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginResponse("Usuario o contraseña inválidos"));
        }
    }

    @PatchMapping("/validate/{username}")
    public ResponseEntity<LoginResponse> validate(@PathVariable String username, @Validated @RequestBody RegisterRequest request) {
        boolean validated = userService.validateUser(username, request.getValidationCode());
        if (validated) {
            return ResponseEntity.ok(new LoginResponse("Usuario validado exitosamente"));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new LoginResponse("Error al validar el usuario"));
        }
    }
}
