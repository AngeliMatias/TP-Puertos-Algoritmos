package Viajes;
import java.util.ArrayList;
import java.util.List;
import Arbol.Puerto;
import Comparaciones.CompararTiempo;
import Comparaciones.CompararPrecio;
import Comparaciones.Comparar;

public class Grafo {
    private List<NodoGrafo> vertices;
    private CaminoMinimo camino;

    public Grafo(){
        vertices = new ArrayList<>();
        camino = new CaminoMinimo();
    }

    public void agregarVertice (Puerto dato) {
        vertices.add(new NodoGrafo(dato));
    }

    private NodoGrafo buscar(int codigo){
        NodoGrafo retornar = null;
        int iterar=0;
        while (iterar<vertices.size() && retornar == null){
            NodoGrafo nodo = vertices.get(iterar);
            if (nodo.getDato().getCodigo() == codigo){
                retornar = nodo;
            }else{
                iterar = iterar + 1;
            }
        }
        return retornar;
    }

    public void agregarArista(int codigo, Viaje arista) {
        NodoGrafo nodoAgregar = buscar(codigo);
        if (nodoAgregar!=null) nodoAgregar.agregarArista(arista);
    }

    public boolean pertenece(int codigo) {
        return buscar(codigo)!=null;
    }

    private void iniciarDijkstra(){
        int iterar=0;
        while (iterar<vertices.size()){
            NodoGrafo nodo = vertices.get(iterar);
            nodo.setDistancia(999999999);
            nodo.setVisitado(false);
            iterar = iterar+1;
        }
    }

    void dijkstra (int codigo, Comparar criterioComparar) {
        Heap heapOrden = new Heap(vertices.size());
        iniciarDijkstra();
        NodoGrafo verticeEvaluado = buscar(codigo);
        verticeEvaluado.setDistancia(0);
        heapOrden.agregar(verticeEvaluado);
        while (!heapOrden.estaVacio()) {
            verticeEvaluado = heapOrden.extraer();
            if (verticeEvaluado.getVisitado()){
                continue;
            }
            verticeEvaluado.setVisitado(true);
            List<Viaje> adyacentes = verticeEvaluado.getAdyacentes();
            int indice = 0;
            while (indice < adyacentes.size()) {
                Viaje arista = adyacentes.get(indice);
                NodoGrafo verticeAdyacente = buscar(arista.getCodigoDest());
                if (!(verticeAdyacente.getVisitado())) {
                    if(criterioComparar.comparar(verticeEvaluado,verticeAdyacente,arista)){
                        criterioComparar.modificar(verticeEvaluado,verticeAdyacente,arista);
                        criterioComparar.actualizarCamino(verticeEvaluado,verticeAdyacente,arista,this.camino);
                        heapOrden.agregar(verticeAdyacente);
                    }
                }
                indice = indice +1;
            }
        }
    }

    public List<NodoCamino> caminoMinimo(int origen, int opcion, int destino){
        Comparar criterio;
        List<NodoCamino> caminoRetornar=null;
        if(opcion == 1) criterio = new CompararPrecio();
        else criterio = new CompararTiempo();
        if (vertices.size()>0){
            dijkstra (origen, criterio);
            caminoRetornar= camino.listaOrdenada(origen, destino);
        }
        return caminoRetornar;
    }

    public void imprimir(){
        int iterar=0;
        while (iterar<vertices.size()){
            NodoGrafo nodo = vertices.get(iterar);
            System.out.println(nodo.getDato());
            nodo.imprimirAristas();
            iterar =  iterar + 1;
        }
    }


}
