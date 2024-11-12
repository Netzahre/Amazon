package org.example;

import java.util.LinkedList;

public class Cinta<T> {
    private final LinkedList<T> cola1 = new LinkedList<>();
    private final LinkedList<T> cola2 = new LinkedList<>();

    public T quitarPaqueteCinta1() throws InterruptedException {
        while (cola1.isEmpty()) {
            wait();
        }
        T paquete = cola2.pop();
        System.out.println("Cola 1 actual: " + cola1);
        Thread.sleep(3000);
        notifyAll();
        return paquete;
    }

    public T quitarPaqueteCinta2() throws InterruptedException {
        while (cola1.isEmpty()) {
            wait();
        }
        T paquete = cola2.pop();
        System.out.println("Cola 2 actual: " + cola2);
        Thread.sleep(3000);
        notifyAll();
        return paquete;
    }

    public synchronized void meterPaqueteCinta1(T paquete) throws InterruptedException {
        while (cola1.size() == 5) {
            wait();
        }
        cola1.add(paquete);
        System.out.println("Cola 1 actual: " + cola1.size());
        Thread.sleep(3000);
        notifyAll();
    }

    public void meterPaqueteCinta2(T paquete) throws InterruptedException {
        while (cola2.size() == 10) {
            wait();
        }
        cola2.add(paquete);
        System.out.println("Cola 2 actual: " + cola2);
        Thread.sleep(3000);
        notifyAll();
    }

}
