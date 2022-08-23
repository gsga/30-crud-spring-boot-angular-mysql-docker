package gga.backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gga.backend.models.Tarea;
import gga.backend.services.TareaService;

// Annotation @Component
// https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Component.html
// Indicates that an annotated class is a "component".
// Such classes are considered as candidates for
// auto-detection when using annotation-based
// configuration and classpath scanning.

// Factory pattern, o patrón factoría.
// https://en.wikipedia.org/wiki/Factory_method_pattern

// Spring usa el patrón factoría. Para marcar una interfaz o clase como
// factoría,
// se usa alguna de las anotaciones @Controller, @Service, @Repository o
// @RestController.

// Annotation @Controller
// https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Controller.html
// Indicates that an annotated class is a 
// "Controller" (e.g. a web controller).
// This annotation serves as a specialization 
// of @Component, allowing for implementation 
// classes to be autodetected through classpath 
// scanning. It is typically used in combination 
// with annotated handler methods based on 
// the @RequestMapping annotation.

// Annotation @Service
// https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Service.html
// Indicates that an annotated class is a "Service":
// "an operation offered as an interface that stands
// alone in the model, with no encapsulated state."
// Originally defined by Domain-Driven Design (Evans, 2003).
// This annotation serves as a specialization of @Component,
// allowing for implementation classes to be autodetected
// through classpath scanning.

// Annotation @Repository
// https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Repository.html
// Indicates that an annotated class is a "Repository":
// "a mechanism for encapsulating storage, retrieval,
// and search behavior which emulates a collection of objects".
// Originally defined by Domain-Driven Design (Evans, 2003).
// Teams implementing traditional Java EE patterns such as
// "Data Access Object" may also apply this stereotype to
// DAO classes, though care should be taken to understand
// the distinction between Data Access Object and
// DDD-style repositories before doing so.
// A class thus annotated is eligible for Spring
// DataAccessException translation when used in conjunction
// with a PersistenceExceptionTranslationPostProcessor.
// The annotated class is also clarified as to its role
// in the overall application architecture for the purpose
// of tooling, aspects, etc.
// As of Spring 2.5, this annotation also serves as a
// specialization of @Component, allowing for implementation
// classes to be autodetected through classpath scanning.

// Annotation @RestController
// https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/RestController.html
// A convenience annotation that is itself annotated
// with @Controller and @ResponseBody.
// Types that carry this annotation are treated as
// controllers where @RequestMapping methods
// assume @ResponseBody semantics by default.

// Annotation @ResponseBody
// https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/ResponseBody.html
// Annotation that indicates a method return value 
// should be bound to the web response body. 
// Supported for annotated handler methods.
// As of version 4.0 this annotation can also be 
// added on the type level in which case it is 
// inherited and does not need to be added 
// on the method level.
@RestController
// Vamos a tener un frontend en Angular. Los requests de
// ese frontend vendrán desde el puerto :4200.
// Al llegar al puerto :8080 serán vistos como provenientes
// de otro dominio. Y vamos a tener problemas con CORS.
// Para prevenir esto, tenemos que indicar los orígenes
// de los cuales queremos recibir requests.
// https://www.baeldung.com/spring-cors
// @CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")

// Annotation @RequestMapping
// https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/RequestMapping.html
// Annotation for mapping web requests onto methods
// in request-handling classes with flexible
// method signatures.
// Both Spring MVC and Spring WebFlux support
// this annotation through a RequestMappingHandlerMapping
// and RequestMappingHandlerAdapter in their
// respective modules and package structure. For the
// exact list of supported handler method arguments
// and return types in each, please use the reference
// documentation links below:
// Spring MVC Method Arguments and Return Values
// Spring WebFlux Method Arguments and Return Values
// Note: This annotation can be used both at the class
// and at the method level. In most cases, at the method
// level applications will prefer to use one of the HTTP
// method specific variants @GetMapping, @PostMapping,
// @PutMapping, @DeleteMapping, or @PatchMapping.
// La URL que vaya en la anotación habrá que agregarla detrás
// del puerto :8080 en todas las llamadas a esta aplicación.
// Por ejemplo @RequestMapping("/asdf")
// resultaría en lo siguiente:
// localhost:8080/asdf.... y detrás de esto habría que
// agregar el resto de la URL para ser RESTful.
// En este caso, queda como localhost:8080/api

@RequestMapping("/api")
public class TareaController {
    // Annotation @Autowired
    // https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/annotation/Autowired.html
    // Marks a constructor, field, setter method, or config
    // method as to be autowired by Spring's dependency
    // injection facilities.

    // Una vez que los objetos estan creados, la anotación
    // Spring @Autowired se encarga de construir las
    // ligazones entre los distintos elementos.
    @Autowired
    private TareaService tareaService;

    @GetMapping("/tareas")
    public List<Tarea> listar() {
        return tareaService.findAll();
    }

    @PostMapping("/tareas")
    public Tarea guardar(@RequestBody Tarea tarea) {
        return tareaService.save(tarea);
    }

    @GetMapping("/tareas/{id}")
    public Optional<Tarea> findByID(@PathVariable Long id) {
        return tareaService.findById(id);
    }

    @PutMapping("/tareas/{id}")
    public Tarea modificar(@RequestBody Tarea tarea, @PathVariable Long id) {
        Tarea tareaActual = tareaService.findById(id).get();
        tareaActual.setTarea(tarea.getTarea());
        tareaActual.setFinalizado(tarea.isFinalizado());
        return tareaService.save(tareaActual);
    }

    @DeleteMapping("/tareas/{id}")
    public void eliminar(@PathVariable Long id) {
        tareaService.deleteById(id);
    }
}
