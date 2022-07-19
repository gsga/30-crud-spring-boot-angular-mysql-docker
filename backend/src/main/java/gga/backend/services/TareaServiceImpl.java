package gga.backend.services;

/* La clase TareaServiceImpl encapsula la implementación de todo lo que
 * promete la interfaz contractual TareaService.
 * Esta clase no es para ser mostrada a los consumidores de los servicios.
 * Podemos modificar a gusto esta clase, y siempre que nuestra implementación
 * cumpla lo que promete la interfaz contractual, nadie puede objetar, porque no 
 * vamos a incurrir en ninguna incompatibilidad.
 */
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gga.backend.models.Tarea;
import gga.backend.repositories.TareaRepository;

// @Service Annotation
// https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Service.html
// Indicates that an annotated class is a "Service":
// "an operation offered as an interface that stands
// alone in the model, with no encapsulated state."
// Originally defined by Domain-Driven Design (Evans, 2003).
// This annotation serves as a specialization of @Component,
// allowing for implementation classes to be autodetected
// through classpath scanning.
// In an application, the business logic resides within the service
// layer so we use the @Service Annotation to indicate that a 
// class belongs to that layer. It is also a specialization 
// of @Component Annotation like the @Repository Annotation. 
// One most important thing about the @Service Annotation 
// is it can be applied only to classes. It is used to mark 
// the class as a service provider. So overall @Service 
// annotation is used with classes that provide some business 
// functionalities. Spring context will autodetect these 
// lasses when annotation-based configuration and classpath 
// scanning is used.
// En resumen, esta clase está anotada con @Service porque
// esta clase, de hecho, expone los servicios, entendidos
// como una operación que un cliente consume, y además
// esta clase no tiene un estado encapsulado.
// Notar que la única propiedad que tiene es tareaRepository,
// que está anotada como @Autowired
@Service
public class TareaServiceImpl implements TareaService {

    // tareaRepository es de tipo TareaRepository, que es una interfaz.
    // TareaRepository a su vez extiende la interfaz CrudRepository.
    // La interfaz CrudRepository es genérica. En nuestro caso, la declaración es
    // CrudRepository<Tarea, Long>. Tarea es el tipo sobre el que implementa la
    // programación genérica, y Long es el tipo que se requiere para el campo Id.
    // Esto significa que el repositorio almacena objetos (instancias)
    // del tipo Tarea.
    // La anotación @Autowired está justo antes de la declaración de
    // tareaRepository, de modo que afecta solo a este campo.
    // Esto es una inyección de dependencia.
    // Esta anotación elimina la necesidad de implementar
    // constructores, getters y setters. No necesitamos hacerlo
    // nosotros, sino que la plataforma lo hace automáticamente.
    // O sea que el campo tareaRepository tendrá automáticamente implementados
    // todos los métodos que necesite, que son los de CrudRepository.
    // https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html#findAll--
    // El método findAll() retorna todas las instancias de la clase Tarea
    // contenidas en el repositorio. O sea, trae todos los registros de la
    // tabla asociada con el tipo Tarea. Pero los retorna de un modo preciso,
    // como un objeto de tipo Iterable<Tarea>.
    // https://docs.oracle.com/javase/8/docs/api/java/lang/Iterable.html?is-external=true
    // La interfaz Iterable hace lo que su nombre indica.
    // List extiende Collection, y Collection extiende Iterable.
    // Por eso podemos castear Iterable<Tarea> en List<Tarea>
    //

    @Autowired
    private TareaRepository tareaRepository;

    @Override
    @Transactional(readOnly = false)
    public void deleteById(Long id) {
        tareaRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Tarea> findAll() {
        return (List<Tarea>) tareaRepository.findAll();
    }

    // https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html#findById-ID-
    // Notar el tipo de retorno: Optional<Tarea>
    // Viene directamente de la plataforma.
    @Override
    @Transactional(readOnly = true)
    public Optional<Tarea> findById(Long id) {
        return tareaRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = false)
    public Tarea save(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

}
