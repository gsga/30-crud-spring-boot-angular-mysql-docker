package gga.backend.services;

// El paquete services expone los servicios que los clientes consumen.
// Solo se ocupa de eso. En particular, no se ocupa de la persistencia.

// TareaService no es una clase, sino una interfaz. Publica métodos, pero
// no implementa nada. Esto se llama interfaz contractual. Si vamos a
// organizar nuestra aplicación publicando en una o más APIs los
// servicios o microservicios que queremos que nuestros clientes consuman,
// esta interfaz es lo que vamos a dar a conocer a nuestros clientes.
// Todas las implementaciones están en la clase TareaServiceImpl.
// Están encapsuladas, ocultas a los clientes. En realidad, a los
// clientes no deberían interesarles los detalles de la implementación,
// en tanto en cuanto cumplamos a rajatabla con lo que la interfaz contractual
// promete.

// Los nombres de los métodos que expone son iguales a los de la
// inerfaz CrudRepository. Pero no la extiende. 
// No estoy seguro en este momento, pero pienso que si esta interfaz
// extendiera CrudRepository, terminaríamos inyectando una dependencia
// que no necesitamos en este paquete, porque está en el paquete 
// repositories. 
// El instinto me dice que es mejor usar los mismos nombres con las 
// mismas signaturas. Pero no es obligatorio.

import java.util.List;
import java.util.Optional;

import gga.backend.models.Tarea;

public interface TareaService {

    public void deleteById(Long id);

    public List<Tarea> findAll();

    public Tarea save(Tarea tarea);

    public Optional<Tarea> findById(Long id);

}
