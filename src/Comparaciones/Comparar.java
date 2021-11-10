package Comparaciones;

import Viajes.CaminoMinimo;
import Viajes.NodoGrafo;
import Viajes.Viaje;

public interface Comparar {
    boolean comparar(NodoGrafo nodoEvaluar, NodoGrafo nodoAdyacente, Viaje arista);
    void modificar(NodoGrafo nodoEvaluar, NodoGrafo nodoAdyacente, Viaje arista);
    void actualizarCamino(NodoGrafo nodoEvaluar, NodoGrafo nodoAdyacente, Viaje arista, CaminoMinimo camino);
}
