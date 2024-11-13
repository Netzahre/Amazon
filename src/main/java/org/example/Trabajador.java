package org.example;

import java.util.concurrent.Semaphore;

public class Trabajador implements Runnable{
    private final Cinta<Paquete> cola;
    Semaphore semaphore = new Semaphore(1);

    public Trabajador(Cinta<Paquete> cola) {
        this.cola = cola;
    }

    private void procesarPaquete() throws InterruptedException {
        semaphore.acquire();
        Thread.sleep(5000);
        semaphore.release();
    }
    @Override
    public void run() {
        boolean continuar = true;
        while (continuar) {
            try {
                for (int i = 0; i < 20; i++) {
                    if (cola.quitarPaqueteCinta1() != null) {
                        procesarPaquete();
                        Thread.sleep(3000);
                    }
                    if (cola.quitarPaqueteCinta2() != null) {
                        procesarPaquete();
                        Thread.sleep(3000);
                    }
                }
                Thread.sleep(100);
                continuar = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
