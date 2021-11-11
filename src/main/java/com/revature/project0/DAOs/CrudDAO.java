package com.revature.project0.DAOs;

import com.revature.project0.util.List;

// DRUD: Create, Read, Update, Delete
public interface CrudDAO<T> {
    T save(T newObj);
    T findById(String id);
    List<T> findAll();
    boolean update(T updatedObj);
    boolean removeById(String id);
}
