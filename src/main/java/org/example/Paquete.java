package org.example;

public class Paquete {
    private final int id;
    private final int peso;

    public Paquete() {
        this.id = 0;
        this.peso = 0;
    }

    public Paquete(int id, int peso) {
        this.id = id;
        this.peso = peso;
    }

    public int getId() {
        return id;
    }

    public int getPeso() {
        return peso;
    }
}
