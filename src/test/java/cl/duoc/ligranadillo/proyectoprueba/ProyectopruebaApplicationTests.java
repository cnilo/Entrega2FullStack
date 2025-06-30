package cl.duoc.ligranadillo.proyectoprueba;

import cl.duoc.ligranadillo.proyectoprueba.model.Curso;
import cl.duoc.ligranadillo.proyectoprueba.service.CursoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;


@Service
public class CursoService {
    public String agregarCurso(String nombre) {
        return "Curso " + nombre + " creado";
    }
}

@SpringBootTest
public class CursoServiceTest {

    @Autowired private CursoService cursoService;

    @Test
    public void testAgregarCurso() {
        String resultado = cursoService.guardarCurso("SpringBoot");
        Assertions.assertEquals( "Curso Guardado exitosamente: Curso de Prueba", resultado);
    }

}
