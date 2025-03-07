package com.ega.reclamos.application.input;

import com.ega.reclamos.domain.useCases.InputUseCases;
import com.ega.reclamos.infrastructure.views.dto.TaskDto;

public interface InputPort extends InputUseCases<TaskDto, Long> {
}
