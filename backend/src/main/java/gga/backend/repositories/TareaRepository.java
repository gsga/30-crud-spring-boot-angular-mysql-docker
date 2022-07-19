package gga.backend.repositories;

import org.springframework.data.repository.CrudRepository;

import gga.backend.models.Tarea;

// El paquete repositories está pensado para la persistencia.
// Se ocupa de la tabla que representa a esta entidad en la
// base de datos. No ofrece ningún servicio. Eso tiene que
// ver con el principio de separación de responsabilidades.

// CrudRepository
// https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
// Interface for generic CRUD operations on a repository for a specific type.
// Publica los métodos count(), delete(), deleteAll(), deleteAllBiId(), deleteById(), existsById(), 
// findAll(), findAllById(), findById(), save() y saveAll().

// Vemos que TareaRepository es una interfaz. Como tal, no implementa ningún método.
// No publica ni métodos ni propiedades. Se limita
// a extender CrudRepository, que es también una interfaz: publica pero no implementa.
// En otras palabras, no hemos implementado ni métodos ni propiedades.
// La magia ocurre en la clase TareaServiceImpl, que tiene un campo de tipo
// TareaRepository, y ese campo tiene la anotación @Autowired. Esa anotación es la
// que se ocupa de la inyección de dependencias.
// La interfaz CrudRepository es genérica en el tipo Tarea. La clase Tarea está en el
// paquete models.
// Esto es un mecanismo de inyección de dependencias. La interfaz TareaRepository
// tiene inyectada la dependencia de la clase Tarea, gracias a esta
// declaración en el extends.
public interface TareaRepository extends CrudRepository<Tarea, Long> {

}
