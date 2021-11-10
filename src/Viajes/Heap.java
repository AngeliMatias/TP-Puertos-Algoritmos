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

    public Heap(int capacidadInicial){
        tamanio=0;
        capacidad =capacidadInicial;
        items = new NodoGrafo[capacidad];
    }

    public NodoGrafo extraer() {
        NodoGrafo item = items[0];
        tamanio--;
        items[0] = items[tamanio];
        heapifydown(0);
        return item;
    }
    public boolean estaVacio(){
        return (tamanio == 0);
    }

    public void agregar(NodoGrafo item) {
        items[tamanio] = item;
        heapifyup(tamanio);
        tamanio++;

    }

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

    public void heapifyup(int posicionIni){
        int direccion = posicionIni;
        while (tienePadre(direccion) && (funcioncmp(padre(direccion),items[direccion])==-1)){
            intercambiar(direccionPadre(direccion),direccion);
            direccion = direccionPadre(direccion);
        }
    }
};

