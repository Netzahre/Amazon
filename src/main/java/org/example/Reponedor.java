package org.example;

public class Reponedor implements Runnable {
    private final Cinta<Paquete> cola;

    public Reponedor(Cinta<Paquete> cola) {
        this.cola = cola;
    }

    @Override
    public void run() {
        while (true) {
            try {
                for (int i = 0; i < 20; i++) {
                    cola.meterPaqueteCinta1(new Paquete());
                    cola.meterPaqueteCinta2(new Paquete());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
