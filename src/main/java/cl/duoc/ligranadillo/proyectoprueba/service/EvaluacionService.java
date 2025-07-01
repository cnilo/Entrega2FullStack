package cl.duoc.ligranadillo.proyectoprueba.service;

import cl.duoc.ligranadillo.proyectoprueba.model.Evaluacion;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class EvaluacionService {

    private final Map<Long, Evaluacion> evaluaciones = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong();

    public Evaluacion crearEvaluacion(Evaluacion evaluacion) {
        if (evaluacion.getCursoId() == null) {
            throw new IllegalArgumentException("cursoId no puede ser nulo");
        }
        return guardarEvaluacion(evaluacion);
    }

    private Evaluacion guardarEvaluacion(Evaluacion evaluacion) {
        Long id = idGenerator.incrementAndGet();
        evaluacion.setId(id);
        evaluaciones.put(id, evaluacion);
        return evaluacion;
    }

    public List<Evaluacion> listarEvaluaciones() {
        return new ArrayList<>(evaluaciones.values());
    }

    public Optional<Evaluacion> obtenerEvaluacionPorId(Long id) {
        return Optional.ofNullable(evaluaciones.get(id));
    }

    public Optional<Evaluacion> actualizarEvaluacion(Long id, Evaluacion evaluacionActualizada) {
        if (evaluaciones.containsKey(id)) {
            evaluacionActualizada.setId(id);
            evaluaciones.put(id, evaluacionActualizada);
            return Optional.of(evaluacionActualizada);
        }
        return Optional.empty();
    }

    public boolean eliminarEvaluacion(Long id) {
        return evaluaciones.remove(id) != null;
    }
}
