package org.example;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Cinta<T> {
    private final LinkedList<T> cola1 = new LinkedList<>();
    private final LinkedList<T> cola2 = new LinkedList<>();
    ReentrantLock lock = new ReentrantLock();
    ReentrantLock lock2 = new ReentrantLock();
    private final Condition condicion1 = lock.newCondition();
    private final Condition condicion2 = lock2.newCondition();
    private final int maxCola1 = 5;
    private final int maxCola2 = 10;

    public T quitarPaqueteCinta1() throws InterruptedException {
        lock.lock();
        try {
            while (cola1.isEmpty()) {
                condicion1.await();
            }

            T paquete = cola2.pop();
            System.out.println("Cola 1 actual: " + cola1.size());
            Thread.sleep(3000);
            condicion1.signalAll();
            return paquete;

        } finally {
            lock.unlock();
        }

    }

    public T quitarPaqueteCinta2() throws InterruptedException {
        lock2.lock();
        try {
            while (cola1.isEmpty()) {
                condicion2.await();
            }
            T paquete = cola2.pop();
            System.out.println("Cola 2 actual: " + cola2.size());
            Thread.sleep(3000);
            condicion2.signalAll();
            return paquete;
        } finally {
            lock2.unlock();
        }
    }

    public void meterPaqueteCinta1(T paquete) throws InterruptedException {
        lock.lock();
        try {
            while (cola1.size() == maxCola1) {
                condicion1.await();
            }
            cola1.add(paquete);
            System.out.println("Cola 1 actual: " + cola1.size());
            Thread.sleep(3000);
            condicion1.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void meterPaqueteCinta2(T paquete) throws InterruptedException {
        lock2.lock();
        try {
            while (cola2.size() == maxCola2) {
                condicion2.await();
            }
            cola2.add(paquete);
            System.out.println("Cola 2 actual: " + cola2.size());
            Thread.sleep(3000);
            condicion2.signalAll();
        } finally {
            lock2.unlock();
        }
    }

    public int gettamanioCola1() {
        return cola1.size();
    }
    public int gettamanioCola2() {
        return cola2.size();
    }

    public int getMaxCola1() {
        return maxCola1;
    }
    public int getMaxCola2() {
        return maxCola2;
    }

}
