package com.qfedu;

import java.util.ArrayList;
import java.util.List;

// FILO - 栈 - 全栈工程师
public class MyStack<E> {
    private List<E> content = new ArrayList<>();

    public void push(E e) {
        content.add(e);
    }

    public E pop() {
        return content.remove(content.size() - 1);
    }

    public E peek() {
        return content.get(content.size() - 1);
    }

    public void clear() {
        content.clear();
    }

    public boolean isEmpty() {
        return content.size() == 0;
    }
}
