package com.cydeo.service;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Status;

import java.util.List;

public interface ProjectService extends CrudService<ProjectDTO,String>{//string because we use Code as unique key

void complete(ProjectDTO project);

List<ProjectDTO> CountedListOfProjectDTO(UserDTO manager);

}
