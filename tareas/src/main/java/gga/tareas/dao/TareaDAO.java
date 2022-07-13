package gga.tareas.dao;

import org.springframework.data.repository.CrudRepository;

import gga.tareas.models.Tarea;

public interface TareaDAO extends CrudRepository<Tarea, Integer>{
    
}
