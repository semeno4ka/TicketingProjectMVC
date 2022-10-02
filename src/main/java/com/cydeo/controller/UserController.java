package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import com.cydeo.dto.UserDTO;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import com.cydeo.service.impl.RoleServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private final RoleService roleService;// injection in order to use the classes and methods within this class
    private final UserService userService;

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createUser(Model model){
    model.addAttribute("user", new UserDTO());
    model.addAttribute("roles", roleService.findAll());
    model.addAttribute("users", userService.findAll());
    return "/user/create";
        // if you return same view, you have to provide in a method all the attributes required for the html file to show it
        // whatever view needs(object, lists etc) need to be provided again in a new method
}
    @PostMapping ("/create")
    public String insertUser(@ModelAttribute("user")UserDTO user){
        //User object, roles, users
        userService.save(user);

        return "redirect:/user/create";//end point when you redirect
    }

    @GetMapping("/update/{username}")// to bring something from html to our code we need PathVariable or Query
    public String editUser(@PathVariable("username") String username, Model model){
        model.addAttribute("user", userService.findById(username));
        // need to go to DB take a required object and get the user
        // if you do any action that required connection with DB you need to go to service
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());
        return "/user/update";
    }

}
