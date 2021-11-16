package com.revature.project0.util.Collections;

public interface Queue<T> extends Collection<T> {
    T poll();
    T peek();
}
