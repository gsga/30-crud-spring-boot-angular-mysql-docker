package gga.tareas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import gga.tareas.dao.TareaDAO;
import gga.tareas.models.Tarea;

public class TareaServiceImpl implements TareaService {

    @Autowired
    private TareaDAO tareaDAO;

    @Override
    public List<Tarea> findAll() {
        return (List<Tarea>) tareaDAO.findAll();
    }

    @Override
    public Tarea save(Tarea tarea) {
        return tareaDAO.save(tarea);
    }

    //https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html#findById-ID-
    // Notar el tipo de retorno: Optional<Tarea>
    // Viene directamente de la plataforma.
    @Override
    public Optional<Tarea> findById(Integer id) {
        return tareaDAO.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        tareaDAO.deleteById(id);
    }

}
