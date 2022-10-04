package com.cydeo.controller;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.TaskDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import com.cydeo.service.TaskService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/task")
public class TaskController {
private final TaskService taskService;
private final ProjectService projectService;
private final UserService userService;

    public TaskController(TaskService taskService, ProjectService projectService, UserService userService) {
        this.taskService = taskService;
        this.projectService = projectService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createTask(Model model){
        model.addAttribute("task", new TaskDTO());
        model.addAttribute("tasks", taskService.findAll());
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("employees",userService.findEmployees());
        return "/task/create";
    }

    @PostMapping("/create")
    public String insertTask(@ModelAttribute("task") TaskDTO task){
    taskService.save(task);
        return "redirect:/task/create";
    }


    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id) {
        taskService.deleteById(id);
        return "redirect:/task/create";
    }


    @GetMapping("/update/{taskId}")
    public String editTask(@PathVariable("taskId") Long taskId, Model model){
        model.addAttribute("task", taskService.findById(taskId));// to show the project in the form
        model.addAttribute("tasks", taskService.findAll());
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("employees",userService.findEmployees());
        return "/task/update";
    }


    @PostMapping("/update/{id}")
    // if the { name } is exactly the same as the Field name in the TaskDTO class, then it knows, where to pass it implicitly
    public String updateTask(TaskDTO task){
        taskService.update(task);

        return "redirect:/task/create";
    }

    @GetMapping("/employee/pending-tasks")
    public String employeePendingTasks(Model model){
model.addAttribute("tasks", taskService.findAllTasksByStatusIsNot(Status.COMPLETE));

        return "/task/pending-tasks";
    }

@GetMapping("/employee/archive")
    public String employeeArchive(Model model){
model.addAttribute("tasks",taskService.findAllTasksByStatus(Status.COMPLETE));
        return "/task/archive";
}

@GetMapping("/employee/edit/{id}")// in get we capture data input thus Path required
    public String employeeEditTask(@PathVariable("id") Long id, Model model){
   model.addAttribute("task", taskService.findById(id));// get the task to update based on id
    // model.addAttribute("projects", projectService.findAll());
    // model.addAttribute("employees", userService.findEmployees());
   model.addAttribute("statuses", Status.values());
   model.addAttribute("tasks", taskService.findAllTasksByStatusIsNot(Status.COMPLETE));
        return "/task/status-update";
}
@PostMapping("/employee/update/{id}")
    public String employeeUpdate(TaskDTO task){
        taskService.updateStatus(task);

        return "redirect:/task/employee/pending-tasks";
}
}
/*
   @PostMapping("/update/{taskId}")// we need to get ID  from DB
    // and keep it in browser to reassign it back to user, since there is no field for ID in the form
    //IN DB we will alswasy capture this ID
    public String updateTask(@PathVariable("taskId") Long taskId, @ModelAttribute("task") TaskDTO task){
        task.setId(taskId);
        taskService.update(task);

        return "redirect:/task/create";
    }
 */