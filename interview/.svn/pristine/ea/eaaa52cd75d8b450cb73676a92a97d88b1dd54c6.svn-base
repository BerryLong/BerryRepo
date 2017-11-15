package com.qfedu;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyThread implements Runnable {
    private IdGenerator generator;

    public MyThread(IdGenerator generator) {
        this.generator = generator;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; ++i) {
            System.out.println(Thread.currentThread().getName() + ": " + generator.nextId());
        }
    }
}

public class Exam3 {

    private static ExecutorService service = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        IdGenerator generator = IdGeneratorManager.get("gen3");
        if (generator == null) {
            generator = new IdGenerator(-100, 50);
            IdGeneratorManager.save("gen3", generator);
        }
        for (int i = 1; i <= 5; ++i) {
            service.execute(new MyThread(generator));
        }
        service.shutdown();
    }
}
