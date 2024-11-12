package org.example;

public class Trabajador implements Runnable{
    private final Cinta<Paquete> cola;

    public Trabajador(Cinta<Paquete> cola) {
        this.cola = cola;
    }

    @Override
    public void run() {
        while (true) {
            try {
                for (int i = 0; i < 20; i++) {
                    cola.quitarPaqueteCinta1();
                    cola.quitarPaqueteCinta2();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
