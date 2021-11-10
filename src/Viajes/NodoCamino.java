package Viajes;

import Arbol.Puerto;

public class NodoCamino {
    private Puerto dato;
    private int pesoCamino, distanciaPadre,  padre;

    public NodoCamino(Puerto dato, int pesoCamino, int distanciaPadre, int padre){
        this.dato = dato;
        this.pesoCamino = pesoCamino;
        this.distanciaPadre = distanciaPadre;
        this.padre = padre;
    }

    public Puerto getDato() {
        return dato;
    }

    public void setDato(Puerto dato) {
        this.dato = dato;
    }

    public int getPadre() {
        return padre;
    }

    public void setPadre(int padre) {
        this.padre = padre;
    }

    public int getDistanciaPadre() {
        return distanciaPadre;
    }

    public void setDistanciaPadre(int distanciaPadre) {
        this.distanciaPadre = distanciaPadre;
    }

    public int getPesoCamino() {
        return pesoCamino;
    }

    public void setPesoCamino(int pesoCamino) {
        this.pesoCamino = pesoCamino;
    }

    @Override
    public String toString() {
        return "NodoCamino{" +
                "dato=" + dato +
                ", pesoCamino=" + pesoCamino +
                ", distanciaPadre=" + distanciaPadre +
                ", padre=" + padre +
                '}';
    }
}
