package com.cydeo.converter;

import com.cydeo.dto.RoleDTO;
import com.cydeo.service.RoleService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
@Component // since we are using another bean inside this class, we add component- injection happens between beans
@ConfigurationPropertiesBinding // Configuration Properties Binding is required in order to apply those operations implicitly, behind the scene, so that Spring knows where to go, what to check and what to return
public class RoleDTOConverter implements Converter <String,RoleDTO> {// what you have and what you need
// html returns us String object within any kind of selection. That is why the String Objects needs to be converted to the type of an object required in code
private final RoleService roleService;
// in our case role was returned not as "Admin or Manager" role was returned as a String id 1,2,3 which is Long in the java
    public RoleDTOConverter(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public RoleDTO convert(String source) {
        return roleService.findById(Long.parseLong(source)); //we need to get the Long value of String input, the rets is done behind the scene
    }

}
//WHENEVER WE work with selection, we need converter to convert th value which comes as String from html into Class Object we need