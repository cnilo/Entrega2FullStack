package cl.duoc.ligranadillo.proyectoprueba.service;

import cl.duoc.ligranadillo.proyectoprueba.model.Curso;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CursoService {

    private final Map<Long, Curso> cursos = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong();

    public Curso guardarCurso(Curso curso) {
        Long id = idGenerator.incrementAndGet();
        curso.setId(id);
        cursos.put(id, curso);
        return curso;
    }

    public List<Curso> obtenerCursos() {
        return new ArrayList<>(cursos.values());
    }

    public Optional<Curso> obtenerCursoPorId(Long id) {
        return Optional.ofNullable(cursos.get(id));
    }

    public Optional<Curso> actualizarCurso(Long id, Curso cursoActualizado) {
        if (cursos.containsKey(id)) {
            cursoActualizado.setId(id);
            cursos.put(id, cursoActualizado);
            return Optional.of(cursoActualizado);
        }
        return Optional.empty();
    }

    public boolean eliminarCurso(Long id) {
        return cursos.remove(id) != null;
    }
}
