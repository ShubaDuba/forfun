package com.company;

public class Main {
    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    private static class MyThread1 extends Thread {
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread 1 holding lock1");
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    System.out.println("Thread 1 was interrupted");
                }

                System.out.println("Thread 1 waiting for lock2");
                synchronized (lock2) {
                    System.out.println("Thread 1 holding lock1 and lock2");
                }
            }
        }
    }

    private static class MyThread2 extends Thread {
        public void run() {
            synchronized (lock2) {
                System.out.println("Thread 1 holding lock2");
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    System.out.println("Thread 1 was interrupted");
                }

                System.out.println("Thread 1 waiting for lock1");
                synchronized (lock1) {
                    System.out.println("Thread 1 holding lock1 and lock2");
                }
            }
        }
    }

    public static void main(String[] args) {
        MyThread1 thread1 = new MyThread1();
        MyThread2 thread2 = new MyThread2();
        thread1.start();
        thread2.start();
    }
}
