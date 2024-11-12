package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Cinta<Paquete> cola = new Cinta<>();
        for (int i = 0; i < 5; i++) {
            new Thread(new Reponedor(cola)).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(new Trabajador(cola)).start();
        }
    }
}