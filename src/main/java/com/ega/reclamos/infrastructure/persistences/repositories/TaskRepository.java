package com.ega.reclamos.infrastructure.persistences.repositories;

import com.ega.reclamos.infrastructure.persistences.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}
