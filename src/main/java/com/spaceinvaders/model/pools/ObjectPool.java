package com.spaceinvaders.model.pools;

import java.util.Stack;

public abstract class ObjectPool<T> {
    protected Stack<T> pool;

    public ObjectPool() {
        pool = new Stack<>();
    }

    //abstract public T create();

    public T extract() {
        if (pool.empty()) return create();
        return pool.pop();
    }

    public void put(T t) {
        pool.push(t);
    }

    abstract public Object getObjectType();

}
