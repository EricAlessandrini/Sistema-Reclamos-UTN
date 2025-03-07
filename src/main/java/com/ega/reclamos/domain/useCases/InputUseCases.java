package com.ega.reclamos.domain.useCases;

import java.util.List;

public interface InputUseCases<T, U> {

    void saveTask(T taskDto);
    T findById(U id);
    List<T> findAll();
    void updateTask(U id, T taskDto);
    void deleteTask(U id);
}
