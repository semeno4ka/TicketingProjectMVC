package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.CrudService;
import com.cydeo.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectServiceImpl extends AbstractMapService<ProjectDTO,String> implements ProjectService {


    @Override
    public ProjectDTO save(ProjectDTO project) {
        if(project.getProjectStatus()==null)  project.setProjectStatus(Status.OPEN);
        return super.save(project.getProjectCode(),project);
    }

    @Override
    public ProjectDTO findById(String id) {
        return super.findById(id);
    }

    @Override
    public List<ProjectDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(String id) {
     super.deleteById(id);
    }

    @Override
    public void update(ProjectDTO project){
        if(project.getProjectStatus()==null)  project.setProjectStatus(findById(project.getProjectCode()).getProjectStatus());
    super.update(project.getProjectCode(),project); //the object already has it's status you just reassign it back
    }

    @Override
    public void complete(ProjectDTO project) {
        project.setProjectStatus(Status.COMPLETE);
    }
}
