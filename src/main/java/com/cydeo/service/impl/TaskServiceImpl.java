package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.TaskDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.TaskService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl extends AbstractMapService<TaskDTO, Long> implements TaskService {



    @Override
    public TaskDTO save(TaskDTO task) {
        if(task.getTaskStatus()==null) task.setTaskStatus(Status.OPEN);
        if(task.getAssignedDate()==null) task.setAssignedDate(LocalDate.now());
        if(task.getId()==null) task.setId(UUID.randomUUID().getMostSignificantBits());
        return super.save(task.getId(),task);
    }

    @Override
    public TaskDTO findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<TaskDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
    super.deleteById(id);
    }

    @Override
    public void update(TaskDTO task) {
   TaskDTO foundTask = findById(task.getId());//gives the task based on id, temp container for holding info, which is reassignef later
        task.setTaskStatus(foundTask.getTaskStatus());
        task.setAssignedDate(foundTask.getAssignedDate());

        super.update(task.getId(),task);
    }

    @Override
    public List<TaskDTO> findTasksByManager(UserDTO manager) {
        return findAll().stream()
                .filter(p->p.getProject().getAssignedManager().equals(manager))
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskDTO> findAllTasksByStatusIsNot(Status status) {
        return findAll().stream().filter(task-> !task.getTaskStatus().equals(status)).collect(Collectors.toList());
    }

    @Override
    public List<TaskDTO> findAllTasksByStatus(Status status) {
        return  findAll().stream().filter(task-> task.getTaskStatus().equals(status)).collect(Collectors.toList());
    }

    @Override
    public void updateStatus(TaskDTO task) {   // setTaskStatus(task.getTaskStatus() - what's coming from UI part
        findById(task.getId()).setTaskStatus(task.getTaskStatus());// change all status First status is updated
        update(task);// Second, task is updated with new Status
    }
}
