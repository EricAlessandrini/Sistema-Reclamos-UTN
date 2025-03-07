package com.ega.reclamos.infrastructure.persistences.dao;

import com.ega.reclamos.application.output.OutputPort;
import com.ega.reclamos.domain.exceptions.TaskNotFoundException;
import com.ega.reclamos.domain.models.Task;
import com.ega.reclamos.infrastructure.persistences.entities.TaskEntity;
import com.ega.reclamos.infrastructure.persistences.repositories.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TaskDao implements OutputPort {

    private final TaskRepository taskRepository;

    @Override
    public void saveTask(Task task) {
        TaskEntity entity = TaskEntity.builder()
                .taskName(task.getTaskName())
                .taskDescription(task.getTaskDescription())
                .build();

        taskRepository.save(entity);
    }

    @Override
    public Task findById(Long id) {
        TaskEntity entity = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task with " + id + " ID not found"));

        return Task.builder()
                .id(entity.getId())
                .taskName(entity.getTaskName())
                .taskDescription(entity.getTaskDescription())
                .build();
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll().stream()
                .map(entity -> Task.builder()
                        .id(entity.getId())
                        .taskName(entity.getTaskName())
                        .taskDescription(entity.getTaskDescription())
                        .build())
                .toList();
    }

    @Override
    public void updateTask(Long id, Task task) {
        TaskEntity entity = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task with " + id + " ID not found"));

        entity.setTaskName(task.getTaskName());
        entity.setTaskDescription(task.getTaskDescription());

        taskRepository.save(entity);
    }

    @Override
    public void deleteTask(Long id) {
        if(taskRepository.existsById(id)) {
           taskRepository.deleteById(id);
        }
    }
}
