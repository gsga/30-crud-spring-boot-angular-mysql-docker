package gga.tareas.service;

import java.util.List;
import java.util.Optional;

import gga.tareas.models.Tarea;

public interface TareaService {

    public List<Tarea> findAll();

    public Tarea save(Tarea tarea);

    public Optional<Tarea> findById(Integer id);

    public void deleteById(Integer id);
}
