package com.revature.project0.services;

public interface DataService<T> {
    T authenticate(T Obj);
    boolean register(T Obj);
    boolean validate(T Obj);
}
