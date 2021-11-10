package Viajes;

public class Heap {
    private int capacidad,tamanio;
    private NodoGrafo[] items;

    private int direccionHijoIz(int direccionPadre) {
        return direccionPadre * 2 + 1;
    }

    private int direccionHijoDe(int direccionPadre) {
        return direccionPadre * 2 + 2;
    }

    private int direccionPadre(int direccionHijo) {
        return (direccionHijo - 1) - 2;
    }

    public int getTamanio() {
        return tamanio;
    }

    private boolean tieneHijoIz(int direccion) {
        return direccionHijoIz(direccion) < tamanio;
    }

    private boolean tieneHijoDe(int direccion) {
        return direccionHijoDe(direccion) < tamanio;
    }

    private boolean tienePadre(int direccion) {
        return direccionPadre(direccion) >= 0;
    }

    private NodoGrafo hijoIz(int direccion) {
        return items[direccionHijoIz(direccion)];
    }

    private NodoGrafo hijoDe(int direccion) {
        return items[direccionHijoDe(direccion)];
    }

    private NodoGrafo padre(int direccion) {
        return items[direccionPadre(direccion)];
    }

    private void intercambiar(int dir1,int dir2){
        NodoGrafo temporal = items[dir1];
        items[dir1]= items[dir2];
        items[dir2]= temporal;
    }

    //compara un vertice con otro y devuelve un numero que representa el tamanio de uno respecto al otro
    private int funcioncmp(NodoGrafo vertice1, NodoGrafo vertice2){
        int valor1 = vertice1.getDistancia();
        int valor2 = vertice2.getDistancia();
        if (valor1 > valor2) return -1;
        if (valor1 == valor2) return 0;
        return 1;
    }

    private int busquedaPos(NodoGrafo dato){
        int pos=0;
        while (pos< tamanio){
            if (funcioncmp(items[pos], dato) == 0){
                break;
            }
            pos++;
        }
        if (pos == tamanio) {
            pos=-1;
        }
        return pos;
    }

    //post: inicializa las variables del heap
    public Heap(int capacidadInicial){
        tamanio=0;
        capacidad =capacidadInicial;
        items = new NodoGrafo[capacidad];
    }
    /*pre: el heap no esta vacio
     *post: se retira el menor elemento, se reduce el tamanio y luego se reacomodan los elementos */
    public NodoGrafo extraer() {
        NodoGrafo item = items[0];
        tamanio--;
        items[0] = items[tamanio];
        heapifydown(0);
        return item;
    }
    //post: devuelve un bool afirmando si el heap se encuentra vacio o no
    public boolean estaVacio(){
        return (tamanio == 0);
    }
    //post: agrega un nuevo elemento en el heap y lo acomoda respecto a los demas
    public void agregar(NodoGrafo item) {
        items[tamanio] = item;
        heapifyup(tamanio);
        tamanio++;

    }
    /*post: reacomoda los elementos a partir de una posicion dada
     * comparandolo con los valores de sus hijos */
    public void heapifydown(int posicionIni){
        int direccion = posicionIni;
        while (tieneHijoIz(direccion)){
            int direccionHijoMenor = direccionHijoIz(direccion);
            if (tieneHijoDe(direccion) && funcioncmp(hijoDe(direccion),hijoIz(direccion))==1){
                direccionHijoMenor = direccionHijoDe(direccion);
            }
            if (funcioncmp(items[direccion],items[direccionHijoMenor])==1){
                break;
            } else {
                intercambiar(direccion,direccionHijoMenor);
            }
            direccion = direccionHijoMenor;
        }
    }
    //post: similar a heapifydown pero lo hace comparandolo con los valores de su padre
    public void heapifyup(int posicionIni){
        int direccion = posicionIni;
        while (tienePadre(direccion) && (funcioncmp(padre(direccion),items[direccion])==-1)){
            intercambiar(direccionPadre(direccion),direccion);
            direccion = direccionPadre(direccion);
        }
    }
};

