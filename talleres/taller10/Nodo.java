import javafx.util.Pair;


public class Nodo {
    
    public Pair<String, Integer> dato;
    public Nodo izq;
    public Nodo der;
    
    public Nodo(Pair<String,Integer> dato){
        this.dato = dato;
        this.izq = null;
        this.der = null;
    }


    
}
