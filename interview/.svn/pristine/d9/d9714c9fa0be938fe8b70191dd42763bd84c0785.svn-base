package com.qfedu;

//  进程和线程有什么区别和联系?
// 进程之间如果想共享数据应该怎么做?
// Java程序中如何让线程共享数据(共享内存)
//  1. 共享一个对象
// 2. 共享同一个上下文
// 3. 用内部类的方式共享外部类的数据
// 4. 管道流 (PipedInputStream/PipedOutputStream)
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

class AddThread implements Callable<Integer> {
    private int begin;
    private int end;

    public AddThread(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = begin; i <= end; ++i) {
            sum += i;
        }
        return sum;
    }
}

class App {
    private static AtomicInteger sum = new AtomicInteger(0);

    private static ExecutorService service = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        Future<Integer> f1 = service.submit(new AddThread(1, 10000));
        Future<Integer> f2 = service.submit(new AddThread(10001, 20000));
        try {
            int num1 = f1.get();
            int num2 = f2.get();
            System.out.println(num1 + num2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        service.shutdown();
        // fork - join
        // Arrays.sort
        // Collections.sort
        // Java 7- --- Double pivot quick sort
        // Java 7+ --- TimSort
        // JMM - Java memory model
    }
}
