package Arbol;

public class NodoArbol {
    private Puerto dato;
    private NodoArbol izq;
    private NodoArbol der;

    public NodoArbol(Puerto datoNuevo){
        dato = datoNuevo;
        izq = null;
        der = null;
    }

    public boolean tieneDer() { return (der!=null); }
    public boolean tieneIzq(){
        return (izq!=null);
    }
    public Puerto getDato(){
        return dato;
    }
    public void setDato(Puerto datoNuevo){
        dato = datoNuevo;
    }
    public NodoArbol getIzq(){
        return izq;
    }
    public void setIzq(NodoArbol izqNuevo){
        izq = izqNuevo;
    }
    public NodoArbol getDer() { return der; }
    public void setDer(NodoArbol derNuevo){
        der = derNuevo;
    }
}
