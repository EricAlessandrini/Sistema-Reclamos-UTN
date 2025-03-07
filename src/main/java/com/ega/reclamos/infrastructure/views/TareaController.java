package com.ega.reclamos.infrastructure.views;

import com.ega.reclamos.application.input.InputPort;
import com.ega.reclamos.infrastructure.views.dto.TaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TareaController {

    private final InputPort inputPort;

    @GetMapping("/")
    public String listarTareas(Model model) {
        model.addAttribute("tasks", inputPort.findAll());
        return "index";
    }

    @GetMapping("/tarea/{id}")
    public String obtenerTarea(@PathVariable Long id, Model model) {
        model.addAttribute("task", inputPort.findById(id));
        return "detalle";
    }

    @GetMapping("/crear")
    public String mostrarFormulario(Model model) {
        model.addAttribute("task", new TaskDto());
        return "formulario";
    }

    @PostMapping("/guardar")
    public String guardarTarea(@ModelAttribute TaskDto taskDto) {
        inputPort.saveTask(taskDto);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        TaskDto taskDto = inputPort.findById(id);
        model.addAttribute("task", taskDto);
        return "formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarTarea(@PathVariable Long id) {
        inputPort.deleteTask(id);
        return "redirect:/";
    }
}
