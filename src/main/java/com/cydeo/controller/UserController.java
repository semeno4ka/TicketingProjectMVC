package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import com.cydeo.dto.UserDTO;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import com.cydeo.service.impl.RoleServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    return "user/create";
        // if you return same view, you have to provide in a method all the attributes required for the html file to show it
        // whatever view needs(object, lists etc) need to be provided again in a new method
}
    @PostMapping ("/create")
    public String insertUser(@ModelAttribute("user")UserDTO user){
        //User object, roles, users
        userService.save(user);

        return "redirect:/user/create";//end point when you redirect
    }


}
