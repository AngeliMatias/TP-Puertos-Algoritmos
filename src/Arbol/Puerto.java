package Arbol;

public class Puerto {
    private int codigo;
    private String nombre;
    private String pais;

    public Puerto(String[] datos){
        this.codigo = Integer.parseInt(datos[0]);
        this.nombre = datos[1];
        this.pais = datos[2];
    }

    public int comparar(int evaluar){
        return (this.codigo - evaluar);
    }
    public int comparar(Puerto evaluar){
        return (this.codigo - evaluar.getCodigo());
    }
    public int getCodigo(){
        return this.codigo;
    }
    public String getNombre(){
        return this.nombre;
    }

    @Override
    public String toString() {
        return "Puerto{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}