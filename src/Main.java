import Arbol.ABB;
import Lectura.Lector;
import Viajes.Grafo;

public class Main {

    public static void main(String[] args) {
        Lector lector = new Lector();
        Grafo grafo = lector.cargarGrafo();
        ABB arbol = lector.cargarArbol();
    }
}
