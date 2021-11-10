package Viajes;

import java.util.ArrayList;
import java.util.List;

public class CaminoMinimo {
    private List<NodoCamino> caminoMinimo;

    public CaminoMinimo(){
        caminoMinimo = new ArrayList<>();
    }

    public NodoCamino buscarNodocamino(int codigo){
        int indice=0;
        while (indice<this.caminoMinimo.size()){
            if(this.caminoMinimo.get(indice).getDato().getCodigo() == codigo){
                return this.caminoMinimo.get(indice);
            }
            indice = indice+1;
        }
        return null;
    }
    public void agregarNodo(NodoCamino nodoCamino){
        caminoMinimo.add(nodoCamino);
    }
    public List<NodoCamino> listaOrdenada(int origen, int destino){
        List<NodoCamino> listaRetorno = new ArrayList<>();
        NodoCamino nodo = buscarNodocamino(destino);
        listaRetorno.add(nodo);
        while(nodo.getPadre()!=origen){
            nodo = buscarNodocamino(nodo.getPadre());
            listaRetorno.add(0,nodo);
        }
        return listaRetorno;
    }
}
