package com.ega.reclamos.application.output;

import com.ega.reclamos.domain.models.Task;
import com.ega.reclamos.domain.useCases.OutputUseCases;

public interface OutputPort extends OutputUseCases<Task, Long> {
}
