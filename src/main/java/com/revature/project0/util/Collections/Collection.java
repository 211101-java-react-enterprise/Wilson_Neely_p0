package com.revature.project0.util.Collections;

//<T> is an example of a parameterized type
//The value will be determined at object instantiation
public interface Collection<T> {
    boolean add(T element);
    boolean contains(T element);
    boolean isEmpty();
    boolean remove(T element);
    int size();
}
