package org.example;

public class Trabajador implements Runnable{
    private final Cinta<Paquete> cola;
    static boolean mesaOcupada = false;

    public Trabajador(Cinta<Paquete> cola) {
        this.cola = cola;
    }

    @Override
    public void run() {
        while (true) {
            try {
                for (int i = 0; i < 20; i++) {
                    if (cola.quitarPaqueteCinta1() != null && !mesaOcupada) {
                        cola.quitarPaqueteCinta1();
                        mesaOcupada = true;
                        Thread.sleep(3000);
                        mesaOcupada = false;
                    }
                    if (cola.quitarPaqueteCinta2() != null && !mesaOcupada) {
                        cola.quitarPaqueteCinta2();
                        mesaOcupada = true;
                        Thread.sleep(3000);
                        mesaOcupada = false;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
