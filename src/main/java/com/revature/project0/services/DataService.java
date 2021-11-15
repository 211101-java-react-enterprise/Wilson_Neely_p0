package com.revature.project0.services;

public interface DataService<T> {
    boolean register(T Obj);
    boolean validate(T Obj);
}
