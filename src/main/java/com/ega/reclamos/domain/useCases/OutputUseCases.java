package com.ega.reclamos.domain.useCases;

import java.util.List;

public interface OutputUseCases<T, U> {

    void saveTask(T task);
    T findById(U id);
    List<T> findAll();
    void updateTask(U id, T task);
    void deleteTask(U id);

}
