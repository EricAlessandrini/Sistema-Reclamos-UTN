package com.ega.reclamos.application.services;

import com.ega.reclamos.application.input.InputPort;
import com.ega.reclamos.application.output.OutputPort;
import com.ega.reclamos.domain.exceptions.InvalidInputException;
import com.ega.reclamos.domain.models.Task;
import com.ega.reclamos.infrastructure.views.dto.TaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService implements InputPort {

    private final OutputPort outputPort;

    @Override
    public void saveTask(TaskDto taskDto) {
        Task task = Task.builder()
                .taskName(taskDto.getTaskName())
                .taskDescription(taskDto.getTaskDescription())
                .build();

        outputPort.saveTask(task);
    }

    @Override
    public TaskDto findById(Long id) {
        if(id == null) {
            throw new InvalidInputException("Id no puede ser nulo");
        }

        Task task = outputPort.findById(id);

        return TaskDto.builder()
                .id(task.getId())
                .taskName(task.getTaskName())
                .taskDescription(task.getTaskDescription())
                .build();
    }

    @Override
    public List<TaskDto> findAll() {
        return outputPort.findAll().stream()
                .map(task -> TaskDto.builder()
                        .id(task.getId())
                        .taskName(task.getTaskName())
                        .taskDescription(task.getTaskDescription())
                        .build())
                .toList();
    }

    @Override
    public void updateTask(Long id, TaskDto taskDto) {
        if(id == null) {
            throw new InvalidInputException("Id no puede ser nulo");
        }

        Task task = Task.builder()
                .taskName(taskDto.getTaskName())
                .taskDescription(taskDto.getTaskDescription())
                .build();

        outputPort.updateTask(id, task);
    }

    @Override
    public void deleteTask(Long id) {
        if(id == null) {
            throw new InvalidInputException("Id no puede ser nulo");
        }
        outputPort.deleteTask(id);
    }
}
