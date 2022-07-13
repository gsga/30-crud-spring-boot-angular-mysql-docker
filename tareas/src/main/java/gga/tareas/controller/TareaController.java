package gga.tareas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gga.tareas.models.Tarea;
import gga.tareas.service.TareaService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class TareaController {

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
    public Optional<Tarea> findByID(@PathVariable Integer id) {
        return tareaService.findById(id);
    }

    @PutMapping("/tareas/{id}")
    public Tarea modificar(@RequestBody Tarea tarea, @PathVariable Integer id) {
        Tarea tareaActual = tareaService.findById(id).get();
        tareaActual.setTarea(tarea.getTarea());
        tareaActual.setFinalizado(tarea.isFinalizado());
        return tareaService.save(tareaActual);
    }
}
