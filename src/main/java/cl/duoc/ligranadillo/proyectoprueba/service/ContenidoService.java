package cl.duoc.ligranadillo.proyectoprueba.service;

import cl.duoc.ligranadillo.proyectoprueba.model.Contenido;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;


@Service
public class ContenidoService {

    private final Map<Long, Contenido> contenidos = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong();

    public Contenido crearContenido(Contenido contenido) {
        if (existeContenidoPorTitulo(contenido.getTitulo())) {
            throw new IllegalStateException("Ya existe un contenido con ese título");
        }
        return guardarContenido(contenido);
    }

    private Contenido guardarContenido(Contenido contenido) {
        Long id = idGenerator.incrementAndGet();
        contenido.setId(id);
        contenidos.put(id, contenido);
        return contenido;
    }

    public List<Contenido> listarContenidos() {
        return new ArrayList<>(contenidos.values());
    }

    private boolean existeContenidoPorTitulo(String titulo) {
        return contenidos.values().stream()
                .anyMatch(c -> c.getTitulo().equalsIgnoreCase(titulo));
    }

    public Optional<Contenido> obtenerContenidoPorId(Long id) {
        return Optional.ofNullable(contenidos.get(id));
    }

    public Optional<Contenido> actualizarContenido(Long id, Contenido contenidoActualizado) {
        if (contenidos.containsKey(id)) {
            contenidoActualizado.setId(id);
            contenidos.put(id, contenidoActualizado);
            return Optional.of(contenidoActualizado);
        }
        return Optional.empty();
    }

    public boolean eliminarContenido(Long id) {
        return contenidos.remove(id) != null;
    }
}
