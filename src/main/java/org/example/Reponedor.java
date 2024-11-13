package org.example;

public class Reponedor implements Runnable {
    private final Cinta<Paquete> cola;

    public Reponedor(Cinta<Paquete> cola) {
        this.cola = cola;
    }

    @Override
    public void run() {
        boolean continuar = true;
        while (continuar) {
            try {
                for (int i = 0; i < 20; i++) {
                    if (cola.gettamanioCola1() < cola.getMaxCola1()) {
                        cola.meterPaqueteCinta1(new Paquete());
                    }
                    if (cola.gettamanioCola2() < cola.getMaxCola2()) {
                        cola.meterPaqueteCinta2(new Paquete());
                    }
                }
                Thread.sleep(10);
                continuar = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
