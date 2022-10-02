package com.cydeo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractMapService <T,ID>{// abstracting impl because impl for all will be similar


    public Map<ID,T> map=new HashMap<>();//fake dataBase, easy to use map because we have key and value as as ID and Object

    T save( ID id, T object){
        map.put(id,object);
        return object;
    }

    List<T> findAll(){
        return new ArrayList<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void update(ID id, T object){
        map.put(id,object);
    }
}
