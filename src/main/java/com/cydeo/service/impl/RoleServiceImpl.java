package com.cydeo.service.impl;

import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.service.RoleService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl extends AbstractMapService<RoleDTO, Long> implements RoleService {

    // map from abstract class is applied and saves roles in one map and user will get it's own map
    @Override
    public RoleDTO save(RoleDTO role) {
        return super.save(role.getId(),role);
    }

    @Override
    public RoleDTO findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<RoleDTO> findAll() {
        return super.findAll(); //call the method from parent class, where there is a map, which is our DB
    }

    @Override
    public void deleteById(Long id) {
    super.deleteById(id);
    }
}
