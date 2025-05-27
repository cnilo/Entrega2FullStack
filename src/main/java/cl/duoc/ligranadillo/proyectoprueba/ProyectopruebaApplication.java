package cl.duoc.ligranadillo.proyectoprueba;

import cl.duoc.ligranadillo.proyectoprueba.controller.response.LoginResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


    public class main{
        public static void main(String[] args) {
            System.out.println("Subiendo Repo!");
            System.out.println("FullStack!");
            System.out.println(" Ingenieria en Informatica!");
        }
    }



@SpringBootApplication
public class ProyectopruebaApplication {

    public static void main(String[] args) {SpringApplication.run(ProyectopruebaApplication.class, args);
    }

}

public LoginResponse authenticateUser(String username, String password) {
    boolean validated = validateLogin(username, password);
    return validated ? new LoginResponse("Login successful") : new LoginResponse("Invalid username or password");
}