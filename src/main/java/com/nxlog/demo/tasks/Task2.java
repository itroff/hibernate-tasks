package com.nxlog.demo.tasks;

import java.util.concurrent.CountDownLatch;

public class Task2 {
    private Processor processor;

    public static void SynchroProcessor() {
        Task2 proc = new Task2();
        CountDownLatch latch = new CountDownLatch(1);
        Thread t1 = proc.new Executor(latch);
        t1.start();
        Thread t2 = proc.new Initializer(latch);
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
 //       System.exit(0);
    }

    private class Processor {

        public Processor() {
            System.out.println("construct");
        }

        public void init() {
            System.out.println("init");
        }

        public void process() {
            System.out.println("process");
        }
    }

    private class Initializer extends Thread {
        private final CountDownLatch latch;

        public Initializer(CountDownLatch latch) {
            this.latch = latch;
        }

        public void run() {
            processor = new Processor();
            processor.init();
            latch.countDown();
        }
    }

    private class Executor extends Thread {
        private final CountDownLatch latch;

        public Executor(CountDownLatch latch) {
            this.latch = latch;
        }

        public void run() {
            try {
                latch.await();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            processor.process();
        }
    }

}
