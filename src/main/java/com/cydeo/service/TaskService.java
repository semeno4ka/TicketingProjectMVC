package com.cydeo.service;

import com.cydeo.dto.TaskDTO;

import java.util.List;

public interface TaskService extends CrudService<TaskDTO, Long> {
    @Override
    default TaskDTO save(TaskDTO obj) {
        return null;
    }

    @Override
    default TaskDTO findById(Long aLong) {
        return null;
    }

    @Override
    default List<TaskDTO> findAll() {
        return null;
    }

    @Override
    default void deleteById(Long aLong) {

    }

    @Override
    default void update(TaskDTO object) {

    }
}
