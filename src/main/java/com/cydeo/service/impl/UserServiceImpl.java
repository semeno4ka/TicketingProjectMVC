package com.cydeo.service.impl;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service// same as @Component but is applied to Service classes (creates beans from the class)
public class UserServiceImpl extends AbstractMapService<UserDTO,String> implements UserService {

    // map from abstract class is applied and saves roles in one map and user will get it's own map
    @Override
    public UserDTO save(UserDTO user) {
        return super.save(user.getUserName(), user);
    }

    @Override
    public UserDTO findById(String id) {
        return super.findById(id);
    }

    @Override
    public List<UserDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(String id) {
    super.deleteById(id);
    }

    @Override
    public void update(UserDTO object) {
        super.update(object.getUserName(),object);
    }

    @Override
    public List<UserDTO> findManagers() {
       // return findAll().stream().filter(p->p.getRole().getDescription().equals("Manager")).collect(Collectors.toList());
        return findAll().stream().filter(p->p.getRole().getId()==2).collect(Collectors.toList());
    }
}
