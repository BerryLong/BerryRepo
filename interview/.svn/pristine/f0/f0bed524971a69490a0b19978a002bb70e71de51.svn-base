package com.qfedu;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator implements Serializable {
    private long start;
    private long increment;
    private AtomicLong currentId;

    public IdGenerator(long start, long increment) {
        this.start = start;
        this.increment = increment;
        this.currentId = new AtomicLong(start);
    }

    // 隐式的锁机制 - synchronized
    // 显式的锁机制 - Lock
    public long nextId() {
        return currentId.getAndAdd(increment);
    }

    public long currentId() {
        return currentId.get();
    }
}
