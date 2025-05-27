package cl.duoc.ligranadillo.proyectoprueba.controller.response;

import cl.duoc.ligranadillo.proyectoprueba.controller.request.ContenidoRequest;
import cl.duoc.ligranadillo.proyectoprueba.controller.request.LoginRequest;
import cl.duoc.ligranadillo.proyectoprueba.controller.request.RegisterRequest;
import cl.duoc.ligranadillo.proyectoprueba.model.Curso;
import cl.duoc.ligranadillo.proyectoprueba.model.Evaluacion;
import cl.duoc.ligranadillo.proyectoprueba.service.RegisterUserResult;
import cl.duoc.ligranadillo.proyectoprueba.service.UserService;
import com.sun.net.httpserver.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//Gestion de usuarios
// Crear usuarios, autenticar, actualizar perfiles.
@RestController
@RequestMapping ("/api/v1/users")
public class UserController {
    @Autowired private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@Validated @RequestBody RegisterRequest request) {
        RegisterUserResult result = userService.registerUser(request.getUsername(), request.getPassword(), request.getEmail());

        RegisterResponse response = new RegisterResponse(result.getUserId(), "Usuario Registrado Exitosamente");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);//201 Created
    }


    @PostMapping ("/login")
    public ResponseEntity<LoginResponse> login(@Validated @RequestBody LoginRequest request) {
        boolean validated = userService.validateLogin(request.getUsername(), request.getPassword());

        if (validated) {
            return ResponseEntity.ok(new LoginResponse("Login successful"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new LoginResponse("Invalid username or password"));
        }
    }


    @PatchMapping("/validate/{username}")
    public ResponseEntity<LoginResponse> validate(@PathVariable String username, @Validated RegisterRequest request) {
        boolean validated = userService.validateUser(username, request.getValidationCode());

        if (validated) {
            return ResponseEntity.ok(new LoginResponse("Usuario Validado Exitosamente"));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new LoginResponse("Error validating user"));
        }
    }
}


@RestController
@RequestMapping("/api/v2/cursos")
public class CursoController {
    @Autowired private UserService cursoService;

    @PostMapping("/crear")
    public ResponseEntity<Curso> crearCurso(@RequestBody Curso curso) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.guardarCurso(curso));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Curso>> listarCursos() {
        return ResponseEntity.ok(cursoService.obtenerCursos());
    }
}

@RestController
@RequestMapping("/api/v3/contenido")
public class ContenidoController {

    @Autowired private UserService contenidoService;

    @PostMapping("/subir")
    public ResponseEntity<ContenidoRequest> subirContenido(@RequestBody ContenidoRequest contenidoRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contenidoService.guardarContenido(contenidoRequest));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ContenidoRequest>> listarContenidos() {
        return ResponseEntity.ok(contenidoService.obtenerContenidos());
    }
}

@RestController
@RequestMapping("/api/v4/evaluaciones")
public class EvaluacionController {

    @Autowired private UserService evaluacionService;

    @PostMapping("/crear")
    public ResponseEntity<Evaluacion> crearEvaluacion(@RequestBody Evaluacion evaluacion) {
        return ResponseEntity.status(HttpStatus.CREATED).body(evaluacionService.guardarEvaluacion(evaluacion));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Evaluacion>> listarEvaluaciones() {
        return ResponseEntity.ok(evaluacionService.obtenerEvaluaciones());
    }
}