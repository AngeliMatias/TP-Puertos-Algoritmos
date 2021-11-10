package Arbol;

public class ABB {
    private NodoArbol nodoRaiz;

    public ABB(){ nodoRaiz=null; }

    public NodoArbol getRaiz(){
        return nodoRaiz;
    }

    public void insertar(Puerto dato){
        if (this.nodoRaiz == null) {
            this.nodoRaiz = new NodoArbol(dato);
        } else {
            insertar(dato, this.nodoRaiz);
        }
    }

    private void insertar(Puerto dato, NodoArbol nodo){
        if(nodo.getDato().comparar(dato)>0) {
            if (nodo.getIzq() == null) {
                System.out.println("Nuevo puerto: " + dato.getNombre());
                nodo.setIzq(new NodoArbol(dato));
            } else {
                this.insertar(dato, nodo.getIzq());
            }
        }
        else {
            if (nodo.getDer() == null) {
                nodo.setDer(new NodoArbol(dato));
                System.out.println("Nuevo puerto: " + dato.getNombre());
            } else {
                this.insertar(dato, nodo.getDer());
            }
        }
    }

    public NodoArbol busqueda(int dato){
        return busqueda(dato, this.getRaiz());
    }

    public NodoArbol busqueda(int dato, NodoArbol nodo){
        if (nodo==null) return null;
        int resultado = nodo.getDato().comparar(dato);
        if (resultado==0) return nodo;
        else if (resultado>0) return busqueda(dato, nodo.getIzq());
        else return busqueda(dato, nodo.getDer());
    }

    private NodoArbol[] buscarPadre(int dato, NodoArbol padre, NodoArbol nodo){
        if (nodo==null) return null;
        int resultado = nodo.getDato().comparar(dato);
        if (resultado==0) return new NodoArbol[]{padre, nodo};
        else if (resultado>0) return buscarPadre(dato, nodo, nodo.getIzq());
        else return buscarPadre(dato, nodo, nodo.getDer());
    }

    private void eliminarCaso1(NodoArbol[]padreHijo){
        if (padreHijo[0]==null){
            this.nodoRaiz=null;
        }
        else {
            if (padreHijo[0].getDer() == padreHijo[1]) {
                padreHijo[0].setDer(null);
            } else {
                padreHijo[0].setIzq(null);
            }
        }
    }

    private void eliminarCaso2(NodoArbol[] padreHijo ){
        if (padreHijo[0]==null){
            if (!padreHijo[1].tieneIzq()) {
                this.nodoRaiz = padreHijo[1].getDer();
            }else{
                this.nodoRaiz =padreHijo[1].getIzq();
            }
        }else {
            if (padreHijo[0].getDer() == padreHijo[1]) {
                if (!padreHijo[1].tieneIzq()) {
                    padreHijo[0].setDer(padreHijo[1].getDer());
                } else {
                    padreHijo[0].setDer(padreHijo[1].getIzq());
                }
            } else {
                if (!padreHijo[1].tieneIzq()) {
                    padreHijo[0].setIzq(padreHijo[1].getDer());
                } else {
                    padreHijo[0].setIzq(padreHijo[1].getIzq());
                }
            }
        }
    }

    private void intercambio(NodoArbol nodoCambio1, NodoArbol nodoCambio2){
        Puerto datoAux = nodoCambio1.getDato();
        nodoCambio1.setDato(nodoCambio2.getDato());
        nodoCambio2.setDato(datoAux);
    }

    private NodoArbol[] buscarMenorMayores(NodoArbol nodo){
        NodoArbol menorMayores = nodo.getDer();
        NodoArbol padre = nodo;
        while (menorMayores.tieneIzq()) {
            padre=menorMayores;
            menorMayores = menorMayores.getIzq();
        }
        return new NodoArbol[] {padre,menorMayores};
    }

    private void eliminarCaso3(NodoArbol[] padreHijo ){
        NodoArbol[] padreHijoEliminar = buscarMenorMayores(padreHijo[1]);
        intercambio(padreHijo[1],padreHijoEliminar[1]);
        if (padreHijoEliminar[0]!=null){
            System.out.println("Entra acá");
            if(!(padreHijoEliminar[1].tieneDer()) && !(padreHijoEliminar[1].tieneIzq())){
                eliminarCaso1(padreHijoEliminar);
            }else{
                eliminarCaso2(padreHijoEliminar);
            }
        }
    }

    public void eliminar(int dato){
        NodoArbol[] padreHijo = buscarPadre(dato,null,this.getRaiz());
        if(padreHijo!=null){
            if(!(padreHijo[1].tieneDer()) && !(padreHijo[1].tieneIzq())){
                eliminarCaso1(padreHijo);
            }else if(!(padreHijo[1].tieneDer()) || !(padreHijo[1].tieneIzq())){
                eliminarCaso2(padreHijo);
            }else {
                eliminarCaso3(padreHijo);
            }
        }
    }

    public void enOrden(){
        enOrden(this.getRaiz());
    }

    private void enOrden(NodoArbol nodo){
        if(nodo!=null){
            enOrden(nodo.getIzq());
            System.out.println(nodo.getDato());
            enOrden(nodo.getDer());
        }
    }

}
