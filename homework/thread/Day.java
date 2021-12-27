package com.galeeva.lesson25.homework.thread;

import com.galeeva.lesson25.homework.util.DayConst;

public class Day extends Thread {

    private final Object lock = new Object();

    @Override
    public void run() {
        for (int i = 0; i < DayConst.AMOUNT_OF_DAY; i++) {
            synchronized (lock) {
                try {
                    System.out.printf("---------------\nMidnight %s started\n", (i + 1));
                    lock.notifyAll();
                    lock.wait(DayConst.DAY_INTERVAL);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        synchronized (lock) {
            lock.notifyAll();
        }
    }

    public Object getLock() {
        return lock;
    }
}
