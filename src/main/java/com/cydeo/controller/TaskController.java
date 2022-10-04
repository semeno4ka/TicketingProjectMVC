package com.cydeo.controller;

import com.cydeo.dto.TaskDTO;
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
        model.addAttribute("taskList", taskService.findAll());
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("users",userService.findAll());
        return "/task/create";
    }

    @PostMapping("/create")
    public String insertTask(@ModelAttribute("task") TaskDTO taskDTO){
    taskService.save(taskDTO);
        return "redirect:/task/create";
    }
}
