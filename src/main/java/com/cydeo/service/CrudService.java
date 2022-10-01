package com.cydeo.service;

import com.cydeo.dto.RoleDTO;

import java.util.List;

public interface CrudService <T,ID> {// We need also to add ID which we don't know yet what will be exactly
// IF IT IS COMMON FOR ALL, else if it is UNIQUE go to specific Service
    T save (T obj);
    T findById(ID id);
    List<T> findAll();
    void deleteById(ID id);

}
