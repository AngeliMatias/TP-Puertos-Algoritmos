package Comparaciones;

import Viajes.CaminoMinimo;
import Viajes.NodoCamino;
import Viajes.NodoGrafo;
import Viajes.Viaje;

public class CompararTiempo implements Comparar {
    public boolean comparar(NodoGrafo nodoEvaluar, NodoGrafo nodoAdyacente, Viaje arista){
        return nodoEvaluar.getDistancia()+arista.getDiasViaje() < nodoAdyacente.getDistancia();
    }

    @Override
    public void modificar(NodoGrafo nodoEvaluar, NodoGrafo nodoAdyacente, Viaje arista) {
        nodoAdyacente.setDistancia(nodoEvaluar.getDistancia() + arista.getDiasViaje());
    }

    public void actualizarCamino(NodoGrafo nodoEvaluar, NodoGrafo nodoAdyacente, Viaje arista, CaminoMinimo camino){
        NodoCamino nodoCamino = camino.buscarNodocamino(nodoAdyacente.getDato().getCodigo());
        if (nodoCamino==null){

            nodoCamino = new NodoCamino(nodoAdyacente.getDato(), nodoAdyacente.getDistancia(),arista.getDiasViaje(),nodoEvaluar.getDato().getCodigo());
            camino.agregarNodo(nodoCamino);
        }else{
            nodoCamino.setPadre(nodoEvaluar.getDato().getCodigo());
            nodoCamino.setDistanciaPadre(arista.getDiasViaje());
            nodoCamino.setPesoCamino(nodoAdyacente.getDistancia());
        }
    }
}
